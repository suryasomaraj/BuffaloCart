package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddSalesCommissionAgentPage extends ObjectUtility {
    WebDriver driver;

    /**Page Constructor**/
    public AddSalesCommissionAgentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /**Web Element**/
    private final String _salesCommissionAgentSurName = "input[id='surname']";
    @FindBy(css = _salesCommissionAgentSurName) private WebElement salesCommissionAgentSurName;
    private final String _salesCommissionAgentFirstName = "input[id='first_name']";
    @FindBy(css = _salesCommissionAgentFirstName) private WebElement salesCommissionAgentFirstName;
    private final String _salesCommissionAgentLastName = "input[id='last_name']";
    @FindBy(css = _salesCommissionAgentLastName) private WebElement salesCommissionAgentLastName;
    private final String _salesCommissionAgentEmail = "input[id='email']";
    @FindBy(css = _salesCommissionAgentEmail) private WebElement salesCommissionAgentEmail;
    private final String _salesCommissionAgentContactNumber = "input[id='contact_no']";
    @FindBy(css = _salesCommissionAgentContactNumber) private WebElement salesCommissionAgentContactNumber;
    private final String _salesCommissionAgentAddress = "textarea[id='address']";
    @FindBy(css = _salesCommissionAgentAddress) private WebElement salesCommissionAgentAddress;
    private final String _salesCommissionAgentCommissionPercentage = "input[id='cmmsn_percent']";
    @FindBy(css = _salesCommissionAgentCommissionPercentage) private WebElement salesCommissionAgentCommissionPercentage;
    private final String _salesCommissionAgentSaveButton = "button[class='btn btn-primary']";
    @FindBy(css = _salesCommissionAgentSaveButton) private WebElement salesCommissionAgentSaveButton;

    /**user action**/

    public void enterSalesCommissionAgentSurName(String salesAgentSurName) {
        page.enterText(salesCommissionAgentSurName,salesAgentSurName);
    }

    public void enterSalesCommissionAgentFirstName(String salesAgentFirstName) {
        page.enterText(salesCommissionAgentFirstName,salesAgentFirstName);
    }

    public void enterSalesCommissionAgentLastName(String salesAgentLastName) {
        page.enterText(salesCommissionAgentLastName,salesAgentLastName);
    }
    public void enterSalesCommissionAgentEmail(String salesAgentEmail) {
        page.enterText(salesCommissionAgentEmail,salesAgentEmail);
    }
    public void enterSalesCommissionAgentContactNumber(String salesAgentContactNumber) {
        page.enterText(salesCommissionAgentContactNumber,salesAgentContactNumber);
    }
    public void enterSalesCommissionAgentAddress(String salesAgentAddress) {
        page.enterText(salesCommissionAgentAddress,salesAgentAddress);
    }
    public void enterSalesCommissionCommissionPercentage(String CommissionPercentage) {
        page.enterText(salesCommissionAgentCommissionPercentage,CommissionPercentage);
    }

    public SalesCommissionAgentsPage clickOnSalesCommissionAgentSaveButton() {
        page.clickOnElement(salesCommissionAgentSaveButton);
        return new SalesCommissionAgentsPage(driver);
    }






}
