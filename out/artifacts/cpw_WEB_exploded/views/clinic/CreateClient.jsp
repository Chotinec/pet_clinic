<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
    <h1 style="text-align: center; border-bottom: 2px solid lightgrey">Client add</h1>

    <div>
        <a href="${pageContext.servletContext.contextPath}/clinic/view">Back to clinic</a>
    </div><br>


    <form action="${pageContext.servletContext.contextPath}/clinic/create" method="POST">
    <table>
        <tr>
            <td align="right" >Client ID: </td>
            <td>
                <input type="text" name="clientId">
            </td>
        </tr>

        <tr>
            <td align="right" >Client name: </td>
            <td>
                <input type="text" name="clientName">
            </td>
        </tr>

        <tr>
            <td><input type="submit" align="center" value="Add Client"/></td>
        </tr>
    </table>
        <c:if test="${errorValue != null}">
            <h4>${errorValue}</h4>
        </c:if>
</form>
</body>
</html>
