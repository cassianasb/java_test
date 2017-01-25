package db_crud;

import exec.House;
import exec.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by kassi on 20/01/2017.
 */
public class PersonDB {
    public void insert(Person person) throws Exception{
        Connection connection = ConnectionFactory.createConnection();

        PreparedStatement prepStatement =
                connection.prepareStatement("INSERT INTO person(name, description, imageSuffix, wikiSuffix, id_house) VALUES (?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
        prepStatement.setString(1, person.getName());
        prepStatement.setString(2, person.getDescription());
        prepStatement.setString(3, person.getImageSuffix());
        prepStatement.setString(4, person.getWikiSuffix());
        prepStatement.setInt(5, person.getHouse().getId());
        prepStatement.executeUpdate();
        ResultSet generatedKeys = prepStatement.getGeneratedKeys();
        if (generatedKeys.next())
            person.setId(generatedKeys.getInt(1));
        prepStatement.close();
        connection.close();
    }

    public void update(Person person) throws Exception {
        Connection connection = ConnectionFactory.createConnection();

        PreparedStatement prepStatement =
                connection.prepareStatement("UPDATE person SET name = ?, description = ?, imageSuffix = ?, wikiSuffix = ?, id_house = ? where id = ?");
        prepStatement.setString(1, person.getName());
        prepStatement.setString(2, person.getDescription());
        prepStatement.setString(3, person.getImageSuffix());
        prepStatement.setString(4, person.getWikiSuffix());
        prepStatement.setInt(5, person.getHouse().getId());
        prepStatement.setInt(6, person.getId());
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

    public List<Person> listMembersStartsWith(String house, String letter) throws Exception {
        Connection connection = ConnectionFactory.createConnection();

        List<Person> people = new ArrayList<Person>();
        PreparedStatement prepStatement = connection.prepareStatement("SELECT * FROM person p INNER JOIN house h ON p.id_house=h.id_house WHERE h.name = ? AND p.name LIKE ? ");
        letter+="%";
        prepStatement.setString(1, house);
        prepStatement.setString(2, letter);
        ResultSet result = prepStatement.executeQuery();
        while (result.next()) {
            int id = result.getInt("id_person");
            String name = result.getString("name");
            String description = result.getString("description");
            String image = result.getString("imageSuffix");
            String suffix = result.getString("wikiSuffix");
            Person person = new Person(id, name, description, image, suffix);
            people.add(person);
        }
        result.close();
        prepStatement.close();

        connection.close();

        return people;
    }

}
