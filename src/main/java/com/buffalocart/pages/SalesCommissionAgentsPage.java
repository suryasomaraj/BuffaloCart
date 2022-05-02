package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesCommissionAgentsPage extends ObjectUtility {
    WebDriver driver;

    /**Page Constructor**/
    public SalesCommissionAgentsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**Page Elements**/
    private final String _addSalesCommissionAgent = "button[class='btn btn-primary btn-modal pull-right']";
    @FindBy(css = _addSalesCommissionAgent) private WebElement addSalesCommissionAgent;

    private final String _addSalesCommissionAgentVerified = "div[class='modal fade view_modal']";
    @FindBy(css = _addSalesCommissionAgentVerified) private WebElement addSalesCommissionAgentVerified;


    private final String _addSalesCommissionAgentSearch = "input[type='search']";
    @FindBy(css = _addSalesCommissionAgentSearch) private WebElement addSalesCommissionAgentSearch;

    private final String _getSalesCommissionAgentSearchedMail = "div[class='toast-message']";
    @FindBy(css = _getSalesCommissionAgentSearchedMail) private WebElement getSalesCommissionAgentSearchedMail;


    private final String _editSalesCommissionAgent = "//table[@id='sales_commission_agent_table']/tbody/tr/td[6]/button[1]";
    @FindBy(xpath = _editSalesCommissionAgent) private WebElement editSalesCommissionAgent;







    /**User Actions**/
    public String getSalesCommissionAgentsPageTitle(){
        String title = page.getPageTitle(driver);
        return title;
    }

    public void addSalesCommissionAgentVerified(){
        page.getElementText(addSalesCommissionAgentVerified);
    }


    public AddSalesCommissionAgentPage clickOnAddSalesCommissionAgentButton(){
        page.clickOnElement(addSalesCommissionAgent);
        return new AddSalesCommissionAgentPage(driver);
    }

    public void clickOnSearchAgent(String agentEmail){
        page.enterText(addSalesCommissionAgentSearch,agentEmail);
    }
    public String getSalesCommissionAgentBySearchedMail(){
        String getSalesCommissionAgent=page.getElementText(getSalesCommissionAgentSearchedMail);
        System.out.println(getSalesCommissionAgent);
        return getSalesCommissionAgent;
    }


    public UpdateSalesCommissionAgentPage clickOnEditSalesCommissionAgent(){
        page.clickOnElement(editSalesCommissionAgent);
        return new UpdateSalesCommissionAgentPage(driver);
    }



    public String getUpdatedSalesCommissionAgent(){
        String getSalesCommissionAgent=page.getElementText(getSalesCommissionAgentSearchedMail);
        System.out.println(getSalesCommissionAgent);
        return getSalesCommissionAgent;
    }




}
