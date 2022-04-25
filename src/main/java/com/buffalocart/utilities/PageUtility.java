package com.buffalocart.utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PageUtility {
    /**Web Driver Commands**/
    public String getPageTitle(WebDriver driver){
        String title=driver.getTitle();
        return title;
    }
    public String getSourceCode(WebDriver driver){
        String sourceCode=driver.getPageSource();
        return sourceCode;
    }

    /**Web Element Commands**/
    public void clickOnElement(WebElement element){
        element.click();
    }

    public void enterText(WebElement element,String value){
        element.sendKeys(value);
    }
    public String getAttributeValue(WebElement element,String attribute){
        String value=element.getAttribute(attribute);
        return value;
    }
    public boolean isElementEnabled(WebElement element) {
        boolean status = element.isEnabled();
        return status;
    }
    public boolean isElementDisplayed(WebElement element) {
        boolean status = element.isDisplayed();
        return status;
    }
    public boolean isElementSelected(WebElement element) {
        boolean status = element.isSelected();
        System.out.println("status="+status);
        return status;
    }
    public String getElementText(WebElement element){
        String TextValue=element.getText();
        return TextValue;
    }


    /**Selenium Commands**/

    /**HANDLING ALERTS**/

    public void acceptAlert(WebDriver driver){
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
    public void dismissAlert(WebDriver driver){
        Alert alert=driver.switchTo().alert();
        alert.dismiss();
    }
    public String getAlertText(WebDriver driver){
        Alert alert=driver.switchTo().alert();
        String value=alert.getText();
        return value;
    }
    public void enterValueOnAlert(WebDriver driver,String value){
        Alert alert=driver.switchTo().alert();
        alert.sendKeys(value);
    }
    /**Handling DropDown**/
    public void selectDropdownByVisibleTex(WebElement element,String value){
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }
    public void selectDropdownByValue(WebElement element,String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }
    public void selectDropdownByIndex(WebElement element,int value){
        Select select = new Select(element);
        select.selectByIndex(value);
    }
    public void deSelectDropdownByVisibleTex(WebElement element,String value){
        Select select = new Select(element);
        select.deselectByVisibleText(value);
    }
    public void deSelectDropdownByValue(WebElement element,String value){
        Select select = new Select(element);
        select.deselectByValue(value);
    }
    public void deSelectDropdownByIndex(WebElement element,int value){
        Select select = new Select(element);
        select.deselectByIndex(value);
    }
    public void deSelectAll(WebElement element){
        Select select = new Select(element);
        select.deselectAll();
    }
    public ArrayList<String> getAllSelected(WebElement element){
        Select select = new Select(element);
        List<WebElement> t = select.getAllSelectedOptions();
        ArrayList<String> allSelected = new ArrayList<String>();
        for (int i = 0; i < t.size(); i++) {
            allSelected.add(t.get(i).getText());
        }
        return allSelected;
    }
    public ArrayList<String> getAllDropdownOptions(WebElement element){
        Select select = new Select(element);
        List<WebElement> t = select.getOptions();
        ArrayList<String> allOptions = new ArrayList<String>();
        for (int i = 0; i < t.size(); i++) {
            allOptions.add(t.get(i).getText());
        }
        return allOptions;
    }
    public String getFirstSelected(WebElement element){
        Select select = new Select(element);
        String first=select.getFirstSelectedOption().getText();
        return first;
    }

    /**Window Handles**/

    public String navigateToAnotherTab(WebDriver driver){
        String window = driver.getWindowHandle();
        return window;
    }
    public Set<String> navigateToAnotherWindowTab(WebDriver driver){
        Set<String> windows = driver.getWindowHandles();
        return windows;
    }
}
