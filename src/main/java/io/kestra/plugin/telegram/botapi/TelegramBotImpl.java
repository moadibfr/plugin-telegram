package io.kestra.plugin.telegram.botapi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TelegramBotImpl implements TelegramBot {
    private static final String SendurlString = "/bot%s/sendMessage?chat_id=%s&text=%s";

    @Builder.Default
    private String baseUrl = "https://api.telegram.org";
    private String apiToken;
    private String destinationId;


    @Override
    public void send(String message) throws IOException {
        String urlString = String.format(baseUrl + SendurlString, apiToken, destinationId, message);
        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();
        InputStream is = new BufferedInputStream(conn.getInputStream());
    }
}
