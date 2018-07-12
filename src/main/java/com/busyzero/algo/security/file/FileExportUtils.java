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
     * <Description>将数据导出为Excel文件</Description>
     * <p>
     *     该方法将创建一个特定的Excel 到指定文件夹创建为文件
     *     对于这个方法创建Excel 时候需要指定文件路径
     * </p>
     * @param excel
     */
    public static void toExcelFile(ExcelBuilder.Excel excel){

    }

    /**
     * <Description>将数据导出为Excel流</Description>
     * <p>
     *     该方法将创建一个特定的Excel，并将返回一个二进制
     * </p>
     * @param excel
     */
    public static byte[] toExcelStream(ExcelBuilder.Excel excel){
        return null;
    }

    /**
     * <Description>将数据导出为PDF文件</Description>
     * <p>
     *     该方法就是将数据导出为PDF文件，需要在builder 中指定路径
     * </p>
     * @param pdf
     */
    public static void toPdfFile(PdfBuilder.Pdf pdf){

    }

    /**
     * <Description>将数据导出为PDF文件流</Description>
     * <p>
     *     将该方法将数据导出为PDF 文件，导出为二进制流
     * </p>
     * @param pdf
     * @return
     */
    public static byte[]  toPdfStream(PdfBuilder.Pdf pdf){
        return null;
    }

    /**
     * <Description>将数据导出为Word 文件</Description>
     * <p>
     *    将该方法将数据导出为Word文件， 导出到具体文件
     *    需要指定路径地址
     * </p>
     * @param word
     */
    public static void toWordFile(WordBuilder.Word word){

    }

    /**
     * <Description>将数据导出为Word 文件流</Description>
     * <p>
     *    将该方法将数据导出为Word文件， 导出到具体bin 数据
     *    需要指定路径地址
     * </p>
     * @param word
     */
    public static byte[] toWordStream(WordBuilder.Word word){
        return null;
    }

}
