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

    public String infos(String house) throws  Exception{
        Connection connection = ConnectionFactory.createConnection();

        StringBuilder sb = new StringBuilder();
        PreparedStatement prepStatement = connection.prepareStatement("SELECT h.name, p.name AS member, COUNT(*) AS members_num FROM person p INNER JOIN house h ON p.id_house = h.id_house WHERE h.name = ? LIMIT 1 ");
        prepStatement.setString(1, house);
        ResultSet result = prepStatement.executeQuery();
        while (result.next()){
            sb.append("Casa: ");
            sb.append(result.getString("name"));
            sb.append(" - ");
            sb.append("Quantidade de pessoas: ");
            sb.append(result.getString("members_num"));
            sb.append(" - ");
            sb.append("1º Membro: ");
            sb.append(result.getString("member"));
        }
        result.close();
        prepStatement.close();

        connection.close();

        return sb.toString();
    }

    public ArrayList<String> listHouses() throws Exception {
        Connection connection = ConnectionFactory.createConnection();

        ArrayList<String> houses = new ArrayList();
        PreparedStatement prepStatement = connection.prepareStatement("SELECT name FROM house");
        ResultSet result = prepStatement.executeQuery();
        while (result.next()) {
            String name = result.getString("name");
            houses.add(name);
        }
        result.close();
        prepStatement.close();

        connection.close();

        return houses;
    }

}
