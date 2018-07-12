package com.busyzero.algo.security.file;

import java.util.List;

/**
 * <Description>构建excel</Description>
 * <p>
 *     对于整个应用而言将可以根据需求配置builder，
 *     最后调用builder.toExcel() 获取
 * </p>
 * @author katey2658
 * @date 2018-07-12
 */
public class ExcelBuilder {

    /** 一个sheet 最大记录数 **/
    private int sheetMaxRowSize = 20000;

    /** 最大的Sheet数 */
    private int sheetNum;

    /** 设置表列数 */
    private int columnNum;

    /** 记录表表头数据 */
    private List<String> tableHeaderNames;

    /** sheet 命名 */
    private List<String> sheetNames;

    /** 数据记录 */
    private List<List<Object>> data;

    /** 是否输出为文件: 默认不输出为文件 */
    private Boolean outToFile = false;

    /** 文件名字 */
    private String outFileName;

    /** 输出路径 */
    private String outPath;


    /**
     * 获取一个配置好的EXCEL
     *
     * @return
     */
    public Excel toExcel (){
        return new Excel(this);
    }

    public static class Excel {
        private final int sheetMaxRowSize;

        private final int sheetNum;

        private final int columnNum;

        private Boolean outToFile;

        private String outFileName;

        private String outPath;

        private final List<String> tableHeaderNames;

        private final List<String> sheetNames;

        private final List<List<Object>> data;

        private Excel(ExcelBuilder builder){
            this.columnNum = builder.columnNum;
            this.data = builder.data;
            this.sheetMaxRowSize = builder.sheetMaxRowSize;
            this.sheetNum = builder.sheetNum;
            this.tableHeaderNames = builder.tableHeaderNames;
            this.sheetNames = builder.sheetNames;
            this.outToFile = builder.outToFile;
            this.outFileName = builder.outFileName;
            this.outPath = builder.outPath;
        }

        public int getSheetMaxRowSize() {
            return sheetMaxRowSize;
        }

        public int getSheetNum() {
            return sheetNum;
        }

        public int getColumnNum() {
            return columnNum;
        }

        public List<String> getTableHeaderNames() {
            return tableHeaderNames;
        }

        public List<String> getSheetNames() {
            return sheetNames;
        }

        public List<List<Object>> getData() {
            return data;
        }

        public Boolean getOutToFile() {
            return outToFile;
        }

        public String getOutFileName() {
            return outFileName;
        }

        public String getOutPath() {
            return outPath;
        }
    }

    public ExcelBuilder setSheetMaxRowSize(int sheetMaxRowSize) {
        this.sheetMaxRowSize = sheetMaxRowSize;
        return this;
    }

    public ExcelBuilder setSheetNum(int sheetNum) {
        this.sheetNum = sheetNum;
        return this;
    }

    public ExcelBuilder setColumnNum(int columnNum) {
        this.columnNum = columnNum;
        return this;
    }

    public ExcelBuilder setTableHeaderNames(List<String> tableHeaderNames) {
        this.tableHeaderNames = tableHeaderNames;
        return this;
    }

    public ExcelBuilder setSheetNames(List<String> sheetNames) {
        this.sheetNames = sheetNames;
        return this;
    }

    public ExcelBuilder setData(List<List<Object>> data) {
        this.data = data;
        return this;
    }

    public ExcelBuilder setOutFileName(String outFileName) {
        this.outFileName = outFileName;
        return this;
    }

    public ExcelBuilder setOutToFile(Boolean outToFile) {
        this.outToFile = outToFile;
        return this;
    }

    public ExcelBuilder setOutPath(String outPath){
        this.outPath = outPath;
        return  this;
    }

}
