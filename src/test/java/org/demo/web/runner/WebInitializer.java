package org.demo.web.runner;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Slf4j
public class WebInitializer {

    private static WebDriver driver;
    private Properties properties;
    public static String webUrl;

    public WebInitializer() {
        try {
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/config" +
                    "/test-config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            log.error("IO error streaming configuration", e);
        }
    }

    public WebDriver initialize() {
        final String browser = properties.getProperty("web.browser");
        webUrl = properties.getProperty("web.url");
        if (driver == null) {
            if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:\\softwares\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equals("firefox")) {
                System.setProperty("webdriver.gecko.driver", "C:\\softwares\\geckodriver.exe");
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }


}
