package com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.utils.Utils;

import com.utils.BasicTest;

public class Bai19_ICEHRM_LoginTest extends BasicTest {

    @DataProvider(name = "testDataFeed")
    public Object[][] testData(){
        Object[][] account = new Object[2][2];
        account[0][0] = "nhanvip124@gmail.com";
        account[0][1] = "P@ssword1235678";
        account[1][0] = "admin";
        account[1][1] = "admin123";
        return account;
    }

    @Test(dataProvider = "testDataFeed")
    public void shoppingCartTest(String username, String password) throws Exception {
        driver.get("https://bantheme.xyz/hathanhauto/tai-khoan/");
        Utils.loginWithEmail_Password(username,password,driver);
        Utils.hardWait();
        Boolean isVerifyText = driver.findElements(By.xpath("//div[@class='woocommerce-MyAccount-content']")).size() > 0;
        if(isVerifyText){
            Assert.assertTrue(isVerifyText);
        } else {
            Utils.hardWait();
            Boolean isDisplayError = driver.findElement(By.xpath("//ul[@class='woocommerce-error']")).isDisplayed();
            Assert.assertTrue(isDisplayError);
        }
    }

}