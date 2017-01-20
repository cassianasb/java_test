package exec;

import java.lang.reflect.Array;

/**
 * Created by kassi on 19/01/2017.
 */
public class Houses {

    House[] houses;

    public Houses(House[] houses) {
        this.houses = houses;
    }

    public House[] getHouses() {
        return houses;
    }

    public void setHouses(House[] houses) {
        this.houses = houses;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (House house : houses){
            sb.append("[").append(house).append("]").append("\n\n");
        }
        return sb.toString();
    }

}
