import java.time.LocalDate;

public class Person implements Comparable<Person> {
    private String fullName;
    private String sex;
    private LocalDate dateOfBirth;

    public Person() {
    }

    public Person(String fullName, String sex, LocalDate dateOfBirth) {
        this.fullName = fullName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    @Override
    public int compareTo(Person o) {
        return this.dateOfBirth.compareTo(o.dateOfBirth);
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", sex='" + sex + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
