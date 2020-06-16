package lab7.pageObj;
import lab7.Model.Acc;
import lab7.utils.RegistrationErrors;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;
import org.testng.Assert;
@Getter
@Setter
@Component
public class AccountCreationForm extends BasePage
{
	// переменные для идентификации полей формы
    private By formContainer = By.id("account-creation_form");
    private By titleMr = By.id("id_gender1");
    private By titleMrs = By.id("id_gender2");
    private By nameInfo = By.id("customer_firstname");
    private By surnameInfo = By.id("customer_lastname");
    private By email = By.id("email");
    private By password = By.id("passwd");
    private By bd = By.id("days");
    private By bm = By.id("months");
    private By byr = By.id("years");
    private By newsletter = By.id("newsletter");
    private By specialOffers = By.id("optin");
    private By nameYourAddress = By.id("firstname");
    private By surnameYourAddress = By.id("lastname");
    private By company = By.id("company");
    private By address1 = By.id("address1");
    private By address2 = By.id("address2");
    private By city = By.id("city");
    private By state = By.id("id_state");
    private By postCode = By.id("postcode");
    private By country = By.id("id_country");
    private By additionalInfo = By.id("other");
    private By homePhone = By.id("phone");
    private By mobilePhone = By.id("phone_mobile");
    private By addressAlias = By.id("alias");
    private By submitButton = By.id("submitAccount");
	// конструктор создания формы
    public AccountCreationForm(WebDriver webDriver)
    {
        super(webDriver);
    }
	// отображение контейнера
    public boolean isFormDisplayed()
    {
        this.waitForElementDisplayed(formContainer);
        return true;
    }
	// выбор пола
    public void chooseGender(String g)
    {
        if (g.equals("male"))
            webDriver.findElement(titleMr).click();
        else if (g.equals("female"))
            webDriver.findElement(titleMrs).click();
    }
	// заполнение имени
    public void fillNameInfo(String name)
    {
        webDriver.findElement(nameInfo).sendKeys(name);
    }
	// заполнение фамилии
    public void fillSurnameInfo(String Surname)
    {
        webDriver.findElement(surnameInfo).sendKeys(Surname);
    }
	// заполнение эл. почты
    public void fillEmail(String mail)
    {
        webDriver.findElement(email).clear();
        webDriver.findElement(email).sendKeys(mail);
    }
	// заполнение пароля
    public void fillPassword(String pswd)
    {
        webDriver.findElement(password).sendKeys(pswd);
    }
	// заполнение дня рождения
    public void fillBD(String day)
    {
        Select drpDay = new Select(webDriver.findElement(bd));
        drpDay.selectByValue(day);
    }
	// заполнение месяца рождения
    public void fillBM(String month)
    {
        Select drpDay = new Select(webDriver.findElement(bm));
        drpDay.selectByValue(month);
    }
	// заполнение года рождения
    public void fillBYR(String year)
    {
        Select drpDay = new Select(webDriver.findElement(byr));
        drpDay.selectByValue(year);
    }
	// нажать на "newsletter"
    public void clickNewsletter()
    {
        webDriver.findElement(newsletter).click();
    }
	// нажать на "spacial offers"
    public void clickSpecialOffers()
    {
        webDriver.findElement(specialOffers).click();
    }
	// заполнение имени
    public void fillNameAddress(String name)
    {
        webDriver.findElement(nameYourAddress).sendKeys(name);
    }
	// заполнение фамилии
    public void fillSurnameAddress(String Surname)
    {
        webDriver.findElement(surnameYourAddress).sendKeys(Surname);
    }
	// заполнение компании
    public void fillCompany(String company)
    {
        webDriver.findElement(this.company).sendKeys(company);
    }
	// заполнение строки адрес1
    public void fillAddress(String address1)
    {
        webDriver.findElement(this.address1).sendKeys(address1);
    }
	// заполнение строки адрес2
    public void fillAddress2(String address1)
    {
        webDriver.findElement(this.address2).sendKeys(address1);
    }
	// заполнение города
    public void fillCity(String city)
    {
        webDriver.findElement(this.city).sendKeys(city);
    }
	// заполнение штата проживания
    public void fillState(String state)
    {
        Select drpState = new Select(webDriver.findElement(this.state));
        drpState.selectByVisibleText(state);
    }
	// заполнение почтового кода
    public void fillPostalCode(String code)
    {
        webDriver.findElement(this.postCode).sendKeys(code);
    }
	// заполнение страны проживания
    public void fillCountry(String country)
    {
        Select drpCountry = new Select(webDriver.findElement(this.country));
        drpCountry.selectByVisibleText(country);
    }
	// заполнение доп. информации
    public void fillAddInfo(String info)
    {
        webDriver.findElement(this.additionalInfo).sendKeys(info);
    }
	// заполнение домашнего телефона
    public void fillHomePhone(String phone)
    {
        webDriver.findElement(this.homePhone).sendKeys(phone);
    }
	// заполнение мобильного телефона
    public void fillMobilePhone(String phone)
    {
        webDriver.findElement(this.mobilePhone).sendKeys(phone);
    }
	// заполнить поле "Alias"
    public void fillAddressAlias(String alias)
    {
        webDriver.findElement(this.addressAlias).sendKeys(alias);
    }
	// нажатие на кнопку Submit"
    public void clickSubmitButton()
    {
        webDriver.findElement(this.submitButton).click();
    }
	// метод полной регистрации
    public void fullRegistration(Acc account)
    {
        Assert.assertTrue(isFormDisplayed());
        chooseGender(account.getGender());
        fillNameInfo(account.getName());
        fillSurnameInfo(account.getSurname());
        fillPassword(account.getPassword());
        fillBD(account.getBd());
        fillBM(account.getBm());
        fillBYR(account.getByr());
        if (account.isNewsletter()) clickNewsletter();
        if (account.isSpecialOffers()) clickSpecialOffers();
        fillCompany(account.getCompany());
        fillAddress(account.getAddress1());
        fillAddress2(account.getAddress2());
        fillCity(account.getCity());
        fillState(account.getState());
        fillPostalCode(account.getPostCode());
        fillCountry(account.getCountry());
        fillAddInfo(account.getAdditionalInfo());
        fillHomePhone(account.getHomePhone());
        fillMobilePhone(account.getMobilePhone());
        fillAddressAlias(account.getAddressAlias());
        clickSubmitButton();
    }
	// ожидание прогрузки формы
    public boolean isRegistrationSuccessful()
    {
        By myAcc = By.id("my-account");
        this.waitForElementDisplayed(myAcc);
        return webDriver.findElements(myAcc).size() != 0;
    }
	// метод для заполнения только необязательных полей
    public void registrationNoRequiredFields(Acc account)
    {
        Assert.assertTrue(isFormDisplayed());
        chooseGender(account.getGender());
        fillEmail("");
        fillBD(account.getBd());
        fillBM(account.getBm());
        fillBYR(account.getByr());
        if (account.isNewsletter()) clickNewsletter();
        if (account.isSpecialOffers()) clickSpecialOffers();
        fillCompany(account.getCompany());
        fillAddress2(account.getAddress2());
        fillState(account.getState());
        fillCountry(account.getCountry());
        fillAddInfo(account.getAdditionalInfo());
        clickSubmitButton();
    }
	// проверка сообщений об ошибке
    public boolean errorMessageCheck()
    {
        By myAcc = By.className("alert-danger");
        this.waitForElementDisplayed(myAcc);
        String bodyText = webDriver.findElement(myAcc).getText();
        return (webDriver.findElements(myAcc).size() != 0) &&
                bodyText.contains(RegistrationErrors.noPhoneNumber) &&
                bodyText.contains(RegistrationErrors.noSurname) &&
                bodyText.contains(RegistrationErrors.noName) &&
                bodyText.contains(RegistrationErrors.noEmail) &&
                bodyText.contains(RegistrationErrors.noPassword) &&
                bodyText.contains(RegistrationErrors.noAddress1) &&
                bodyText.contains(RegistrationErrors.noCity) &&
                bodyText.contains(RegistrationErrors.invalidPostCode);
    }
}
