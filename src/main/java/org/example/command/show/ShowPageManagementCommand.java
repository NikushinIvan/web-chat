package org.example.command.show;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.User;
import org.example.result.ForwardResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import static org.example.Resources.MANAGEMENT_PAGE;

public class ShowPageManagementCommand implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        List<User> users = DataBase.getUsers();
        session.setAttribute("units", users);

        return new ForwardResult(MANAGEMENT_PAGE);
    }
}
