package page;
import com.AutoRia.Car;
import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

        String collect[] = new String[links];
        Car[] cars = new Car[links];

        for (int i = 0; i < links; i++) {
            String push;
            try {
                push = driver.findElement(By.xpath("/descendant::section//section[" + (i + 1) + "]/descendant::a[@class ='m-link-ticket']")).getAttribute("href");

            }catch(Exception io){
                System.out.println(io.getMessage());
                continue;}
            if(push == null){
                System.out.println("ошибочка");
                continue;
            }
                collect[i] = String.valueOf(push);
        }

        for (int x = 0; x < links; x++) {
            driver.get(collect[x]);
            String cName = driver.findElement(By.xpath("//descendant::div[@id = 'heading-cars']//h1")).getText();
            String cPrice = driver.findElement(By.xpath("//descendant::section[@class = 'price mb-15 mhide']/descendant::div[@class = 'price_value']/strong")).getText();
            String cRun =  driver.findElement(By.xpath("//descendant::section[@class = 'price mb-15 mhide']/descendant::div[@class = 'base-information bold']/span")).getText();
            cars[x] = new Car(cName, cPrice, cRun);

             }

            for(int i = 0; i < links; i++){
                cars[i].writeDate("C://Program Files//Java//notes3.txt",true);
            }

    }
}

