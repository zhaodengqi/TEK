package behavior.tek;

import behavior.Elements.AllegisElements;
import behavior.Elements.ShinedElements;
import behavior.util.CommonUtils;
import behavior.util.ReadExcleUtils;
import com.google.inject.Inject;
import contract.ActionBot;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

@ScenarioScoped
public class AllegisSteps {
    private final ActionBot actionBot;

    @Inject
    public AllegisSteps(ActionBot actionBot) {
        this.actionBot = actionBot;
    }

    @Given("Open Allegis check login page")
    public void open_Allegis_check_login_page() {
        // Write code here that turns the phrase above into concrete actions
        actionBot.openOtherUrl("https://allegisgroup-apac1--survey.sandbox.my.salesforce.com");

    }

    @When("input username and password login Allegis")
    public void input_username_and_password_login_Allegis() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        actionBot.sendKeys(By.xpath(AllegisElements.allegis_username_xpath),"18729319975@163.com");
        actionBot.sendKeys(By.xpath(AllegisElements.allegis_password_xpath),"abc123456");
        actionBot.click(By.xpath(AllegisElements.allegis_logon_xpath));
        Thread.sleep(5000);
    }
    @When("create new order in Allegis")
    public void create_new_order_in_Allegis() throws Exception {

    /*
     *  Allegis:创建employee信息-第一个输入页
     */
        //点击Create Employee (TC)
        actionBot.click(By.xpath(AllegisElements.allegis_creat_employee_button_xpath));
        Thread.sleep(5000);
        //获取Employee First Name值
        String employee_first_name = ReadExcleUtils.readExcel("D:\\vito\\需求资料\\tek\\Test.xlsx",
                "",0, 63, 2);
        //输入Employee First Name
        actionBot.sendKeys(By.xpath(AllegisElements.allegis_employee_first_name_input_xpath),employee_first_name);
        //获取Employee Last Name值
        String employee_last_name = ReadExcleUtils.readExcel("D:\\vito\\需求资料\\tek\\Test.xlsx",
                "",0, 64, 2);
        //输入Employee Last Name
        actionBot.sendKeys(By.xpath(AllegisElements.allegis_employee_last_name_input_xpath),employee_last_name);

        //获取Leagl Name值
        String employee_legal_name = ReadExcleUtils.readExcel("D:\\vito\\需求资料\\tek\\Test.xlsx",
                "",0, 65, 2);
        //输入Leagl Name
        actionBot.sendKeys(By.xpath(AllegisElements.allegis_legal_name_input_xpath),employee_legal_name);

        //获取mobile number值
        String employee_mobile_number = ReadExcleUtils.readExcel("D:\\vito\\需求资料\\tek\\Test.xlsx",
                "",0, 66, 2);
        //输入mobile number
        actionBot.sendKeys(By.xpath(AllegisElements.allegis_mobile_number_input_xpath),employee_mobile_number);

        //获取email值
        String employee_email = ReadExcleUtils.readExcel("D:\\vito\\需求资料\\tek\\Test.xlsx",
                "",0, 67, 2);
        //输入email
        actionBot.sendKeys(By.xpath(AllegisElements.allegis_email_input_xpath),employee_email);
        //获取brand值
        String employee_brand = ReadExcleUtils.readExcel("D:\\vito\\需求资料\\tek\\Test.xlsx",
                "",0, 68, 2);
        //点击brand选择框
        actionBot.click(By.xpath(AllegisElements.allegis_brand_choose_xpath));
        //选择brand值
        actionBot.inputTextByItems(By.xpath(AllegisElements.allegis_brand_choose_item_xpath),employee_brand);

        //获取iit location值
        String employee_iit_location = ReadExcleUtils.readExcel("D:\\vito\\需求资料\\tek\\Test.xlsx",
                "",0, 69, 2);
        //点击iit location选择框
        actionBot.click(By.xpath(AllegisElements.allegis_iit_location_xpath));
        //选择iit location值
        actionBot.inputTextByItems(By.xpath(AllegisElements.allegis_iit_location_choose_item_xpath),employee_iit_location);
        Thread.sleep(5000);

        //获取SI Benefit Province值
        String employee_si_benefit_province_location = ReadExcleUtils.readExcel("D:\\vito\\需求资料\\tek\\Test.xlsx",
                "",0, 70, 2);
        //点击SI Benefit Province选择框
        actionBot.click(By.xpath(AllegisElements.allegis_si_benefit_province_xpath));
        //选择SI Benefit Province值
        actionBot.inputTextByItems(By.xpath(AllegisElements.allegis_si_benefit_province_choose_item_xpath),employee_si_benefit_province_location);

        //获取SI Benefit City值
        String employee_si_benefit_city_location = ReadExcleUtils.readExcel("D:\\vito\\需求资料\\tek\\Test.xlsx",
                "",0, 71, 2);
        //点击SI Benefit City选择框
        actionBot.click(By.xpath(AllegisElements.allegis_si_benefit_city_xpath));
        //选择SI Benefit City值
        actionBot.inputTextByItems(By.xpath(AllegisElements.allegis_si_benefit_city_choose_item_xpath),employee_si_benefit_city_location);

        //点击next
        actionBot.click(By.xpath(AllegisElements.allegis_button_next_xpath));
        Thread.sleep(1000);
    /*
    *  Allegis:创建employee信息-第二个输入页
    */
        //获取Onboard Date值   <-此处获取的日期有问题？？？->
        String employee_onboard_date = ReadExcleUtils.readExcel("D:\\vito\\需求资料\\tek\\Test.xlsx",
                "",0, 63, 5);
        //清空日期
        actionBot.clear(By.xpath(AllegisElements.allegis_onboard_date_input_xpath));
        //输入Onboard Date值
        actionBot.sendKeys(By.xpath(AllegisElements.allegis_onboard_date_input_xpath),"2022年10月19日");
//        actionBot.sendKeys(By.xpath(AllegisElements.allegis_onboard_date_input_xpath),employee_onboard_date);
        actionBot.clickBlank(0,0);

        //获取Employment Type值
        String employee_employment_type = ReadExcleUtils.readExcel("D:\\vito\\需求资料\\tek\\Test.xlsx",
                "",0, 64, 5);
        //点击Employment Type选择框
        actionBot.click(By.xpath(AllegisElements.allegis_employment_type_choose_xpath));
        //选择Employment Type值
        actionBot.inputTextByItems(By.xpath(AllegisElements.allegis_employment_type_choose_item_xpath),employee_employment_type);

        //获取Benefit Start Month值
        String employee_benefit_start_month= ReadExcleUtils.readExcel("D:\\vito\\需求资料\\tek\\Test.xlsx",
                "",0, 65, 5);
        //点击Benefit Start Month选择框
        actionBot.click(By.xpath(AllegisElements.allegis_benefit_start_month_choose_xpath));
        //选择Benefit Start Month值
        actionBot.inputTextByItemsStarsMonth(By.xpath(AllegisElements.allegis_benefit_start_month_choose_item_xpath),employee_benefit_start_month);

        //获取Payment Entity值
        String employee_payment_entity= ReadExcleUtils.readExcel("D:\\vito\\需求资料\\tek\\Test.xlsx",
                "",0, 66, 5);
        //点击Payment Entity选择框
        actionBot.click(By.xpath(AllegisElements.allegis_payment_entity_choose_xpath));
        //选择Payment Entity值
        actionBot.inputTextByItems(By.xpath(AllegisElements.allegis_payment_entity_choose_item_xpath),employee_payment_entity);


        //获取 Pay Schedule值
        String employee_pay_schedule= ReadExcleUtils.readExcel("D:\\vito\\需求资料\\tek\\Test.xlsx",
                "",0, 67, 5);
        //点击Payment Entity选择框
        actionBot.click(By.xpath(AllegisElements.allegis_pay_schedule_choose_xpath));
        //选择Payment Entity值
        actionBot.inputTextByItems(By.xpath(AllegisElements.allegis_pay_schedule_choose_item_xpath),employee_pay_schedule);

        //获取Social Insurance Benefit City值
        String employee_social_insurance_benefit_city= ReadExcleUtils.readExcel("D:\\vito\\需求资料\\tek\\Test.xlsx",
                "",0, 68, 5);
        //点击Payment Entity选择框
        actionBot.click(By.xpath(AllegisElements.allegis_social_insurance_benefit_city_choose_xpath));
        //选择Payment Entity值   <-->
        actionBot.inputTextByItems(By.xpath(AllegisElements.allegis_social_insurance_benefit_city_choose_item_xpath),employee_social_insurance_benefit_city);

        //点击Sick Leave Rule选择框
        actionBot.click(By.xpath(AllegisElements.allegis_sick_leave_rule_choose_xpath));
        //选择Sick Leave Rule值   <-->
        actionBot.click(By.xpath(AllegisElements.allegis_sick_leave_rule_choose_item_xpath));

        actionBot.click(By.xpath(AllegisElements.allegis_button_next_xpath));
        Thread.sleep(5000);

        //
        System.out.println("sss");
    }
}
