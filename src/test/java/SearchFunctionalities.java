import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class SearchFunctionalities {

    ChromeDriver driver;
    String url = "https://batdongsan.com.vn/";

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/"
                + "src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void testSearchFunction() {
        String beforeSearch = getWebTitle();
        inputCityName("Ha Noi");
        clickSearchBtn();
        String afterSearch = getWebTitle();
        validateSearchSuccess(beforeSearch, afterSearch);
    }

    @After
    public void afterTest() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    private String getWebTitle() {
        return driver.getTitle();
    }

    private void inputCityName(String cityName) {
        WebElement inputName = driver.findElement(By.xpath("//input[@id='txtSearch']"));
        inputName.sendKeys(cityName);
    }

    private void clickSearchBtn() {
        WebElement searchBtn = driver.findElement(By.xpath("//span[contains(text(),'Tìm kiếm')]"));
        searchBtn.click();
    }

    private void validateSearchSuccess(String beforeSearch, String afterSearch) {
        Assert.assertNotEquals(beforeSearch, afterSearch);
    }
}

