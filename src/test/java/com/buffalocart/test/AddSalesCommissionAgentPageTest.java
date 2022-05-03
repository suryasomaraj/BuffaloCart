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

public class AddSalesCommissionAgentPageTest extends Base {
    LoginPage login;
    ExcelUtility excel=new ExcelUtility();
    MyAccountPage account;
    AddSalesCommissionAgentPage addSalesCommissionAgent;
    RolesPage roles;
    SalesCommissionAgentsPage salesCommissionAgents;
    WaitUtility wait;
    RandomDataUtility randomData= new RandomDataUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 29,enabled = true,description = "TC_029_verify_User_Can_Add_Sales_Agent",groups = {"regression"})
    public void verify_User_Can_Add_Sales_Agent () {
        extentTest.get().assignCategory("regression");
        login = new LoginPage(driver);
        String mail = randomData.random();
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
        salesCommissionAgents = account.clickOnSalesCommissionAgents();
        addSalesCommissionAgent=salesCommissionAgents.clickOnAddSalesCommissionAgentButton();
        extentTest.get().log(Status.PASS, "clicked on Add Sales Commission Agent Button successfully");
        List<String> dataAddSales = excel.readDataFromExcel("Add_Sales_Commission_Agent");
        addSalesCommissionAgent.enterSalesCommissionAgentSurName(dataAddSales.get(6));
        extentTest.get().log(Status.PASS, "Agent sur name entered successfully");
        addSalesCommissionAgent.enterSalesCommissionAgentFirstName(dataAddSales.get(7));
        extentTest.get().log(Status.PASS, "Agent first name entered successfully");
        addSalesCommissionAgent.enterSalesCommissionAgentLastName(dataAddSales.get(8));
        extentTest.get().log(Status.PASS, "Agent last name entered successfully");
        addSalesCommissionAgent.enterSalesCommissionAgentEmail(mail);
        extentTest.get().log(Status.PASS, "Agent email entered successfully");
        addSalesCommissionAgent.enterSalesCommissionAgentContactNumber(dataAddSales.get(9));
        extentTest.get().log(Status.PASS, "Agent contact number entered successfully");
        addSalesCommissionAgent.enterSalesCommissionAgentAddress(dataAddSales.get(10));
        extentTest.get().log(Status.PASS, "Agent address entered successfully");
        addSalesCommissionAgent.enterSalesCommissionCommissionPercentage(dataAddSales.get(11));
        extentTest.get().log(Status.PASS, "Agent percentage entered successfully");
        salesCommissionAgents=addSalesCommissionAgent.clickOnSalesCommissionAgentSaveButton();
        extentTest.get().log(Status.PASS, "Click on Agent save button successfully");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        salesCommissionAgents.clickOnSearchAgent(mail);
        extentTest.get().log(Status.PASS, "search the agent successfully");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
        String actual_addAgent=salesCommissionAgents.getSalesCommissionAgentBySearchedMail();
        extentTest.get().log(Status.PASS, "get the agent details successfully");
        String expected_addAgent="Commission agent added successfully";
        extentTest.get().log(Status.PASS, "expected agent is equal to actual agent");
        Assert.assertEquals(actual_addAgent,expected_addAgent,"newly added agent not found");
        extentTest.get().log(Status.PASS, "User can add sales agent successfully");
    }


}
