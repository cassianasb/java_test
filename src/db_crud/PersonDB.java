package db_crud;

import exec.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;


/**
 * Created by kassi on 20/01/2017.
 */
public class PersonDB {
    public void insert(Person person) throws Exception{
        Connection connection = ConnectionFactory.createConnection();

        PreparedStatement prepStatement =
                connection.prepareStatement("INSERT INTO person(name, description, imageSuffix, wikiSuffix) VALUES (?, ?, ?, ?)");
        prepStatement.setString(1, person.getName());
        prepStatement.setString(2, person.getDescription());
        prepStatement.setString(3, person.getImageSuffix());
        prepStatement.setString(4, person.getWikiSuffix());
        prepStatement.executeUpdate();

        prepStatement.close();
        connection.close();
    }

    public void update(Person person) throws Exception {
        Connection connection = ConnectionFactory.createConnection();

        PreparedStatement prepStatement =
                connection.prepareStatement("UPDATE house SET name = ?, description = ?, imageSuffix = ?, wikiSuffix = ? where id = ?");
        prepStatement.setString(1, person.getName());
        prepStatement.setString(2, person.getDescription());
        prepStatement.setString(3, person.getImageSuffix());
        prepStatement.setString(4, person.getWikiSuffix());
        prepStatement.setInt(5, person.getId());
        prepStatement.executeUpdate();
        prepStatement.close();

        connection.close();
    }

    public void delete(Person person) throws Exception {
        Connection connection = ConnectionFactory.createConnection();

        PreparedStatement prepStatement =
                connection.prepareStatement("DELETE FROM person where id = ?");
        prepStatement.setInt(1, person.getId());
        prepStatement.executeUpdate();

        prepStatement.close();
        connection.close();
    }

}
