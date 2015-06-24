<%-- 
    Document   : index
    Created on : Apr 12, 2014, 2:51:04 PM
    Author     : Vashista
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" ACTION="/Project1Task1/ComputeHashes">
            Enter some text: 
            <br>
            <input type="radio" name="hash" value="MD5" checked>MD5
            <br>
            <input type="radio" name="hash" value="SHA-1">SHA-1
            <br>
            <textarea name="text" style="height: 100px; width: 400px;">YOO</textarea>
            <br>
            <input type="submit">
            
        </form>
    </body>
</html>
