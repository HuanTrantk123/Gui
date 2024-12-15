/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author huan
 */
public class Processor {

    public static void main(String[] args) {
        PersonList Ps = new PersonList();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add a new student (Student). \n"
                    + "2. Add a new teacher (Teacher). \n"
                    + "3. Update person by id. \n"
                    + "4. Delete person by id. \n"
                    + "5. Find person by id. \n"
                    + "6. Display all persons. \n"
                    + "7. Find the top 3 students with the highest GPA. \n"
                    + "8. Find the teacher with the highest income.");
            int choice;
            System.out.println("Nhap lua chon:");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    Student st = new Student();
                    Ps.addPerson(st);
                    st.EnterDetail();
                    break;
                case 2:
                    Teacher Tc = new Teacher();
                    Ps.addPerson(Tc);
                    Tc.EnterDetail();
                    break;
                case 3:
                    String idtoUpdate;
                    System.out.println("Nhap id:");
                    idtoUpdate = sc.nextLine();
                    Ps.updatePersonById(idtoUpdate);
                    break;
                case 4:
                    String idToDelete;
                    System.out.println("Nhap id:");
                    idToDelete = sc.nextLine();
                    Ps.deleteById(idToDelete);
                    break;
                case 5:
                    Person ps1;
                    String idtoFind;
                    System.out.println("Nhap id:");
                    idtoFind = sc.nextLine();
                    ps1 = Ps.findById(idtoFind);
                    ps1.displayDetail();
                    break;
                case 6:
                    Ps.displayAll();
                    break;
                case 7:
                    List<Student> Ls1 = new ArrayList<>();
                    Ls1 = Ps.top3Student();
                    for (Student student : Ls1) {
                        student.displayDetail();
                    }
                    break;
                case 8:
                    Teacher tc1 = new Teacher();
                    tc1 = Ps.findTeacherWithHighestIncome();
                    tc1.displayDetail();
                    break;
                default:
                    System.out.println("Khong ton tai.");
                    break;

            }
        }
    }
}
