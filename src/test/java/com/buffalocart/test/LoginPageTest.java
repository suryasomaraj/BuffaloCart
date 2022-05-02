package com.buffalocart.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listener.TestListener;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.MyAccountPage;
import com.buffalocart.pages.ResetPasswordPage;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class LoginPageTest extends Base {
    LoginPage login;
    ExcelUtility excel=new ExcelUtility();
    MyAccountPage account;
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 1,enabled = true,description = "TC_001_verify_Login_Page_Title",groups = {"regression"})
    public void verify_Login_Page_Title()  {
        extentTest.get().assignCategory("regression");
        login=new  LoginPage(driver);
        List<String> dataS=excel.readDataFromExcel("LoginPage");
        String actualTitle = login.getLoginPageTitle();
        String expectedTitle = dataS.get(6);
        extentTest.get().log(Status.PASS, "Login page title received");
        Assert.assertEquals(actualTitle,expectedTitle,"Page title not equal");
        extentTest.get().log(Status.PASS, "Expected title is matched with actual login page title");
    }
    @Test(priority = 2,enabled = true,description = "TC_002_verify_User_Login_With_Valid_User_Credentials",groups = {"smoke","regression"})
    public void verify_User_Login_With_Valid_User_Credentials() {
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
        String actual_ValidUserName=account.getUserName();
        String expected_ValidUserName=dataS.get(7);
        Assert.assertEquals(actual_ValidUserName,expected_ValidUserName,"User Login Failed with valid credentials");
        extentTest.get().log(Status.PASS, "user logged in successfully with valid credentials");
    }
    @Test(priority = 3,dataProvider = "user_credentials",enabled = true,groups = {"Regression"},description = "TC_003__verify_The_Error_Message_Displayed_For_User_Login_With_Invalid_Credentials")
    public void verify_The_Error_Message_Displayed_For_User_Login_With_Invalid_Credentials(String userName, String password){
        extentTest.get().assignCategory("regression");
        login = new LoginPage(driver);
        login.enterLoginEmail(userName);
        extentTest.get().log(Status.PASS, "User name entered successfully");
        login.enterLoginPassword(password);
        extentTest.get().log(Status.PASS, "Password entered successfully");
        login.clickOnRememberMeSelection();
        extentTest.get().log(Status.PASS, "user is able to click on Remember Me Check Box successfully");
        account=login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        String expected_ErrorMessage ="These credentials do not match our records.";
        String actual_ErrorMessage =login.getLoginFailedMessage();
        extentTest.get().log(Status.PASS, "Error message displayed for login with invalid user credentials successfully");
        Assert.assertEquals(actual_ErrorMessage,expected_ErrorMessage,"User Logged in with invalid credentials");
    }
    @DataProvider(name = "user_credentials")
    public Object[][] userLoginData()  {
        Object[][] data = excel.getData("Login_invalidCredentials");
        return data;
    }
    @Test(priority = 4,enabled = true,description = "TC_004_verify_Whether_The_User_Is_Able_To_Click_On_Remember_Me_Checkbox",groups = {"regression"})
    public void verify_Whether_The_User_Is_Able_To_Click_On_Remember_Me_Checkbox(){
        login=new LoginPage(driver);
        extentTest.get().assignCategory("regression");
        boolean statusRememberMe=login.clickOnRememberMeSelection();
        Assert.assertTrue(statusRememberMe, "Checkbox Remember Me is not selected");
        extentTest.get().log(Status.PASS, "user is able to click on Remember Me Check Box successfully");
    }




}
