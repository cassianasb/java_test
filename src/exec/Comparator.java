package exec;

/**
 * Created by kassi on 19/01/2017.
 */
public class Comparator implements java.util.Comparator<Person> {

    @Override
    public int compare(Person person0, Person person1) {
        return person0.getName().compareToIgnoreCase(person1.getName());
    }
}
