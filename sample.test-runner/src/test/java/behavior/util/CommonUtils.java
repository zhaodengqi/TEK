package behavior.util;

import java.io.IOException;

public class CommonUtils {

    //模拟上传文件操作   exeFilepath:Autoit .exe执行文件路径(注意传入.exe命令行路径后面加空格);filepath:被上传文件路径
    public static void uploadFiles(String exeFilepath,String filepath){
        String picName = "D:\\vito\\需求资料\\tek\\张三.xlsx";
        //上传简历
        Runtime runtime = Runtime.getRuntime();
        try {

            runtime.exec(exeFilepath+" "+filepath);
            Thread.sleep(5000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
