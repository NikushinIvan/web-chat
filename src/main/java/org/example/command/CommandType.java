package org.example.command;

import org.example.command.action.LoginCommand;
import org.example.command.action.LogoutCommand;
import org.example.command.action.SendMessageCommand;
import org.example.command.action.SetPermissionCommand;
import org.example.command.show.ShowChatPageCommand;
import org.example.command.show.ShowLoginPageCommand;
import org.example.command.show.ShowPageManagementCommand;

public enum CommandType {
    EMPTY(new EmptyCommand()),
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    SET_PERMISSION(new SetPermissionCommand()),

    SHOW_CHAT_PAGE(new ShowChatPageCommand()),
    SHOW_LOGIN_PAGE(new ShowLoginPageCommand()),
    SEND_MESSAGE(new SendMessageCommand()),
    SHOW_PAGE_MANAGEMENT(new ShowPageManagementCommand());

    private final Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
