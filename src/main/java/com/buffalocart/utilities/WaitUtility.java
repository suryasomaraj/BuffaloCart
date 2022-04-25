package com.buffalocart.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtility {
    public static final long PAGE_LOAD_WAIT=20;
    public static final long IMPLICIT_WAIT=20;
    public static final long EXPLICIT_WAIT=20;
    WebDriverWait wait;
    public enum LocatorType{
        Id,Xpath,Name,CssSelector,LinkText,PartialLinkText,TagName
    }
    public void setPageLoadWait(WebDriver driver){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_WAIT));
    }
    public void setImplicitWait(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
    }
    public void waitForVisibilityOfElementLocatedBy(WebDriver driver,Enum locatorType,String target){
        wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
        if(locatorType.equals(LocatorType.Id)){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(target)));
        }else if(locatorType.equals(LocatorType.Xpath)){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(target)));
        }else if(locatorType.equals(LocatorType.Name) ){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(target)));
        }else if(locatorType.equals(LocatorType.CssSelector) ){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(target)));
        }else if(locatorType.equals(LocatorType.LinkText) ) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(target)));
        }else if(locatorType.equals(LocatorType.PartialLinkText) ) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(target)));
        }else if(locatorType.equals(LocatorType.TagName) ){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(target)));
        }else {
            try {
                throw new Exception("invalid");

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void waitForVisibilityOfElement(WebDriver driver, String target, WebElement element){
        wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
