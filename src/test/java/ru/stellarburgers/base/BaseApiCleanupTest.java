package ru.stellarburgers.base;

import org.junit.After;
import ru.stellarburgers.steps.ClientSteps;

import static org.apache.hc.core5.http.HttpStatus.*;

public abstract class BaseApiCleanupTest extends BaseUITest {
    protected ClientSteps clientSteps;
    protected String accessToken;

    public BaseApiCleanupTest() {
        this.clientSteps = new ClientSteps();
    }

    @After
    public void tearDown() {
        super.tearDown(); // закрываем драйвер
        if (accessToken != null && !accessToken.isEmpty()) {
            try {
                clientSteps.deleteClient(accessToken).then().statusCode(SC_ACCEPTED);
            } catch (Exception e) {
                System.err.println("Не удалось удалить пользователя: " + e.getMessage());
            }
        }
    }
}