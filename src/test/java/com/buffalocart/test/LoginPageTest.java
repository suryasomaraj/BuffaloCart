package com.buffalocart.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listener.TestListener;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.MyAccountHomePage;
import com.buffalocart.pages.ResetPasswordPage;
import com.buffalocart.utilities.ExcelUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class LoginPageTest extends Base {
    LoginPage login;
    ExcelUtility excel=new ExcelUtility();
    MyAccountHomePage account;
    ResetPasswordPage resetPassword;
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 1,enabled = true,description = "TC_001_verify_Login_Page_Title",groups = {"regression"})
    public void verify_Login_Page_Title() throws IOException {
        extentTest.get().assignCategory("regression");
        login=new  LoginPage(driver);
        List<String> dataS=excel.readDataFromExcel("LoginPage");
        String actualTitle =login.getLoginPageTitle();
        String expectedTitle = dataS.get(6);
        extentTest.get().log(Status.PASS, "Login page title received");
        Assert.assertEquals(actualTitle,expectedTitle,"Page title not equal");
        extentTest.get().log(Status.PASS, "Expected title is matched with actual home page title");
    }
    @Test(priority = 2,enabled = true,description = "TC_002_verify_User_Login_With_Valid_User_Credentials",groups = {"smoke","regression"})
    public void verify_User_Login_With_Valid_User_Credentials() throws IOException {
        login=new LoginPage(driver);
        extentTest.get().assignCategory("smoke");
        extentTest.get().assignCategory("regression");
        List<String> dataS=excel.readDataFromExcel("LoginPage");
        login.enterLoginEmail(dataS.get(4));
        extentTest.get().log(Status.PASS, "User name entered successfully");
        login.enterLoginPassword(dataS.get(5));
        extentTest.get().log(Status.PASS, "Password entered successfully");
        account=login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        String actual=account.getUserName();
        String expected=dataS.get(7);
        Assert.assertEquals(actual,expected,"User Login Failed");
        extentTest.get().log(Status.PASS, "user logged in successfully");
    }
    @Test(priority = 3,enabled = true,description = "TC_003_verify_The_Error_Message_Displayed_For_User_Login_With_Invalid_Credentials",groups = {"regression"})
    public void verify_The_Error_Message_Displayed_For_User_Login_With_Invalid_Credentials() throws IOException {
        login=new LoginPage(driver);
        extentTest.get().assignCategory("regression");
        List<String> dataS=excel.readDataFromExcel("LoginPage");
        login.enterLoginEmail(dataS.get(12));
        extentTest.get().log(Status.PASS, "User name entered successfully");
        login.enterLoginPassword(dataS.get(13));
        extentTest.get().log(Status.PASS, "Password entered successfully");
        account=login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        String actual=login.getLoginFailedMessage();
        String expected=dataS.get(14);
        Assert.assertEquals(actual,expected,"User Logged in");
        extentTest.get().log(Status.PASS, "user logged in Fails");
    }
    @Test(priority = 4,enabled = true,description = "TC_004_verify_Whether_The_User_Is_Able_To_Click_On_Remember_Me_Checkbox",groups = {"regression"})
    public void verify_Whether_The_User_Is_Able_To_Click_On_Remember_Me_Checkbox() throws IOException {
        login=new LoginPage(driver);
        extentTest.get().assignCategory("regression");
        List<String> dataS=excel.readDataFromExcel("LoginPage");
        login.enterLoginEmail(dataS.get(4));
        extentTest.get().log(Status.PASS, "User name entered successfully");
        login.enterLoginPassword(dataS.get(5));
        extentTest.get().log(Status.PASS, "Password entered successfully");
        boolean statusRememberMe=login.getRememberMeSelection();
        System.out.println(statusRememberMe);
        Assert.assertTrue(statusRememberMe, "Checkbox Remember Me is not selected");
        account=login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        String actual=account.getUserName();
        String expected=dataS.get(7);
        Assert.assertEquals(actual,expected,"User Login Failed");
        extentTest.get().log(Status.PASS, "user logged in successfully");
    }
    @Test(priority =5,enabled = true,description = "TC_005_verify_Error_Message_Displayed_On_Reset_Password_Page_With_Invalid_Email_Id",groups = {"regression"})
    public void verify_Error_Message_Displayed_On_Reset_Password_Page_With_Invalid_Email_Id() throws IOException {
        login=new LoginPage(driver);
        extentTest.get().assignCategory("sanity");
        extentTest.get().assignCategory("regression");
        resetPassword=login.clickOnForgotYourPassword();
        extentTest.get().log(Status.PASS, "click on forgot your password successfully");
        List<String> dataS=excel.readDataFromExcel("LoginPage");
        resetPassword.enterEmailAddress(dataS.get(17));
        extentTest.get().log(Status.PASS, "Email id  entered successfully");
        resetPassword.getResetPasswordLink();
        String actual=resetPassword.getResetPasswordErrorMessage();
        System.out.println(dataS.get(18));
        String expected=dataS.get(18);
        Assert.assertEquals(actual,expected,"Send password reset link successfully");
        extentTest.get().log(Status.PASS, "Password Reset error message displayed successfully");
    }

}
