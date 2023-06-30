package io.kestra.plugin.telegram.botapi;

import java.io.IOException;

public interface TelegramBot {
    void send(String message) throws IOException;
}
