package org.example;

public final class Resources {

    public static final String PAGE_LOGIN = "/WEB-INF/jsp/login.jsp";
    public static final String PAGE_CHAT = "/WEB-INF/jsp/chat.jsp";
    public static final String MANAGEMENT_PAGE = "/WEB-INF/jsp/managementPage.jsp";

    public static final String COMMAND_SHOW_LOGIN_PAGE = "chat?command=show_login_page";
    public static final String COMMAND_SHOW_CHAT_PAGE = "chat?command=show_chat_page";

    public static final String COMMAND_SEND_MESSAGE = "chat?command=send_message";
    public static final String COMMAND_SHOW_MANAGEMENT_PAGE = "chat?command=show_page_management";

    private Resources() {
    }
}
