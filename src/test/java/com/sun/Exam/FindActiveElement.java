package com.sun.Exam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * selenium 사이트의 예제
 * https://www.selenium.dev/documentation/en/webdriver/web_element/
 */
public class FindActiveElement
{
    public static void main(String[] args)
    {
        WebDriver driver = new SafariDriver();

        try
        {
            driver.get("http://www.google.com");
            // name='q' 인 요소는 google 페이지의 검색 입력박스 이다. webElement라고 입력한다.
            driver.findElement(By.cssSelector("[name='q']")).sendKeys("webElement");

            // 현재 활성되어있는 요소의 title 속성을 가져온다.
            String attr = driver.switchTo().activeElement().getAttribute("title");
            System.out.println(attr);

        } finally {
            driver.quit();
        }
    }
}
