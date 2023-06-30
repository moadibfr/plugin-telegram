package io.kestra.plugin.telegram;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;

@Controller()
public class FakeTelegramController {

    public static String token;
    public static String chatId;
    public static String text;

    @Get("/bot{token}/sendMessage")
    public HttpResponse<String> post(String token, @QueryValue String chat_id, @QueryValue String text) {
        FakeTelegramController.token = token;
        FakeTelegramController.chatId = chat_id;
        FakeTelegramController.text = text;
        return HttpResponse.ok("ok");
    }
}