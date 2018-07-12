package com.busyzero.algo.security.file;

/**
 * <Description>文件导出工具类</Description>
 * <p>
 *     当前版本支持 Excel，Pdf， World
 *     对应需要通过@link{ExcelBuilder},@link{PdfBuilder},@link{WordBuilder}
 * </p>
 * @author katey2659
 */
public class FileExportUtils {

    /**
     * <Description>讲数据导出为Excel文件</Description>
     * <p>
     *     该方法将创建一个特定的Excel 到指定文件夹创建为文件
     *     对于这个方法创建Excel 时候需要指定文件路径
     * </p>
     * @param excel
     */
    public static void toExcelFile(ExcelBuilder.Excel excel){

    }

    /**
     * <Description>讲数据导出为Excel流</Description>
     * <p>
     *     该方法将创建一个特定的Excel，并将返回一个二进制
     * </p>
     * @param excel
     */
    public static byte[] toExcelStream(ExcelBuilder.Excel excel){
        return null;
    }

    public static void toPdfFile(PdfBuilder.Pdf pdf){

    }

    public static byte[]  toPdfStream(PdfBuilder.Pdf pdf){
        return null;
    }

    public static void toWordFile(WordBuilder.Word word){

    }

    public static byte[] toWordStream(WordBuilder.Word word){
        return null;
    }

}
