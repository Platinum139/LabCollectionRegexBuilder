package lab2;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Student{
    
    public enum PaidFree {
        PAID, FREE;
    }
    
    // fields
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirthday;
    private double averageMark;
    private String phoneNumber;
    private PaidFree paidOrFreeGroup;
    
    private static final double MAXMARK = 5.0;
    private static final int CURRENT_YEAR = LocalDate.now().getYear();
    private static final String PATTERN = "^[A-Z][a-z]+";

    private Student(Builder b){       
        firstName = b.firstName;
        lastName = b.lastName;
        dateOfBirthday = b.dateOfBirthday;
        averageMark = b.averageMark;
        phoneNumber = b.phoneNumber;
        paidOrFreeGroup = b.paidOrFreeGroup;
    }

    // getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PaidFree getPaidOrFreeGroup() {
        return paidOrFreeGroup;
    }
    
    // builder
    public static class Builder {
        
        // fields
        private String firstName;
        private String lastName;
        private LocalDate dateOfBirthday;
        private double averageMark;
        private String phoneNumber;
        private PaidFree paidOrFreeGroup;
        
        // setters
        public Builder setFirstName(String firstName) {
            Pattern p = Pattern.compile(PATTERN);
            if (p.matcher(firstName).matches())
                this.firstName = firstName;
            else 
                throw new IllegalArgumentException("Illegal Argument");
            return this;
        }

        public Builder setLastName(String lastName) {
            Pattern p = Pattern.compile(PATTERN);
            if (p.matcher(lastName).matches())
                this.lastName = lastName;
            else
                throw new IllegalArgumentException("Illegal Argument");
            return this;
        }

        public Builder setDateOfBirthday(LocalDate date) {
            if (date.getYear() > CURRENT_YEAR - 100 && date.getYear() < CURRENT_YEAR - 15)
                this.dateOfBirthday = date;
            else
                throw new IllegalArgumentException("Illegal Argument");
            return this;
        }

        public Builder setAverageMark(double averageMark) {
            if (averageMark >= 0.0 && averageMark <= MAXMARK)
                this.averageMark = averageMark;
            else
                throw new IllegalArgumentException("Illegal Argument");
        return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            Pattern p = Pattern.compile("^[\\+]*(380)[0-9]{9}");
            if (p.matcher(phoneNumber).matches())
                this.phoneNumber = phoneNumber;
            else 
                throw new IllegalArgumentException("Illegal Argument");
        return this;
        }

        public Builder setPaidOrFreeGroup (PaidFree p) {
            this.paidOrFreeGroup = p;
        return this;
        }   

        public Student createStudent(){
            return new Student(this);
        }

    }

    @Override
    public String toString(){
        return "\nFirst name: " + firstName + "\nLast name: " + lastName +
                "\nBirthday: " + dateOfBirthday + "\nAverage mark: " + averageMark +
                "\nPhone number: " + phoneNumber + "\nGroup: " + paidOrFreeGroup + "\n";
    }

    @Override
    public boolean equals (Object obj){

        return  firstName.equals(((Student) obj).firstName) &&
                lastName.equals(((Student) obj).lastName) &&
                phoneNumber.equals(((Student) obj).phoneNumber) &&
                paidOrFreeGroup.equals(((Student) obj).paidOrFreeGroup);
    }
}


