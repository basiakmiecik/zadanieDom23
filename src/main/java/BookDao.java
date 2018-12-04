import java.sql.*;
import java.util.Scanner;

public class BookDao {
    private final String URL="jdbc:mysql://localhost:3306/library?useSSL=false";
    private final String USERNAME="root";
    private final String PASSWORD="basia11kmiecik";
    private Connection connection;


    public BookDao() throws SQLException {
        connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }

    public void addBook(Book book) throws SQLException {
        final String insert="insert into books (title, authorName, authorLastName, year, isbn) values (?,?,?,?,?)";
        PreparedStatement statement=connection.prepareStatement(insert);
        statement.setString(1,book.getTitle());
        statement.setString(2,book.getAuthorName());
        statement.setString(3,book.getAuthorLastName());
        statement.setInt(4,book.getYear());
        statement.setString(5,book.getIsbn());
        statement.executeUpdate();
    }


    public Book findBook() throws SQLException {
        BookFind bookFind=new BookFind();
        String[] options=bookFind.bookf();
        String type= options[0];
        String value=options[1];
        ResultSet resultSet = null;
        switch (type) {
            case "authorLastname":
                final String query = "select *from books where authorLastName=?";
                PreparedStatement select = connection.prepareStatement(query);
                select.setString(1, value);
                resultSet = select.executeQuery();
                break;
            case "title":
                final String query2 = "select *from books where title=?";
                PreparedStatement select2 = connection.prepareStatement(query2);
                select2.setString(1, value);
                resultSet = select2.executeQuery();
                break;
            case "isbn":
                final String query3 = "select *from books where isbn=?";
                PreparedStatement select3 = connection.prepareStatement(query3);
                select3.setString(1, value);
                resultSet = select3.executeQuery();
                break;
        }
                Book result = null;
                if (resultSet.next()) {
                    result = new Book();
                    result.setTitle(resultSet.getString("title"));
                    result.setAuthorName(resultSet.getString("authorName"));
                    result.setAuthorLastName(resultSet.getString("authorLastName"));
                    result.setYear(resultSet.getInt("year"));
                    result.setIsbn(resultSet.getString("isbn"));
                }return result;
        }



    public void deletebook(String title) throws SQLException {
        final  String delete="delete from books where title=?";
        PreparedStatement deleteBook=connection.prepareStatement(delete);
        deleteBook.setString(1,title);
        deleteBook.executeUpdate();
        if(deleteBook.executeUpdate()==1)
            System.out.println("Usunięto książke");
        else
            System.out.println("Nie ma takiej książki");
    }

}
