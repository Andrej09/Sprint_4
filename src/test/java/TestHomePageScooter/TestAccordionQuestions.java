package TestHomePageScooter;
import PageObjectHomePageScooter.AccordionQuestions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAccordionQuestions {
    private WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testOpen() {
        AccordionQuestions accordionQuestions = new AccordionQuestions(driver);

        driver.get("https://qa-scooter.praktikum-services.ru/");
        accordionQuestions
                          .expectation()
                          .pressButtonCookie()
                          .scroll();
        accordionQuestions
                          .checkingFirstQuestion()
                          .checkingSecondQuestion()
                          .checkingThirdQuestion()
                          .checkingFourthQuestion()
                          .checkingFifthQuestion()
                          .checkingSixthQuestion()
                          .checkingSeventhQuestion()
                          .checkingEighthQuestion();
    }

    @After
    public void teardown() {
        driver.quit();
    }
 }
