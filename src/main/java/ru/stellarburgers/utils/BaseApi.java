package ru.stellarburgers.utils;

import io.restassured.response.Response;
import ru.stellarburgers.data.ClientData;
import ru.stellarburgers.model.ClientModel;
import ru.stellarburgers.steps.ClientSteps;

import static org.apache.hc.core5.http.HttpStatus.*;

public class BaseApi {
    private ClientSteps clientSteps = new ClientSteps();

    public ClientModel createRandomUser() {
        ClientModel client = ClientData.createDefaultClient();
        Response response = clientSteps.createClient(client);
        // Если статус не 200, бросаем исключение
        response.then().statusCode(SC_OK);
        String accessToken = response.then().extract().path("accessToken");
        client.setAccessToken(accessToken);
        return client;
    }

    public String loginAndGetToken(ClientModel client) {
        Response response = clientSteps.loginClient(client);
        response.then().statusCode(SC_OK);
        return response.then().extract().path("accessToken");
    }

    public void deleteUser(String accessToken) {
        if (accessToken != null && !accessToken.isEmpty()) {
            clientSteps.deleteClient(accessToken).then().statusCode(SC_ACCEPTED);
        }
    }
}
