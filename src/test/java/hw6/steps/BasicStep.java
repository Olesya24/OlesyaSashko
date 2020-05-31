package hw6.steps;

import hw6.SingletonDriver;
import hw6.voids.OtherElementsOnPage;
import hw6.voids.UserIndexPage;
import hw6.voids.UserTablePage;

public abstract class BasicStep {
    UserIndexPage userIndexPage;
    OtherElementsOnPage otherElementsOnPage;
    UserTablePage userTablePage;

    protected BasicStep(){
        userIndexPage = new UserIndexPage(SingletonDriver.INSTANCE.getDriver());
        otherElementsOnPage = new OtherElementsOnPage(SingletonDriver.INSTANCE.getDriver());
        userTablePage = new UserTablePage(SingletonDriver.INSTANCE.getDriver());
    }
}
