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
    private final String url = "https://qa-scooter.praktikum-services.ru/";
    //Первая кнопка "Заказать"


    public void open(){
        driver.get(url);
    }

    //Главная страница
    private By homePage = By.className("Home_HomePage__ZXKIX");

    //Кнопка кук
    public final By buttonCookie = By.className("App_CookieButton__3cvqF");

    //Кнопка первого вопроса
    public final By firstQuestion = By.xpath(".//div[text()='Сколько это стоит? И как оплатить?']");

    //Кнопка второго вопроса
    public final By secondQuestion = By.xpath(".//div[text()='Хочу сразу несколько самокатов! Так можно?']");

    //Кнопка третьего вопроса
    public final By thirdQuestion = By.xpath(".//div[text()='Как рассчитывается время аренды?']");

    //Кнопка четвертого вопроса
    public final By fourthQuestion = By.xpath(".//div[text()='Можно ли заказать самокат прямо на сегодня?']");

    //Кнопка пятого вопроса
    public final By fifthQuestion = By.xpath(".//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']");

    //Кнопка шестого вопроса
    public final By sixthQuestion = By.xpath(".//div[text()='Вы привозите зарядку вместе с самокатом?']");

    //Кнопка седьмого вопроса
    public final By seventhQuestion = By.xpath(".//div[text()='Можно ли отменить заказ?']");

    //Кнопка восьмого вопроса
    public final By eighthQuestion = By.xpath(".//div[text()='Я жизу за МКАДом, привезёте?']");

    //Ответы на вопросы
    public final String answerFirstQuestion = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public final String answerSecondQuestion = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public final String answerThirdQuestion = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public final String answerFourthQuestion = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public final String answerFifthQuestion = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public final String answerSixthQuestion = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public final String answerSeventhQuestion = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public final String answerEighthQuestion = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    //Ожидание загрузки страницы приложения
    public final AccordionQuestions expectation(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return this;
    }

    //Скрол до списка вопросов
    public void scroll(){
        WebElement element = driver.findElement(By.xpath(".//div[@class='Home_SubHeader__zwi_E' and text()='Вопросы о важном']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //Принять куки
    public AccordionQuestions pressButtonCookie(){
        driver.findElement(buttonCookie).click();
        return this;
    }

    //Проверка соответствия ответов вопросам
    public AccordionQuestions checkingFirstQuestion(){
        driver.findElement(firstQuestion).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(".//div[@class='accordion']/div[1]"), answerFirstQuestion));
        return this;
    }

    public AccordionQuestions checkingSecondQuestion(){
        driver.findElement(secondQuestion).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(".//div[@class='accordion']/div[2]"), answerSecondQuestion));
        return this;
    }

    public AccordionQuestions checkingThirdQuestion(){
        driver.findElement(thirdQuestion).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(".//div[@class='accordion']/div[3]"), answerThirdQuestion));
        return this;
    }

    public AccordionQuestions checkingFourthQuestion(){
        driver.findElement(fourthQuestion).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(".//div[@class='accordion']/div[4]"), answerFourthQuestion));
        return this;
    }

    public AccordionQuestions checkingFifthQuestion(){
        driver.findElement(fifthQuestion).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(".//div[@class='accordion']/div[5]"), answerFifthQuestion));
        return this;
    }

    public AccordionQuestions checkingSixthQuestion(){
        driver.findElement(sixthQuestion).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(".//div[@class='accordion']/div[6]"), answerSixthQuestion));
        return this;
    }

    public AccordionQuestions checkingSeventhQuestion(){
        driver.findElement(seventhQuestion).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(".//div[@class='accordion']/div[7]"), answerSeventhQuestion));
        return this;
    }

    public AccordionQuestions checkingEighthQuestion(){
        driver.findElement(eighthQuestion).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(".//div[@class='accordion']/div[8]"), answerEighthQuestion));
        return this;
    }
}
