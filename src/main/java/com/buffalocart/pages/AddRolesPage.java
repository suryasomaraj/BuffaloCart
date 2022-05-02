package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddRolesPage extends ObjectUtility {
    WebDriver driver;

    /**Page Constructor**/
    public AddRolesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getAddRolesPageTitle(){
        String title = page.getPageTitle(driver);
        return title;
    }

}
