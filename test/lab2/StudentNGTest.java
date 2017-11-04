package lab2;

import lab2.Student.PaidFree;
import lab2.Student.Builder;
import java.time.LocalDate;
import java.time.Month;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StudentNGTest {
    
    // -------------------------------------------------------------
    
    @Test(dataProvider = "equalsProvider")
    public void testEquals(Student s1, Student s2, boolean res) {
        assertEquals(s1.equals(s2), res);
    }
    
    @DataProvider
    public Object[][] equalsProvider(){
        
        Student s1 = new Student.Builder().setFirstName("Damian").
                setLastName("Johnson").setAverageMark(4.7).setPhoneNumber("380932134567").
                setPaidOrFreeGroup(PaidFree.FREE).
                setDateOfBirthday(LocalDate.of(1990, Month.JANUARY, 18)).createStudent();

        Student s2 = new Student.Builder().setFirstName("Kim").setLastName("Loss").
                setDateOfBirthday(LocalDate.of(1992, Month.APRIL, 23)).setAverageMark(4.2).
                setPaidOrFreeGroup(PaidFree.FREE).setPhoneNumber("380932134567").createStudent();
        
        Student s3 = new Student.Builder().setFirstName("Kim").setLastName("Loss").
                setDateOfBirthday(LocalDate.of(1992, Month.APRIL, 23)).setAverageMark(4.2).
                setPaidOrFreeGroup(PaidFree.FREE).setPhoneNumber("380932134567").createStudent();
        
        return new Object[][]{{s1, s2, false},
                              {s2, s3, true}};
    }
    
    // -------------------------------------------------------------
    
    @Test
     public void testSetFirstNamePositive() {

        Student s = new Student.Builder().setFirstName("Damian").createStudent();
        assertEquals(s.getFirstName(), "Damian");
    }   
     
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetFirstNameNegative() {
        
        Builder builder = new Builder();
        builder.setFirstName("damian");
    }
  
    // -------------------------------------------------------------

    @Test
    public void testSetPhoneNumberPositive() {

        Student s = new Student.Builder().setPhoneNumber("380981234567").createStudent();
        assertEquals(s.getPhoneNumber(), "380981234567");
    }   
     
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetPhoneNumberNegative() {
        
        Builder builder = new Builder();
        builder.setFirstName("0981234567");
    }
  
    // -------------------------------------------------------------
}