package contract;

/**
 * 配置管理接口
 */
public interface CoralReefConfiguration {
    /**
     * 获取配置项
     *
     * @param key 配置 Key
     * @return 配置项信息
     */
    String getOption(String key);

    //TODO 需要重新设计，目前是应急方案
    String getSubOption(String key, String subKey);
}
