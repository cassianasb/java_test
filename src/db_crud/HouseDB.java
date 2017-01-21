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
                connection.prepareStatement("INSERT INTO house(name) VALUES (?)");
        prepStatement.setString(1, house.getName());
        prepStatement.executeUpdate();
        prepStatement.close();

        connection.close();
    }

    public void update(House house) throws Exception {
        Connection connection = ConnectionFactory.createConnection();

        PreparedStatement prepStatement =
                connection.prepareStatement("UPDATE house SET name = ? where id = ?");
        prepStatement.setString(1, house.getName());
        prepStatement.setInt(2, house.getId());
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

}
