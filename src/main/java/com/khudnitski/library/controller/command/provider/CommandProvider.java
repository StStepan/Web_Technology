package com.khudnitski.library.controller.command.provider;

import com.khudnitski.library.controller.command.Command;

public interface CommandProvider {
    Command getCommand(String commandName);
}
