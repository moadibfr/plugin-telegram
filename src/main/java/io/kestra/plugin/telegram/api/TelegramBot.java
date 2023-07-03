package io.kestra.plugin.telegram.api;

import io.kestra.plugin.telegram.exceptions.ErrorSendingMessageException;

import java.io.IOException;

public interface TelegramBot {
    void send(String message) throws IOException, ErrorSendingMessageException;
}
