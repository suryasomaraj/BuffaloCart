package com.buffalocart.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.listener.TestListener;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.MyAccountPage;
import com.buffalocart.pages.SignOutPage;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SignOutPageTest extends Base {

    LoginPage login;
    ExcelUtility excel=new ExcelUtility();
    MyAccountPage account;
    SignOutPage signOut;
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 8,enabled = true,description = "TC_008_verify_Whether_User_Is_Navigating_To_Login_Page_By_Clicking_On_Sign_Out_Button",groups = {"regression"})
    public void verify_Whether_User_Is_Navigating_To_Login_Page_By_Clicking_On_Sign_Out_Button() {
        login = new LoginPage(driver);
        extentTest.get().assignCategory("regression");
        extentTest.get().assignCategory("smoke");
        List<String> data = excel.readDataFromExcel("Login_User");
        login.enterLoginEmail(data.get(4));
        extentTest.get().log(Status.PASS, "User name entered successfully");
        login.enterLoginPassword(data.get(5));
        extentTest.get().log(Status.PASS, "Password entered successfully");
        account = login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        account.clickOnEndTour();
        extentTest.get().log(Status.PASS, "clicked on end tour button successfully");
        account.clickOnAccountUserName();
        extentTest.get().log(Status.PASS, "clicked on user name successfully");
        login=account.clickOnSignOutButton();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        extentTest.get().log(Status.PASS, "clicked on sign out button successfully");
        List<String> dataS=excel.readDataFromExcel("LoginPage");
        String actualTitle =login.getAfterSignOutLoginPageTitle();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        String expectedTitle = dataS.get(6);
        extentTest.get().log(Status.PASS, "Login page loaded successfully");
        Assert.assertEquals(actualTitle,expectedTitle,"Login Page not Loaded");
        extentTest.get().log(Status.PASS, "user is navigating to login page by clicking on sign out button successfully");
    }


    }
