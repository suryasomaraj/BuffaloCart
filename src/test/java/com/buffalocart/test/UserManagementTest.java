package com.buffalocart.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.listener.TestListener;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.MyAccountPage;
import com.buffalocart.pages.UserManagementPage;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class UserManagementTest extends Base {
    LoginPage login;
    ExcelUtility excel=new ExcelUtility();
    MyAccountPage account;

    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 9,enabled = true,description = "TC_009_verify_The_User_Management_sub_Tabs",groups = {"regression"})
    public void verify_The_User_Management_sub_Tabs() {
        login = new LoginPage(driver);
        extentTest.get().assignCategory("regression");
        List<String> data = excel.readDataFromExcel("Login_User");
        login.enterLoginEmail(data.get(4));
        extentTest.get().log(Status.PASS, "User name entered successfully");
        login.enterLoginPassword(data.get(5));
        extentTest.get().log(Status.PASS, "Password entered successfully");
        account = login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        account.clickOnEndTour();
        extentTest.get().log(Status.PASS, "clicked on end tour button successfully");
        account.clickOnUserManagementbutton();
        extentTest.get().log(Status.PASS, "clicked on UserManagement button successfully");
        List<String> actualSubMenuList=account.getUserManagementSubMenu();

        /*account.clickOnUserManagement();
        extentTest.get().log(Status.PASS, "clicked on user management successfully");
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        List<String>actual_subMenu=account.getUserManagementSubMenu();
        System.out.println(actual_subMenu.get(0));
        extentTest.get().log(Status.PASS, "get user management sub menu successfully");*/
        List<String> expected_subMenu=excel.readDataFromExcel("User_Management");

        Assert.assertEquals(actualSubMenuList,expected_subMenu,"error in user management sub tab list");
        extentTest.get().log(Status.PASS, "The user management sub tabs found successfully");
    }



}
