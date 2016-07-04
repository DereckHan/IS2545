import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * As a user,
 * I would like to see the details for compiling,
 * So that I can know the code has been correctly compiled.
 *
 * @author Hongyu Han
 */

public class CompileTest {

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
    // When the user type 'puts "have a nice day!"' in the textBox and click the Compile button
    // Then the user should see "putstring"
    @Test
    public void testPutString(){
        try {
            WebElement textBox = driver.findElement(By.id("code_code"));
            textBox.sendKeys("puts \"have a nice day!\"");
            WebElement tokenizeButton = driver.findElements(By.name("commit")).get(2);
            tokenizeButton.click();
            WebElement context = driver.findElement(By.tagName("code"));
            assertTrue(context.getText().contains("putstring"));
        }catch (NoSuchElementException ex){
            fail();
        }
    }


    // Given the user is on the main page
    // When the user type "a = 1 + 2" in the textBox and click the Tokenize button
    // Then the user should see "putobject" and "opt_plus"
    @Test
    public void testPlusOperation(){
        try {
            WebElement textBox = driver.findElement(By.id("code_code"));
            textBox.sendKeys("a = 1 + 2");
            WebElement tokenizeButton = driver.findElements(By.name("commit")).get(2);
            tokenizeButton.click();
            WebElement context = driver.findElement(By.tagName("code"));
            assertTrue(context.getText().contains("putobject"));
            assertTrue(context.getText().contains("opt_plus"));
        }catch (NoSuchElementException ex){
            fail();
        }
    }


    // Given the user is on the main page
    // When the user type "a = 2 - 1" in the textBox and click the Tokenize button
    // Then the user should see "putobject" and "opt_minus"
    @Test
    public void testMinusOperation(){
        try {
            WebElement textBox = driver.findElement(By.id("code_code"));
            textBox.sendKeys("a = 2 - 1");
            WebElement tokenizeButton = driver.findElements(By.name("commit")).get(2);
            tokenizeButton.click();
            WebElement context = driver.findElement(By.tagName("code"));
            assertTrue(context.getText().contains("putobject"));
            assertTrue(context.getText().contains("opt_minus"));
        }catch (NoSuchElementException ex){
            fail();
        }
    }
    // Given the user is on the main page
    // When the user type "a = 1 * 2" in the textBox and click the Tokenize button
    // Then the user should see "putobject" and "opt_mult"
    @Test
    public void testMultOperation(){
        try {
            WebElement textBox = driver.findElement(By.id("code_code"));
            textBox.sendKeys("a = 1 * 2");
            WebElement tokenizeButton = driver.findElements(By.name("commit")).get(2);
            tokenizeButton.click();
            WebElement context = driver.findElement(By.tagName("code"));
            assertTrue(context.getText().contains("putobject"));
            assertTrue(context.getText().contains("opt_mult"));
        }catch (NoSuchElementException ex){
            fail();
        }
    }
    // Given the user is on the main page
    // When the user type "a = 1 / 2" in the textBox and click the Tokenize button
    // Then the user should see "putobject" and "opt_div"
    @Test
    public void testDivisionOperation(){
        try {
            WebElement textBox = driver.findElement(By.id("code_code"));
            textBox.sendKeys("a = 1 / 2");
            WebElement tokenizeButton = driver.findElements(By.name("commit")).get(2);
            tokenizeButton.click();
            WebElement context = driver.findElement(By.tagName("code"));
            assertTrue(context.getText().contains("putobject"));
            assertTrue(context.getText().contains("opt_div"));
        }catch (NoSuchElementException ex){
            fail();
        }
    }




}
