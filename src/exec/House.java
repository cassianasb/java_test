package exec;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by kassi on 19/01/2017.
 */
public class House {

    String name;
    ArrayList<Person> people;


    public House(String name, ArrayList<Person> people) {
        this.name = name;
        this.people = people;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(name).append("\n");
        if (people.size()>0)
            sb.append("Membros: ").append("\n");
        for (Person person : people){
            sb.append(person.toString()).append("\n");
        }

        return sb.toString();
    }

}
