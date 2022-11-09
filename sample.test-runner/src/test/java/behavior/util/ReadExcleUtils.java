package behavior.util;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExcleUtils {

    //读取excle对应的行列字段值   path:文件路径  ；whichsheet:excle中的第which个表，从0开始计数 ； row:行号  ； cell：列号
    public static String
        readExcel(String path,String strURL,int whichsheet,int row,int cell) {
        String getExcleValue="";
        try {
			/*// 如果需要通过URL获取资源的加上以下的代码，不需要的省略就行
			URL url = new URL(strURL);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			// 设置超时间为3秒
			conn.setConnectTimeout(3*1000);
			// 防止屏蔽程序抓取而返回403错误
			conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			// 获取输入流
			InputStream inputStream = conn.getInputStream();
			......*/

            // 获取文件输入流
            InputStream inputStream = new FileInputStream(path);
            // 定义一个org.apache.poi.ss.usermodel.Workbook的变量
            Workbook workbook = null;
            // 截取路径名 . 后面的后缀名，判断是xls还是xlsx还是xlsm
            String substring = path.substring(path.lastIndexOf("." )+1,path.length());
            if (substring.equals("xls")){
                workbook = new HSSFWorkbook(inputStream);
            } else if (substring.equals("xlsx")) {
                workbook = new XSSFWorkbook(inputStream);
            }else if (substring.equals("xlsm")) {
                workbook = new XSSFWorkbook(inputStream);
            }

            // 获取表
            Sheet sheet = workbook.getSheetAt(whichsheet);
            //获取对应的行
            Row get_row = sheet.getRow(row);
            //获取对应的列
            Cell get_cell = get_row.getCell(cell);
            get_cell.setCellType(CellType.STRING);
            getExcleValue = get_cell.getStringCellValue();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getExcleValue;
    }

    //读取word文件内容
    public static String readWordDoc(String path) throws IOException {
        String resullt = "";
        //首先判断文件中的是doc/docx
        try {
            if (path.endsWith(".doc")) {
                InputStream is = new FileInputStream(new File(path));
                WordExtractor re = new WordExtractor(is);
                resullt = re.getText();
                re.close();
            } else if (path.endsWith(".docx")) {
                OPCPackage opcPackage = POIXMLDocument.openPackage(path);
                POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
                resullt = extractor.getText();
                extractor.close();
            } else {
                System.out.println("此文件不是word文件");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return resullt;
    }


}
