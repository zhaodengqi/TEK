package toolkit;

import contract.TestContext;
import io.cucumber.guice.ScenarioScoped;

import java.util.HashMap;
import java.util.Map;

@ScenarioScoped
public class HashMapTestContext implements TestContext {
    private final Map map;
    public HashMapTestContext() {
        map = new HashMap();
    }

    public <T> T get(Object key) {
        return (T)map.get(key);
    }

    public void put(Object key,Object value) {
        map.put(key, value);
    }
}
