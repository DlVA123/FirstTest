package com.AutoRia;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page.Main;
import page.Second;
import java.util.concurrent.TimeUnit;


public class FirstTest {
    public WebDriver driver;
    public Main main;
    public Second second;


@BeforeEach
    public void start(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    main = PageFactory.initElements(driver, Main.class);
    second = PageFactory.initElements(driver, Second.class);
}
@AfterEach
public void end(){
    driver.quit();
}


    @Test
    public void firsTest()  {
        main.goTo()
                .findMark("Nissan")
                .findModel("Almera")
                //.findRegion("Київ")
                .startSeach();
        second.checkPage()
                .collectData();

    }


}
