package ru.stellarburgers.data;

import ru.stellarburgers.model.ClientModel;

public class ClientData {
    public static final String BASE_URL = "https://stellarburgers.education-services.ru/";
    public static final String DEFAULT_PASSWORD = "password123";
    public static final String INVALID_SHORT_PASSWORD = "12345";

    public static ClientModel createDefaultClient() {
        String email = "user_" + System.currentTimeMillis() + "@mail.ru";
        String name = "User_" + System.currentTimeMillis();
        return ClientModel.builder()
                .email(email)
                .password(DEFAULT_PASSWORD)
                .name(name)
                .build();
    }
}