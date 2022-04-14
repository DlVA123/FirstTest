package page;
import com.AutoRia.Car;
import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);


    }




    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    public void click(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    public void isElementDisplayed(By elementBy) {
        waitVisibility(elementBy);
        assertTrue(driver.findElement(elementBy).isDisplayed());
    }

    public void back() {
        driver.navigate().back();

    }

    public void tookData(By element1By, By element2By, By element3By) {
        String carModel = driver.findElement(element1By).getText();
        String carRun = driver.findElement(element2By).getText();
        String carPrice = driver.findElement(element3By).getText();
        System.out.println("Name: " + carModel);
        System.out.println("Price: " + carRun);
        System.out.println("Run: " + carPrice + "000 KM");

    }

    public int takeCount(By elementBy) {
        int count = Integer.parseInt(driver.findElement(elementBy).getText());

        return count;
    }

    public void clickElement(By elementBy) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(elementBy);
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(elementBy).click();

    }


    public void collectLinks(int links)  {
        int numb = links;
        String collect[] = new String[numb + 1];
        Car[] cars = new Car[numb +1];
        ;
        for (int i = 1; i <= numb; i++) {
            String push = driver.findElement(By.xpath("/descendant::section//section[" + i + "]/descendant::a[@class ='m-link-ticket']")).getAttribute("href");
            collect[i] = String.valueOf(push);
        }

        for (int x = 1; x <= numb; x++) {
            driver.get(collect[x]);
            String cName = driver.findElement(By.xpath("//div[6]/div[11]/div[1]/div/h1")).getText();
            String cPrice = driver.findElement(By.xpath("//div[6]/div[11]/div[4]/aside/section[1]/div[1]/strong")).getText();
            String cRun =  driver.findElement(By.xpath("//div[6]/div[11]/div[4]/aside/section[1]/div[3]/span")).getText();
            cars[x] = new Car(cName, cPrice, cRun);

             }

            for(int i = 1; i <=numb; i++){
                cars[i].writeDate();
            }



    }
}
