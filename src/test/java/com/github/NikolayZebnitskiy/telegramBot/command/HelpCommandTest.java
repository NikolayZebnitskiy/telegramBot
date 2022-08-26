package com.github.NikolayZebnitskiy.telegramBot.command;

import org.junit.jupiter.api.DisplayName;

import static com.github.NikolayZebnitskiy.telegramBot.command.CommandName.HELP;
import static com.github.NikolayZebnitskiy.telegramBot.command.HelpCommand.HELP_MESSAGE;

@DisplayName("Unit-level testing for HelpCommand")
public class HelpCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return HELP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new HelpCommand(sendBotMessageService);
    }
}
