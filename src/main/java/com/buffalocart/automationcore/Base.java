package com.buffalocart.automationcore;

import com.buffalocart.constants.Constants;
import com.buffalocart.extendreport.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {
    public WebDriver driver;
    public Properties prop;
    public FileInputStream fs;
    public Base(){
        prop= new Properties();
        try {
            fs= new FileInputStream(Constants.CONFIG_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(fs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void testInitialize(String browser) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            try {
                throw new Exception("invalid browser name");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
    @BeforeSuite
    public void setExtent(final ITestContext testContext){
        ExtentManager.createInstance().createTest(testContext.getName(), "TEST FAILED");
    }
    @BeforeMethod(alwaysRun = true)
    //@Parameters({"browser","url"})
    public void setUp() {

        String browser= prop.getProperty("browser");
        String url=prop.getProperty("url");
        testInitialize(browser);
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT));
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("./Screenshots/" + result.getName() + ".png"));
        }
        driver.close();
    }
}

