package toolkit;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import contract.CoralReefConfiguration;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class CoralReefConfigurationImp implements CoralReefConfiguration {
    private final HashMap map;

    public CoralReefConfigurationImp() {
        Gson gson = new Gson();
        String strJson = loadJsonStrFromFile();

        map = gson.fromJson(strJson, HashMap.class);
    }

    /**
     * 获取配置项
     *
     * @param key 配置 Key
     * @return 配置项信息
     */
    @Override
    public String getOption(String key) {
        return (String) map.get(key);
    }
    @Override
    public String getSubOption(String key,String subKey) {
        return (String) ((LinkedTreeMap) map.get(key)).get(subKey);
    }

    private String loadJsonStrFromFile() {
        String fileName = String.format("%s/src/test/resources/config/configuration.qa.json", System.getProperty("user.dir"));
        String content = null;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(fileName));
            content = new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            // some things here
        }
        return content;
    }
}
