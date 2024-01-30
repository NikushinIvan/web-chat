package org.example.filter;


import org.example.data.User;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;
import static org.example.data.UserType.ADMIN;

public class ManagementFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        if ("show_page_management".equals(request.getParameter("command"))) {
            HttpServletRequest hsr = (HttpServletRequest) request;
            HttpSession session = hsr.getSession();
            User user = (User) session.getAttribute("user");
            if (user.getUserType() != ADMIN) {
                HttpServletResponse httpServletResponse = (HttpServletResponse) response;
                httpServletResponse.sendRedirect(COMMAND_SHOW_CHAT_PAGE);
                return;
            }
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
