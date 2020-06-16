package lab7.config;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
@Getter
@Configuration
@ComponentScan( basePackages = "lab7" )
@PropertySource("classpath:config.properties")
public class AppConfig
{
    // адрес веб-страницы
    @Value("${baseUrl}")
    private String baseUrl;
    // время ожидания
    @Value("${baseTimeout}")
    private int baseTimeout;
    // веб драйвер
    @Bean(name = "webDriver")
    public WebDriver webDriver()
    {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "/src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        // открыть на весь экран
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);
    }
}
