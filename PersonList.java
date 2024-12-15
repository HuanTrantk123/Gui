/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author huan
 */
public class PersonList {

    private ArrayList<Person> personList = new ArrayList<>();
    private Student student;
    Scanner sc = new Scanner(System.in);

    public void addPerson(Person person) {
        personList.add(person);
    }

    public boolean updatePersonById(String id) {
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                if (person instanceof Student) {
                    System.out.println("Nhập name:");
                    person.setName(sc.nextLine());
                    System.out.println("Nhập DateOfBirth (dd/MM/yyyy):");
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        String dateInput = sc.nextLine();
                        person.setDateOfBirth(sdf.parse(dateInput));
                    } catch (ParseException e) {
                        System.out.println("Lỗi định dạng ngày tháng.");
                    }
                    System.out.println("Nhap gpa:");
                    ((Student) person).setGpa(sc.nextDouble());
                    System.out.println("Nhap tuitionFee:");
                    ((Student) person).setTuiitionFee(sc.nextDouble());
                } else if (person instanceof Teacher) {
                    System.out.println("Nhập name:");
                    person.setName(sc.nextLine());

                    System.out.println("Nhập DateOfBirth (dd/MM/yyyy):");
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        String dateInput = sc.nextLine();
                        person.setDateOfBirth(sdf.parse(dateInput));
                    } catch (ParseException e) {
                        System.out.println("Lỗi định dạng ngày tháng.");
                    }
                    System.out.println("Nhap numberOfClasses:");
                    ((Teacher) person).setNumberOfClasses(sc.nextInt());
                    System.out.println("Nhap baseSalary:");
                    ((Teacher) person).setBaseSalary(sc.nextDouble());
                }
                return true;
            }
        }
        return false;
    }

    public boolean deleteById(String id) {
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                personList.remove(person);
                return true;
            }
        }
        return false;
    }

    public Person findById(String id) {
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }

    public void displayAll() {
        for (Person person : personList) {
            person.displayDetail();
        }
    }

    public List<Student> top3Student() {
        List<Student> st = new ArrayList<>();
        for (Person person : personList) {
            if (person instanceof Student) {
                st.add((Student) person);
            }
        }
        st.sort((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()));
        return st.size() > 3 ? st.subList(0, 3) : st;
    }

    public Teacher findTeacherWithHighestIncome() {
        Teacher tc = null;
        double maxSalary = 0;
        for (Person person : personList) {
            if (person instanceof Teacher) {
                if (person.calculateIncome() > maxSalary) {
                    maxSalary = person.calculateIncome();
                    tc = (Teacher) person;
                }
            }
        }
        return tc;
    }

    public List<Student> findStudentsWithScholarships() {
        List<Student> St = new ArrayList<>();
        for (Person person : personList) {
            if (person instanceof Student) {
                if (person.calculateIncome() == 2 * ((Student) person).getTuiitionFee()) {
                    St.add((Student) person);
                }
            }
        }
        return St;
    }
}
