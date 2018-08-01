package main;

import Controller.Controller;

public class Application {

    static Controller controller = new Controller();

    public static void main(String[] args) {
        /*
        Додаємо студентів
        * */
        controller.addStudent(0,"Andrew Kostenko");
        controller.addStudent(1,"Julia Veselkina");
        controller.addStudent(2,"Maria Perechrest");
        controller.addStudent(3,"Vasya Moroz");
        controller.addStudent(4,"Ivan Ivanov");
        controller.addStudent(5,"Sasha Kostyk");
        controller.addStudent(6,"Olya Bojinska");

        System.out.println("===========================================================================");

        /*
        Присвоюємо рівень знань студентам
        * */
        controller.setKnowledge("Andrew Kostenko", 70);
        controller.setKnowledge("Julia Veselkina", 90);
        controller.setKnowledge("Maria Perechrest", 45);
        controller.setKnowledge("Vasya Moroz", 34);
        controller.setKnowledge("Ivan Ivanov", 99);
        controller.setKnowledge("Sasha Kostyk", 66);
        controller.setKnowledge("Olya Bojinska", 84);

        System.out.println("===========================================================================");

        /*
        Додаємо Університети та Інтернатуру
        * */
        controller.addUniversity(1, "Oxford");
        controller.addUniversity(2, "Harvard");

        controller.addIntership(1,"Google");
        controller.addIntership(2,"Amazon");

        System.out.println("===========================================================================");

        /*
        Додаємо студентів до Університетів та Інтернатури
        * */
        controller.addStudentToUniversity("Oxford","Andrew Kostenko");
        controller.addStudentToUniversity("Oxford","Julia Veselkina");
        controller.addStudentToUniversity("Oxford","Maria Perechrest");
        controller.addStudentToUniversity("Oxford","Vasya Moroz");

        controller.addStudentToUniversity("Harvard","Ivan Ivanov");
        controller.addStudentToUniversity("Harvard","Sasha Kostyk");
        controller.addStudentToUniversity("Harvard","Olya Bojinska");

        System.out.println("===========================================================================");

        controller.addStudentToInternship("Google","Andrew Kostenko");
        controller.addStudentToInternship("Google","Julia Veselkina");

        controller.addStudentToInternship("Amazon","Ivan Ivanov");

        System.out.println("===========================================================================");

        /*
        У цього студента недостатня кількість балів для поступлення на Інтернатуру
        * */
        controller.addStudentToInternship("Amazon", "Vasya Moroz");

        System.out.println("===========================================================================");

        controller.getUniversityStudents("Oxford");
        controller.getUniversityStudents("Harvard");

        System.out.println("===========================================================================");

        controller.getInternshipStudents("Google");
        controller.getInternshipStudents("Amazon");
    }
}
