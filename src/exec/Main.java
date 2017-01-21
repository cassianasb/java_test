package exec;

import com.google.gson.Gson;
import db_crud.ConnectionFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by kassi on 19/01/2017.
 */
public class Main {
    public static void main(String[] args){

        try {
            BufferedReader reader = new BufferedReader(new FileReader("c:\\Users\\kassi\\IdeaProjects\\java_test\\files\\houses.json"));
            Gson gson = new Gson();
            //Primeira tarefa
            Houses houses = gson.fromJson(reader, Houses.class);
            System.out.println(houses.toString());

            //Segunda Tarefa
            House stark = houses.getHouses()[0];
            ArrayList<Person> starks = stark.getPeople();
            Comparator list = new Comparator();
            starks.sort(list);

            for (Person s : starks){
                System.out.println(s.getName());
            }

            //Terceira Tarefa
            Connection connection = ConnectionFactory.createConnection();

            if (connection!=null) {
                System.out.println("Conectado! " + connection);
                connection.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro: " + e);
        }




    }
}
