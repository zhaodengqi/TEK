package behavior.Elements;

public class AllegisElements {

    /*
     *  Allegis:登录页面
     */

    //用户名输入框xpath
    public static String allegis_username_xpath="//input[@id='username']";
    //密码输入框xpath
    public static String allegis_password_xpath="//input[@id='password']";
    //登录按钮xpath
    public static String allegis_logon_xpath="//input[@id='Login']";

    /*
     *  Allegis:HOME页面
     */
    //Create Employee (TC)按钮xpath
    public static String allegis_creat_employee_button_xpath="//ul[@class='utilitybar slds-utility-bar']/li[3]/div/div/button";

    /*
     *  Allegis:创建employee信息
     */
    //Employee First Name输入框xpath
    public static String allegis_employee_first_name_input_xpath="//input[@name='sel_Employee_Firstname']";
    //Employee Last Name输入框xpath
    public static String allegis_employee_last_name_input_xpath="//input[@name='sel_Employee_Last_Name']";
    //Legal_name输入框xpath
    public static String allegis_legal_name_input_xpath="//input[@name='sel_LegalName']";
    //Mobile Number输入框xpath
    public static String allegis_mobile_number_input_xpath="//input[@name='sel_Mobile_Number2']";
    //Email输入框xpath
    public static String allegis_email_input_xpath="//input[@inputmode='email']";

    //Brand选择框xpath
    public static String allegis_brand_choose_xpath="//select[@name='sel_Brand']";
    //Brand选择框选项xpath
    public static String allegis_brand_choose_item_xpath="//select[@name='sel_Brand']/option";

    //IIT Location选择框xpath
    public static String allegis_iit_location_xpath="//flowruntime-dependent-picklists/lightning-select/div/div/select";
    //IIT Location选择框选项xpath
    public static String allegis_iit_location_choose_item_xpath="//flowruntime-dependent-picklists/lightning-select/div/div/select/option";

    //SI Benefit Province选择框xpath
    public static String allegis_si_benefit_province_xpath="//flowruntime-dependent-picklists/lightning-select[2]/div/div/select";
    //SI Benefit Province选择框选项xpath
    public static String allegis_si_benefit_province_choose_item_xpath="//flowruntime-dependent-picklists/lightning-select[2]/div/div/select/option";

    //SI Benefit City选择框xpath
    public static String allegis_si_benefit_city_xpath="//flowruntime-dependent-picklists/lightning-select[3]/div/div/select";
    //SI Benefit City选择框选项xpath
    public static String allegis_si_benefit_city_choose_item_xpath="//flowruntime-dependent-picklists/lightning-select[3]/div/div/select/option";

    //next button按钮xpath //button[text()='Next']
    public static String allegis_button_next_xpath="//button[text()='Next']";



    //Onboard Date选择框选项xpath
    public static String allegis_onboard_date_input_xpath="//input[@name='sel_Payroll_Start_Date']";

    //Employment Type选择框xpath
    public static String allegis_employment_type_choose_xpath="//select[@name='Employment_Type']";
    //Employment Type选择框选项xpath
    public static String allegis_employment_type_choose_item_xpath="//select[@name='Employment_Type']/option";

    //Benefit Start Month选择框xpath
    public static String allegis_benefit_start_month_choose_xpath="//select[@name='Benefit_Start_Month1']";
    //Benefit Start Month选择框选项xpath
    public static String allegis_benefit_start_month_choose_item_xpath="//select[@name='Benefit_Start_Month1']/option";

    //Payment Entity选择框xpath
    public static String allegis_payment_entity_choose_xpath="//select[@name='sel_Payment_Entity']";
    //Payment Entity选择框选项xpath
    public static String allegis_payment_entity_choose_item_xpath="//select[@name='sel_Payment_Entity']/option";

    //Pay Schedule选择框xpath
    public static String allegis_pay_schedule_choose_xpath="//select[@name='sel_Pay_Schedule']";
    //Pay Schedule选择框选项xpath
    public static String allegis_pay_schedule_choose_item_xpath="//select[@name='sel_Pay_Schedule']/option";


    //Social Insurance Benefit City选择框xpath
    public static String allegis_social_insurance_benefit_city_choose_xpath="//flowruntime-dependent-picklists/lightning-select[1]/div/div/select";
    //Social Insurance Benefit City选择框选项xpath
    public static String allegis_social_insurance_benefit_city_choose_item_xpath="//flowruntime-dependent-picklists/lightning-select[1]/div/div/select/option";

    //Sick Leave Rule选择框xpath
    public static String allegis_sick_leave_rule_choose_xpath="//flowruntime-dependent-picklists/lightning-select[2]/div/div/select";
    //Sick Leave Rule选择框选项xpath
    public static String allegis_sick_leave_rule_choose_item_xpath="//flowruntime-dependent-picklists/lightning-select[2]/div/div/select/option[2]";
}
