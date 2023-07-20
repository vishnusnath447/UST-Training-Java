package org.example.ust.dao.book;

import org.example.ust.dao.DBConnection;
import org.example.ust.domain.Book;
import org.example.ust.dto.AuthorBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class BookDaoMySqlImpl implements BookDao{

    private static final String INSERT_QUERY = """
            INSERT INTO BOOKS 
            (BOOK_ID,BOOK_TITLE,AUTHOR_ID) 
            VALUES(?,?,?)
            """;
    private static final String READ_BY_ID = "SELECT * FROM BOOKS WHERE BOOK_ID = ?";
    private static final String UPDATE_QUERY = " UPDATE BOOKS " +
            " SET BOOK_TITLE = ?, AUTHOR_ID = ? " +
            " WHERE BOOK_ID = ? ";
    private static final String DELETE_QUERY = " DELETE FROM BOOKS WHERE BOOK_ID = ? ";
    private  static final String GET_AUTHOR_DETAILS = "SELECT A.AUTHOR_NAME,B.BOOK_TITLE FROM "+
            "AUTHORS A,BOOKS B "+
            "WHERE A.AUTHOR_ID = B.AUTHOR_ID AND B.BOOK_ID = ?";
    @Override
    public int update(Book object) {
        int update = 0;
        try(Connection connection = DBConnection.getConnection();
            var preparedStatement = connection.prepareStatement(UPDATE_QUERY)){
            preparedStatement.setString(1,object.bookTitle());
            preparedStatement.setInt(2,object.authorId());
            preparedStatement.setInt(3,object.bookId());
            update=preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.err.println(e);
        }
        return update;
    }

    @Override
    public int delete(Integer id) {
        int update = 0;
        try(Connection connection = DBConnection.getConnection();
            var preparedStatement = connection.prepareStatement(DELETE_QUERY)){

            preparedStatement.setInt(1,id);
            update=preparedStatement.executeUpdate();
        }catch(SQLException e){
            System.err.println(e);
        }
        return update;
    }

    @Override
    public int create(Book object) {
        int update = 0;
        try(Connection connection = DBConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setInt(1,object.bookId());
            preparedStatement.setString(2,object.bookTitle());
            preparedStatement.setInt(3,object.authorId());
            update=preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch(SQLException e){
            System.err.println(e);
        }
        return update;
    }

    @Override
    public Optional<Book> read(Integer id) {
        Book book = null;
        try (Connection connection = DBConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                book = new Book(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3));
            }
            preparedStatement.close();
        }catch (SQLException e){
            System.err.println(e);
        }
        return Optional.ofNullable(book);
    }

    @Override
    public Optional<AuthorBook> getAuthorDetails(Integer bookId) {
        AuthorBook authorBook = null;
        try(Connection connection = DBConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(GET_AUTHOR_DETAILS);
            preparedStatement.setInt(1,bookId);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                authorBook = new AuthorBook(resultSet.getString(1),
                        resultSet.getString(2));
            }
            preparedStatement.close();
        }
        catch(SQLException e){
            System.err.println(e);
        }
        return Optional.ofNullable(authorBook);
    }
}
