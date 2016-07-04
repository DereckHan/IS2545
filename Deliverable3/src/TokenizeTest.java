import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * As a user,
 * I would like to see the details for tokenization,
 * So that I can know the code has been correctly tokenized.
 *
 * @author Hongyu Han
 */

public class TokenizeTest {

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
    // When the user type "a" in the textBox and click the Tokenize button
    // Then the user should see ":on_ident"
    @Test
    public void testIdentifier_Variable(){
        try {
            WebElement textBox = driver.findElement(By.id("code_code"));
            WebElement tokenizeButton = driver.findElements(By.name("commit")).get(0);
            textBox.sendKeys("a");
            tokenizeButton.click();
            WebElement context = driver.findElement(By.tagName("code"));
            assertTrue(context.getText().contains(":on_ident"));
        }catch (NoSuchElementException ex){
            fail();
        }
    }

    // Given the user is on the main page
    // When the user type 'puts "have a nice day!"' in the textBox and click the Tokenize button
    // Then the user should see ":on_indent"
    @Test
    public void testIdentifier_Function(){
        try {
            WebElement textBox = driver.findElement(By.id("code_code"));
            textBox.sendKeys("puts \"have a nice day!\"");
            WebElement tokenizeButton = driver.findElements(By.name("commit")).get(0);
            tokenizeButton.click();
            WebElement context = driver.findElement(By.tagName("code"));
            assertTrue(context.getText().contains(":on_ident"));
        }catch (NoSuchElementException ex){
            fail();
        }
    }

    // Given the user is on the main page
    // When the user type " " in the textBox and click the Tokenize button
    // Then the user should see ":on_sp"
    @Test
    public void testSpace(){
        try {
            WebElement textBox = driver.findElement(By.id("code_code"));
            textBox.sendKeys(" ");
            WebElement tokenizeButton = driver.findElements(By.name("commit")).get(0);
            tokenizeButton.click();
            WebElement context = driver.findElement(By.tagName("code"));
            assertTrue(context.getText().contains(":on_sp"));
        }catch (NoSuchElementException ex){
            fail();
        }
    }

    // Given the user is on the main page
    // When the user type "+" in the textBox and click the Tokenize button
    // Then the user should see ":on_op"
    @Test
    public void testOperation(){
        try {
            WebElement textBox = driver.findElement(By.id("code_code"));
            textBox.sendKeys("+");
            WebElement tokenizeButton = driver.findElements(By.name("commit")).get(0);
            tokenizeButton.click();
            WebElement context = driver.findElement(By.tagName("code"));
            assertTrue(context.getText().contains(":on_op"));
        }catch (NoSuchElementException ex){
            fail();
        }
    }

    // Given the user is on the main page and the textBox already has a line "a = 1"
    // When the user type "b = 2" in a new line of the textBox and click the Tokenize button
    // Then the user should see ":on_nl"
    @Test
    public void testNewLine(){
        try {
            WebElement textBox = driver.findElement(By.id("code_code"));
            textBox.sendKeys("a = 1\nb = 2");
            WebElement tokenizeButton = driver.findElements(By.name("commit")).get(0);
            tokenizeButton.click();
            WebElement context = driver.findElement(By.tagName("code"));
            assertTrue(context.getText().contains(":on_nl"));
        }catch (NoSuchElementException ex){
            fail();
        }
    }


}
