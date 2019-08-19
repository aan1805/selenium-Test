import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainClass {

    static WebDriver browser;

    public static void main(String[] args) {

        String sitePage;
        sitePage = "en.wikipedia.org";
        String sitePageYan = "market.yandex.ru";

        //инициализация
  //      System.setProperty("webdriver.gecko.driver", "/home/alex/aan1805/selenium-Test/drivers/geckodriver");
        System.setProperty("webdriver.chrome.driver", "/home/alex/aan1805/selenium-Test/drivers/chromedriver");
  //      System.setProperty("phantomjs.binary.path", "/home/alex/aan1805/selenium-Test/drivers/phantomjs");
        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //implicit timeout
        browser.manage().window().maximize();

        browser.get("http://" + sitePageYan);

        //javascripts
        JavascriptExecutor jse = (JavascriptExecutor)browser;
        // jse.executeScript("alert('Hello World')");
        jse.executeScript("window.scrollBy(0, 1000)", "");
        jse.executeScript("window.scrollBy(0, -1000)", "");

        //radioButton checkBox
        browser.findElement(By.xpath("/html/body/div[1]/div/span/div[2]/noindex/div[2]/div/div/div/div[3]/a")).click();
    //    browser.findElement(By.xpath("/html/body/div[1]/div[2]/div[7]/div/div/div[1]/div/div/div/div/div/div/div[2]/div[2]/ul/li[1]/div/a")).click();
     //   browser.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div[2]/div/div/div/div[3]/div/div[2]/div[3]/fieldset/ul/li[1]/div/a/label/div")).click();

        browser.get("http://" + sitePage);

        //ссылки
        WebElement link = browser.findElement(By.xpath("//li[@id='n-aboutsite']/a"));
        System.out.println(link.getText());
        link.click();


        //работа с текстовыми полями
        browser.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("Selenium WebDriver");
        browser.findElement(By.xpath("//form[@id='searchform']//input[last()]")).click();
        System.out.println(browser.findElement(By.xpath("//div[@id='searchText']//input")).getAttribute("value"));
        browser.findElement(By.xpath("//div[@id='searchText']//input")).clear();


        //поиск элементов
        WebElement linkLog = browser.findElement(By.linkText("Log in"));
        WebElement searchField = browser.findElement(By.name("search"));
        WebElement searchButton = browser.findElement(By.xpath("//form[@id='searchform']//input[@id='searchButton']"));
        browser.get("http://" + sitePage);
        WebElement li = browser.findElement(By.id("ca-viewsource"));


/*
        //формирование массива данных
        WebElement[] data = {
                link,
                searchField,
                searchButton};
*/

        //формирование листа данных
        List<WebElement> data = new ArrayList<>();

        data.add(linkLog);
        data.add(searchField);
        data.add(searchButton);
        data.add(li);

        Iterator<WebElement> iterator = data.iterator();
        while (iterator.hasNext()) {
            //...
            iterator.next();
        }

        browser.quit();

    }

}
