package io.kestra.plugin.telegram;

import io.kestra.core.models.annotations.PluginProperty;
import io.kestra.core.models.tasks.RunnableTask;
import io.kestra.core.models.tasks.Task;
import io.kestra.core.models.tasks.VoidOutput;
import io.kestra.core.runners.RunContext;
import io.kestra.plugin.telegram.botapi.TelegramBot;
import io.kestra.plugin.telegram.botapi.TelegramBotImpl;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.slf4j.Logger;

@SuperBuilder
@ToString
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@Schema(
        title = "Send input as a telegram message"
)
public class TelegramBotSend extends Task implements RunnableTask<VoidOutput> {
    @Schema(
            title = "Telegram Bot token",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @PluginProperty(dynamic = true)
    protected String token;

    @Schema(
            title = "Telegram channel/user ID",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @PluginProperty(dynamic = true)
    protected String channel;

    @Schema(
            title = "Message payload",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @PluginProperty(dynamic = true)
    protected String payload;

    @Schema(
            title = "Only to be used when testing locally",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @PluginProperty(dynamic = false)
    protected String endpointOverride;

    @Override
    public VoidOutput run(RunContext runContext) throws Exception {
        Logger logger = runContext.logger();

        TelegramBotImpl.TelegramBotImplBuilder clientBuilder = TelegramBotImpl.builder()
                .destinationId(runContext.render(this.channel))
                .apiToken(runContext.render(this.token));
        if (this.endpointOverride != null) {
            clientBuilder.baseUrl(this.endpointOverride);
        }

        TelegramBot client = clientBuilder.build();
        client.send(runContext.render(this.payload));

        return null;
    }
}
