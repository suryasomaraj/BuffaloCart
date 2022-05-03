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


    /**User Action Methods**/
    public String getUsersPageTitle() {
        String title = page.getPageTitle(driver);
        System.out.println(title);
        return title;
    }
    public void enterUserSearch(String userName) {
        page.enterText(userSearch,userName);
    }
    public List<ArrayList<String>> getValidUserData() {
        List<WebElement> rowElement = driver.findElements(By.xpath("//table[@id='users_table']//th"));
        List<WebElement> columnElement = driver.findElements(By.xpath("//table[@id='users_table']//tr//td"));
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



    }
