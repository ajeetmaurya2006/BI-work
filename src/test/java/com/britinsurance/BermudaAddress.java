package com.britinsurance;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BermudaAddress {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.britinsurance.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@class='header--toggle']")).click();
        driver.findElement(By.xpath("//a[@href='/contact']")).click();

        Thread.sleep(5000);

    }
}
