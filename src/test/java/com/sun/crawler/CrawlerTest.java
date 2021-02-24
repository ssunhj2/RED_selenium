package com.sun.crawler;

import java.io.File;
import java.io.IOException;

public class CrawlerTest
{
    public void aa()
    {
        // 크롬 드라이버를 가져온다.
        final File driverFile = new File("src/main/resources/bin/chromedriver.exec");
        final String driverFilePath = driverFile.getAbsolutePath();

        if (!driverFile.exists() && driverFile.isFile()) {
            throw new RuntimeException("Not Found Chrome Driver File OR This is Not File.");
        }

        // ChromeDriverService 를 생성한다.
        final ChromeDriverService service;

        service = new ChromeDriverService.Builder()
                .usingDriverEzecutable(driverFile)
                .usingAnyFreePort()
                .build();

        try
        {
            service.start();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        final WebDriver driver = new ChromeDriver(service);
        final WebDriverWait wait = new WebDriverWait(driver, 10);

        try
        {
            driver.get("https://google.com");
            Thread.sleep(5000); //
            driver.findElement(By.name("q")).sendKeys("cat" + Keys.ENTER);
            final WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("h3>div")));
            System.out.println(firstResult.getAttribute("textContent"));

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            driver.quit();
            service.stop();
        }

    }

}
