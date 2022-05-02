package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends ObjectUtility {
    WebDriver driver;

    /**Page Constructor**/
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**Page Elements**/
    private final String _loginName = "//input[@id='username']";
    @FindBy(xpath = _loginName) private WebElement loginName;
    private final String _loginPassword = "//input[@id='password']";
    @FindBy(xpath = _loginPassword) private WebElement loginPassword;
    private final String _loginButton = "button[type='submit']";
    @FindBy(css = _loginButton) private WebElement loginButton;
    private final String _loginFailedMessage = "span[class='help-block']>strong";
    @FindBy(css = _loginFailedMessage) private WebElement loginFailedMessage;
    private final String _loginRememberMe = "input[type='checkbox']";
    @FindBy(css = _loginRememberMe) private WebElement loginRememberMe;
    private final String _forgotPasswordLogin = "a[class='btn btn-link']";
    @FindBy(css = _forgotPasswordLogin) private WebElement forgotPasswordLogin;

    /** User Action Methods **/
    public String getLoginPageTitle(){
        String title = page.getPageTitle(driver);
        String expected = String.valueOf(excel.readDataFromExcel("LoginPage"));
        System.out.println(expected);
        return title;
    }
    public void enterLoginEmail(String userName) {
        page.enterText(loginName,userName);
    }
    public void enterLoginPassword(String password) {
        page.enterText(loginPassword, password);
    }
    public MyAccountPage clickOnLoginButton() {
        page.clickOnElement(loginButton);
        return new MyAccountPage(driver);
    }
    public String getLoginFailedMessage(){
        String errorMessage = page.getElementText(loginFailedMessage);
        return errorMessage;
    }
    public boolean clickOnRememberMeSelection() {
        page.clickOnElement(loginRememberMe);
        boolean rememberMeStatus=page.isElementSelected(loginRememberMe);
        System.out.println(rememberMeStatus);
        return rememberMeStatus;
    }
    public ResetPasswordPage clickOnForgotYourPassword(){
        page.clickOnElement(forgotPasswordLogin);
        return new ResetPasswordPage(driver);
    }
    public String getAfterSignOutLoginPageTitle(){
        String title = page.getPageTitle(driver);
        return title;
    }

}
