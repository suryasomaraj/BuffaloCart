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

public class UpdateRolesPageTest extends Base {
    LoginPage login;
    ExcelUtility excel=new ExcelUtility();
    MyAccountPage account;
    RolesPage roles;
    UpdateRolesPage updateRoles;
    AddRolesPage addRoles;
    RandomDataUtility randomData;
    WaitUtility wait;
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 24,enabled = true,description = "TC_024_verify_Edit_Role_Page_Title",groups = {"regression"})
    public void verify_Edit_Role_Page_Title() {
        extentTest.get().assignCategory("regression");
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
        extentTest.get().log(Status.PASS, "click on roles successfully");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        addRoles = roles.clickOnAddRolesButton();
        extentTest.get().log(Status.PASS, "click on add roles successfully");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String newRole="Engineer_JuniorTester_123";
        roles.enterNewRole(newRole);
        extentTest.get().log(Status.PASS, "new role entered successfully");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        roles.saveNewRoleButton();
        extentTest.get().log(Status.PASS, "save button clicked successfully");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        roles.getSearchRole(newRole);
        extentTest.get().log(Status.PASS, "role searched successfully");
        updateRoles=roles.clickOnEditButton();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        String actualEditTitle=updateRoles.getEditRolePageTitle();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        String expectedEditTitle="Edit Role - Llolll";
        Assert.assertEquals(actualEditTitle,expectedEditTitle,"Edit role title not equal");
        extentTest.get().log(Status.PASS, "Edit role title verified successfully");

    }

    @Test(priority = 25,enabled = true,description = "TC_025_verify_User_Can_Update_A_Role",groups = {"regression"})
    public void verify_User_Can_Update_A_Role() {
        extentTest.get().assignCategory("regression");
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
        extentTest.get().log(Status.PASS, "click on roles successfully");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        addRoles = roles.clickOnAddRolesButton();
        extentTest.get().log(Status.PASS, "click on add roles successfully");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String newRole = "Engineer_123";
        roles.enterNewRole(newRole);
        extentTest.get().log(Status.PASS, "new role entered successfully");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        roles.saveNewRoleButton();
        extentTest.get().log(Status.PASS, "save button clicked successfully");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        roles.getSearchRole(newRole);
        extentTest.get().log(Status.PASS, "role searched successfully");
        updateRoles = roles.clickOnEditButton();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        updateRoles.enterUpdatedNewRole("Senior_Design_Engineer789");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        roles=updateRoles.updateRoleButton();
        extentTest.get().log(Status.PASS, "click on update button successfully");
        String actualEditTitle=roles.getRolesUpdated();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        String expectedEditTitle="Role updated successfully";
        Assert.assertEquals(actualEditTitle,expectedEditTitle,"Role update is not done");
        extentTest.get().log(Status.PASS, "user can update a role successfully");
    }

    @Test(priority = 26,enabled = true,description = "TC_026_verify_User_Can_Delete_A_Role_From_The_List",groups = {"regression"})
    public void verify_User_Can_Delete_A_Role_From_The_List() {
        extentTest.get().assignCategory("regression");
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
        extentTest.get().log(Status.PASS, "click on roles successfully");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        addRoles = roles.clickOnAddRolesButton();
        extentTest.get().log(Status.PASS, "click on add roles successfully");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String newRole = "Designer_DesignEngineer8876";
        roles.enterNewRole(newRole);
        extentTest.get().log(Status.PASS, "new role entered successfully");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        roles.saveNewRoleButton();
        extentTest.get().log(Status.PASS, "save button clicked successfully");
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        roles.getSearchRole(newRole);
        extentTest.get().log(Status.PASS, "role searched successfully");
        roles.clickOnDeleteRoleButton();
        roles.ClickOnConfirmDeleteRoleButton();
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        extentTest.get().log(Status.PASS, "click on confirm button successfully");
        String actualEditTitle=roles.getRolesDeleted();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        String expectedEditTitle="Role deleted successfully";
        Assert.assertEquals(actualEditTitle,expectedEditTitle,"Role delete is not done");
        extentTest.get().log(Status.PASS, "user can delete a role successfully");

    }
}
