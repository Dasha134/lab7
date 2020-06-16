import lab7.Model.Acc;
import lab7.pageObj.AccountCreationForm;
import lab7.pageObj.BasePage;
import lab7.pageObj.SignUpForm;
import lab7.utils.EmailGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class PositiveRegistrationTest extends BaseTest
{
    @Autowired
    SignUpForm signUpForm;
    @Autowired
    AccountCreationForm accountCreationForm;
	// DataProvider для регистрации пользователя (все поля заполнены)
    @DataProvider(name = "crAccInfo")
    public Object[][] crAccInfo()
    {
        Acc account = new Acc();
        account.setGender("male");
        account.setName("Brad");
        account.setSurname("Falchuk");
        account.setEmail(EmailGenerator.generateEmail());
        account.setPassword("123456");
        account.setBd("1");
        account.setBm("3");
        account.setByr("1971");
        account.setNewsletter(true);
        account.setSpecialOffers(true);
        account.setCompany("American Stories");
        account.setAddress1("That Street");
        account.setAddress2("134");
        account.setCity("Newton");
        account.setState("Massachusetts");
        account.setPostCode("05840");
        account.setCountry("United States");
        account.setAdditionalInfo("Here's some additional info: I'm the director of AHS");
        account.setHomePhone("854796");
        account.setMobilePhone("84597826585");
        account.setAddressAlias("Address alias no");
        return new Object[][]
        {
			{account}
        };
    }
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify successful user registration.")
    @Test(dataProvider = "crAccInfo")
	// регистрация с заполнением всех полей формы
    public void fullRegistrationPositive(Acc account) throws InterruptedException {
        BasePage basePage = new BasePage(webdriver);
        basePage.signIn();
        signUpForm.fillForm(account.getEmail());
        signUpForm.clickCreateAccountButton();
        accountCreationForm.fullRegistration(account);
        Thread.sleep(1000);
        Assert.assertTrue(accountCreationForm.isRegistrationSuccessful());
    }
}