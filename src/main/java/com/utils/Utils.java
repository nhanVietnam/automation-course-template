package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {
    public static void hardWait(int timeout){
        try {
            Thread.sleep(timeout);
        } catch (Exception e) {
            // pass
        }
    }

    public static void hardWait(){
        hardWait(3000);
    }

    public static void loginWithEmail_Password(String email, String password, WebDriver driver){
        WebElement emailLogin = driver.findElement(By.xpath("//input[@id='username']"));
        emailLogin.sendKeys(email);
        WebElement pwdLogin = driver.findElement(By.xpath("//input[@id='password']"));
        pwdLogin.sendKeys(password);
        WebElement btnLogin = driver.findElement(By.xpath("//button[@name='login']"));
        btnLogin.click();
    }
}
