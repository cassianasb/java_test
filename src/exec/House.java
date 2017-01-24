package exec;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by kassi on 19/01/2017.
 */
public class House {

    int id;
    String name;
    String wikiSuffix;
    ArrayList<Person> people;

    public House(int id, String name, String wikiSuffix) {
        this.id = id;
        this.name = name;
        this.wikiSuffix = wikiSuffix;
    }

    public House(int id, String name, String wikiSuffix, ArrayList<Person> people) {
        this.id = id;
        this.name = name;
        this.wikiSuffix = wikiSuffix;
        this.people = people;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWikiSuffix() {
        return wikiSuffix;
    }

    public void setWikiSuffix(String wikiSuffix) {
        this.wikiSuffix = wikiSuffix;
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
        sb.append("Wiki: ").append(wikiSuffix).append("\n");
        if (people.size()>0)
            sb.append("Membros: ").append("\n");
        for (Person person : people){
            sb.append(person.toString()).append("\n");
        }

        return sb.toString();
    }

}
