package api.enums;

public enum Categories {
    dog(1,"dog"),
    cat(2,"cat");

    private int id;
    private String name;

    Categories(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
