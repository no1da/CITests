package tests;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.WayPage;
import utils.Config;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Основной класс для тестирования главной страницы (https://www.way2automation.com/).
 * Этот класс предоставляет общие методики и настройки для тестов,
 * использующих Selenium WebDriver и страницу WayPage.
 */
@Epic("Testing Way2Automation Page")
public class MainPageTest {
    protected static Config config;
    protected WayPage wayPage;
    protected WebDriver driver;

    public WebDriver initRemoteDriver() {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("browserName", "chrome");

        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVNC", false);   
        selenoidOptions.put("enableVideo", false);
        caps.setCapability("selenoid:options", selenoidOptions);

        try {
            return new RemoteWebDriver(new URL(config.getProperty("remote.web.driver.url")), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * Инициализирует конфигурационные данные.
     * Выполняется один раз перед всеми тестами.
     */
    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        config = new Config();
    }

    /**
     * Метод инициализации, выполняемый перед каждым тестом.
     * Создает новый экземпляр WebDriver, открывает браузер,
     * настраивает его и переходит на целевой URL, определенный в конфигурации.
     */
    @BeforeEach
    public void setUp() {
        driver = initRemoteDriver(); // удалённый драйвер!
        wayPage = new WayPage(driver);
        driver.manage().window().maximize();
        driver.get(config.getProperty("app.url"));

    }

    /**
     * Метод, выполняемый после каждого теста.
     * Закрывает браузер и освобождает используемые ресурсы.
     */
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
