package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RolesPage extends ObjectUtility {
    WebDriver driver;

    /**Page Constructor**/
    public RolesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /**Page Elements**/
    private final String _addRoles = "//div[2]/div[1]/section[2]/div/div[1]/div";
    @FindBy(xpath = _addRoles) private WebElement addRoles;



    public String getRolesPageTitle(){
        String title = page.getPageTitle(driver);
        return title;
    }
    public AddRolesPage clickOnAddRoles(){
        page.clickOnElement(addRoles);
        return new AddRolesPage(driver);
    }





}
