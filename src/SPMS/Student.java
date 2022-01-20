package SPMS;

import java.io.Serializable;

public class Student implements Serializable{
    private String password;
	private Long phNo;
	private int rollNo;
	private String name;
	private String batch;
	private float tenthPercentage;
	private float twelthPercentage;
	private int noOfBackLogs;
	private float CGPA;
	private String otherQualifications;
	
	//single parametric constructor for Student class
	Student(){
		this.password= "12345678";
	}
	
	//parametric constructor for Student class
	Student(Long phNo, int rollNo, String name, String batch, String password){
        this.name = name;
		this.password = password;
		this.phNo= phNo;
		this.rollNo= rollNo;
		this.batch = batch;
	}
	
	//setter and getter for phone number
	public Long getphNo() {
		return this.phNo;
	}
	public void setphNo(Long phNo) {
		this.phNo= phNo;
	}
	
	//setter and getter for name
	public String getname() {
		return this.name;
	}
	public void setname(String name) {
		this.name= name;
	}
	
	//setter and getter for roll number
	public int getrollNo () {
		return this.rollNo;
	}
	public void setrollNo(int rollNo) {
		this.rollNo= rollNo;
	}
	
	//setter and getter for batch 
	public String getbatch() {
		return this.batch;
	}
	public void setbatch(String batch) {
		this.batch= batch;
	}
	
	//setter and getter for tenth percentage
	public float gettenthPercentage() {
		return this.tenthPercentage;
	}
	public void settenthPercentage(float tenthPercentage) {
		this.tenthPercentage= tenthPercentage;
	}
	
	//setter and getter for 12th percentage
	public float gettwelthhPercentage() {
		return this.twelthPercentage;
	}
	public void settwelthPercentage(float twelthPercentage) {
		this.twelthPercentage=  twelthPercentage;
	}
	
	//setter and getter for other qualifications
	public String getotherQualifications() {
		return this.otherQualifications;
	}
	public void setotherQualifications(String otherQualifications) {
		this.otherQualifications=  otherQualifications;
	}
	
	//setter and getter for no of backlogs
	public int getnoOfBackLogs() {
		return this.noOfBackLogs;
	}
	public void setBackLogs(int noOfBackLogs) {
		this.noOfBackLogs = noOfBackLogs;
	}
	
	//setter and getter for CGPA
	public float getCGPA() {
		return this.CGPA;
	}
	public void setCGPA(float CGPA) {
		this.CGPA=  CGPA;
	}
	
	//setter and getter for password
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	//to be developed further
    public String toString(){
        return ("name: " + this.name + 
        ";\nbatch: " +this.batch+";\nCGPA: "+ this.CGPA +";\nRoll Number: "+ 
        this.rollNo +";\nTenth Percentage: "+ this.tenthPercentage+";\nTwelth Percentage: "+ 
        this.twelthPercentage +";\nNo of Backlogs: "+ this.noOfBackLogs);
    }

	public String oneLineString(){
		return("name: " + this.name + "phone: " + this.phNo + 
        "; batch: " +this.batch+"; CGPA: "+ this.CGPA +"; Roll Number: "+ 
        this.rollNo +"; Tenth Percentage: "+ this.tenthPercentage+"; Twelth Percentage: "+ 
        this.twelthPercentage +"; No of Backlogs: "+ this.noOfBackLogs);
	}
	
}
