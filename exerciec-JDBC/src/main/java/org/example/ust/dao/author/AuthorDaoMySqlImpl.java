package org.example.ust.dao.author;

import org.example.ust.dao.DBConnection;
import org.example.ust.domain.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthorDaoMySqlImpl implements AuthorDao {
    private final String INSERT_QUERY = """
            INSERT INTO AUTHORS 
            (AUTHOR_ID,AUTHOR_NAME,AUTHOR_EMAIL,JOIN_DATE) 
            VALUES(?,?,?,?)
            """;
    private final String READ_BY_ID = "SELECT * FROM AUTHORS WHERE AUTHOR_ID = ?";
    private final String READ_ALL = "SELECT * FROM AUTHORS";
    private static final String UPDATE_QUERY = """
            UPDATE AUTHORS 
            SET AUTHOR_NAME = ?, AUTHOR_EMAIL = ?, JOIN_DATE = ? 
            WHERE AUTHOR_ID = ? 
            """;
    private static final String DELETE_QUERY = " DELETE FROM AUTHORS WHERE AUTHOR_ID = ? ";



    @Override
    public List<Author> readAll() {
        List<Author> authors = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             var prepareStatement = connection.prepareStatement(READ_ALL)) {
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                Author author = new Author(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4).toLocalDate());
                authors.add(author);
            }
        } catch (SQLException e) {
            System.err.println("Error while connecting to database");
            System.err.println(e.getMessage());
        }
        return authors;
    }


    @Override
    public int create(Author author) {
        int updated = 0;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, author.authorId());
            preparedStatement.setString(2, author.authorName());
            preparedStatement.setString(3, author.authorEmail());
            preparedStatement.setDate(4, Date.valueOf(author.joinDate()));
            updated = preparedStatement.executeUpdate();
        } catch (SQLException e) {

            System.err.println(e);
        }
        return updated;
    }

    @Override
    public Optional<Author> read(Integer authorId) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_BY_ID)) {
            preparedStatement.setInt(1, authorId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Author author = new Author(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4).toLocalDate());
                return Optional.ofNullable(author);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    @Override
    public int update(Author author) {
        int update = 0;
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)){
            preparedStatement.setString(1,author.authorName());
            preparedStatement.setString(2,author.authorEmail());
            preparedStatement.setDate(3, Date.valueOf(author.joinDate()));
            preparedStatement.setInt(4,author.authorId());
            update=preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.err.println(e);
        }
        return update;
    }

    @Override
    public int delete(Integer authorId) {
        int update = 0;
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY)){
            preparedStatement.setInt(1,authorId);
            update=preparedStatement.executeUpdate();
        }catch(SQLException e){
            System.err.println(e);
        }
        return update;
    }
}
