package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Main extends BasePage {
    String SITE_URL = "https://auto.ria.com";
    public Main(WebDriver driver) {
        super(driver);
    }
    public Main goTo(){
        driver.get(SITE_URL);
        return this;
    }
    public Main findMark(String carMark){
        click(By.id("brandTooltipBrandAutocomplete-brand"));
        click(By.xpath("/descendant::div[@id='brandTooltipBrandAutocomplete-brand']/descendant::a[contains (text(),'"+ carMark +"')]"));
        return this;
    };
    public Main findModel(String carModel){
        click(By.id("brandTooltipBrandAutocomplete-model"));
        click(By.xpath("/descendant::div[@id='brandTooltipBrandAutocomplete-model']/descendant::a[contains (text(),'"+ carModel +"')]"));
        return this;
    }
    public Main findRegion(String carRegion){
        click(By.id("brandTooltipBrandAutocomplete-region"));
            click(By.xpath("/descendant::div[@id='brandTooltipBrandAutocomplete-region']/descendant::a[contains (text(),'"+ carRegion +"')]"));
        return this;
    }
    public Main startSeach(){
        click(By.xpath("/descendant::button[@class='button']"));

        return this;
    }



}
