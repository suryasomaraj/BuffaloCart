package com.buffalocart.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listener.TestListener;
import com.buffalocart.pages.AddUserPage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.MyAccountPage;
import com.buffalocart.pages.UsersPage;
import com.buffalocart.utilities.ExcelUtility;
import com.buffalocart.utilities.RandomDataUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AddUsersPageTest extends Base {
    LoginPage login;
    ExcelUtility excel=new ExcelUtility();
    MyAccountPage account;
    UsersPage users;
    AddUserPage addUser;
    RandomDataUtility randomData= new RandomDataUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 15,enabled = true,description = "TC_0015_verify_Add_Users_Page_Title",groups = {"regression"})
    public void verify_Add_Users_Page_Title() {
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
        addUser=users.clickOnAddUserButton();
        String actualTitle = users.getUsersPageTitle();
        String expectedTitle ="Add user - Llolll";
        extentTest.get().log(Status.PASS, "Login page title received");
        Assert.assertEquals(actualTitle,expectedTitle,"Page title not equal");
        extentTest.get().log(Status.PASS, "Expected title is matched with actual login page title");
    }


    @Test(priority = 16,enabled = true,description = "TC_0016_verify_User_Can_Add_User_Details",groups = {"regression","smoke"})
    public void verify_User_Can_Add_User_Details() {
        login = new LoginPage(driver);
        extentTest.get().assignCategory("regression");
        extentTest.get().assignCategory("smoke");
        String mail= randomData.randomUserMail();
        String userName=randomData.randomUser();
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
        users=addUser.clickOnUserSaveButton();
        extentTest.get().log(Status.PASS, "User percentage entered successfully");

        String actual_addUser=users.getAddedUser();
        extentTest.get().log(Status.PASS, "get the agent details successfully");
        String expected_addUser="User added successfully";
        extentTest.get().log(Status.PASS, "expected user is equal to actual user");
        Assert.assertEquals(actual_addUser,expected_addUser,"newly added user not found");
        extentTest.get().log(Status.PASS, "User can add user details successfully");



    }
}
