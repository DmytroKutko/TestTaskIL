package Controller;

import institution.University;
import institution.interlink.Internship;
import person.Student;
import person.consciousness.Knowledge;

import java.util.ArrayList;

public class Controller {

    /*
    Згідно правил нормалізації баз даних кожному студенту буде присвоєне id
        університету та інтернатури(зв'язок один до багатьох), усі необхідні дані будемо
        отримувати через id.
     * */
    public ArrayList<Student> students = new ArrayList<>();
    public ArrayList<University> universities = new ArrayList<>();
    public ArrayList<Internship> internships = new ArrayList<>();

    public void addStudent(int id, String name){
        Student student = new Student(id, name);
        students.add(student);
        System.out.println("Add new Student: " + name + "\n");
    }

    public void addUniversity(int id, String name){
        University university = new University(id, name);
        universities.add(university);
        System.out.println("Add new University: " + name + "\n");
    }

    public void addIntership(int id, String name){
        Internship internship = new Internship(id, name);
        internships.add(internship);
        System.out.println("Add new Internship: " + name + "\n");
    }

    /*
    Присвоюємо рівень знань студентам
     * */
    public void setKnowledge(String name, int level){

        Knowledge knowledge = new Knowledge(level);

        for (Student s : students){
            if (s.getName().equals(name)){
                s.setKnowledge(knowledge);
            }
        }
        System.out.println("Student: " + name +" has Knowledge level: " + level + "\n");
    }
    /*
        Додаємо студентів до Університетів
    * */
    public void addStudentToUniversity(String universityName, String studentName){
        for (University u : universities){
            if (u.getName().equals(universityName)){
                for (Student s : students){
                    if (s.getName().equals(studentName)){
                        s.setUniverId(u.getId());
                    }
                }
            }
        }
        System.out.println("Student: " + studentName + " added to University: " + universityName + "\n");
    }

    /*
        Середня оцінка по університету
     * */
    public Integer avgUniversity(String universityName){
        int avarage = 0;
        int countStudents = 0;
        for (University u: universities){
            if (u.getName().equals(universityName)){
                for (Student s : students){
                    if (s.getUniverId() == u.getId()){
                        avarage += s.getKnowledge();
                        countStudents++;
                    }
                }
            }
        }
        avarage /= countStudents;
        return avarage;
    }
    /*
    Якщо рівень знань студента вищий за середній бал по університету то він проходить на інтернатуру
     * */
    public void addStudentToInternship(String internshipName, String studentName){

        String univerName = "";

        for (Student s : students){
            if (s.getName().equals(studentName)){
                for (University u : universities){
                    if (s.getUniverId() == u.getId()){
                        univerName = u.getName();
                    }
                }
            }
        }

        for (Internship i : internships){
            if (i.getName().equals(internshipName)){
                for (Student s : students){
                    if (s.getName().equals(studentName)) {
                        if (s.getKnowledge() >= avgUniversity(univerName)){
                            s.setIntership(i.getId());
                            System.out.println("Student " + s.getName() + " added to " + i.getName() + " internship\n");
                        } else {
                            System.out.println("Student has insufficient level of knowledge: \n"
                                    + s.getName() + " has " + s.getKnowledge() + "\n"
                                    + "Avarage " + univerName + " University: " + avgUniversity(univerName) + "\n");
                        }
                    }
                }
            }
        }
    }

    /*
    Виводимо всіх студентів вказаного університету
     * */
    public void getUniversityStudents(String universityName){

        System.out.println("Students of " + universityName + " university: ");

        int univerId = 0;

        for (University u : universities){
            if (u.getName().equals(universityName)) {
                univerId = u.getId();
            }
        }

        for (Student s : students){
            if (s.getUniverId() == univerId){
                System.out.println("\t" + s.getName());
            }
        }
        System.out.println();
    }

    /*
    Виводимо всіх студентів інтернатури
     * */
    public void getInternshipStudents(String internshipName){
        System.out.println("Students of " + internshipName + " internship: ");

        int internshipId = 0;
        for (Internship i : internships){
            if (i.getName().equals(internshipName)){
                internshipId = i.getId();
            }
        }
        for (Student s : students){
            if (s.getIntership() == internshipId){
                System.out.println("\t" + s.getName());
            }
        }
        System.out.println();
    }
}
