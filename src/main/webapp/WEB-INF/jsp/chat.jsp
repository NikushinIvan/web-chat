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
            <div style="background-color:#ABBAEA" align="left">
                <c:forEach var="message" items="${messages}">
                    <option><c:out value="${message.value.sender}: ${message.value.message}" /></option>
                </c:forEach>
            </div>

            <form method="POST" action="chat?command=send_message" style="background-color:#49438F">
                <table style="width: 80%">
                    <tr>
                        <td><input id="message" type="text" name="message" value="${message}" style="width: 100%"/></td>
                        <td align="right"><button type="submit">Отправить</button></td>
                    </tr>
                </table>
            </form>

            <a href="chat?command=logout">Выход</a>
        </div>
    </body>
</html>