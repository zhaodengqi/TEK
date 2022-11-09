package behavior.Elements;

public class ShinedElements {
    //用户名输入框xpath
    public static String shined_username_xpath="//input[@placeholder='用户名']";
    //密码输入框xpath
    public static String shined_password_xpath="//input[@placeholder='密码']";
    //登录按钮xpath
    public static String shined_login_xpath="//span[text()='登 录']";
    //订单管理xpath
    public static String shined_order_management_xpath="//span[text()='订单管理']";
    //创建订单xpath
    public static String shined_craet_order_xpath="//li[text()='创建订单']";
    //添加候选人
    public static String add_single_xpath="//i[@class='iconfont icontianjia']";
    //简历上传按钮xpath
    public static String shined_resume_upload_button_xpath="//div[@id='addOrder']/div[2]/div/div/form/div[9]/div/div/div/a[1]";
    //简历上传输入框xpath
    public static String upload_resume_input_xpath="//input[@type='file']";
    //结束添加按钮xpath
    public static String end_add_button_xpath="//button[@class='el-button el-button--success']";

    /*
     *  订单管理->创建订单：   候选人信息xpath
     */
    //候选人姓名 xpath
    public static String candidate_name_xapth="//input[@placeholder='候选人姓名']";
    //候选人电话 xpath
    public static String candidate_phone_number="//input[@placeholder='候选人电话']";
    //候选人邮箱 xpath
    public static String candidate_email="//input[@placeholder='候选人邮箱']";
    //是否加急输入框xpath
    public static String urgent_orNot_xpath="//div[@id='addOrder']/div[2]/div/div/form/div[6]/div[2]/div/div/div/div/input";
    //是否加急：选择-是 xpath
    public static String urgent_orNot_select_Yes_xpath="//body/div[2]/div/div/ul/li[1]";
    //选择是-弹出提示框确定按钮xpath
    public static String urgent_orNot_select_Yes_confirm_button_xpath="//button[@class='el-button el-button--default el-button--small el-button--primary ']";
    //是否加急：选择-否 xpath
    public static String urgent_orNot_select_No_xpath="//body/div[2]/div/div/ul/li[2]";


    /*
     *  选择套餐
     */
    //附加调查项
    public static String addinal_survey_items="//div[text()='附加调查项']";
    //套餐：标准版-xpath
    public static String standard_edtion_xpath="//span[text()='标准版']";
    //套餐：套餐1-xpath
    public static String package_one_xpath="//span[text()='套餐1']";
    //套餐：套餐2-xpath
    public static String package_two_xpath="//span[text()='套餐2']";
    //套餐：套餐3-xpath
    public static String package_three_xpath="//span[text()='套餐3']";

    /*
     *  附加调查项选项
     */
    //学历毕业证验证(2001年之后)(50元)
    public static String verification_of_diploma_checkbox_xpath="//span[text()='学历毕业证验证(2001年之后)（50元）']";

    //工作履历信息验证X5(600元)
    public static String verification_of_work_experience_X5_checkbox_xpath="//span[text()='工作履历信息验证X5（600元）']";


    //工作履历信息验证X4(480元)
    public static String verification_of_work_experience_X4_checkbox_xpath="//span[text()='工作履历信息验证X4（480元）']";

    //金融违规调查(115元)
    public static String financial_violation_investigation_checkbox_xpath="//span[text()='金融违规调查（115元）']";

    //网络媒体库查询(100元)
    public static String network_media_query_checkbox_xpath="//span[text()='网络媒体库查询（100元）']";

    //有限法院诉讼记录查询(110元)
    public static String court_record_query_checkbox_xpath="//span[text()='有限法院诉讼记录查询（110元）']";

    //全球数据库
    public static String globle_database_checkbox_xpath="//span[text()='全球数据库（220元）']";

    // 提交按钮xpath
    public static String submit_button_xpath="//span[text()='提交']";

    //提交弹框确认按钮xpath

    public static String submit_confirm_xpath="//button[@class='el-button el-button--default el-button--small el-button--primary ']";


}
