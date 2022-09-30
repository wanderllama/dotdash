package assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropDownPage;
import util.Driver;
import util.Hooks;

import java.util.List;

public class DropDown extends Hooks {

    DropDownPage page = new DropDownPage(Driver.getDriver());

    @Test
    public void dropdown_test() {
        Driver.getDriver().get("http://localhost:7080/dropdown");

        Select dropdown = new Select(page.dropdown);

        List<WebElement> options = dropdown.getOptions();

        if (options.size() > 0) {
            for (WebElement option : options) {
                dropdown.selectByVisibleText(option.getText());
                Assert.assertTrue(option.isSelected() , option.getText() + " option is not selected");
            }
        } else {
            Assert.fail("dropdown has no options");
        }
    }
}
