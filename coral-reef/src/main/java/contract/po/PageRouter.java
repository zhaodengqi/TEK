package contract.po;

public interface PageRouter {
    <T extends BasePageObject> T goTo(Class<T> pageClass);
    <T extends BasePageObject> T build(Class<T> pageClass);
}
