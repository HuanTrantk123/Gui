/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author huan
 */
public abstract class Person implements iPerson {

    private String id;
    private String name;
    private Date dateOfBirth;
    Scanner sc = new Scanner(System.in);

    public Person() {
    }

    public Person(String id, String name, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public void displayDetail() {
        System.out.println("Id:" + id + "\n Name:" + name + "\n DateOfBirth:" + dateOfBirth);
    }

    @Override
    public abstract double calculateIncome();

    public void EnterDetail() {
        System.out.println("Nhap id:");
        id = sc.nextLine();
        System.out.println("Nhap name:");
        name = sc.nextLine();
        System.out.println("Nhap DateOfBirth (dd/MM/yyyy):");
        String dateInput = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dateOfBirth = sdf.parse(dateInput);
        } catch (ParseException e) {
            System.out.println("Lỗi định dạng ngày tháng.");
        }
    }

}
