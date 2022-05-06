package com.buffalocart.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.listener.TestListener;
import com.buffalocart.pages.*;
import com.buffalocart.utilities.ExcelUtility;
import com.buffalocart.utilities.RandomDataUtility;
import com.buffalocart.utilities.WaitUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class RolesPageTest extends Base {
    LoginPage login;
    ExcelUtility excel=new ExcelUtility();
    MyAccountPage account;
    RolesPage roles;
    AddRolesPage addRoles;
    UsersPage users;
    AddUserPage addUser;
    WaitUtility wait;
    RandomDataUtility randomData=new RandomDataUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 21,enabled = true,description = "TC_021_verify_Roles_Page_Title",groups = {"regression"})
    public void verify_Roles_Page_Title()  {
        extentTest.get().assignCategory("regression");
        login=new  LoginPage(driver);
        List<String> dataS=excel.readDataFromExcel("Login_User");
        login.enterLoginEmail(dataS.get(4));
        extentTest.get().log(Status.PASS, "User name entered successfully");
        login.enterLoginPassword(dataS.get(5));
        extentTest.get().log(Status.PASS, "Password entered successfully");
        account=login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        account.clickOnEndTour();
        extentTest.get().log(Status.PASS, "clicked on end tour button successfully");
        account.clickOnUserManagement();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        extentTest.get().log(Status.PASS, "clicked on user management successfully");
        roles=account.clickOnRoles();
        String actualTitle = roles.getRolesPageTitle();
        String expectedTitle = "Roles - Llolll";
        extentTest.get().log(Status.PASS, "Roles page title received");
        Assert.assertEquals(actualTitle,expectedTitle,"Roles Page title not equal");
        extentTest.get().log(Status.PASS, "Expected title is matched with actual Roles page title");
    }

    @Test(priority = 27,enabled = true,description = "TC_027_verify_Whether_The_added_Role_In_Role_Page_Is_Listed_In_Roles_Field_In_User_Add_Page",groups = {"regression"})
    public void verify_Whether_The_added_Role_In_Role_Page_Is_Listed_In_Roles_Field_In_User_Add_Page() {
        extentTest.get().assignCategory("regression");
        login = new LoginPage(driver);
        String new_Role=randomData.randomRole();
        List<String> dataS = excel.readDataFromExcel("Login_User");
        login.enterLoginEmail(dataS.get(4));
        extentTest.get().log(Status.PASS, "User name entered successfully");
        login.enterLoginPassword(dataS.get(5));
        extentTest.get().log(Status.PASS, "Password entered successfully");
        account = login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        account.clickOnEndTour();
        extentTest.get().log(Status.PASS, "clicked on end tour button successfully");
        account.clickOnUserManagement();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        extentTest.get().log(Status.PASS, "clicked on user management successfully");
        roles = account.clickOnRoles();
        extentTest.get().log(Status.PASS, "click on roles successfully");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        addRoles = roles.clickOnAddRolesButton();
        extentTest.get().log(Status.PASS, "click on add roles successfully");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        addRoles.enterNewRole(new_Role);
        extentTest.get().log(Status.PASS, "new role entered successfully");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        roles=addRoles.saveNewRoleButton();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        account=roles.clickOnHome();
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
        addUser.clickOnSearchRolesButton();
        addUser.enterSearchRole(new_Role);
        addUser.selectSearchRoleDrop(new_Role);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        addUser.equal(new_Role);
    }
}
