package ru.stellarburgers.base;

import org.junit.Before;
import ru.stellarburgers.model.ClientModel;
import ru.stellarburgers.utils.BaseApi;

public abstract class BaseAuthUITest extends BaseApiCleanupTest {
    protected BaseApi baseApi;
    protected ClientModel client;

    @Before
    public void createUser() {
        baseApi = new BaseApi();
        client = baseApi.createRandomUser();
        accessToken = client.getAccessToken();
        if (accessToken == null || accessToken.isEmpty()) {
            throw new RuntimeException("Не удалось получить accessToken при создании пользователя");
        }
    }
}