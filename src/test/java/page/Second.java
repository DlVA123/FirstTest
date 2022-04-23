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
        if( carCount <= 20)
            сollectLinks(carCount);
        else{

            for(int i = 0; i < carCount; i = i+20){
                int test = 20;
                сollectLinks(test);
            }
        }


       return this;
    }
}




