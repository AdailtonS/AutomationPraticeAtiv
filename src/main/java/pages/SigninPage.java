package pages;

import com.github.javafaker.Faker;
import core.DriverManager;
import interfaces.TestingType;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Locale;

public class SigninPage extends DriverManager implements TestingType {

    private By txtEmail = By.name("email_create");
    private By btnCriarConta = By.id("SubmitCreate");
    private By radiusGenre = By.id("id_gender1");
    private By firstNamePerson = By.id("customer_firstname");
    private By lastNamePerson = By.id("customer_lastname");
    private By password = By.id("passwd");
    private By address = By.id("address1");
    private By city = By.id("city");
    private By zip = By.id("postcode");
    private By other = By.id("other");
    private By homePhone = By.id("phone");
    private By mobilePhone = By.id("phone_mobile");
    private By btnRegistrar = By.id("submitAccount");
    private By btnProceed = By.name("processAddress");
    private By terms = By.id("cgv");
    private By btnGoPayment = By.name("processCarrier");
    private By payment = By.className("bankwire");
    private By confirPayment = By.xpath("//*[@id=\"cart_navigation\"]/button/span");

    /**
     * Metodo resposavel por valida se a pagina está presente
     *
     * @return true ou false
     *
     * @since 24/11/2020
     */
    public boolean estaPresente() {
        return getWait().until(ExpectedConditions.elementToBeClickable(txtEmail)).isEnabled();
    }


    /**
     *  Metodo resposavel por criar uma conta
     *
     * @since 24/11/2020
     */
    public void criaConta(){
        Faker faker = new Faker();

        getDriver().findElement(txtEmail).sendKeys(faker.name().firstName()+"@etec.gov.br".replace(" ",""));
        getDriver().findElement(btnCriarConta).click();
        getDriver().findElement(radiusGenre).click();
        getDriver().findElement(firstNamePerson).sendKeys(faker.name().firstName().replace(" ", " "));
        getDriver().findElement(lastNamePerson).sendKeys(faker.name().firstName().replace(" ", " "));
        getDriver().findElement(password).sendKeys(faker.name().name().replace(" "," "));
        Select day = new Select(getDriver().findElement(By.id("days")));
        day.selectByValue("15");
        Select month = new Select(getDriver().findElement(By.id("months")));
        month.selectByValue("5");
        Select year = new Select(getDriver().findElement(By.id("years")));
        year.selectByValue("1998");
        getDriver().findElement(address).sendKeys(faker.address().streetAddress().replace(" ", " "));
        getDriver().findElement(city).sendKeys(faker.address().city().replace(" ", " "));
        Select state = new Select(getDriver().findElement(By.id("id_state")));
        state.selectByValue("11");
        getDriver().findElement(zip).sendKeys(faker.address().zipCode());
        getDriver().findElement(other).sendKeys("Nome: Adailton Silva " +
                                                "RM: 19731");
        getDriver().findElement(homePhone).sendKeys(faker.phoneNumber().phoneNumber());
        getDriver().findElement(mobilePhone).sendKeys(faker.phoneNumber().cellPhone());
        getDriver().findElement(btnRegistrar).click();

    }
    public void finaliza(){
        getDriver().findElement(btnProceed).click();
        getDriver().findElement(terms).click();
        getDriver().findElement(btnGoPayment).click();
        getDriver().findElement(payment).click();
        getDriver().findElement(confirPayment).click();
    }


}
