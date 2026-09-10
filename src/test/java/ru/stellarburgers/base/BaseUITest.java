package ru.stellarburgers.base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import ru.stellarburgers.utils.DriverFactory;

public abstract class BaseUITest {
    protected WebDriver driver;

    @Before
    public void setUp() {
        try {
            driver = DriverFactory.getDriver();
            if (driver == null) {
                throw new RuntimeException("Драйвер не создан");
            }
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при создании драйвера: " + e.getMessage(), e);
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}