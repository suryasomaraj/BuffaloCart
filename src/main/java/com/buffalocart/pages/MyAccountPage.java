package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

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

    private final String _currentDate="div[class='m-8 pull-left mt-15 hidden-xs']>strong";
    @FindBy(css=_currentDate) private WebElement currentDate;


    private final String _signOut="div[class='pull-right']>a";
    @FindBy(css=_signOut) private WebElement signOut;

    private final String _endTour="//button[@class='btn btn-default btn-sm']";
    @FindBy(xpath=_endTour) private WebElement endTour;

    private final String _userManagement="span[class='title']";
    @FindBy(css=_userManagement) private WebElement userManagement;

    private final String _userManagementRoles="/html/body/div[2]/aside/section/ul/li[2]/ul/li[2]/a/span";
    @FindBy(xpath=_userManagementRoles) private WebElement userManagementRoles;

    private final String _SalesCommissionAgentsPage = "//div[2]/aside/section/ul/li[2]/ul/li[3]/a/span";
    @FindBy(xpath = _SalesCommissionAgentsPage) private WebElement SalesCommissionAgentsPage;








    /**User Action Methods**/
    public String getUserName(){
        String getUserName=page.getElementText(accountUserName);
        return getUserName;
    }
    public String getAccountPageTitle(){
        String title = page.getPageTitle(driver);
        return title;
    }
    public String getCurrentDate(){
        String dateToday=page.getElementText(currentDate);
        return dateToday;
    }
    public void clickOnEndTour(){
        page.clickOnElement(endTour);
    }
    public void clickOnAccountUserName(){
        page.clickOnElement(accountUserName);
    }
    public LoginPage clickOnSignOutButton() {
        page.clickOnElement(signOut);
        return new LoginPage(driver);
    }
    public void clickOnUserManagement(){
        page.clickOnElement(userManagement);
    }


private final String _usermanagementbutton="//div[2]/aside/section/ul/li[2]/a/span[1]";
    @FindBy(xpath=_usermanagementbutton) WebElement usermanagementbutton;

    public void clickOnUserManagementbutton(){
        page.clickOnElement(usermanagementbutton);
    }

    private final String _usersSubMenuTags="//ul[@class='treeview-menu']//span[@class='title']";
    @FindBy(xpath=_usersSubMenuTags) List<WebElement> usersSubMenuTags;

    /**User Actions Methods**/

    public ArrayList<String> getUserManagementSubMenu() {
        ArrayList<String> subMenuUserManagement = new ArrayList<String>();
        for (int i = 0; i < usersSubMenuTags.size(); i++) {
            subMenuUserManagement.add(usersSubMenuTags.get(i).getText());
            System.out.println(subMenuUserManagement.add(usersSubMenuTags.get(i).getText()));
        }
        System.out.println(subMenuUserManagement.size());
        System.out.println(subMenuUserManagement.get(0));
        System.out.println(subMenuUserManagement);
        return subMenuUserManagement;
    }





    private final String _usersMenu="//html/body/div[2]/aside/section/ul/li[2]/ul/li[1]/a/span";
    @FindBy(xpath=_usersMenu) private WebElement usersMenu;


    public UsersPage clickOnUsersSubTag(){
       page.clickOnElement(usersMenu);
        return new UsersPage(driver);
    }

    public RolesPage clickOnRoles(){
        page.clickOnElement(userManagementRoles);

        return new RolesPage(driver);
    }

    public SalesCommissionAgentsPage clickOnSalesCommissionAgents(){
        page.clickOnElement(SalesCommissionAgentsPage);
        return new SalesCommissionAgentsPage(driver);
    }





}
