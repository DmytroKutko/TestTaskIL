package institution;

public class University {

    private int id;
    private String name;

    public University(int id, String name) {
        this.id = id;
        setName(name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void setStudent(Student student) {
//        //TODO: Implementation is needed
//    }
//
//    public void addStudent(Student student) {
//        //TODO: Implementation is needed
//    }
}
