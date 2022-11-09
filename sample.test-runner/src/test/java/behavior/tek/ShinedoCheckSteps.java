package behavior.tek;

import behavior.Elements.ShinedElements;
import behavior.util.CommonUtils;
import behavior.util.FileUtils;
import behavior.util.ReadExcleUtils;
import com.google.inject.Inject;
import contract.ActionBot;
import contract.CoralReefConfiguration;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import toolkit.CoralReefConfigurationImp;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import static behavior.util.FileUtils.getFile;

@ScenarioScoped
public class ShinedoCheckSteps {
    private final ActionBot actionBot;

    @Inject
    public ShinedoCheckSteps(ActionBot actionBot){
        this.actionBot = actionBot;
    }
    @Given("Open qatool home page")
    public void open_qatool_home_page() throws InterruptedException {
        //TODO: use different config build different web-driver here.
        actionBot.openUrl("{tools-qa}");
    }

    //打开ShinedpCheck登录页面
    @Given("Open shinedo check login page")
    public void open_shinedo_check_login_page() {
        // Write code here that turns the phrase above into concrete actions
        actionBot.openOtherUrl("https://bc.shinedocheck.com/custom/#/app/shouye");


    }

    //输入用户名和密码登录ShinedpCheck
    @When("input username and password login shinedo")
    public void input_username_and_password_login_shinedo() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        actionBot.sendKeys(By.xpath(ShinedElements.shined_username_xpath),"yaya.liu@allegisgroup.com");
        actionBot.sendKeys(By.xpath(ShinedElements.shined_password_xpath),"admin");
        actionBot.click(By.xpath(ShinedElements.shined_login_xpath));
        Thread.sleep(3000);
    }


    //创建新订单
    @When("create new order in shined")
    public void create_new_order_in_shined() throws Exception {

        //excle文件存放路径
        File[] file_list = getFile("D:\\vito\\数据\\背调系统");
        //简历文件存放路径
        File[] file_list_resume = getFile("D:\\vito\\数据\\简历");
        for(int i=0;i<file_list.length;i++){
            if(file_list[i].isFile()){
                // only take file name
                String name = file_list[i].getName();
                System.out.println("^^^^^" + file_list[i].getName());
                File file = file_list[i];
                // take file path and name
                System.out.println("#####" + file_list[i]);
                // take file path and name
                String path = file_list[i].getPath();
                System.out.println("*****" + file_list[i].getPath());

                // Write code here that turns the phrase above into concrete actions
                //点击订单管理
                actionBot.click(By.xpath(ShinedElements.shined_order_management_xpath));
                Thread.sleep(2000);
                //点击创建订单
                actionBot.click(By.xpath(ShinedElements.shined_craet_order_xpath));
                //点击获取添加候选人
                actionBot.click(By.xpath(ShinedElements.add_single_xpath));
                Thread.sleep(2000);

                /*
                 *候选人信息填写
                 */
                //滑动到结束添加按钮
                actionBot.swipeToElementVisible(By.xpath(ShinedElements.end_add_button_xpath));

                //获取候选人姓名
                String candidate_name = ReadExcleUtils.readExcel(file_list[i].getPath(),
                        "",1, 28, 2);

                //填入候选人姓名
                actionBot.sendKeys(By.xpath(ShinedElements.candidate_name_xapth),candidate_name);

                //获取候选人电话
                String candidate_phone_number = ReadExcleUtils.readExcel(file_list[i].getPath(),
                        "",1, 29, 2);

                //填入候选人电话
                actionBot.sendKeys(By.xpath(ShinedElements.candidate_phone_number),candidate_phone_number);


                //获取候选人邮箱
                String candidate_eamil = ReadExcleUtils.readExcel(file_list[i].getPath(),
                        "",1, 30, 2);

                //填入候选人邮箱
                actionBot.sendKeys(By.xpath(ShinedElements.candidate_email),candidate_eamil);

                //获取是否加急
                String urgent_orNot = ReadExcleUtils.readExcel(file_list[i].getPath(),
                        "",1, 32, 2);
                //填入是否加急-1.点击弹出选择框
                actionBot.click(By.xpath(ShinedElements.urgent_orNot_xpath));

                //填入是否加急-2.根据表中获取值选择是否选项
                if (urgent_orNot.equals("Yes")){
                    //选择是
                    actionBot.click(By.xpath(ShinedElements.urgent_orNot_select_Yes_xpath));
                    //点击额外收费弹框确定按钮
                    actionBot.click(By.xpath(ShinedElements.urgent_orNot_select_Yes_confirm_button_xpath));
                    Thread.sleep(2000);
                }else if (urgent_orNot.equals("No")){
                    //选择否
                    actionBot.click(By.xpath(ShinedElements.urgent_orNot_select_No_xpath));
                }

                String resume_path="";
                //获取对应的上传简历所在路径
                for (int j=0;j<file_list_resume.length;j++){
                    String get_resume_name = file_list_resume[j].getName();
                    if(get_resume_name.contains(candidate_name)){

                        resume_path = file_list_resume[j].getPath();

                        break;
                    }
                }
                //点击简历上传
                actionBot.click(By.xpath(ShinedElements.shined_resume_upload_button_xpath));
                Thread.sleep(2000);
                CommonUtils.uploadFiles("D:\\vito\\sheet\\upload.exe",resume_path);

                //点击结束添加按钮
                actionBot.click(By.xpath(ShinedElements.end_add_button_xpath));
                Thread.sleep(1000);

                /*
                 *套餐选择
                 */
                //滑动页面到附加调查项
                actionBot.swipeToElementVisible(By.xpath(ShinedElements.addinal_survey_items));
                //获取套餐字段
                String package_item = ReadExcleUtils.readExcel(file_list[i].getPath(),
                        "",1, 34, 2);
                String package_item_fields = package_item.substring(package_item.length() - 5);
                //选择对应套餐
                if (package_item_fields.equals("定制套装1")){//套餐1

                    actionBot.click(By.xpath(ShinedElements.package_one_xpath));

                }else if(package_item_fields.equals("定制套装2")){//套餐2

                    actionBot.click(By.xpath(ShinedElements.package_two_xpath));

                }else if(package_item_fields.equals("定制套装3")){//套餐3

                    actionBot.click(By.xpath(ShinedElements.package_three_xpath));

                }

                /*
                 *附加调查项选择------此处逻辑待定，Yaya确认后更新
                 */

                //滑动页面到提交按钮
                actionBot.swipeToElementVisible(By.xpath(ShinedElements.submit_button_xpath));
                //获取是否额外添加产品字段值
                String isOrNot_additional_product= ReadExcleUtils.readExcel(file_list[i].getPath(),
                        "",1, 35, 2);
                //是否额外添加产品
                if (isOrNot_additional_product.equals("No")){

                }else if(isOrNot_additional_product.equals("Yes")){

                }

                //点击提交按钮
                actionBot.click(By.xpath(ShinedElements.submit_button_xpath));
                Thread.sleep(500);
                actionBot.click(By.xpath(ShinedElements.submit_confirm_xpath));
                System.out.println("sss");
            }
        }


    }
}
