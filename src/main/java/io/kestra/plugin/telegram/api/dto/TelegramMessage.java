package io.kestra.plugin.telegram.api.dto;

public record TelegramMessage(String chat_id, String text) {
}
