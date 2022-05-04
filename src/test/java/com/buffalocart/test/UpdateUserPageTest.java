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

public class UpdateUserPageTest extends Base {
    LoginPage login;
    ExcelUtility excel=new ExcelUtility();
    MyAccountPage account;
    UsersPage users;
    AddUserPage addUser;
    UpdateUserPage updateUser;
    RandomDataUtility randomData= new RandomDataUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();


    @Test(priority = 17,enabled = true,description = "TC_0017_verify_Edit_User_Page_Title",groups = {"regression"})
    public void verify_Edit_User_Page_Title() {
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
        extentTest.get().log(Status.PASS, "User searched successfully");
        updateUser=users.clickOnUserEditButton();
        extentTest.get().log(Status.PASS, "click on user edit button successfully");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        String actualUpdateUserPageTitle = updateUser.getUpdateUserPageTitle();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        String expectedUpdateUserPageTitle = "Edit user - Llolll";
        extentTest.get().log(Status.PASS, "User edit page title received");
        Assert.assertEquals(actualUpdateUserPageTitle,expectedUpdateUserPageTitle,"User edit page title not equal");
        extentTest.get().log(Status.PASS, "Expected title is matched with actual user edit page title");
    }

    @Test(priority = 18,enabled = true,description = "TC_0018_verify_User_Can_Edit_The_User_Details",groups = {"regression"})
    public void verify_User_Can_Edit_The_User_Details() {
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
        extentTest.get().log(Status.PASS, "User searched successfully");
        updateUser = users.clickOnUserEditButton();
        extentTest.get().log(Status.PASS, "click on user edit button successfully");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        updateUser.enterUserUpdatePercentage("79");
        extentTest.get().log(Status.PASS, "user details updated successfully");
        users=updateUser.clickOnUpdateButton();
        extentTest.get().log(Status.PASS, "click on user update button successfully");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        String actualUpdateUser = users.getUpdateUser();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        String expectedUpdateUser = "User updated successfully";
        extentTest.get().log(Status.PASS, "User updated successfully");
        Assert.assertEquals(actualUpdateUser,expectedUpdateUser,"User details not updated");
        extentTest.get().log(Status.PASS, "User can edit the user details successfully");
    }
}
