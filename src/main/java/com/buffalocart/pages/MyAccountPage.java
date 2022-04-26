package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends ObjectUtility {
    WebDriver driver;
    /**Page Constructor**/
    public MyAccountPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    /**Page Elements**/
    private final String _accountUserName="a[class='dropdown-toggle']>span";
    @FindBy(css=_accountUserName) private WebElement accountUserName;

    /**User Action Methods**/
    public String getUserName(){
        String userName=page.getElementText(accountUserName);
        return userName;
    }
}
