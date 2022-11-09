package core.container;

import com.google.inject.Injector;

public class ServiceLocator {
    private static Injector injector;
    public static void setInjector(Injector injector) {
        ServiceLocator.injector = injector;
    }

    public <T> T getInstance(Class<T> aClass) {
        return injector.getInstance(aClass);
    }

}

