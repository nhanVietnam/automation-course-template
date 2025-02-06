package com.pages;

import java.sql.Time;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.BasicTest;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    protected BasePage(WebDriver givenDriver){
        this.driver = givenDriver;
        // PageFactory.initElements(this.driver,this);
        this.wait = new WebDriverWait(driver,10);
        
    }

    private void setDriver(String browserName, String appURL){
        switch (browserName){
            case "chrome":
                driver = new ChromeDriver();
                driver.get(appURL);
                break;
            case "firefox":
                driver = new ChromeDriver();
                driver.get(appURL);
                break;
            case "edge":
                driver = new ChromeDriver();
                driver.get(appURL);
                break;
            default:
                System.out.println("Browser: " + browserName + "is invalid, launching Chrome");
                driver = new ChromeDriver();
                driver.get(appURL);
        }
    }

    public void getURL(String url){
        this.driver.get(url);
    }

    public void clickLink(String text){
        WebElement element = this.driver.findElement(By.xpath("//li/a[text()='"+ text +"']"));
    }

    public WebElement findElement(By by){
        return this.driver.findElement(by);
    }

    public void checkExistWithWait(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public String getTextofElement(By by){
        return findElement(by).getText();
    }
}