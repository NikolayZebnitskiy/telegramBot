package com.github.NikolayZebnitskiy.telegramBot.service;

import com.github.NikolayZebnitskiy.telegramBot.bot.NZTelegramBot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for SendBotMessageService")
public class SendBotMessageServiceTest {

    private SendBotMessageService sendBotMessageService;
    private NZTelegramBot nzTelegramBot;

    @BeforeEach
    public void init() {
        nzTelegramBot = Mockito.mock(NZTelegramBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(nzTelegramBot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        //given
        String chatId = "test_chat_id";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);

        //when
        sendBotMessageService.sendMessage(chatId, message);

        //then
        Mockito.verify(nzTelegramBot).execute(sendMessage);
    }
}
