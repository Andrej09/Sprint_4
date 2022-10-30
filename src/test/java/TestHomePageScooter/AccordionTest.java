package TestHomePageScooter;
import PageObjectHomePageScooter.AccordionQuestions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


    @RunWith(Parameterized.class)
    public class AccordionTest {
        private WebDriver driver;
        private final By question;
        private final By accordion;
        private final String answer;

        public AccordionTest(By question, By accordion, String answer) {
            this.question =  question;
            this.accordion =  accordion;
            this.answer =  answer;
        }

        // Два прогона, вход с разных кнопок "Заказать"
        @Parameterized.Parameters
        public static Object[][] getTestAccordion() {
            return new Object[][]{
                    {By.id("accordion__heading-0"),By.className("Home_FAQ__3uVm4"), "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                    {By.id("accordion__heading-1"),By.className("Home_FAQ__3uVm4"), "Пока что у нас так: один заказ — один самокат. Если хотите покататься " +
                            "с друзьями," + " можете просто сделать несколько заказов — один за другим."},
                    {By.id("accordion__heading-2"),By.className("Home_FAQ__3uVm4"), "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая " +
                            "в течение дня." + " Отсчёт времени аренды начинается с момента, " + "когда вы оплатите заказ курьеру. " +
                            "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                    {By.id("accordion__heading-3"),By.className("Home_FAQ__3uVm4"), "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                    {By.id("accordion__heading-4"),By.className("Home_FAQ__3uVm4"), "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку " +
                            "по красивому номеру 1010."},
                    {By.id("accordion__heading-5"),By.className("Home_FAQ__3uVm4"), "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь " +
                            "суток — даже если будете кататься без передышек и во сне. " + "Зарядка не понадобится."},
                    {By.id("accordion__heading-6"),By.className("Home_FAQ__3uVm4"), "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки " +
                            "тоже не попросим. Все же свои."},
                    {By.id("accordion__heading-7"),By.className("Home_FAQ__3uVm4"), "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
            };
        }

        @Before
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
            driver = new ChromeDriver();
        }

        @Test
        public void checkingCorrespondenceAnswersQuestions() {
            AccordionQuestions accordionQuestions = new AccordionQuestions(driver);

            accordionQuestions
                              .open()
                              .expectation()
                              .pressButtonCookie()
                              .scroll()
                              .checkingE(question,accordion,answer);
        }

    @After
    public void teardown() {
        driver.quit();
    }
}


