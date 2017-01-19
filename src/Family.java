import java.util.ArrayList;

/**
 * Created by kassi on 19/01/2017.
 */
public class Family {

    String name;
    ArrayList<Person> people;


    public Family(String name, ArrayList<Person> people) {
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
}
