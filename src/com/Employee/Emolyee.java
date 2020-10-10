package com.Employee;

public class Emolyee {
	String name , address,bankAccountNumber;
	int grade;
    double salary ;
    double basic;
    int lowest_grade= 1;
    double medicalAllowance;
    double houseRent;
    double initialSalary;
    
    public  double getInitialSalary() {
	return initialSalary;
}
public  void setInitialSalary(double initialSalary) {
	this.initialSalary = initialSalary;
}
	int id;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBankAccountNumber() {
		return bankAccountNumber;
	}
	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		
	
		this.grade = grade;
		
	}
	public double getSalary() {
		this.calculatesalary();
	
		return salary;
	}
	public void calculatesalary() {
		double basicSalary=(grade-lowest_grade)*5000+this.initialSalary;
		medicalAllowance=basicSalary*0.20;
		houseRent = basicSalary*0.15;
		
	   this.salary =basicSalary+medicalAllowance+houseRent;
	}
	
	

	

}
