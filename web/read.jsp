
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movies</title>
    </head>

    <% String table = (String) request.getAttribute("table");%>

    <body>
        <div class="wrap">

            <%@ include file="includes/header.jsp" %>

            <%@ include file="includes/menu.jsp" %>

            <div class ="main">

                <h1>Movies to Watch</h1>

                <%= table%>

            </div>
            <%@ include file= "includes/footer.jsp"%>

        </div>
    </body>
</html>
