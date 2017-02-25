package module3.homework3;

import java.util.Date;

/**
 * Created by Igor on 25.02.2017.
 */
public class Solution {
    public static void main(String[] args) {
        Course course1 = new Course(new Date(), "course1");
        Course course2 = new Course(new Date(), "course1");
        Course course3 = new Course(new Date(), "course1");
        Course course4 = new Course("course4", 64, "Ihor Shylo");
        Course course5 = new Course("course5", 128, "Some other Guy");

        Student student1 = new Student("Vasya", "Pupkin", 1);
        Student student2 = new Student("Sveta", "Ivanova", 1);


        SpecialStudent specialStudent1 = new SpecialStudent("Petya", "Petrov", 2);
        SpecialStudent specialStudent2 = new SpecialStudent("GoIT", 5, 123, "Semen", "Semenchenko", 2, new Course[5], 25);
        SpecialStudent specialStudent3 = new SpecialStudent("Zagorulko", new Course[33], 777);

        CollegeStudent collegeStudent1 = new CollegeStudent("Grisha", "Grishenko", 3);
        CollegeStudent collegeStudent2 = new CollegeStudent("Levchenko", new Course[6]);
        CollegeStudent collegeStudent3 = new CollegeStudent("GoIT", 4, 125, "Nadya", "Savchenko", 3, new Course[8], 30);

    }
}
