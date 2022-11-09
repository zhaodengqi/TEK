package toolkit.pageobject.web;

import com.google.inject.Inject;
import contract.ActionBot;
import contract.po.BasePageObject;
import contract.po.PageRouter;
import core.container.ServiceLocator;

public class PageRouterImp implements PageRouter {
    private final ServiceLocator serviceLocator;
    private final ActionBot actionBot;

    @Inject
    public PageRouterImp(
            ServiceLocator serviceLocator,
            ActionBot actionBot) {
        this.serviceLocator = serviceLocator;
        this.actionBot = actionBot;
    }

    @Override
    public <T extends BasePageObject> T goTo(Class<T> pageClass) {
        //1.反射获取信息，导航页面
        T pageObject = build(pageClass);
        actionBot.openUrl(pageObject.getPageUrl());
        return pageObject;
    }

    @Override
    public <T extends BasePageObject> T build(Class<T> pageClass) {
        return this.serviceLocator.getInstance(pageClass);
    }
}
