package PageObjectHomePageScooter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AccordionQuestions {
    private WebDriver driver;

    public AccordionQuestions(WebDriver driver){
        this.driver = driver;

    }
    //Страница сайта
    private final String url = "https://qa-scooter.praktikum-services.ru/";

    //Переход на страницу сайта
    public AccordionQuestions open(){
        driver.get(url);
        return this;
    }

    //Главная страница
    private By homePage = By.className("Home_HomePage__ZXKIX");

    //Кнопка кук
    public final By buttonCookie = By.className("App_CookieButton__3cvqF");

    //Панель вопросов
    public final By questionPanel = By.className("Home_FAQ__3uVm4");

    //Ожидание загрузки страницы приложения
    public final AccordionQuestions expectation(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return this;
    }

    //Скрол до списка вопросов
    public AccordionQuestions scroll(){
        WebElement element = driver.findElement(By.xpath(".//div[@class='Home_SubHeader__zwi_E' and text()='Вопросы о важном']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }

    //Принять куки
    public AccordionQuestions pressButtonCookie(){
        driver.findElement(buttonCookie).click();
        return this;
    }

    //Проверка соответствия ответов вопросам
    public AccordionQuestions checkingE(By question, By panel, String answer){
        driver.findElement(question).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(panel, answer));
        return this;
    }

}


