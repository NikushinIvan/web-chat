<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <link rel="icon" href="data:,">
    <head>
        <title>Чат</title>
    </head>
    <body>
        <div align="center">
            <div style="background-color:#ABBAEA">
                <ul>
                    <c:forEach var="message" items="${messages}">
                        <li><c:out value="${message}" /></li>
                    </c:forEach>
                </ul>
            </div>

            <form method="POST" action="chat?command=send_message" style="background-color:#49438F">
                <table>
                    <tr>
                        <td><input id="message" type="text" name="message" value="${message}"/></td>
                        <td><button type="submit">Отправить</button></td>
                    </tr>
                </table>
            </form>

            <a href="chat?command=logout">Выход</a>
        </div>
    </body>
</html>