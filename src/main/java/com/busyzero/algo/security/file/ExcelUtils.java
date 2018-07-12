package com.busyzero.algo.security.file;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * excel 工具类
 * @author katey2658
 */
public class ExcelUtils {

    /** 一sheet 最大记录数据 */
    private static final int SHEET_MAX_ROW_SIZE_DEFAULT = 20000;

    public static void exportWithHeaders(String path, List<String> headers, List<List> data) throws IOException {
        export(path, null, headers, data);
    }

    public static void exportWithSheetNames(String path, List<String> sheetNames, List<List> data) throws IOException {
        export(path, sheetNames, null, data);
    }

    /**
     * 导出Excel文件
     *
     * @param path    导出的Excel文件的绝对路径
     * @param headers Excel的标题头
     * @param data    导出的数据
     */
    public static void export(String path, List<String> sheetNames, List<String> headers, List<List> data) throws IOException {

        HSSFWorkbook workbook = new HSSFWorkbook();
        File file = new File(path);

        int rowSize = data.size();
        int sheetSize;
        if (rowSize % SHEET_MAX_ROW_SIZE_DEFAULT == 0) {
            sheetSize = rowSize / SHEET_MAX_ROW_SIZE_DEFAULT;
        } else {
            sheetSize = (rowSize / SHEET_MAX_ROW_SIZE_DEFAULT) + 1;
        }


        //创建sheets
        for (int sheetIndex = 0; sheetIndex < sheetSize; sheetIndex++) {

            //按照sheetNames创建sheet，若sheetName不足，则用数字填充
            HSSFSheet sheet;
            if (sheetNames != null && sheetIndex < sheetNames.size()) {
                sheet = workbook.createSheet(sheetNames.get(sheetIndex));
            } else {
                sheet = workbook.createSheet("sheet" + (sheetIndex + 1));
            }

            //设置header
            if (headers != null) {
                setSheetHeader(sheet, headers);
            }

            //填充数据
            int rowBeginIndex = sheetIndex * SHEET_MAX_ROW_SIZE_DEFAULT;
            setSheetData(sheet, data, rowBeginIndex);

        }

        workbook.write(file);
        workbook.close();
    }

    /**
     * 给指定的sheet添加数据
     * 给指定sheet的第二行开始放数据，第一行留给header
     *
     * @param sheet         添加数据的sheet
     * @param data          添加的二维数据list集合
     * @param rowBeginIndex 从list集合中的某个索引开始放数据
     */
    public static void setSheetData(HSSFSheet sheet, List<List> data, int rowBeginIndex) {

        //不能超过每个sheet的最大行数
        int rowNum = data.size() - rowBeginIndex;
        if (rowNum > SHEET_MAX_ROW_SIZE_DEFAULT) {
            rowNum = SHEET_MAX_ROW_SIZE_DEFAULT;
        }

        for (int rowIndex = 0; rowIndex < rowNum; rowIndex++) {
            HSSFRow row = sheet.createRow(rowIndex + 1);
            List rowValue = data.get(rowBeginIndex + rowIndex);
            int rowSize = rowValue.size();
            for (int colIndex = 0; colIndex < rowSize; colIndex++) {
                HSSFCell cell = row.createCell(colIndex);
                cell.setCellValue(rowValue.get(colIndex).toString());
            }

        }
    }


    public static void setSheetHeader(HSSFSheet sheet, List<String> headers) {

        Row header = sheet.createRow(0);
        int headerSize = headers.size();
        for (int headerIndex = 0; headerIndex < headerSize; headerIndex++) {
            Cell cell = header.createCell(headerIndex);
            cell.setCellValue(headers.get(headerIndex));
        }
    }
}

