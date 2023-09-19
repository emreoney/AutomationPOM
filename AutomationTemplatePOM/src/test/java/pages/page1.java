package pages;

import baseProject.Base;
import baseProject.Functions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class page1 extends Base {


    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device Name\"]")
    private WebElement devicesTab;
    @FindBy(xpath = "//*[@value='Search in devices...']")
    private WebElement deviceNameColumn;

    public void clickDevicesTab() throws InterruptedException {
        Functions.click(devicesTab);
        Functions.waitForElementToBeVisible(Base.driver,deviceNameColumn,10);
    }


    public page1() {
        PageFactory.initElements(driver,this);
    }
}
