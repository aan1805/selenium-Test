import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainClass {
    public static void main(String[] args) {

        String sitePage;
        sitePage = "en.wikipedia.org";

        //инициализация
        System.setProperty("webdriver.gecko.driver", "/home/alex/IdeaProjects/TestSelenium/drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //implicit timeout
        driver.manage().window().maximize();

        driver.get("http://" + sitePage);

        //поиск элементов
        WebElement link = driver.findElement(By.linkText("Log in"));
        WebElement searchField = driver.findElement(By.name("search"));
        WebElement searchButton = driver.findElement(By.xpath("//form[@id='searchform']//input[@id='searchButton']"));
        WebElement li = driver.findElement(By.id("ca-viewsource"));


        /*
        //формирование массива данных
        WebElement[] data = {
                link,
                searchField,
                searchButton};
         */

        //формирование листа данных
        List<WebElement> data = new ArrayList<>();

        data.add(link);
        data.add(searchField);
        data.add(searchButton);
        data.add(li);

        Iterator<WebElement> iterator = data.iterator();
        while (iterator.hasNext()) {
            //...
            iterator.next();
        }

        searchButton.click();

       driver.quit();

    }

}
