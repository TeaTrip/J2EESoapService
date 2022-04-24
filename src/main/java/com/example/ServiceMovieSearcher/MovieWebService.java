package com.example.ServiceMovieSearcher;


import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebService(serviceName = "MovieService")
public class MovieWebService  {

    @Resource(lookup = "jdbc/ifmo-ws")
    private DataSource dataSource;

    @WebMethod(operationName = "selectAll")
    public List<Movie> selectAll() {
        PostgreSQLDAO postgreSQLDAO = new PostgreSQLDAO(getConnection());
        return postgreSQLDAO.selectAll();
    }

    @WebMethod(operationName = "selectById")
    public Movie selectById(@WebParam(name = "id") int id) {
        PostgreSQLDAO postgreSQLDAO = new PostgreSQLDAO(getConnection());
        return postgreSQLDAO.selectById(id);
    }

    @WebMethod(operationName = "selectByYear")
    public List<Movie> selectByYear(@WebParam(name = "year")int year) {
        PostgreSQLDAO postgreSQLDAO = new PostgreSQLDAO(getConnection());
        return postgreSQLDAO.selectByYear(year);
    }

    @WebMethod(operationName = "selectByRating")
    public List<Movie> selectByRating(@WebParam(name = "rating")int rating) {
        PostgreSQLDAO postgreSQLDAO = new PostgreSQLDAO(getConnection());
        return postgreSQLDAO.selectByRating(rating);
    }

    @WebMethod(operationName = "selectByName")
    public List<Movie> selectByName(@WebParam(name = "name")String name) {
        PostgreSQLDAO postgreSQLDAO = new PostgreSQLDAO(getConnection());
        return postgreSQLDAO.selectByName(name);
    }

    @WebMethod(operationName = "selectByGenre")
    public List<Movie> selectByGenre(@WebParam(name = "genre")String genre) {
        PostgreSQLDAO postgreSQLDAO = new PostgreSQLDAO(getConnection());
        return postgreSQLDAO.selectByGenre(genre);
    }

    @WebMethod(operationName = "selectByDirector")
    public List<Movie> selectByDirector(@WebParam(name = "director")String director) {
        PostgreSQLDAO postgreSQLDAO = new PostgreSQLDAO(getConnection());
        return postgreSQLDAO.selectByDirector(director);
    }

    @WebMethod(operationName = "selectByYearAndRating")
    public List<Movie> selectByYearAndRating(@WebParam(name = "year")String year,
                                             @WebParam(name = "rating")String rating) {
        PostgreSQLDAO postgreSQLDAO = new PostgreSQLDAO(getConnection());
        return postgreSQLDAO.selectByYearAndRating(year, rating);
    }

    @WebMethod(operationName = "selectByYearAndGenre")
    public List<Movie> selectByYearAndGenre(@WebParam(name = "year")String year,
                                            @WebParam(name = "genre")String genre) {
        PostgreSQLDAO postgreSQLDAO = new PostgreSQLDAO(getConnection());
        return postgreSQLDAO.selectByYearAndGenre(year, genre);
    }

    @WebMethod(operationName = "selectByRatingAndGenre")
    public List<Movie> selectByRatingAndGenre(@WebParam(name = "rating")String rating,
                                              @WebParam(name = "genre")String genre) {
        PostgreSQLDAO postgreSQLDAO = new PostgreSQLDAO(getConnection());
        return postgreSQLDAO.selectByRatingAndGenre(rating, genre);
    }

    private Connection getConnection(){
        Connection result = null;
        try{
            result = dataSource.getConnection();
        } catch (SQLException e){
            Logger.getLogger(MovieWebService.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }
}
