package baseProject;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import pages.*;

public class Base {

    protected static IOSDriver driver;
    protected static page2 page2;
    protected static page1 page1;




    @BeforeSuite(groups = {"WithInternetConnection"})
    public void setUp() throws Exception {


        Thread.sleep(2000);


        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:noReset",true);
        caps.setCapability("platformVersion", "16.5.1");
        caps.setCapability("deviceName", "iPad Pro (11-inch) (3rd generation)");
        caps.setCapability("automationName","XCUITest");
        caps.setCapability("appium:udid",);
        caps.setCapability("appium:bundleId",);

        Base.driver = new IOSDriver(url,caps);
        Base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        page2 = new page2();
        page1 = new page1();


    }



    @BeforeMethod(groups = {"WithInternetConnection"})
    public void beforeTest ( ) throws MalformedURLException, InterruptedException {
        Thread.sleep(10000);

        if (isDriverActive(driver)) {
            System.out.println("Driver Açık");
        }
        else {
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "iOS");
            caps.setCapability("appium:noReset",true);
            caps.setCapability("platformVersion", "16.5.1");
            caps.setCapability("deviceName", "iPad Pro (11-inch) (3rd generation)");
            caps.setCapability("automationName","XCUITest");
            caps.setCapability("appium:udid",);
            caps.setCapability("appium:bundleId",);

            Base.driver = new IOSDriver(url,caps);
            Base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


            page2 = new page2();
            page1 = new page1();

            Thread.sleep(5000);
        }


    }


    @AfterMethod(groups = {"WithInternetConnection"})
    public void afterTestReport (ITestResult result) throws Exception {
        Thread.sleep(5000);
        driver.terminateApp("");
        }


    @AfterSuite(groups = {"WithInternetConnection"})
    public void tearDown() throws InterruptedException {
        driver.quit();
        Thread.sleep(2000);
    }

    public static boolean isDriverActive(IOSDriver driver) {
        try {
            driver.getTitle();  // Driver'ın aktif olup olmadığını kontrol etmek için bu metodu kullanıyoruz.
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
