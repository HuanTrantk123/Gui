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
public class Student extends Person{
private double gpa;
private double tuiitionFee;

    public Student(double gpa, double tuiitionFee, String id, String name, Date dateOfBirth) {
        super(id, name, dateOfBirth);
        this.gpa = gpa;
        this.tuiitionFee = tuiitionFee;
    }

    public Student() {
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public double getTuiitionFee() {
        return tuiitionFee;
    }

    public void setTuiitionFee(double tuiitionFee) {
        this.tuiitionFee = tuiitionFee;
    }

    @Override
    public double calculateIncome() {
        if(gpa>3.5){
            return tuiitionFee*0.5;
        }else{
            return tuiitionFee;
        }
    }

    @Override
    public void displayDetail() {
        super.displayDetail(); 
        System.out.println("Gpa:"+gpa+"/n TuiitionFee:"+calculateIncome());
    }

    @Override
    public void EnterDetail() {
        super.EnterDetail();
        System.out.println("Nhap gpa:");
       gpa=sc.nextDouble();
        System.out.println("Nhap tuitionFee:");
       tuiitionFee=sc.nextDouble();
    }
    
    
    
}
