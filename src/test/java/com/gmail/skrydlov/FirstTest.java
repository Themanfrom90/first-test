package com.gmail.skrydlov;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "H:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://gmail.com");
    }

    @Test
    public void userLogin() {
        WebElement loginField = driver.findElement(By.id("identifierId"));
        loginField.sendKeys("testfor00001");
        WebElement nextButton = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span"));
        nextButton.click();
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("123qweasD");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span"));
        loginButton.click();
        WebElement profileButton = driver.findElement(By.xpath("//*[@id=\"gb\"]/div[1]/div[1]/div[2]/div[5]/div[1]/a/span"));
        profileButton.click();
        WebElement profileUser = driver.findElement(By.xpath("//*[@id=\"gb\"]/div[1]/div[1]/div[2]/div[5]/div[2]/div[1]/div/div[2]"));
        String mailUser = profileUser.getText();
        Assert.assertEquals("testfor00001@gmail.com", mailUser);
    }

    @AfterClass
    public static void tearDown() {
        WebElement exitButton = driver.findElement(By.xpath("//*[@id=\"gb_71\"]"));
        exitButton.click();
        driver.quit();
    }
}
