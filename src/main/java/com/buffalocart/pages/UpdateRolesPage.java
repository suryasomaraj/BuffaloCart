package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateRolesPage extends ObjectUtility {
    WebDriver driver;

    /**Page Constructor**/
    public UpdateRolesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private final String _enterNewRole = "input[id='name']";
    @FindBy(css = _enterNewRole) private WebElement newRole;

    private final String _updateRoleButton = "button[class='btn btn-primary pull-right']";
    @FindBy(css = _updateRoleButton) private WebElement updateRoleButton;



    public String getEditRolePageTitle(){
        String title = page.getPageTitle(driver);
        return title;
    }
    public void enterUpdatedNewRole(String newRoleAdd){
        newRole.clear();
        page.enterText(newRole,newRoleAdd);
    }

    public RolesPage updateRoleButton(){
        page.clickOnElement(updateRoleButton);
        return new RolesPage(driver);
    }



}
