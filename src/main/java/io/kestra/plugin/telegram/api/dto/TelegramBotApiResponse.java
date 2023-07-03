package io.kestra.plugin.telegram.api.dto;

public record TelegramBotApiResponse(boolean ok, TelegramMessage result) {
}
