package com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.Utils;

import com.utils.*;

public class Bai20_ShoppingCartTest extends BasicTest {
    @Test
    public void shoppingCartTest() throws Exception {
        Wait<WebDriver> wait = new WebDriverWait(driver, 4);
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Utils.loginWithEmail_Password("nhanvip124@gmail.com","P@ssword1235678",driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='woocommerce-MyAccount-content']")));
        Boolean isVerifyText = driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']")).getText().contains("Xin chào");
        Assert.assertTrue(isVerifyText);
        
        WebElement searchBar = driver.findElement(By.xpath("(//input[@placeholder='Tìm kiếm...'])[1]"));
        searchBar.sendKeys("merc");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.fs-sremain-products a:first-child")));
        WebElement firstResult = driver.findElement(By.cssSelector("div.fs-sremain-products a:first-child"));
        firstResult.click();
        Select selectOrigin = new Select(driver.findElement(By.xpath("//select[@id='pa_xuat-xu']")));
        selectOrigin.selectByValue("england");
        WebElement btnAddCard = driver.findElement(By.xpath("//*[text()='Thêm vào giỏ hàng']"));
        btnAddCard.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='woocommerce-message']")));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='woocommerce-message']")).isDisplayed());
    }

}
