import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("ALL")
public class Login {
    ChromeDriver driver;
    final String url = "https://batdongsan.com.vn/";
    final String email = "tuananh1994cmhn@yahoo.com";
    final String pass = "Test@123";

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/"
                + "src/test/resources/chromedriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--enable-javascript");
        options.addArguments("start-maximized");
        options.addArguments("--disable-web-security");
        options.addArguments("--disable-blink-features=AutomationControlled");
        driver = new ChromeDriver(options);
        driver.get(url);
    }

    @Test
    public void testLogin() throws InterruptedException {

        clickLoginIcon();
        inputEmail(email);
        inputPassword(pass);
        clickLoginBtn();
        validateLoginSuccess();
    }

    private void inputEmail(String email) {
        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='UserName']"));
        inputEmail.click();
        inputEmail.sendKeys(email);
    }

    private void inputPassword(String passWord) {
        WebElement inputPassWord = driver.findElement(By.id("Password"));
        inputPassWord.sendKeys(passWord);
    }

    private void clickLoginIcon() {
        By icon = By.id("kct_login");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated((icon)));
        WebElement iconLogin = driver.findElement(icon);
        iconLogin.click();
    }

    private void clickLoginBtn() {
        WebElement btnLogin = driver.findElement(By.xpath("//button[@class='js__btn-login re__btn re__btn-pr-solid--md']"));
        btnLogin.click();
    }

    private void validateLoginSuccess() {
        By postProductIcon = By.xpath("//a[@class='lnk-posting btn-post-product']");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated((postProductIcon)));
        WebElement element = driver.findElement(postProductIcon);
        Assert.assertTrue(element.isDisplayed());
    }

    @After
    public void afterTest() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
