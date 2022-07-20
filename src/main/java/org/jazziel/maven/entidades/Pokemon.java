package main.java.org.jazziel.maven.entidades;

public class Pokemon {
    private String name;
    private String type;
    private String id;
    private String evo;

    public Pokemon(String name, String type, String id, String evo) {
        this.name = name;
        this.type = type;
        this.id = id;
        this.evo = evo;
    }

    public Pokemon(String name, String type, String id) {
        this.name = name;
        this.type = type;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEvo() {
        return evo;
    }

    public void setEvo(String evo) {
        this.evo = evo;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", evo='" + evo + '\'' +
                '}';
    }
}
