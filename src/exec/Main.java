package exec;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

/**
 * Created by kassi on 19/01/2017.
 */
public class Main {
    public static void main(String[] args){

        try {
            BufferedReader reader = new BufferedReader(new FileReader("c:\\Users\\kassi\\IdeaProjects\\java_test\\files\\houses.json"));
            Gson gson = new Gson();
            Houses houses = gson.fromJson(reader, Houses.class);
            System.out.println(houses.toString());


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro: " + e);
        }




    }
}
