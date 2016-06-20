<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center; border-bottom: 2px solid lightgrey">Edit client</h1>

<div>
    <a href="${pageContext.servletContext.contextPath}/clinic/view">Back to clinic</a></div>
<br>
    <form action="${pageContext.servletContext.contextPath}/clinic/edit" method="POST">
     <input type="hidden" name="id" value="${client.id}">
        <table>
            <tr>
                <td align="right" >Client name : </td>
                <td>
                    <input type="text" name="clientName" value="${client.name}">
                </td>

                <td align="right" >Client id : </td>
                <td>
                    ${client.id}
                </td>

                <td><input type="submit" name="update" align="center" value="Edit"/></td>
            </tr>
        </table>
    </form><br>

    <h2>Add pet:</h2>

    <form action="${pageContext.servletContext.contextPath}/clinic/edit" method="POST">
        <table>
            <tr>
                <td align="right">Pet type : </td>
                <td>
                    <select name="petType">
                        <option value='1'>Cat
                        <option value='2'>Dog
                        <option value='3'>Bird
                        <option value='4'>Mouse
                        <option value='100'>Ather
                    </select>
                </td>
                <td align="right">Pet name : </td>
                <td>
                    <input type="text" name="petName"/>
                </td>
                <td>
                    <input type="submit" name="addPet" value="Add">
                </td>
            </tr>
        </table>
    </form><br>

    <c:choose>
        <c:when test="${client.pets.size() > 0}">
            <table border="1">
                <tr>
                    <td>Type</td>
                    <td>Pet name</td>
                    <td>Delete</td>
                </tr>
                <c:forEach items="${client.pets}" var="pet" varStatus="status" >
                    <tr valign="top">
                        <td>${pet.type}</td>
                        <td>${pet.name}</td>
                        <td>
                            <a href="${pageContext.servletContext.contextPath}/pet/delete?name=${pet.name}">delete</a>
                        </td>

                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <h4>No pets!</h4>
        </c:otherwise>
    </c:choose>


</body>
</html>
