package com.sun.crawler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class ImageCrawler
{
    public static void main(String[] args)
    {
        final WebDriver driver = new SafariDriver();
        final WebDriverWait wait = new WebDriverWait(driver, 10);

        try
        {
            String url = "https://www.google.co.kr/imghp?hl=ko&ogbl"; // 구글 이미지검색 URL
            driver.get(url); // url로 이동한다.

            WebElement searchEle = driver.findElement(By.name("q")); // 구글 검색창 요소
            searchEle.sendKeys("cat"); // 검색창에 cat 입력
            searchEle.sendKeys(Keys.RETURN); // 검색창 요소에서 ENTER

            Thread.sleep(3000); // 검색이 완료될 시간을 기다린다.

            List<WebElement> imgList = driver.findElements(By.cssSelector("img.rg_i.Q4LuWd")); // 이미지 목록을 불러온다

            int imgSize = imgList.size();

            for (int i = 0; i <imgSize ; i++)
            {
                imgList.get(i).click(); // 이미지를 순서대로 클릭

                Thread.sleep(6000); // 이미지 로딩 시간동안 기다린다.

                URL imgUrl = new URL(driver.findElement(By.cssSelector(".n3VNCb")).getAttribute("src")); // 이미지 URL을 가져온다.
                // 이미지 다운로드
                BufferedImage image = ImageIO.read(imgUrl);
                ImageIO.write(image, "png", new File("저장할 경로/tmp/img"+i));
            }

        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            driver.quit();
        }

    }

}
