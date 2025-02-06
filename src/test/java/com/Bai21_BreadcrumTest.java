package com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.Utils;

import com.utils.*;

public class Bai21_BreadcrumTest extends BasicTest {
    
    @Test
    public void breadcrumTest() throws Exception {
        
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        Actions action = new Actions(driver);
        driver.get(url);
        action.moveToElement(driver.findElement(By.xpath("//li[@id='menu-item-347']"))).perform();
        action.moveToElement(driver.findElement(By.xpath("//li[@id='menu-item-465']"))).perform();
        driver.findElement(By.xpath("//a[text()='Phanh tay ô tô']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@class='woocommerce-breadcrumb']")));
        Boolean isOnBreadbrum = driver.findElement(By.xpath("//nav[@class='woocommerce-breadcrumb']")).getText().contains("Phanh tay ô tô");
        Assert.assertTrue(isOnBreadbrum);
    }
}
