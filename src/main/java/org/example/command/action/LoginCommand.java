package org.example.command.action;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.User;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;

public class LoginCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {

        // Ваша реализация выполнения входа в Чат
        String login = request.getParameter("loginInput");
        String password = request.getParameter("passwordInput");

        User user = DataBase.getUser(login, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        }

        return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);
    }
}
