
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title id="addTitle">Add A New Movie</title>
    </head>
    <body>
        <h1>Add a New Movie</h1>
        
        <form name="addForm" action="addMovie" method="get">
            <label> Movie Title: </label>
            <input type="text" name="title" value=""/>
            <br>
            <label> Movie Year: </label>
            <input type="text" name="year" value=""/>
            <br>
            <label> Movie Genre: </label>
            <input type="text" name="genre" value=""/>
            <br>
            <label> Movie Director: </label>
            <input type="text" name="director" value=""/>
            <br>
            <input tupe="reset" name="reset" value="Clear"/>
            <input type="submit" name="submit" value="Submit"/>
        </form>
    </body>
</html>
