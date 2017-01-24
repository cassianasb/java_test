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

    /*public List<Person> list() throws Exception {
        Connection connection = ConnectionFactory.createConnection();

        List<Person> people = new ArrayList<Person>();
        PreparedStatement prepStatement = connection.prepareStatement("SELECT * FROM person");
        ResultSet result = prepStatement.executeQuery();
        while (result.next()) {
            int id = result.getInt("Id");
            String name = result.getString("Nome");
            String description = result.getString("Descrição");
            String image = result.getString("Imagem");
            String suffix = result.getString("Sufixo");
            House house = result.getObject("House");
            Person person = new Person(id, name, description, image, suffix, house);
            person.setId(id);
            person.setName(name);
            person.setHouse(house);
            people.add(person);
        }
        result.close();
        prepStatement.close();

        connection.close();

        return people;
    }*/

}
