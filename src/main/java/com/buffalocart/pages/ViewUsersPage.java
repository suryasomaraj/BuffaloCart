package com.buffalocart.pages;


import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewUsersPage  extends ObjectUtility {
    WebDriver driver;

    /**Page Constructor**/
    public ViewUsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private final String _getEmail = "/html/body/div[2]/div[1]/section[2]/div/div/div/div[2]/p[1]";
    @FindBy(xpath = _getEmail) private WebElement getEmail;

    public String getViewUsers(){
        String actual=page.getElementText(getEmail);
        return actual;

    }


}
