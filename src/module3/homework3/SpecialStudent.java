package module3.homework3;

/**
 * Created by Igor on 25.02.2017.
 */
public class SpecialStudent extends CollegeStudent {
    private long secretKey;
    private String email;

    public SpecialStudent(String firstName, String lastName, int group) {
        super(firstName, lastName, group);
    }

    public SpecialStudent(String collegeName, int rating, long id, String firstName, String lastName, int group, Course[] coursesTaken, int age) {
        super(collegeName, rating, id, firstName, lastName, group, coursesTaken, age);
    }

    public SpecialStudent(String lastName, Course[] coursesTaken, long secretKey) {
        super(lastName, coursesTaken);
        this.secretKey = secretKey;
    }

    public long getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(long secretKey) {
        this.secretKey = secretKey;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
