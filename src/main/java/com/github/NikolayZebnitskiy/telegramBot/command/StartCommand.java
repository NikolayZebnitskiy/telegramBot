package com.github.NikolayZebnitskiy.telegramBot.command;

import com.github.NikolayZebnitskiy.telegramBot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Start {@link Command}.
 */

public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String START_MESSAGE = "Привет. Я Telegram Bot. Я еще маленький и только учусь.";

    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
