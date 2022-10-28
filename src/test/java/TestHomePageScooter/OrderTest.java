package TestHomePageScooter;
import PageObjectHomePageScooter.AboutRent;
import PageObjectHomePageScooter.WhomScooter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@RunWith(Parameterized.class)
    public class OrderTest {
    private WebDriver driver;

        private final By buttonOrder;
        private final String name;
        private final String surname;
        private final String address;
        private final String metro;
        private final String telephone;
        private final String date;
        private final String period;
        private final String color;
        private final String comment;

        public OrderTest(By buttonOrder, String name, String surname,
                         String address, String metro, String telephone,
                         String date, String period, String color, String comment) {
            this.buttonOrder = buttonOrder;
            this.name = name;
            this.surname = surname;
            this.address = address;
            this.metro = metro;
            this.telephone = telephone;
            this.date = date;
            this.period = period;
            this.color = color;
            this.comment = comment;
        }

        // Два прогона, вход с разных кнопок "Заказать"
        @Parameterized.Parameters
        public static Object[][] getOrderDetails() {
            return new Object[][]{
                    {By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']"),
                    "Иван","Иванов","улица Мира дои 3", "Лубянка","88005553535","12.12.2022","сутки","черный","Спасибо"},

                    {By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']"),
                    "КОЛЯ","ПЕТРОВ","Набережная 35","Сокольники","+700000000000","23112022","трое суток","серый",""},
            };
        }

        @Before
        public void setUp() {

            System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
            driver = new ChromeDriver();
        }

        @Test
        public void АillingFieldMaking() {

            driver.get("https://qa-scooter.praktikum-services.ru/");
            WhomScooter whomScooter = new WhomScooter(driver);
            whomScooter.clickButtonOrder(buttonOrder)
                       .completionFieldName(name)
                       .completionFieldSurname(surname)
                       .completionFieldAddress(address)
                       .completionFieldMetro(metro)
                       .completionFieldtTelephone(telephone)
                       .clickNextButton();

            AboutRent aboutRent = new AboutRent(driver);
            aboutRent.findFieldtDeliveryDate(date)
                     .findRentalPeriod(period)
                     .findColor(color)
                     .findFieldComment(comment)
                     .clickButtenOrder()
                     .clickButtenYesIDo();


        }

        @After
        public void teardown() {
            driver.quit();
        }
    }

