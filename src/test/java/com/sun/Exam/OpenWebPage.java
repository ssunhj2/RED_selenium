package com.sun.Exam;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class OpenWebPage
{

    public static void main(String[] args)
    {
        final WebDriver driver = new SafariDriver();
        final WebDriverWait wait = new WebDriverWait(driver, 10);

        try
        {
            String url = "https://google.com";
            driver.get(url); // url로 이동한다.
            String title = driver.getTitle();

            driver.findElement(By.name("q")).sendKeys("cat" + Keys.ENTER);
            final WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("h3>div")));
            System.out.println(firstResult.getAttribute("textContent"));
            Thread.sleep(6000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            driver.quit();
        }
    }

}
