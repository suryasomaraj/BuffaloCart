package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class AddUserPage extends ObjectUtility {
    WebDriver driver;

    /**Page Constructor**/
    public AddUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /**Web Elements**/
    private final String _userSurName = "input[id='surname']";
    @FindBy(css = _userSurName) private WebElement userSurName;
    private final String _userFirstName = "input[id='first_name']";
    @FindBy(css = _userFirstName) private WebElement userFirstName;
    private final String _userLastName = "input[id='last_name']";
    @FindBy(css = _userLastName) private WebElement userLastName;
    private final String _userEmail = "input[id='email']";
    @FindBy(css = _userEmail) private WebElement userEmail;
    private final String _userName = "input[id='username']";
    @FindBy(css = _userName) private WebElement userName;
    private final String _userPassword = "input[id='password']";
    @FindBy(css = _userPassword) private WebElement userPassword;
    private final String _userConfirmPassword = "input[id='confirm_password']";
    @FindBy(css = _userConfirmPassword) private WebElement userConfirmPassword;
    private final String _userPercentage = "input[id='cmmsn_percent']";
    @FindBy(css = _userPercentage) private WebElement userPercentage;
    private final String _submit_user_button = "button[id='submit_user_button']";
    @FindBy(css = _submit_user_button) private WebElement submit_user_button;
    private final String _mandatoryError = "//label[@id='email-error']";
    @FindBy(xpath = _mandatoryError) private WebElement mandatoryError;
    private final String _addRole = "//span[@id='select2-role-container']";
    @FindBy(xpath = _addRole) private WebElement addRole;
    private final String _enterSearchRole = "/html/body/span/span/span[1]/input";
    @FindBy(xpath = _enterSearchRole) private WebElement enterSearchRole;

    private final String _enterSearchRole1 = "#select2-role-container";
    @FindBy(css = _enterSearchRole1) private WebElement enterSearchRole1;


    /**User Actions**/
    public String getAddUsersPageTitle(){
        String title = page.getPageTitle(driver);
        return title;
    }
    public void enterUserSurName(String userSurName1) {
        page.enterText(userSurName,userSurName1);
    }
    public void enterUserFirstName(String userFirstName1) {
        page.enterText(userFirstName,userFirstName1);
    }
    public void enterUserLastName(String userLastName1) {
        page.enterText(userLastName,userLastName1);
    }
    public void enterUserEmail(String userEmail1) {
        page.enterText(userEmail,userEmail1);
    }
    public void enterUserPassword(String userPassword1) {
        page.enterText(userPassword,userPassword1);
    }
    public void enterUserPasswordConfirm(String userConfirmPassword1) {
        page.enterText(userConfirmPassword,userConfirmPassword1);
    }
    public void enterUserPercentage(String userPercentage1) {
        page.enterText(userPercentage,userPercentage1);
    }
    public void enterUserUserName(String userName1) {
        page.enterText(userName,userName1);
    }
    public UsersPage clickOnUserSaveButton(){
        page.clickOnElement(submit_user_button);
        return new UsersPage(driver);
    }
    public String errorMandatoryDisplay(){
        String mandatoryErrorActual=page.getElementText(mandatoryError);
        return mandatoryErrorActual;
    }
    public void clickOnSearchRolesButton(){
        page.clickOnElement(addRole);
    }
    public void enterSearchRole(String role){
        page.enterText(enterSearchRole,role);
    }
    public void selectSearchRoleDrop(String new_Role){
        page.selectDropdownByValue(enterSearchRole1,"Test Engineer");
       // page.selectDropdownByValue(enterSearchRole,new_Role);
    }
    public void equal(String new_Role){
        if(page.getElementText(enterSearchRole1).equals(new_Role)){
            System.out.println("Equal");
        }

    }
}
