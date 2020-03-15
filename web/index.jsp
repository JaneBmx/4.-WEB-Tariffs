<%--
  Created by IntelliJ IDEA.
  User: Bubaleh
  Date: 07.03.2020
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>
        Parsing XML
    </title>
</head>
<body>
<form action="Controller" method="POST" enctype="multipart/form-data">
    <input type="hidden" name="command" value="parse"/>
    <input type="file" name="file" id="upload" accept=".xml"/><br/>
    <br>
    <label> Введите парсер(DOM, SAX, StAX) :
        <input type="text" name="parser" size="10"/><br/>
    </label>
    <br>
    <input type="submit" value="OK"/><br/>
</form>
</body>
</html>
