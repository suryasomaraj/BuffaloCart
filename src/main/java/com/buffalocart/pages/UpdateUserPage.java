package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateUserPage extends ObjectUtility {
    WebDriver driver;

    /**Page Constructor**/
    public UpdateUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /**Web Elements**/
    private final String _userSurName = "input[id='surname']";
    @FindBy(css = _userSurName) private WebElement userSurName;
    private final String _userUpdatePercentage = "input[id='cmmsn_percent']";
    @FindBy(css = _userUpdatePercentage) private WebElement userUpdatePercentage;

    private final String _userUpdateEditButton = "button[id='submit_user_button']";
    @FindBy(css = _userUpdateEditButton) private WebElement userUpdateEditButton;

    /**user actions**/
    public String getUpdateUserPageTitle(){
        String title = page.getPageTitle(driver);
        return title;
    }

    public void enterUserUpdatePercentage(String userUpdatePercentage1) {
        userUpdatePercentage.clear();
        page.enterText(userUpdatePercentage,userUpdatePercentage1);
    }
    public UsersPage clickOnUpdateButton(){
        page.clickOnElement(userUpdateEditButton);
        return new UsersPage(driver);
    }
}
