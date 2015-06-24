<%-- 
    Document   : index
    Created on : Apr 14, 2014, 6:03:36 PM
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
        <form method="post" ACTION="/Project1Task2/BigCalc">
            X <input type="text" name="xvalue"value="0"/><br/>
            Y <input type="text" name="yvalue"value="0"/><br/>
            What operation do you want to perform:
            <select name="choice">
                <option value="add">Addition</option>
                <option value="multi">Multiplication</option>
                <option value="relativelyPrime">Relatively Prime</option>
                <option value="mod">Modulo</option>
                <option value="modInverse">Modular Inverse</option>
                <option value="power">X to the Power of Y</option>
            </select><br/>
        <input type="submit"/> 
        </form>
    </body>
</html>
