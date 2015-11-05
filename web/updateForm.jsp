<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Movies"%>
<% Movies movies = (Movies) request.getAttribute("movies"); %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title id="addTitle">Update A Movie</title>
    </head>
    <body>
        <h1> Update A Movie Record </h1>
        <form name="updateForm" action="updateMovie" method="get">
            <label> Movie ID: </label>
            <input type="text" name="id" value="<%=movies.getMovieID() %>" readonly/>
            <br>
            <label> Movie Title: </label>
            <input type="text" name="title" value="<%=movies.getMovieTitle() %>"/>
            <br>
            <label> Movie Year: </label>
            <input type="text" name="year" value="<%=movies.getMovieYear() %>"/>
            <br>
            <label> Movie Genre: </label>
            <input type="text" name="genre" value="<%=movies.getMovieGenre() %>"/>
            <br>
            <label> Movie Director: </label>
            <input type="text" name="director" value="<%=movies.getDirector() %>"/>
            <br>
            <input type="reset" name="reset" value="Clear"/>
            <input type="submit" name="submit" value="Update"/>
            </table>
        </form>
    </body>
</html>
