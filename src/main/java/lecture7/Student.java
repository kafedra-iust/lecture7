package lecture7;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private String group;
    private double rating;

    public Student(int id, String name, String group, double rating) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.rating = rating;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Double.compare(student.rating, rating) == 0 && Objects.equals(name, student.name) && Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, group, rating);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if (name.compareTo(o.name) == 0) {
            return Integer.compare(id, o.id);
        }
        return name.compareTo(o.name);
    }
}
