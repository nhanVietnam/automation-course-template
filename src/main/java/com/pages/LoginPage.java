package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }

    By emailField = By.xpath("//input[@id='username']");
    By passwordField = By.xpath("//input[@id='password']");
    By submitButton = By.xpath("//button[@name='login']");
    By getAlertMsg = By.xpath("//div[@class='woocommerce-MyAccount-content']");

    public void enterEmail(String email){
        findElement(emailField).clear();
        findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password){
        findElement(passwordField).clear();
        findElement(passwordField).sendKeys(password);
    }

    public void clickLoginBtn(){
        findElement(submitButton).click();
    }

    public void getAlertMessage(){
        findElement(getAlertMsg);
    }

    
}