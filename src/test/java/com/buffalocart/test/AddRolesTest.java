package com.buffalocart.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.listener.TestListener;
import com.buffalocart.pages.AddRolesPage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.MyAccountPage;
import com.buffalocart.pages.RolesPage;
import com.buffalocart.utilities.ExcelUtility;
import com.buffalocart.utilities.WaitUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AddRolesTest extends Base {
    LoginPage login;
    ExcelUtility excel=new ExcelUtility();
    MyAccountPage account;
    RolesPage roles;
    AddRolesPage addRoles;
    WaitUtility wait;
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();


    @Test(priority = 22,enabled = true,description = "TC_022_verify_Add_Roles_Page_Title",groups = {"regression"})
    public void verify_Add_Roles_Page_Title()  {
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
        addRoles=roles.clickOnAddRoles();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String actualTitle = addRoles.getAddRolesPageTitle();
        String expectedTitle = "Add Role - Llolll";
        extentTest.get().log(Status.PASS, "Add Role page title received");
        Assert.assertEquals(actualTitle,expectedTitle,"Add Role Page title not equal");
        extentTest.get().log(Status.PASS, "Expected title is matched with actual Add Role Page title");
    }

    @Test(priority = 23,enabled = true,description = "TC_023_verify_User_Can_Add_Roles",groups = {"regression"})
    public void verify_User_Can_Add_Roles() {
        extentTest.get().assignCategory("regression");
        extentTest.get().assignCategory("smoke");
        login = new LoginPage(driver);
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
        addRoles = roles.clickOnAddRoles();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

}
