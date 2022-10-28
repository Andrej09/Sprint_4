package PageObjectHomePageScooter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AboutRent {
    private WebDriver driver;

    public AboutRent(WebDriver driver){
        this.driver = driver;
    }

    //Поле Даты доставки
    public final By fieldDeliverydate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //Поле Срок аренды
    public final By fieldRentalPeriod = By.xpath(".//div[@class='Dropdown-root']/div/div[@class='Dropdown-placeholder']");

    //Поле Для коментария
    public final By fieldComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    //Кнопка Заказать
    public final By buttenOrder = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    //Кнопка Да (Хотите оформить заказ)
    public final By buttenYesIDo = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div/button[text()='Да']");

    public AboutRent findFieldtDeliveryDate(String name){
    driver.findElement(fieldDeliverydate).sendKeys(name);
    driver.findElement(fieldDeliverydate).sendKeys(Keys.RETURN);
        return this;
    }

    public AboutRent findRentalPeriod(String name){
        driver.findElement(fieldRentalPeriod).click();
        driver.findElement(By.xpath(".//div[@class='Dropdown-menu']/div[@class='Dropdown-option' and text()='"+ name +"']")).click();
        return this;
    }
    public AboutRent findColor(String color){
        if (color == "черный"){
            driver.findElement(By.id("black")).click();
        }else if (color == "серый"){
            driver.findElement(By.id("grey")).click();
        }
        return this;
    }

    public AboutRent findFieldComment(String name2){
        driver.findElement(fieldComment).sendKeys(name2);
        return this;
    }


    public AboutRent clickButtenOrder(){
        driver.findElement(buttenOrder).click();
        return this;
    }
    public AboutRent clickButtenYesIDo(){
        driver.findElement(buttenYesIDo).click();
        return this;
    }
}
