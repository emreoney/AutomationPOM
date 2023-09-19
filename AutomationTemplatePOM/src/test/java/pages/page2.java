package pages;

import baseProject.Base;
import baseProject.Functions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class page2 extends Base {


    @FindBy(xpath = "//*[@name='Save']")
    private WebElement saveLocationButton;

    public page2() {
        PageFactory.initElements(driver,this);
    }

    public void clickSaveLocation() throws InterruptedException {
        Functions.click(saveLocationButton);
    }

}
