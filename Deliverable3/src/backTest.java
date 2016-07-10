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

public class backTest {

    static WebDriver driver = new HtmlUnitDriver();


    @Before
    public void setUp() throws Exception {
        driver.get("http://lit-bayou-7912.herokuapp.com/");
    }

    @After
    public void tearDown() {
        driver.manage().deleteAllCookies();
    }



    @Test
    public void testBack(){
        try {
            WebElement textBox = driver.findElement(By.id("code_code"));
            textBox.sendKeys("puts \"have a nice day!\"");
            WebElement tokenizeButton = driver.findElements(By.name("commit")).get(2);
            tokenizeButton.click();
            System.out.println("Before click: "+driver.getCurrentUrl());
            driver.findElement(By.linkText("Back")).click();
            System.out.println("After click: +"+driver.getCurrentUrl());
            driver.findElement(By.id("code_code"));
        }catch (NoSuchElementException ex){
            fail();
        }
    }






}
