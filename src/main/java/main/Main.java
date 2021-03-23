package main;

import lecture7.Student;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Queue<Student> students = new PriorityQueue<>(Comparator
                .comparingDouble(Student::getRating).reversed()
                .thenComparing(Comparator.naturalOrder()));
        students.addAll(createStudentList());
//        for (Student student : students) {
//            System.out.println(student);
//        }
        while (!students.isEmpty()) {
            System.out.println(students.poll());
        }
    }

    private void run4() {
        NavigableSet<Student> students = new TreeSet<>(createStudentList());
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("-".repeat(50));
        Student first = students.first();
        System.out.println(first);
        System.out.println("-".repeat(50));
        Student last = students.last();
        System.out.println(last);
        System.out.println("-".repeat(50));

        Student low = new Student(0, "M", "", 0);
        Student high = new Student(9999, "Vzzzzzz", "", 0);
        SortedSet<Student> set = students.subSet(low, high);
        printSet(set);
    }

    private void run0() {
        List<Student> students = createStudentList();
        Map<Student, Integer> map = new TreeMap<>();
        map.put(students.get(0), 5);
        map.put(students.get(1), 0);
        map.put(students.get(2), 10);
        map.put(students.get(3), 15);
        map.put(students.get(4), 150);
        map.put(students.get(5), 1);

        for (Map.Entry<Student, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "   :    " + entry.getValue());
        }
    }

    private void run2() {
        List<Student> students = createStudentList();
        printList(students);
        System.out.println("-".repeat(50));
        Set<Student> studentSet = new HashSet<>(students);
        printSet(studentSet);

        Set<Integer> set = new HashSet<>(List.of(1, 2, 4, 5, 6, 7, 19, 3, 20, 8));
        System.out.println(set);
        set.add(9);
        set.add(16);
        System.out.println(set);
        set.add(10);
        System.out.println(set);
        System.out.println(set.size());
    }

    private void printSet(Set<?> set) {
        for (Object element : set) {
            System.out.println(element);
        }
    }

    private void run1() {
        List<Student> students = createStudentList();
        printList(students);
        System.out.println("-".repeat(50));
        students.sort(Comparator.naturalOrder());
        printList(students);
        System.out.println("-".repeat(50));
        students.sort(Comparator.comparingDouble(Student::getRating).thenComparingInt(Student::getId));
        printList(students);
    }

    private void printList(List<Student> students) {
        for (Student student : students) {
            System.out.println(student.getId() + " " + student.getName() + " " + student.getGroup() + " " + student.getRating());
        }
    }

    public List<Student> createStudentList() {
        return new ArrayList<>(
                List.of(
                        new Student(1, "Ivan", "2141", 70),
                        new Student(2, "Masha", "2144", 85),
                        new Student(3, "Petya", "2111", 60),
                        new Student(4, "Vova", "2141", 99),
                        new Student(5, "Vasya", "2144", 100),
                        new Student(3, "Petya", "2111", 60),
                        new Student(7, "Anya", "2144", 85),
                        new Student(6, "Anya", "2144", 85)
                )
        );
    }
}
