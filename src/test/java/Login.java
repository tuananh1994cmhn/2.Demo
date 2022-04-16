import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Login {
    ChromeDriver driver;
    String url = "https://batdongsan.com.vn/";
    String email = "tuananh1994cmhn@yahoo.com";
    String pass = "Test@123";

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/"
                + "src/test/resources/chromedriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--enable-javascript");

        driver = new ChromeDriver(options);

        driver.get(url);
        driver.manage().window().maximize();
    }

    @After
    public void afterTest() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void testLogin() throws InterruptedException {
        clickLoginIcon();
        Thread.sleep(3000);
        inputEmail(email);
        inputPassword(pass);
        clickLoginBtn();
    }

    private void inputEmail(String email) {
        WebElement inputName = driver.findElement(By.xpath(" //input[@id='UserName']"));
        inputName.sendKeys(email);
    }

    private void inputPassword(String passWord) {
        WebElement inputName = driver.findElement(By.id("Password"));
        inputName.sendKeys(passWord);
    }

    //input[@id='UserName']
    private void clickLoginIcon() {
        WebElement searchBtn = driver.findElement(By.id("kct_login"));
        searchBtn.click();
    }

    private void clickLoginBtn() {
        WebElement searchBtn = driver.findElement(By.xpath("//button[@class='js__btn-login re__btn re__btn-pr-solid--md']"));
        searchBtn.click();
    }
}
