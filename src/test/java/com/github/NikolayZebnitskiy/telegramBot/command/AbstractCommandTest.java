package com.github.NikolayZebnitskiy.telegramBot.command;

import com.github.NikolayZebnitskiy.telegramBot.bot.NZTelegramBot;
import com.github.NikolayZebnitskiy.telegramBot.service.SendBotMessageService;
import com.github.NikolayZebnitskiy.telegramBot.service.SendBotMessageServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Abstract class for testing {@link Command}s.
 */
abstract class AbstractCommandTest {

   protected NZTelegramBot nzTelegramBot = Mockito.mock(NZTelegramBot.class);
   protected SendBotMessageService sendBotMessageService = new SendBotMessageServiceImpl(nzTelegramBot);

   abstract String getCommandName();

   abstract String getCommandMessage();

   abstract Command getCommand();

   @Test
   public void shouldProperlyExecuteCommand() throws TelegramApiException {
      //given
      Long chatId = 123456789L;

      Update update = new Update();
      Message message = Mockito.mock(Message.class);
      Mockito.when(message.getChatId()).thenReturn(chatId);
      Mockito.when(message.getText()).thenReturn(getCommandName());
      update.setMessage(message);

      SendMessage sendMessage = new SendMessage();
      sendMessage.setChatId(chatId.toString());
      sendMessage.setText(getCommandMessage());
      sendMessage.enableHtml(true);
      //when
      getCommand().execute(update);
      //then
      Mockito.verify(nzTelegramBot).execute(sendMessage);
   }
}
