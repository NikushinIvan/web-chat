<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <link rel="icon" href="data:,">
    <head>
        <title>Страница управления</title>
    </head>

    <body>
        <div align="center">
            <table>
                <tr style="border: 1px solid #CCCCCC">
                    <td style="border: 1px solid #CCCCCC">Пользователь</td>
                    <td style="border: 1px solid #CCCCCC">Тип</td>
                    <td style="border: 1px solid #CCCCCC" >В сети</td>
                    <td style="border: 1px solid #CCCCCC" >Только чтение</td>
                </tr>
                <c:forEach var="unit" items="${units}">
                    <tr style="border: 1px solid #CCCCCC">
                        <td style="border: 1px solid #CCCCCC">${unit.name}</td>
                        <td style="border: 1px solid #CCCCCC">${unit.userType}</td>
                        <td style="border: 1px solid #CCCCCC">${unit.online}</td>
                        <td style="border: 1px solid #CCCCCC">${unit.readOnly}</td>
                    </tr>
                </c:forEach>
            </table>
            <form method="POST" action="chat?command=set_permission">
                <label for="numberUser">Номер пользователя</label>
                <input name="numberUser" type="number" min=1 max="${units.size()}" value="1"/>
                <button type="submit">Изменить доступ</button>
            </form>
            <a href="chat?command=show_chat_page">Вернуться в чат</a>
        </div>
    </body>
</html>