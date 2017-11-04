package lab3;

import lab2.Student;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.TreeSet;

public class Group {

    // fields
    private String title;
    private String mentor;
    private int yearOfGraduation;

    private TreeSet<Student> students = new TreeSet<>(new Comparator<Student>() {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getFirstName().compareTo(o2.getFirstName());
        }
    });

    // setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    public void setYearOfGraduation(int yearOfGraduation) {
        this.yearOfGraduation = yearOfGraduation;
    }

    // getters
    public String getTitle() {
        return title;
    }

    public String getMentor() {
        return mentor;
    }

    public int getYearOfGraduation() {
        return yearOfGraduation;
    }

    // methods
    public TreeSet<Student> sortByAverageMarks() {

        TreeSet<Student> s = new TreeSet<>(new ComparatorByAvgMark());

        for (Student st : this.students) {
            s.add(st);
        }
        return s;
    }

    public void addStudentToGroup(Student st){
        students.add(st);
    }

    public int getCourse(){
        return 5 - (yearOfGraduation - LocalDate.now().getYear());
    }

    public void transferToNextGroup(Student st, Group g){
        g.students.add(st);
        students.remove(st);
    }

    public TreeSet<Student> outputGrantApplicants(int pc){

        int count = (int)(Math.round(students.size() / 100.0 * pc));

        TreeSet<Student> stud = this.sortByAverageMarks();

        Student[] s = stud.toArray(new Student[stud.size()]);
        if (s[count-1].getAverageMark() == s[count].getAverageMark())
            while (s[count-1].getAverageMark() == s[count].getAverageMark() && count >= 0){
                count--;
            }
       
        TreeSet<Student> res = new TreeSet<>(new ComparatorByAvgMark());
        
        for (int i = 0; i < count; i++)
            res.add(s[i]);
        return res;
    }

    public void outputGroup(){
        for (Student s: students) {
            System.out.println(s.toString());
            System.out.println();
        }
    }

    @Override
    public String toString() {
        String res = "Title: " + title +
                "\nMentor: " + mentor +
                "\nYearOfGraduation: " + yearOfGraduation +
                "\nStudents: " + "\n";

        for (Student st : students){
            res += st.toString();
        }
        return res;
    }

    @Override
    public boolean equals(Object obj){
        return  (title.equals(((Group) obj).title) &&
                mentor.equals(((Group) obj).mentor) &&
                yearOfGraduation == (((Group) obj).yearOfGraduation));
    }
}

class ComparatorByAvgMark implements Comparator<Student>{
    
    @Override
    public int compare(Student o1, Student o2) {         
        if (o1.getAverageMark() > o2.getAverageMark())
           return -1;
        else if (o1.getAverageMark() < o2.getAverageMark())
           return 1;
        else 
           return (o1.getFirstName()).compareTo(o2.getFirstName()); 
        } 
}
