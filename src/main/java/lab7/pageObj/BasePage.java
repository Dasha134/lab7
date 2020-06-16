package lab7.pageObj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class BasePage
{
    private static final int timeout = 100;		// время ожидания отклика
    protected WebDriver webDriver;				// веб драйвер
    private By signInb = By.className("login");
	// конструктор создания стартовой страницы
    public BasePage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }
	// нажать кнопку "sign in"
    public void signIn()
    {
        webDriver.findElement(signInb).click();
    }
	// ожидание загрузки конкретного элемента
    public void waitForElementDisplayed(By by)
    {
        WebDriverWait wait = new WebDriverWait(webDriver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}