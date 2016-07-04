import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * As a user,
 * I would like to see the details for parsing,
 * So that I can know the code has been correctly parsed.
 *
 * @author Hongyu Han
 */

public class ParseTest {

    static WebDriver driver = new HtmlUnitDriver();


    @Before
    public void setUp() throws Exception {
        driver.get("http://lit-bayou-7912.herokuapp.com/");
    }

    @After
    public void tearDown() {
        driver.manage().deleteAllCookies();
    }

    // Given the user is on the main page
    // When the user type "a = 1 + 2" and type "puts "have a nice day"" in another line in the textBox and click the Parse button
    // Then the user shouldn't see ":on_nl" or ":on_sp"
    @Test
    public void testWhiteSpace(){
        try {
            WebElement textBox = driver.findElement(By.id("code_code"));
            WebElement parseButton = driver.findElements(By.name("commit")).get(1);
            textBox.sendKeys("a = 1 + 2\n puts \"have a nice day\"");
            parseButton.click();
            WebElement context = driver.findElement(By.tagName("code"));
            assertFalse(context.getText().contains(":on_sp"));
            assertFalse(context.getText().contains(":on_nl"));
        }catch (NoSuchElementException ex){
            fail();
        }
    }

    // Given the user is on the main page
    // When the user type "a = 1 + 2" and type "puts "have a nice day"" in another line in the textBox and click the Parse button
    // Then the user should see "a", "=", "1", "+" and "2"
    @Test
    public void testNonWhiteSpace(){
        try {
            WebElement textBox = driver.findElement(By.id("code_code"));
            WebElement parseButton = driver.findElements(By.name("commit")).get(1);
            textBox.sendKeys("a = 1 + 2\n puts \"have a nice day\"");
            parseButton.click();
            WebElement context = driver.findElement(By.tagName("code"));
            assertTrue(context.getText().contains("a"));
//            assertTrue(context.getText().contains("="));
            assertTrue(context.getText().contains("1"));
            assertTrue(context.getText().contains("+"));
            assertTrue(context.getText().contains("2"));
        }catch (NoSuchElementException ex){
            fail();
        }
    }


}
