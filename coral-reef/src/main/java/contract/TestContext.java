package contract;


//@ImplementedBy(HashMapTestContext.class)
public interface TestContext {
    <T> T get(Object key);

    void put(Object key, Object value);
}