package com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.Utils;

import com.utils.BasicTest;

public class Bai16_LoginTest extends BasicTest {
    @Test
    public void loginTestFailed() throws Exception {
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Utils.loginWithEmail_Password("nhanvip124@gmail.com","",driver);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='woocommerce-error']")));
        WebElement errorMsg = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
        Assert.assertTrue(errorMsg.isDisplayed());
    }

    @Test
    public void loginTestSuccess() throws Exception {
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Utils.loginWithEmail_Password("nhanvip124@gmail.com","P@ssword1235678",driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='woocommerce-MyAccount-content']")));
        Boolean isVerifyText = driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']")).getText().contains("Xin chào");
        Assert.assertTrue(isVerifyText);
    }
}
