package exec;

import java.io.Serializable;

/**
 * Created by kassi on 19/01/2017.
 */
public class Person implements Serializable {

    int id;
    String name;
    String description;
    String imageSuffix;
    String wikiSuffix;
    House house;


    public Person(int id, String name, String description, String imageSuffix, String wikiSuffix){
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageSuffix = imageSuffix;
        this.wikiSuffix = imageSuffix;
    }

    public Person(int id, String name, String description, String imageSuffix, String wikiSuffix, House house){
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageSuffix = imageSuffix;
        this.wikiSuffix = imageSuffix;
        this.house = house;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageSuffix() {
        return imageSuffix;
    }

    public void setImageSuffix(String imageSuffix) {
        this.imageSuffix = imageSuffix;
    }

    public String getWikiSuffix() {
        return wikiSuffix;
    }

    public void setWikiSuffix(String wikiSuffix) {
        this.wikiSuffix = wikiSuffix;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(name).append(", ");
        sb.append("Descrição: ").append(description).append(", ");
        sb.append("Imagem: ").append(imageSuffix).append(", ");
        sb.append("Wiki: ").append(wikiSuffix).append(". ");

        return sb.toString();
    }

}
