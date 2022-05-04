package com.buffalocart.pages;

import com.buffalocart.utilities.ExcelUtility;
import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class UsersPage extends ObjectUtility {
    WebDriver driver;

    /**Page Constructor**/
    public UsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /**Page Elements**/
    private final String _userSearch = "input[class='form-control input-sm']";
    @FindBy(css = _userSearch) private WebElement userSearch;

    private final String _addButton = "a[class='btn btn-block btn-primary']";
    @FindBy(css = _addButton) private WebElement addUserButton;
    private final String _addUser = "div[class='toast-message']";
    @FindBy(css = _addUser) private WebElement addUser;

    private final String _signOut="div[class='pull-right']>a";
    @FindBy(css=_signOut) private WebElement signOut;


    private final String _userEditSearch = "input[class='form-control input-sm']";
    @FindBy(css = _userEditSearch) private WebElement userEditSearch;


    private final String _editUserButton = "//table[@id='users_table']/tbody/tr/td[5]/a[1]";
    @FindBy(xpath = _editUserButton) private WebElement editUserButton;

    private final String _updateUser = "div[class='toast-message']";
    @FindBy(css = _updateUser) private WebElement updateUser;


    private final String _deleteUserButton = "//table[@id='users_table']/tbody/tr[1]/td[5]/button";
    @FindBy(xpath = _deleteUserButton) private WebElement deleteUserButton;

    private final String _deleteUser = "div[class='toast-message']";
    @FindBy(css = _deleteUser) private WebElement deleteUser;


    private final String _deleteAlertButton = "//html/body/div[4]/div/div[4]/div[2]/button";
    @FindBy(xpath = _deleteAlertButton) private WebElement deleteAlertButton;


    private final String _viewUserButton = "//table[@id='users_table']/tbody/tr[1]/td[5]/a[2]";
    @FindBy(xpath = _viewUserButton) private WebElement viewUserButton;

    private final String _accountUserName="//html/body/div[2]/header/nav/div/ul/li[2]/a/span";
    @FindBy(xpath=_accountUserName) private WebElement accountUserName;


    private final String _goToAccount="/html/body/div[2]/aside/section/ul/li[1]/a/span";
    @FindBy(xpath=_goToAccount) private WebElement goToAccount;

private final String _invalidUser="//table[@id='users_table']/tbody/tr/td";
    @FindBy(xpath=_invalidUser) private WebElement invalidUser;


    /**User Action Methods**/
    public String getUsersPageTitle() {
        String title = page.getPageTitle(driver);
        System.out.println(title);
        return title;
    }
    public MyAccountPage goToUserAccount(){
        page.clickOnElement(goToAccount);
        return new MyAccountPage(driver);
    }


    public void enterUserSearch(String userName) {
        page.enterText(userSearch,userName);
    }

    private final String _rowElement="//table[@id='users_table']//th";
    @FindBy(xpath=_rowElement) private List<WebElement> rowElement;
    private final String _columnElement="//table[@id='users_table']//tr//td";
    @FindBy(xpath=_columnElement) private List<WebElement> columnElement;


    public List<ArrayList<String>> getValidUserData() {
        List<ArrayList<String>> expected_userData = table.getGridData(rowElement, columnElement);
        return expected_userData;
    }
    public List<ArrayList<String>> getInValidUserData() {
        List<WebElement> rowElement = driver.findElements(By.xpath("//table[@id='users_table']//th"));
        List<WebElement> columnElement = driver.findElements(By.xpath("//table[@id='users_table']//tr//td"));
        List<ArrayList<String>> expected_userData = table.getGridData(rowElement, columnElement);
        return expected_userData;
    }
    public AddUserPage clickOnAddUserButton() {
        page.clickOnElement(addUserButton);
        return new AddUserPage(driver);
    }

    public String getAddedUser(){
        String actual=page.getElementText(addUser);
        return actual;
    }
    public void userSearchEdit(String user){
        page.enterText(userEditSearch,user);
    }
    public UpdateUserPage clickOnUserEditButton(){
        page.clickOnElement(editUserButton);
        return new UpdateUserPage(driver);
    }
    public String getUpdateUser(){
        String actual=page.getElementText(updateUser);
        return actual;
    }
    public void clickOnUserDeleteButton(){
        page.clickOnElement(deleteUserButton);
    }
    public String getDeleteUser(){
        String delete=page.getElementText(deleteUser);
        return delete;
    }
    public void clickOnDeleteAlert(){
        page.clickOnElement(deleteAlertButton);
    }

    public ViewUsersPage clickOnViewUserButton(){
        page.clickOnElement(viewUserButton);
        return new ViewUsersPage(driver);
    }

    public LoginPage clickOnSignOutButton() {
        page.clickOnElement(signOut);
        return new LoginPage(driver);
    }

    public void clickOnAccountUserName(){
        page.clickOnElement(accountUserName);
    }

    public String getInvalidUser(){
        return page.getElementText(invalidUser);
    }



    }
