package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ResetPasswordPage extends ObjectUtility {
        WebDriver driver;
        /**Page Constructor**/
    public ResetPasswordPage(WebDriver driver){
            this.driver=driver;
            PageFactory.initElements(driver,this);
        }
    /**Page Elements**/
    private final String _emailAddress="input[id='email']";
    @FindBy(css=_emailAddress) private WebElement emailAddress;

    private final String _resetPasswordLink="button[type='submit']";
    @FindBy(css=_resetPasswordLink) private WebElement resetPasswordLink;

    private final String _errorResetPasswordMessage="span[class='help-block']>strong";
    @FindBy(css=_errorResetPasswordMessage) private WebElement errorResetPasswordMessage;

    /**User Action Methods**/
    public void enterEmailAddress(String mailAddress) {
        page.enterText(emailAddress, mailAddress);
        System.out.println("email");
    }
    public ResetPasswordPage getResetPasswordLink() {
        page.clickOnElement(resetPasswordLink);
        System.out.println("clicksuccess");
        return new ResetPasswordPage(driver);
    }
    public String getResetPasswordErrorMessage() throws IOException {
        String errorMessage = page.getElementText(errorResetPasswordMessage);
        String expected = String.valueOf(excel.readDataFromExcel("LoginPage"));
        System.out.println(expected);
        return errorMessage;
    }

}
