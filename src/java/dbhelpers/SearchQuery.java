
package dbhelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Movies;

public class SearchQuery {
    
    private Connection conn;
    private ResultSet results;
    
    public SearchQuery(){
        
        
    Properties props = new Properties();
    InputStream instr = getClass().getResourceAsStream("dbConnection.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String url = props.getProperty("server.name");
    String username = props.getProperty("user.name");
    String password = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url,username,password);
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    public void doSearch (String movieTitle){
        
        
        try {
            String query = "SELECT * FROM movies WHERE UPPER(MovieTitle) Like ? ORDER BY movieID ASC";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,"%" + movieTitle.toUpperCase() + "%");
            
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    
    public String getHTMLtable() {
        String table ="<table>";
              table +="<tr> <th> MovieID </th>";
              table += "<th> Movie Title </th>";
              table += "<th> Year </th>";
              table += "<th> Genre </th>";
              table += "<th> Director </th> </tr>";
        
        try {
            while(this.results.next()) {
                
                Movies movies = new Movies();
                movies.setMovieID(this.results.getInt("movieID"));
                movies.setMovieTitle(this.results.getString("movieTitle"));
                movies.setMovieYear(this.results.getInt("movieYear"));
                movies.setMovieGenre(this.results.getString("movieGenre"));
                movies.setDirector(this.results.getString("director"));
                
                table += "<tr>";
                table += "<td>";
                table += movies.getMovieID();                  
                table += "</td>";
                
                table += "<td>";
                table += movies.getMovieTitle();          
                table += "</td>";
               
                table += "<td>";
                table += movies.getMovieYear();            
                table += "</td>";
               
                table += "<td>";
                table += movies.getMovieGenre();          
                table += "</td>";
                
                table += "<td>";
                table += movies.getDirector();        
                table += "</td>";
                
                table+="<td>";
                table+="<a href=update?movieID=" + movies.getMovieID() + "> Update </a>" + "<a href=delete?movieID=" + movies.getMovieID() +"> Delete </a>";
                table += "</tr>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        table += "</table>";
        
                return table;
                
        
        
    }
}

