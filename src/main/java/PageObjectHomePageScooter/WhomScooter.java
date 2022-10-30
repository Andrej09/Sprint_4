package PageObjectHomePageScooter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WhomScooter {
    private WebDriver driver;
    public WhomScooter(WebDriver driver){
        this.driver = driver;
    }

    private final String url = "https://qa-scooter.praktikum-services.ru/";

    //Поле Имя
    public final By fieldName = By.xpath(".//input[@placeholder='* Имя']");

    //Поле Фамилия
    public final By fieldSurname = By.xpath(".//input[@placeholder='* Фамилия']");

    //Поле Адрес
    public final By fieldAddress= By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //Поле Метро
    public final By fieldMetro= By.xpath(".//input[@placeholder='* Станция метро']");

    //Поле Телефон
    public final By fieldTelephone= By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Кнопка Далее
    public final By nextButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Далее']");

    //Переход на страницу сайта
    public WhomScooter open(){
        driver.get(url);
        return this;
    }

    //Нажатие кнопок Заказать
    public WhomScooter clickButtonOrder(By name){
        WebElement element = driver.findElement(name);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(name).click();
        return this;
    }

    public WhomScooter completionFieldName(String name){
        driver.findElement(fieldName).sendKeys(name);
        return this;
    }

    public WhomScooter completionFieldSurname(String name){
        driver.findElement(fieldSurname).sendKeys(name);
        return this;
    }
    public WhomScooter completionFieldAddress(String name){
        driver.findElement(fieldAddress).sendKeys(name);
        return this;
    }

    public WhomScooter completionFieldMetro(String name){
        driver.findElement(fieldMetro).sendKeys(name);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(".//div[text() = '" + name + "']"), name));
        driver.findElement(By.xpath(".//div[text() = '" + name + "']")).click();
        return this;
    }

    public WhomScooter completionFieldtTelephone(String name){
        driver.findElement(fieldTelephone).sendKeys(name);
        return this;
    }

    public WhomScooter clickNextButton(){
        driver.findElement(nextButton).click();
        return this;
    }

}
