package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import com.buffalocart.utilities.WaitUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRolesPage extends ObjectUtility {
    WebDriver driver;
    /**Page Constructor**/
    public AddRolesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /**web element**/
    private final String _saveNewRoleButton = "button[class='btn btn-primary pull-right']";
    @FindBy(css = _saveNewRoleButton) private WebElement saveNewRoleButton;
    private final String _enterNewRole = "input[id='name']";
    @FindBy(css = _enterNewRole) private WebElement newRole;


    /**user action**/
    public String getAddRolesPageTitle(){
        String title = page.getPageTitle(driver);
        return title;
    }
    public void enterNewRole(String newRoleAdd){
        page.enterText(newRole,newRoleAdd);
    }

    public RolesPage saveNewRoleButton(){
        //wait.waitForVisibilityOfElement(driver);


        page.clickOnElement(saveNewRoleButton);
        return new RolesPage(driver);
    }



}
