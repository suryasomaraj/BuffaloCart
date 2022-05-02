package com.buffalocart.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listener.TestListener;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.MyAccountPage;
import com.buffalocart.pages.ResetPasswordPage;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class ResetPasswordPageTest extends Base {
    LoginPage login;
    ExcelUtility excel=new ExcelUtility();
    MyAccountPage account;
    ResetPasswordPage resetPassword;
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority =5,enabled = true,description = "TC_005_verify_Error_Message_Displayed_On_Reset_Password_Page_With_Invalid_Email_Id",groups = {"regression"})
    public void verify_Error_Message_Displayed_On_Reset_Password_Page_With_Invalid_Email_Id(){
        login=new LoginPage(driver);
        extentTest.get().assignCategory("sanity");
        extentTest.get().assignCategory("regression");
        resetPassword=login.clickOnForgotYourPassword();
        extentTest.get().log(Status.PASS, "click on forgot your password successfully");
        List<String> dataS=excel.readDataFromExcel("LoginPage");
        resetPassword.enterEmailAddress(dataS.get(17));
        extentTest.get().log(Status.PASS, "Email id entered successfully");
        resetPassword.clickOnResetPasswordLink();
        extentTest.get().log(Status.PASS, "click on send password link button successfully");
        String actual_ErrorMessageOnResetPassword=resetPassword.getResetPasswordErrorMessage();
        String expected_ErrorMessageOnResetPassword= dataS.get(18);
        Assert.assertEquals(actual_ErrorMessageOnResetPassword,expected_ErrorMessageOnResetPassword,"Send password reset link successfully");
        extentTest.get().log(Status.PASS, "error message displayed on reset password with invalid email id successfully");
    }
}
