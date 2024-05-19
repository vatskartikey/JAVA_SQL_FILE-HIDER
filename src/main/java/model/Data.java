package model;

public class Data {

    private int id;
    private String name;
    private String path;
    private String email;

    public int getId() {
        return id;
    }

    public Data(int id, String name, String path) {
        this.id = id;
        this.name = name;
        this.path = path;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return name;
    }

    public void setFileName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Data(int id, String name, String path, String email) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.email = email;
    }
}
