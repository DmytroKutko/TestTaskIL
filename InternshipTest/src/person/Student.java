package person;

import person.consciousness.Knowledge;

/*
Згідно правилам нормалізації баз даних кожному студенту(цього класу)
    присвоєно id університету та інтернатури.
* */
public class Student {

    private int id;
    private String name;
    private Knowledge knowledge;
    private int univerId;
    private int intership;

    public Student(int id, String name) {
        this.id = id;
        setName(name);
    }

    public int getIntership() {
        return intership;
    }

    public void setIntership(int intership) {
        this.intership = intership;
    }

    public int getUniverId() {
        return univerId;
    }

    public void setUniverId(int univerId) {
        this.univerId = univerId;
    }

    public String getName() {
        return name;
    }

    public int getKnowledge() {
        return knowledge.getLevel();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKnowledge(Knowledge knowledge) {
        this.knowledge = knowledge;
    }
}
