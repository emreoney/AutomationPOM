package Runner;

import baseProject.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestRunner extends Base {

    @Test(groups = {"WithInternetConnection"},priority = 1)
    public void testSquadPageControl() throws InterruptedException {
        Thread.sleep(3000);
        page2.clickSaveLocation();
    }

}







