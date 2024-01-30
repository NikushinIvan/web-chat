package org.example.command.action;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.User;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static org.example.Resources.COMMAND_SHOW_MANAGEMENT_PAGE;


public class SetPermissionCommand implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {

        String numberUser = request.getParameter("numberUser");

        List<User> users = DataBase.getUsers();
        User user = users.get(Integer.parseInt(numberUser) - 1);
        user.setReadOnly(!user.isReadOnly());

        return new RedirectResult(COMMAND_SHOW_MANAGEMENT_PAGE);
    }
}
