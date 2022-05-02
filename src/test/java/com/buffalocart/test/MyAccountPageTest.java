package com.buffalocart.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listener.TestListener;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.MyAccountPage;
import com.buffalocart.utilities.CurrentDateUtility;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MyAccountPageTest extends Base {
    LoginPage login;
    ExcelUtility excel=new ExcelUtility();
    MyAccountPage account;
    CurrentDateUtility currentDate=new CurrentDateUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 6,enabled = true,description = "TC_006_verify_Home_Page_Title",groups = {"regression"})
    public void verify_Home_Page_Title(){
        login=new LoginPage(driver);
        extentTest.get().assignCategory("regression");
        List<String> dataS=excel.readDataFromExcel("Login_User");
        System.out.println(dataS.size());
        login.enterLoginEmail(dataS.get(4));
        extentTest.get().log(Status.PASS, "User name entered successfully");
        login.enterLoginPassword(dataS.get(5));
        extentTest.get().log(Status.PASS, "Password entered successfully");
        account=login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        String actual_homeTitle = account.getAccountPageTitle();
        String expected_homeTitle = dataS.get(7);
        extentTest.get().log(Status.PASS, "Home page title received");
        Assert.assertEquals(actual_homeTitle,expected_homeTitle,"Home page title not equal");
        extentTest.get().log(Status.PASS, "Expected title is matched with actual home page title");
    }
    @Test(priority = 7,enabled = true,description = "TC_007_verify_Date_Displayed_In_Home_Page",groups = {"regression"})
    public void verify_Date_Displayed_In_Home_Page() {
        login = new LoginPage(driver);
        extentTest.get().assignCategory("regression");
        List<String> dataS = excel.readDataFromExcel("Login_User");
        login.enterLoginEmail(dataS.get(4));
        extentTest.get().log(Status.PASS, "User name entered successfully");
        login.enterLoginPassword(dataS.get(5));
        extentTest.get().log(Status.PASS, "Password entered successfully");
        account = login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        String actual_currentDate= account.getCurrentDate();
        String expected_currentDate=currentDate.currentDate();
        extentTest.get().log(Status.PASS, "current date displayed in home successfully");
        Assert.assertEquals(actual_currentDate,expected_currentDate,"Current Date displayed incorrectly");
    }
}
