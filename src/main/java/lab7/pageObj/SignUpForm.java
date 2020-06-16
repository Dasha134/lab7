package lab7.pageObj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
@Component
public class SignUpForm extends BasePage
{
    private By formContainer = By.id("create-account_form");
    private By emailInput = By.id("email_create");
    private By createAccb = By.id("SubmitCreate");
    private By errorMessage = By.id("create_account_error");
	// конструктор создания страницы авторизации
    public SignUpForm(WebDriver webDriver)
    {
        super(webDriver);
    }
	// заполнение поля email
    public void fillForm(String email)
    {
        this.waitForElementDisplayed(formContainer);
        webDriver.findElement(emailInput).sendKeys(email);
    }
	// нажать кнопку Create Account
    public void clickCreateAccountButton()
    {
        webDriver.findElement(createAccb).click();
    }
}