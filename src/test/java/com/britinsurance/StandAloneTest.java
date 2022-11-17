package com.britinsurance;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.britinsurance.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button)[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("IFRS 17");
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Keys.ENTER);
        List<WebElement> results = driver.findElements(By.xpath("//div[@class='results-container']/div[@class='list-block']"));
        Assert.assertEquals(results.size(), 3);

        String firstResultActual = driver.findElement(By.xpath("(//div[@class='results-container']/div[@class='list-block'])[1]//a")).getText();
        String firstResultExpected = "Interim results for the six months ended 30 June 2022";
        Assert.assertEquals(firstResultActual, firstResultExpected);

        String secondResultActual = driver.findElement(By.xpath("(//div[@class='results-container']/div[@class='list-block'])[2]//a")).getText();
        String secondResultExpected = "Gavin Wilkinson";
        Assert.assertEquals(secondResultActual, secondResultExpected);

        String thirdResultActual = driver.findElement(By.xpath("(//div[@class='results-container']/div[@class='list-block'])[3]//a")).getText();
        String thirdResultExpected = "John King";
        Assert.assertEquals(thirdResultActual, thirdResultExpected);

        Thread.sleep(2000);

        driver.quit();
    }
}
