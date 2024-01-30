package org.example.command.action;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.Message;
import org.example.data.User;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;

public class SendMessageCommand implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Message message = new Message(user.getName(), request.getParameter("message"));

        DataBase.addMessage(message);

        return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);
    }
}
