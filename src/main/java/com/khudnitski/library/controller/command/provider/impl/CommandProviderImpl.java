package com.khudnitski.library.controller.command.provider.impl;

import com.khudnitski.library.controller.command.Command;
import com.khudnitski.library.controller.command.provider.CommandProvider;
import java.util.HashMap;
import java.util.Map;

public class CommandProviderImpl implements CommandProvider {
    private Map<String, Command> commands = new HashMap<>();

    public CommandProviderImpl() {
//        commands.put("authorization", new AuthorizationCommand());
//        commands.put("registration", new RegistrationCommand());
//        commands.put("find_book", new FindBookCommand());
//        commands.put("go_to_index", new GoToIndexPageCommand()); implement later
//        commands.put("change_locale", new ChangeLocale()); add more later
    }

    @Override
    public Command getCommand(String commandName) {
        return commands.get(commandName);
    }
}
