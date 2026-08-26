package ru.stellarburgers.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.stellarburgers.data.ClientData;
import ru.stellarburgers.data.LoginData;
import ru.stellarburgers.model.ClientModel;

import static io.restassured.RestAssured.given;

public class ClientSteps {

    @Step("Создание пользователя через API")
    public Response createClient(ClientModel client) {
        return given()
                .baseUri(ClientData.BASE_URL)
                .header("Content-Type", "application/json")
                .body(client)
                .when()
                .post(LoginData.REGISTER_PATH);
    }

    @Step("Логин пользователя через API")
    public Response loginClient(ClientModel client) {
        return given()
                .baseUri(ClientData.BASE_URL)
                .header("Content-Type", "application/json")
                .body(client)
                .when()
                .post(LoginData.LOGIN_PATH);
    }

    @Step("Удаление пользователя через API")
    public Response deleteClient(String accessToken) {
        return given()
                .baseUri(ClientData.BASE_URL)
                .header("Authorization", accessToken)
                .when()
                .delete(LoginData.USER_PATH);
    }
}