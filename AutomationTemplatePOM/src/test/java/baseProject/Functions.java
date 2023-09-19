package baseProject;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.im4java.core.CompareCmd;
import org.im4java.core.IMOperation;
import org.im4java.process.StandardStream;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

public class Functions {



    public static void click(WebElement element) throws InterruptedException {

        waitForElementToBeClickable(Base.driver,element,50).click();
    }

    public static void fastClick(WebElement element) throws InterruptedException {
        element.click();
    }

    public static void write(WebElement element, String text) throws InterruptedException {

        waitForElementToBeClickable(Base.driver,element,15  );
        element.clear();
        element.sendKeys(text);
    }

    public static void doubleClick(WebElement element) {
        Actions action = new Actions(Base.driver);
        action.doubleClick(element).perform();
    }

    public static void isDisplay(WebElement element,int Seconds)  {

        boolean Check = waitForElementToBeVisible(Base.driver,element,Seconds).isDisplayed();
        if (Check == true) {
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }

    }

    public static WebElement waitForElementToBeVisible(WebDriver driver, WebElement webElement, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        WebElement element = wait.until(ExpectedConditions.visibilityOf(webElement));
        return element;

    }

    public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement webElement, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return element;
    }

    public static String generateString(int size,String alphabet){
        String s = RandomStringUtils.random(size, alphabet);
        return s;
    }


    public static void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) Base.driver;
        HashMap<String, String> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");
        js.executeScript("mobile: scroll", scrollObject);
    }



 }

