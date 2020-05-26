<%-- 
    Document   : listCustomer
    Created on : 25 May, 2020, 2:58:06 PM
    Author     : aman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h2>Customer Manager</h2>  
            </div>
        </div>
        
        <div id="container">
            <div id="content">
                <input class="add-button" type="button" value="Add Customer" onclick="window.location.href='addCustomerForm';return false;" />
                <table>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Action</th>
                        
                    </tr>
                    
                    <c:forEach var="tempCustomer" items="${customers}">
                        
                        <c:url var="updateLink" value="updateCustomer">
                            <c:param name="customerId" value="${tempCustomer.id}"/>
                        </c:url>
                        <c:url var="deleteLink" value="deleteCustomer">
                            <c:param name="customerId" value="${tempCustomer.id}"/>
                        </c:url>
                        <tr>
                            <td>${tempCustomer.firstName}</td>
                            <td>${tempCustomer.lastName}</td>
                            <td>${tempCustomer.email}</td>
                            <td><a href="${updateLink}">Update</a> | <a onclick="if(!(confirm('Are you sure you want to delete?'))) return false" href="${deleteLink}">Delete</a>  </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
