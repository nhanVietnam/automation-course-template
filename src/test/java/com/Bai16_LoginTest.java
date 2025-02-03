package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.Utils;
import com.pages.LoginPage;
import com.utils.BasicTest;

public class Bai16_LoginTest extends BasicTest {
    @Test
    public void loginTestFailed() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        // loginPage.getURL(url);
        driver.get(url);
        loginPage.enterEmail("nhanvip124@gmail.com");
        loginPage.clickLoginBtn();
        // loginPage.enterPassword("P@ssword1235678");
        // loginPage.enterPassword("P@ssword1235678");
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='woocommerce-error']")));
        WebElement errorMsg = loginPage.findElement(By.xpath("//ul[@class='woocommerce-error']"));
        Assert.assertTrue(errorMsg.isDisplayed());
    }

    @Test
    public void loginTestSuccess() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        // loginPage.getURL(url);
        driver.get(url);
        loginPage.enterEmail("nhanvip124@gmail.com");
        loginPage.enterPassword("P@ssword1235678");
        loginPage.clickLoginBtn();
        By alertMsg = By.xpath("//div[@class='woocommerce-MyAccount-content']");
        loginPage.checkExistWithWait(alertMsg);
        Boolean isVerifyText = loginPage.getTextofElement(By.xpath("//div[@class='woocommerce-MyAccount-content']")).contains("Xin chào");
        Assert.assertTrue(isVerifyText);
    }
}
