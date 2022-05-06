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
    private final String _enterNewRole = "input[id='name']";
    @FindBy(css = _enterNewRole) private WebElement newRole;
    private final String _saveNewRoleButton = "button[class='btn btn-primary pull-right']";
    @FindBy(css = _saveNewRoleButton) private WebElement saveNewRoleButton;

    private final String _roleAdded = "div[class='toast-message']";
    @FindBy(css = _roleAdded) private WebElement roleAdded;

    private final String _searchRoleBox = "input[class='form-control input-sm']";
    @FindBy(css = _searchRoleBox) private WebElement searchRoleBox;
    private final String _editRoleButton = "//table[@id='roles_table']/tbody/tr/td[2]/a";
    @FindBy(xpath = _editRoleButton) private WebElement editRoleButton;
    private final String _roleUpdate = "div[class='toast-message']";
    @FindBy(css = _roleUpdate) private WebElement roleUpdate;
    private final String _deleteRolesButton = "button[class='btn btn-xs btn-danger delete_role_button']";
    @FindBy(css = _deleteRolesButton) private WebElement deleteRolesButton;
    private final String _deleteConfirmRolesButton = "/html/body/div[4]/div/div[4]/div[2]/button";
    @FindBy(xpath = _deleteConfirmRolesButton) private WebElement deleteConfirmRolesButton;
    private final String _roleDelete = "div[class='toast-message']";
    @FindBy(css = _roleDelete) private WebElement roleDelete;
    private final String _userHome="/html/body/div[2]/aside/section/ul/li[1]/a/span";
    @FindBy(xpath=_userHome) private WebElement userHome;

    /**User Actions**/
    public String getRolesPageTitle(){
        String title = page.getPageTitle(driver);
        return title;
    }
    public AddRolesPage clickOnAddRolesButton(){
        page.clickOnElement(addRoles);
        return new AddRolesPage(driver);
    }
    public void enterNewRole(String newRoleAdd){
        page.enterText(newRole,newRoleAdd);
    }
    public void saveNewRoleButton(){
        page.clickOnElement(saveNewRoleButton);
    }
    public String getRoleAdded(){
        String newRole=page.getElementText(roleAdded);
        return newRole;
    }
    public void getSearchRole(String role){
        page.enterText(searchRoleBox,role);
    }
    public UpdateRolesPage clickOnEditButton(){
        page.clickOnElement(editRoleButton);
        return new  UpdateRolesPage(driver);
    }
    public  String getRolesUpdated(){
        String rolesUpdate=page.getElementText(roleUpdate);
        return rolesUpdate;
    }
    public void clickOnDeleteRoleButton(){
        page.clickOnElement(deleteRolesButton);
    }
    public void ClickOnConfirmDeleteRoleButton(){
        page.clickOnElement(deleteConfirmRolesButton);
    }
    public String getRolesDeleted(){
        String roleDelete1=page.getElementText(roleDelete);
        return roleDelete1;
    }
    public MyAccountPage clickOnHome(){
        page.clickOnElement(userHome);
        return new MyAccountPage(driver);
    }
}
