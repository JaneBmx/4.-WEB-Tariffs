<%--
  Created by IntelliJ IDEA.
  User: Bubaleh
  Date: 07.03.2020
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Parsing results</title>
</head>

<body>
<table border="1" width="100%" cellpadding="5">
    <tr>
        <th rowspan="2">Id</th>
        <th rowspan="2">Tariff</th>
        <th rowspan="2">Operator</th>
        <th rowspan="2">Payroll</th>
        <th colspan="3">Call prices</th>
        <th colspan="2">Sms prices</th>
        <th colspan="3">Parameters</th>
    </tr>
    <tr>
        <th>Inside the net</th>
        <th>Outside the net</th>
        <th>To stationary phone</th>
        <th>Inside the net</th>
        <th>Outside the net</th>
        <th>Favorite nums</th>
        <th>Billing</th>
        <th>Fee connection</th>
    </tr>

    <c:forEach var="elem" items="${ list }" varStatus="status">
        <tr>
            <td><c:out value="${ elem.id }"/></td>
            <td><c:out value="${ elem.name }"/></td>
            <td><c:out value="${ elem.operatorName }"/></td>
            <td><c:out value="${ elem.payroll }"/></td>
            <td><c:out value="${ elem.callPrices.insideNetworkPrice }"/></td>
            <td><c:out value="${ elem.callPrices.outsideNetworkPrice }"/></td>
            <td><c:out value="${ elem.callPrices.stationaryPhonePrice }"/></td>
            <td><c:out value="${ elem.smsPrices.insideNetworkPrice }"/></td>
            <td><c:out value="${ elem.smsPrices.outsideNetworkPrice}"/></td>
            <td><c:out value="${ elem.parameters.countOfFavoriteNumbers }"/></td>
            <td><c:out value="${ elem.parameters.billing.getValue() }"/></td>
            <td><c:out value="${ elem.parameters.connectionFee }"/></td>
        </tr>
    </c:forEach>
</table>

<br/>
<a href="index.jsp">Back to main page</a>
</body>
</html>
