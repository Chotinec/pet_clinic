<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
    <h1 style="text-align: center; border-bottom: 2px solid lightgrey">Pet clinic</h1>
    <!--<button href="${pageContext.servletContext.contextPath}/views/clinic/CreateClient.jsp">Add new client</button>-->
    <form action="${pageContext.servletContext.contextPath}/clinic/view" method='GET'>
        <div id="addClient">
            <input type="submit" name="addClient" value="Add client" id="addButton" />
        </div>
    </form><br>

    <h3>Search clients:</h3>

    <form action="${pageContext.servletContext.contextPath}/clinic/view" method='POST'>
        <table>
            <tr>
                <td align="right">Pet type : </td>
                <td>
                    <select name="searchType">
                        <option value='id'>id
                        <option value='client_name'>client name
                        <option value='pet_name'>pet name
                    </select>
                </td>
                <td align="right">Parametr: </td>
                <td>
                    <input type="text" name="searchParametr"/>
                </td>

                <td><input type="submit" name="search" align="center" value="Search"/></td>
            </tr>
        </table>
    </form><br>

    <h3>Pets:</h3>
    <table border="1">
        <tr>
            <td>Id</td>
            <td>Client name</td>
            <td>Pets count</td>
            <td>Delete</td>
        </tr>
        <c:forEach items="${clients}" var="client" varStatus="status" >
            <tr valign="top">
                <td>
                    <a href = "${pageContext.servletContext.contextPath}/clinic/edit?id=${client.id}">${client.id}</a>
                </td>
                <td>${client.name}</td>
                <td>${client.pets.size()}</td>
                <td>
                    <a href="${pageContext.servletContext.contextPath}/clinic/delete?id=${client.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
