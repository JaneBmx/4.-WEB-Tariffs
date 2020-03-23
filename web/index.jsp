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
    <link rel="stylesheet" type="text/css" href="css/index/hmm.css">
</head>

<body>
<form action="controller" method="POST" enctype="multipart/form-data">
    <input type="hidden" name="parsingCommand" value="parse"/>
    <div class="example-1">
        <div class="form-group">

            <div class="container">

                <ul>
                    <li>
                        <label class="label">
                            <i class="material-icons">Choose file</i>
                            <span class="title">*.xml </span>
                            <input type="file" name="file" id="upload" accept=".xml">
                        </label>

                    </li>
                    <li></li>

                    <li><h2>Choose parser type: </h2></li>
                    <li>
                        <input type="radio" id="f-option" name="parser">
                        <label for="f-option">DOM</label>
                        <div class="check"></div>
                    </li>

                    <li>
                        <input type="radio" id="s-option" name="parser">
                        <label for="s-option">SAX</label>
                        <div class="check">
                            <div class="inside"></div>
                        </div>
                    </li>

                    <li>
                        <input type="radio" id="t-option" name="parser">
                        <label for="t-option">STAX</label>
                        <div class="check">
                            <div class="inside"></div>
                        </div>
                    </li>
                    <li>
                        <div class="btn btn-3">
                            <input type="submit" value="OK"/><br/>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</form>

</body>
</html>

























