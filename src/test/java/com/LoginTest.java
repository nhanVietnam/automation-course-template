package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.Utils;

import com.utils.BasicTest;

public class LoginTest extends BasicTest {


    @Test(enabled = false)
    public void loginTest() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement emailLogin = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement passwordLogin = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[@name='login']"));
        emailLogin.sendKeys("nhanvip124@gmail.com");
        passwordLogin.sendKeys("P@ssword1235678");
        btnLogin.click();

        // Boolean isDisplayed = isErrorMessageDisplayed("//div[@class='woocommerce-MyAccount-content']");
        // if(isDisplayed == true){
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']")).getText().contains("Xin chào"),true);
        
// 
//         // ===Xpath locator===
//         String loginEmailFieldLocator = "//input[@id=\"username\"]";
//         String loginButtonLocator = "//button[@name=\"login\"]";
//         String logoutButtonLocator = "//a[text()=\"Thoát\"]";
//         String searchFieldLocator = "//input[@name='s']/ancestor::div[contains(@class,'header-main')]";
//         String cartLocator = "//div[@class=\"link-cart\"]//b";
// 
//         System.out.println("Xpath Locator for email field is: " + loginEmailFieldLocator);
//         System.out.println("Xpath Locator for submit button is: " + loginButtonLocator);
//         System.out.println("Xpath Locator for logout button is: " + logoutButtonLocator);
//         System.out.println("Xpath Locator for search field is: " + searchFieldLocator);
//         System.out.println("Xpath Locator for cart is: " + cartLocator);
// 
//         // ===CSS path locator===
//         loginEmailFieldLocator = "#username";
//         loginButtonLocator = ".pos-login";
//         logoutButtonLocator = ".woocommerce-MyAccount-navigation-link--customer-logout a";
//         searchFieldLocator = ".header-main #s";
//         cartLocator = ".header-main .link-cart b";
//         
//         System.out.println("CSS path Locator for email field is: " + loginEmailFieldLocator);
//         System.out.println("CSS path Locator for submit button is: " + loginButtonLocator);
//         System.out.println("CSS path Locator for logout button is: " + logoutButtonLocator);
//         System.out.println("CSS path Locator for search field is: " + searchFieldLocator);
//         System.out.println("CSS path Locator for cart is: " + cartLocator);
    }

    public boolean isErrorMessageDisplayed(String locator){
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }
}
