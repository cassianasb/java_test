package db_crud;

import exec.House;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kassi on 20/01/2017.
 */
public class HouseDB {
    public void insert(House house) throws Exception{
        Connection connection = ConnectionFactory.createConnection();

        PreparedStatement prepStatement =
                connection.prepareStatement("INSERT INTO house(name, wikiSuffix) VALUES (?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
        prepStatement.setString(1, house.getName());
        prepStatement.setString(2, house.getWikiSuffix());
        prepStatement.executeUpdate();
        ResultSet generatedKeys = prepStatement.getGeneratedKeys();
        if (generatedKeys.next())
            house.setId(generatedKeys.getInt(1));
        prepStatement.close();

        connection.close();
    }

    public void update(House house) throws Exception {
        Connection connection = ConnectionFactory.createConnection();

        PreparedStatement prepStatement =
                connection.prepareStatement("UPDATE house SET name = ?, wikiSuffix = ? where id = ?");
        prepStatement.setString(1, house.getName());
        prepStatement.setString(2, house.getWikiSuffix());
        prepStatement.setInt(3, house.getId());
        prepStatement.executeUpdate();
        prepStatement.close();

        connection.close();
    }

    public void delete(House house) throws Exception {
        Connection connection = ConnectionFactory.createConnection();

        PreparedStatement prepStatement =
                connection.prepareStatement("DELETE FROM house where id = ?");
        prepStatement.setInt(1, house.getId());
        prepStatement.executeUpdate();
        prepStatement.close();

        connection.close();
    }

    public List<House> list() throws Exception {
        Connection connection = ConnectionFactory.createConnection();

        List<House> houses = new ArrayList<House>();
        PreparedStatement prepStatement = connection.prepareStatement("SELECT * FROM house");
        ResultSet result = prepStatement.executeQuery();
        while (result.next()) {
            int id = result.getInt("Id");
            String name = result.getString("Nome");
            String suffix = result.getString("Sufixo");
            House house = new House(id, name, suffix);
            house.setId(id);
            house.setName(name);
            house.setWikiSuffix(suffix);
            houses.add(house);
        }
        result.close();
        prepStatement.close();

        connection.close();

        return houses;
    }

}
