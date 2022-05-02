package com.buffalocart.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.listener.TestListener;
import com.buffalocart.pages.*;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class UsersPageTest extends Base {
    LoginPage login;
    ExcelUtility excel=new ExcelUtility();
    MyAccountPage account;
    UsersPage users;
    AddUserPage addUser;
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 10,enabled = true,description = "TC_0010_verify_Users_Page_Title",groups = {"regression"})
    public void verify_Users_Page_Title(){
        login=new LoginPage(driver);
        extentTest.get().assignCategory("regression");
        List<String> dataS=excel.readDataFromExcel("Users_Page");
        System.out.println(dataS.size());
        login.enterLoginEmail(dataS.get(4));
        extentTest.get().log(Status.PASS, "User name entered successfully");
        login.enterLoginPassword(dataS.get(5));
        extentTest.get().log(Status.PASS, "Password entered successfully");
        account=login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        account.clickOnEndTour();
        extentTest.get().log(Status.PASS, "clicked on end tour button successfully");
        account.clickOnUserManagement();

        extentTest.get().log(Status.PASS, "clicked on user management successfully");
        users=account.clickOnUsersSubTag();
        users=account.clickOnUsersSubTag();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        users.getUsersPageTitle();
        //users.enterUserSearch("jupiter");


        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        extentTest.get().log(Status.PASS, "clicked on user management sub tag Users successfully");
        String actualUsersPageTitle = users.getUsersPageTitle();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        System.out.println(users.getUsersPageTitle());

        String expectedUsersPageTitle = dataS.get(7);
        extentTest.get().log(Status.PASS, "User page title received");
        Assert.assertEquals(actualUsersPageTitle,expectedUsersPageTitle,"Users page title not equal");
        extentTest.get().log(Status.PASS, "Expected title is matched with actual users page title");
    }
    @Test(priority = 11,enabled = true,description = "TC_0011_verify_User_Search_With_Valid_Data",groups = {"regression"})
    public void verify_User_Search_With_Valid_Data() {
        login = new LoginPage(driver);
        extentTest.get().assignCategory("regression");
        List<String> dataS = excel.readDataFromExcel("Users_Page");
        System.out.println(dataS.size());
        login.enterLoginEmail(dataS.get(4));
        extentTest.get().log(Status.PASS, "User name entered successfully");
        login.enterLoginPassword(dataS.get(5));
        extentTest.get().log(Status.PASS, "Password entered successfully");
        account = login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        account.clickOnEndTour();
        extentTest.get().log(Status.PASS, "clicked on end tour button successfully");
        account.clickOnUserManagement();
        extentTest.get().log(Status.PASS, "clicked on user management successfully");
        users=account.clickOnUsersSubTag();
        extentTest.get().log(Status.PASS, "clicked on user management sub tag Users successfully");
        users.enterUserSearch("jupiter");
        extentTest.get().log(Status.PASS, "enter name of the user to be search successfully");
        List<ArrayList<String>> actual = excel.readDataSFromExcel("User_Details");
        List<ArrayList<String>> expected=users.getValidUserData();
        Assert.assertEquals(actual,expected,"error");
        extentTest.get().log(Status.PASS, "message displayed with valid user search successfully");
    }
    @Test(priority = 12,enabled = true,description = "TC_0012_verify_Message_Displayed_By_User_Search_With_Invalid_Data",groups = {"regression","smoke"})
    public void verify_Message_Displayed_By_User_Search_With_Invalid_Data() {
        login = new LoginPage(driver);
        extentTest.get().assignCategory("regression");
        extentTest.get().assignCategory("smoke");
        List<String> dataS = excel.readDataFromExcel("Users_Page");
        System.out.println(dataS.size());
        login.enterLoginEmail(dataS.get(4));
        extentTest.get().log(Status.PASS, "User name entered successfully");
        login.enterLoginPassword(dataS.get(5));
        extentTest.get().log(Status.PASS, "Password entered successfully");
        account = login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        account.clickOnEndTour();
        extentTest.get().log(Status.PASS, "clicked on end tour button successfully");
        account.clickOnUserManagement();
        extentTest.get().log(Status.PASS, "clicked on user management successfully");
        users=account.clickOnUsersSubTag();
        extentTest.get().log(Status.PASS, "clicked on user management sub tag Users successfully");
        users.enterUserSearch("13900");
        extentTest.get().log(Status.PASS, "enter name of the user to be search successfully");
        List<ArrayList<String>> actual_userData = users.getInValidUserData();
        List<ArrayList<String>> expected_userData=excel.readDataSFromExcel("Invalid_Data");
        Assert.assertEquals(actual_userData,expected_userData,"error");
        extentTest.get().log(Status.PASS, "message displayed with invalid user search successfully");

    }
    @Test(priority = 13,enabled = true,description = "TC_0011_Verify_Message_Displayed_By_User_Search_With_Invalid_Data",groups = {"regression"})
    public void verify_The_Error_Message_Displayed_Without_Filling_Mandatory_Fields_In_Add_User_Form() {
        login = new LoginPage(driver);
        extentTest.get().assignCategory("regression");
        extentTest.get().assignCategory("smoke");
        List<String> dataS = excel.readDataFromExcel("Users_Page");
        System.out.println(dataS.size());
        login.enterLoginEmail(dataS.get(4));
        extentTest.get().log(Status.PASS, "User name entered successfully");
        login.enterLoginPassword(dataS.get(5));
        extentTest.get().log(Status.PASS, "Password entered successfully");
        account = login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        account.clickOnEndTour();
        extentTest.get().log(Status.PASS, "clicked on end tour button successfully");
        account.clickOnUserManagement();
        extentTest.get().log(Status.PASS, "clicked on user management successfully");
        users=account.clickOnUsersSubTag();
        extentTest.get().log(Status.PASS, "clicked on user management sub tag Users successfully");
        addUser=users.clickOnAddUserButton();
        extentTest.get().log(Status.PASS, "clicked on add user successfully");
        users.enterUserSearch("13900");
        extentTest.get().log(Status.PASS, "enter name of the user to be search successfully");
        List<ArrayList<String>> actual_userData = users.getInValidUserData();
        List<ArrayList<String>> expected_userData=excel.readDataSFromExcel("Invalid_Data");
        Assert.assertEquals(actual_userData,expected_userData,"error");
    }


}
