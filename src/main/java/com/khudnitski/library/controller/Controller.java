package com.khudnitski.library.controller;

import com.khudnitski.library.controller.command.Command;
import com.khudnitski.library.controller.command.provider.CommandProvider;
import com.khudnitski.library.controller.command.provider.impl.CommandProviderImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String PARAMETER_COMMAND = "command";

    private final CommandProvider provider = new CommandProviderImpl();


    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandName = request.getParameter(PARAMETER_COMMAND);
        Command command = provider.getCommand(commandName);

        command.execute(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
