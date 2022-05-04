package com.buffalocart.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.listener.TestListener;
import com.buffalocart.pages.*;
import com.buffalocart.utilities.ExcelUtility;
import com.buffalocart.utilities.RandomDataUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ViewUsersTest  extends Base {
    LoginPage login;
    ExcelUtility excel=new ExcelUtility();
    MyAccountPage account;
    UsersPage users;
    AddUserPage addUser;
    UpdateUserPage updateUser;
    ViewUsersPage viewUser;
    RandomDataUtility randomData= new RandomDataUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();


    @Test(priority = 20,enabled = true,description = "TC_020_verify_The_Details_Displayed_On_View_User_Page",groups = {"regression"})
    public void verify_The_Details_Displayed_On_View_User_Page() {
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
        extentTest.get().log(Status.PASS, "User percentage entered successfully");
        users = addUser.clickOnUserSaveButton();
        extentTest.get().log(Status.PASS, "User percentage entered successfully");
        users.userSearchEdit(mail);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        extentTest.get().log(Status.PASS, "User searched successfully");
        viewUser=users.clickOnViewUserButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        String actualUser= viewUser.getViewUsers();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        String expectedUser="Email: "+mail;
        Assert.assertEquals(actualUser,expectedUser,"Users detail not equal");
        extentTest.get().log(Status.PASS, "details displayed on view user page successfully");
    }
}
