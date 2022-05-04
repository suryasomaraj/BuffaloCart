package com.buffalocart.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.listener.TestListener;
import com.buffalocart.pages.*;
import com.buffalocart.utilities.ExcelUtility;
import com.buffalocart.utilities.RandomDataUtility;
import com.buffalocart.utilities.TableUtility;
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
    RandomDataUtility randomData=new RandomDataUtility();
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
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        extentTest.get().log(Status.PASS, "clicked on user management successfully");
        users=account.clickOnUsersSubTag();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
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
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        users=account.clickOnUsersSubTag();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        extentTest.get().log(Status.PASS, "clicked on user management sub tag Users successfully");
        users.enterUserSearch("jsaturn2022@gmail.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        extentTest.get().log(Status.PASS, "enter name of the user to be search successfully");
        List<ArrayList<String>>getName=users.getValidUserData();
        String actual_Name= String.valueOf(getName.get(1));
        String expected_Name= "[Miss Jupiter Saturn]";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        Assert.assertEquals(actual_Name,expected_Name,"error in details");
        extentTest.get().log(Status.PASS, "user search with valid data searched successfully");
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        extentTest.get().log(Status.PASS, "clicked on user management successfully");
        users = account.clickOnUsersSubTag();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        extentTest.get().log(Status.PASS, "clicked on user management sub tag Users successfully");
        users.enterUserSearch("Huaweindochina");
        extentTest.get().log(Status.PASS, "enter name of the user to be search successfully");
        String actual_userData=users.getInvalidUser();
        String expected_userData="No matching records found";
        Assert.assertEquals(actual_userData,expected_userData,"error");
        extentTest.get().log(Status.PASS, "message displayed with invalid user search successfully");
    }

    @Test(priority = 13,enabled = true,description = "TC_0013_verify_The_Error_Message_Displayed_Without_Filling_Mandatory_Fields_In_Add_User_Form",groups = {"regression"})
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
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        extentTest.get().log(Status.PASS, "clicked on user management successfully");
        users = account.clickOnUsersSubTag();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        extentTest.get().log(Status.PASS, "clicked on user management sub tag Users successfully");
        addUser = users.clickOnAddUserButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        List<String> dataAdd = excel.readDataFromExcel("User_Add");
        addUser.enterUserFirstName(dataAdd.get(8));
        extentTest.get().log(Status.PASS, "User first name entered successfully");
        addUser.enterUserPassword(dataAdd.get(11));
        extentTest.get().log(Status.PASS, "User contact password entered successfully");
        addUser.clickOnUserSaveButton();
        extentTest.get().log(Status.PASS, "User percentage entered successfully");
        String actual_errorMandatory=addUser.errorMandatoryDisplay();
        String expected_errorMandatory="This field is required.";
        Assert.assertEquals(actual_errorMandatory,expected_errorMandatory,"error message not displayed");
        extentTest.get().log(Status.PASS, "The error message displayed without filling mandatory fields in add user form successfully");
    }


    @Test(priority = 14,enabled = true,description = "TC_0014_verify_User_Login_With_Newly_Added_User",groups = {"regression"})
    public void verify_User_Login_With_Newly_Added_User() {
        login = new LoginPage(driver);
        extentTest.get().assignCategory("regression");
        String mail = randomData.randomUserMail();
        String userName = randomData.randomUser();
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
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        extentTest.get().log(Status.PASS, "clicked on user management successfully");
        users = account.clickOnUsersSubTag();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        extentTest.get().log(Status.PASS, "clicked on user management sub tag Users successfully");
        addUser = users.clickOnAddUserButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        List<String> dataAdd = excel.readDataFromExcel("User_Add");
        addUser.enterUserSurName(dataAdd.get(7));
        extentTest.get().log(Status.PASS, "User sur name entered successfully");
        addUser.enterUserFirstName(dataAdd.get(8));
        extentTest.get().log(Status.PASS, "User first name entered successfully");
        addUser.enterUserLastName(dataAdd.get(9));
        extentTest.get().log(Status.PASS, "User last name entered successfully");
        addUser.enterUserEmail(mail);
        extentTest.get().log(Status.PASS, "User email entered successfully");
        addUser.enterUserUserName(userName);
        extentTest.get().log(Status.PASS, "User contact username entered successfully");
        addUser.enterUserPassword(dataAdd.get(11));
        extentTest.get().log(Status.PASS, "User contact password entered successfully");
        addUser.enterUserPasswordConfirm(dataAdd.get(12));
        extentTest.get().log(Status.PASS, "User address confirm password successfully");
        addUser.enterUserPercentage(dataAdd.get(13));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        extentTest.get().log(Status.PASS, "User percentage entered successfully");
        users=addUser.clickOnUserSaveButton();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        extentTest.get().log(Status.PASS, "User save button click successfully");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        account=users.goToUserAccount();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        account.clickOnAccountUserName();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        extentTest.get().log(Status.PASS, "clicked on user name successfully");
        login=users.clickOnSignOutButton();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        extentTest.get().log(Status.PASS, "clicked on sign out button successfully");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        login.enterLoginEmail(userName);
        extentTest.get().log(Status.PASS, "User name entered successfully");
        login.enterLoginPassword(dataAdd.get(11));
        extentTest.get().log(Status.PASS, "Password entered successfully");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        account = login.clickOnLoginButton();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        extentTest.get().log(Status.PASS, "clicked on end tour button successfully");
        String actual_userName=account.getAccountUserName();
        String expected_userName=dataAdd.get(8)+" "+dataAdd.get(9);
        Assert.assertEquals(actual_userName,expected_userName,"not login by new user");
        extentTest.get().log(Status.PASS, "User login with newly added user successfully");
    }
}
