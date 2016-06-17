<%-- 
    Document   : index
    Created on : Jun 13, 2016, 8:19:47 AM
    Author     : Carlos H. Nonnemacher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
        <title>Java - aula5</title>
    </head>
    <body>
        <div class="container">
            <%
                String[] s = new String[]{"1", "2", "3"}; 
                
                String title = String.join(";", s);
            %>
            <h1><%= title %></h1>

        </div>

    </body>
</html>
