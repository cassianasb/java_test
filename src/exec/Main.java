package exec;

import com.google.gson.Gson;
import db_crud.ConnectionFactory;
import db_crud.PersonDB;
import db_crud.HouseDB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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
            //Fim Primeira tarefa

            //Segunda Tarefa
            House stark = houses.getHouses()[0];
            ArrayList<Person> starks = stark.getPeople();
            Comparator list = new Comparator();
            starks.sort(list);

            for (Person s : starks){
                System.out.println(s.getName());
            }

            //Fim Segunda Tarefa

            //Terceira Tarefa
            Connection connection = ConnectionFactory.createConnection();
            if (connection!=null) {
                System.out.println("Conectado! " + connection);
                PersonDB personDB = new PersonDB();
                HouseDB house_db = new HouseDB();
                house_db.insert(stark);

                House redwyne = houses.getHouses()[7];
                house_db.insert(redwyne);
                ArrayList<Person> redwynes = redwyne.getPeople();


                for (Person s : starks){
                    s.setHouse(stark);
                    personDB.insert(s);
                }

                for (Person r : redwynes){
                   r.setHouse(redwyne);
                   personDB.insert(r);
                }
               //Quarta Tarefa
                List<Person> result = personDB.listMembersStartsWith("Starks", "B");
                for (Person p : result){
                    System.out.println(p.toString());
                }
                //Quarta Tarefa

                connection.close();
            }
            //Fim Terceira Tarefa

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro: " + e);
        }




    }
}
