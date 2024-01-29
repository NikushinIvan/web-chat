package org.example.command.action;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.Message;
import org.example.data.User;
import org.example.result.ForwardResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.example.Resources.PAGE_CHAT;

public class SendMessageCommand implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Message message = new Message(user.getName(), request.getParameter("message"));

        DataBase.addMessage(message);

        System.out.println(DataBase.getMessages());

        return new  ForwardResult(PAGE_CHAT);
    }
}
