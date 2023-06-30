# Kestra Plugin Telegram

<p align="center">
  <img width="460" src="https://kestra.io/logo.svg"  alt="Kestra workflow orchestrator" />
</p>

> A plugin to send telegram message from kestra

```yaml
id: hello-telegram
namespace: dev
inputs:
  - name: user
    type: STRING
tasks: 👋
  - id: telegram
    type: io.kestra.plugin.telegram.TelegramBotSend
    token: XXXXXXX
    channel: "0000000"
    payload: Hey there, {{ inputs.user }}
```
This plugin uses [Telegram Bot API](https://core.telegram.org/bots/api), please use [telegram documentation](https://core.telegram.org/bots) to create a bot and get a token.

## Documentation
* The official Kestra documentation can be found under: [kestra.io](https://kestra.io)
* The official documentation for developing a plugin can be found [here](https://kestra.io/docs/plugin-developer-guide/)

## License
Apache 2.0 © [Kestra Technologies](https://kestra.io)
