package lab3;

import lab2.Student;
import lab2.Student.PaidFree;
import java.time.LocalDate;
import java.time.Month;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class GroupNGTest {
    
    Student s1, s2, s3, s4, s5, s6;
    
    public GroupNGTest(){
        
        s1 = new Student.Builder().setFirstName("Damian").setLastName("Johnson").
                setDateOfBirthday(LocalDate.of(1997, Month.JANUARY, 18)).
                setAverageMark(4.7).setPaidOrFreeGroup(PaidFree.FREE).
                setPhoneNumber("380981234567").createStudent();
        
        s2 = new Student.Builder().setFirstName("Alex").setLastName("Austen").
                setDateOfBirthday(LocalDate.of(1998, Month.MARCH, 12)).
                setAverageMark(4.5).setPaidOrFreeGroup(PaidFree.FREE).
                setPhoneNumber("380984567843").createStudent();
        
        s3 = new Student.Builder().setFirstName("Kim").setLastName("Loss").
                setDateOfBirthday(LocalDate.of(1993, Month.JULY, 10)).
                setAverageMark(4.2).setPaidOrFreeGroup(PaidFree.FREE).
                setPhoneNumber("380981234521").createStudent();

        s4 = new Student.Builder().setFirstName("Joe").setLastName("Clark").
                setDateOfBirthday(LocalDate.of(1996, Month.JANUARY, 22)).
                setAverageMark(4.5).setPaidOrFreeGroup(PaidFree.PAID).
                setPhoneNumber("380981234561").createStudent();

        s5 = new Student.Builder().setFirstName("Alice").setLastName("Cooper").
                setDateOfBirthday(LocalDate.of(1992, Month.DECEMBER, 13)).
                setAverageMark(4.1).setPaidOrFreeGroup(PaidFree.PAID).
                setPhoneNumber("380981134567").createStudent();
        
        s6 = new Student.Builder().setFirstName("Linda").setLastName("Tyler").
                setDateOfBirthday(LocalDate.of(1989, Month.JULY, 25)).
                setAverageMark(4.3).setPaidOrFreeGroup(PaidFree.PAID).
                setPhoneNumber("380981214547").createStudent();

    }
    
    // ---------------------------------------------------
    
    @Test(dataProvider = "getCourseProvider")
    public void testGetCourse(Group group, int course) {
        assertEquals(group.getCourse(), course);
    }
    
    @DataProvider
    public Object[][] getCourseProvider(){
        
        Group group345 = new Group();
        group345.addStudentToGroup(s1);
        group345.addStudentToGroup(s2);
        group345.addStudentToGroup(s3);
        
        group345.setTitle("345");
        group345.setMentor("Jughed Jones");
        group345.setYearOfGraduation(2019);
        
        return new Object[][]{{group345, 3}};
    }
    
    // ---------------------------------------------------
    
    @Test(dataProvider = "equalsProvider")
    public void testEquals(Group g1, Group g2, boolean res) {
        assertEquals(g1.equals(g2), res);
    }
    
    @DataProvider
    public Object[][] equalsProvider(){
        
        Group group345 = new Group();
        group345.addStudentToGroup(s1);
        group345.addStudentToGroup(s2);
        group345.addStudentToGroup(s3);
        
        group345.setTitle("345");
        group345.setMentor("Jughed Jones");
        group345.setYearOfGraduation(2019);
        
        Group group245 = new Group();
        group245.addStudentToGroup(s4);
        group245.addStudentToGroup(s5);
        group245.addStudentToGroup(s6);
        
        group245.setTitle("245");
        group245.setMentor("Karry Milton");
        group245.setYearOfGraduation(2020);
        
        return new Object[][]{{group345, group245, false}, 
                              {group345, group345, true}};
    }
    
    // ---------------------------------------------------
}
