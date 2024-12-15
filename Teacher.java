/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.person;

import java.util.Date;

/**
 *
 * @author huan
 */
public class Teacher extends Person{
    private int NumberOfClasses;
    private double baseSalary;

    public Teacher(int NumberOfClasses, double baseSalary, String id, String name, Date dateOfBirth) {
        super(id, name, dateOfBirth);
        this.NumberOfClasses = NumberOfClasses;
        this.baseSalary = baseSalary;
    }

    public Teacher() {
    }

    public int getNumberOfClasses() {
        return NumberOfClasses;
    }

    public void setNumberOfClasses(int NumberOfClasses) {
        this.NumberOfClasses = NumberOfClasses;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public double calculateIncome() {
        return NumberOfClasses*baseSalary;
    }

    @Override
    public void EnterDetail() {
        super.EnterDetail(); 
        System.out.println("Nhap numberOfClasses:");
        NumberOfClasses=sc.nextInt();
        System.out.println("Nhap baseSalary:");
        baseSalary=sc.nextDouble();
    }

    @Override
    public void displayDetail() {
        super.displayDetail(); 
        System.out.println("NumberOfClasses:"+NumberOfClasses+"/n Salary:"+calculateIncome());
    }
    
    
}
