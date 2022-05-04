package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateSalesCommissionAgentPage extends ObjectUtility {
    WebDriver driver;

    /**Page Constructor**/
    public UpdateSalesCommissionAgentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**Web Element**/
    private final String _salesCommissionAgentAddressEdit = "textarea[id='address']";
    @FindBy(css = _salesCommissionAgentAddressEdit) private WebElement salesCommissionAgentAddressEdit;
    private final String _salesCommissionAgentCommissionPercentageEdit = "input[id='cmmsn_percent']";
    @FindBy(css = _salesCommissionAgentCommissionPercentageEdit) private WebElement salesCommissionAgentCommissionPercentageEdit;
    private final String _salesCommissionAgentAddressEditSaveButton = "//form[@id='sale_commission_agent_form']/div[3]/button[1]";
    @FindBy(xpath = _salesCommissionAgentAddressEditSaveButton) private WebElement salesCommissionAgentAddressEditSaveButton;

    /**User Action**/
    public void editSalesCommissionAgentAddress(String salesAgentAddress) {
        salesCommissionAgentAddressEdit.clear();
        page.enterText(salesCommissionAgentAddressEdit,salesAgentAddress);
    }
    public void editSalesCommissionAgentPercentage(String CommissionPercentage) {
        salesCommissionAgentCommissionPercentageEdit.clear();
        page.enterText(salesCommissionAgentCommissionPercentageEdit,CommissionPercentage);
    }
    public SalesCommissionAgentsPage clickOnUpEditSaveSalesCommissionAgentButton() {
        page.clickOnElement(salesCommissionAgentAddressEditSaveButton);
        return new SalesCommissionAgentsPage(driver);
    }
}
