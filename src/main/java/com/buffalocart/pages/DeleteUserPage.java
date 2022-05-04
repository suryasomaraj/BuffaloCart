package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DeleteUserPage extends ObjectUtility {
    WebDriver driver;
    /**Page Constructor**/
    public DeleteUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
