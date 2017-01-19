/**
 * Created by kassi on 19/01/2017.
 */
public class Person {
    String name;
    String description;
    String imageSuffix;
    String wikiSuffix;


    public Person(){

    }
    public Person(String name, String description, String imageSuffix, String wikiSuffix){
        this.name = name;
        this.description = description;
        this.imageSuffix = imageSuffix;
        this.wikiSuffix = imageSuffix;

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
}
