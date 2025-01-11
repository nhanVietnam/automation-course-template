package com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.utils.Utils;

import com.utils.BasicTest;

public class Bai18_TabTest extends BasicTest {
    @Test(testName = "Open new tab and check login")
    public void shoppingCartTest() throws Exception {
        driver.get("https://bantheme.xyz/hathanhauto/tai-khoan/");
        Utils.loginWithEmail_Password("nhanvip124@gmail.com","P@ssword1235678",driver);
        Boolean isVerifyText = driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']")).getText().contains("Xin chào");
        Assert.assertTrue(isVerifyText);

        ((JavascriptExecutor) driver).executeScript("window.open()");
        Utils.hardWait();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(1));
        driver.get("https://bantheme.xyz/hathanhauto/tai-khoan/");
        WebElement searchBar = driver.findElement(By.xpath("(//input[@placeholder='Tìm kiếm...'])[1]"));
        searchBar.sendKeys("merc");
        Utils.hardWait();
        WebElement firstResult = driver.findElement(By.cssSelector("div.fs-sremain-products a:first-child"));
        firstResult.click();
        Select selectOrigin = new Select(driver.findElement(By.xpath("//select[@id='pa_xuat-xu']")));
        selectOrigin.selectByValue("england");
        WebElement btnAddCard = driver.findElement(By.xpath("//*[text()='Thêm vào giỏ hàng']"));
        btnAddCard.click();
        Utils.hardWait();
        WebElement btnAccount = driver.findElement(By.xpath("//a[@class='pos-login']"));
        btnAccount.click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']")).getText().contains("Xin chào"),true);
    }
}