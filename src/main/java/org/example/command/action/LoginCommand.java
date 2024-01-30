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

        String login = request.getParameter("loginInput");
        String password = request.getParameter("passwordInput");
        HttpSession session = request.getSession();

        User user = DataBase.getUser(login, password);
        if (user != null) {
            user.setOnline(true);
            session.setAttribute("user", user);
            session.removeAttribute("errorLoginMessage");
        } else {
            session.setAttribute("errorLoginMessage", "Incorrect login or password");
        }

        return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);
    }
}
