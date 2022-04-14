package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class Second extends BasePage {
    public Second(WebDriver driver) {
        super(driver);
    }

    public Second checkPage() {
        isElementDisplayed(By.id("staticResultsCount"));
        return this;
    }


    public Second collectData() {
        int carCount = takeCount(By.xpath("//*[@id='staticResultsCount']"));
        collectLinks(carCount);


       return this;
    }
}




