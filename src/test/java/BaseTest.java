import lab7.config.AppConfig;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;
@ContextConfiguration( classes = AppConfig.class )
public class BaseTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    protected ChromeDriver webdriver;
    @Autowired
    private AppConfig config;
	// открыть браузер
    @BeforeMethod
    public void initBrowser() 
	{
        webdriver.get(config.getBaseUrl());
    }
	// закрыть браузер
    @AfterMethod
    public void closeBrowser()
	{	
    }
}
