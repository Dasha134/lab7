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
public class NegativeRegistrationTest extends BaseTest 
{
    @Autowired
    SignUpForm signUpForm;
    @Autowired
    AccountCreationForm accountCreationForm;
	// DataProvider для регистрации пользователя (обязательные поля не заполняются)
    @DataProvider(name = "crAccInfo")
    public Object[][] crAccInfo() 
	{
        Acc account = new Acc();
        account.setGender("male");
        account.setEmail(EmailGenerator.generateEmail());
        account.setBd("8");
        account.setBm("8");
        account.setByr("1988");
        account.setNewsletter(true);
        account.setSpecialOffers(true);
        account.setCompany("Company");
        account.setAddress2("Address2");
        account.setState("Nebraska");
        account.setCountry("United States");
        account.setAdditionalInfo("Here's some additional info");
        return new Object[][] 
		{
			{account}
        };
    }
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify user registration with incorrect email value.")
    @Test(dataProvider = "crAccInfo")
	// регистрация с пустями необходимыми полями
    public void registrationRequiredFieldsAreEmpty(Acc account) throws InterruptedException {
        BasePage basePage = new BasePage(webdriver);
        basePage.signIn();
        SignUpForm signUpForm = new SignUpForm(webdriver);
        signUpForm.fillForm(account.getEmail());
        signUpForm.clickCreateAccountButton();
        AccountCreationForm accountCreationForm = new AccountCreationForm(webdriver);
        accountCreationForm.registrationNoRequiredFields(account);
        Assert.assertTrue(accountCreationForm.errorMessageCheck());
        Thread.sleep(1000);
    }
}
