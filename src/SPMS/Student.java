package SPMS;

import java.io.Serializable; //this class implements a serializable interface that allows object of this class to be converted into
//byte stream for writing into a file 

public class Student implements Serializable{
    private String password;//password
	private Long phNo;//phone number
	private int rollNo;//roll number
	private String name;//name
	private String batch;//batch
	private float tenthPercentage;//10th percentage
	private float twelthPercentage;//12th percentage
	private int noOfBackLogs;//number of backlogs
	private float CGPA;// average CGPA
	private String otherQualifications;// other things in string
	
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

	//all details in multiple lines
    public String toString(){
        return ("name: " + this.name + 
        ";\nbatch: " +this.batch+";\nCGPA: "+ this.CGPA +";\nRoll Number: "+ 
        this.rollNo +";\nTenth Percentage: "+ this.tenthPercentage+";\nTwelth Percentage: "+ 
        this.twelthPercentage +";\nNo of Backlogs: "+ this.noOfBackLogs);
    }


	//all details in one line
	public String oneLineString(){
		return("name: " + this.name + "; phone: " + this.phNo + 
        "; batch: " +this.batch+"; CGPA: "+ this.CGPA +"; Roll Number: "+ 
        this.rollNo +"; Tenth Percentage: "+ this.tenthPercentage+"; Twelth Percentage: "+ 
        this.twelthPercentage +"; No of Backlogs: "+ this.noOfBackLogs);
	}
	
}
