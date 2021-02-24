package com.sun.webdriver;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstTest
{
    @Test
    public void openWebsite()
    {
        WebDriver driver = new SafariDriver();

        // navigate : 웹사이트를 연다.
        driver.navigate().to("https://google.com");

        assertEquals("test", driver.getTitle(), "Fail");

        driver.close();

        driver.quit();
    }

}
