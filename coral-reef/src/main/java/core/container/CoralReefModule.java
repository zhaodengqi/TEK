package core.container;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import contract.ActionBot;
import contract.CoralReefConfiguration;
import contract.TestContext;
import contract.po.CoralReefWebDriverFactory;
import contract.po.PageRouter;
import contract.po.component.*;
import io.cucumber.guice.ScenarioScoped;
import toolkit.ActionBotImp;
import toolkit.CoralReefConfigurationImp;
import toolkit.HashMapTestContext;
import toolkit.pageobject.web.*;

public final class CoralReefModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ServiceLocator.class).in(Singleton.class);

        // same as use @ImplementedBy(CoralReefWebDriverImp.class) .
        bind(CoralReefWebDriverFactory.class).to(CoralReefWebDriverFactoryImp.class).in(ScenarioScoped.class);
        bind(PageRouter.class).to(PageRouterImp.class).in(ScenarioScoped.class);
        bind(CoralReefConfiguration.class).to(CoralReefConfigurationImp.class).in(Singleton.class);
        bind(TestContext.class).to(HashMapTestContext.class).in(ScenarioScoped.class);

        bind(ActionBot.class).to(ActionBotImp.class);
        bind(WebButton.class).to(WebButtonImp.class);
        bind(WebText.class).to(WebTextImp.class);
        bind(WebTextBox.class).to(WebTextBoxImp.class);
        bind(WebTable.class).to(WebTableImp.class);
        bind(WebSelect.class).to(WebSelectImp.class);
    }
}