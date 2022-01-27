package SPMS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import BufferList.*; 
//BufferList is a self written package whic works with the isea of lists
//which wont loose data when the program is terminated


// this class SR acts as a type of data register and manager for all the student users
public class SR {
    
    //this list acts as a storage for all the Student objects created
    // this GenericBufferList is a generic datatype defined in BufferList package
    static GenericBufferList<Student> list; 

    //this method initiates the list
    static void start() throws ClassNotFoundException, IOException{
        
        list = new GenericBufferList<Student>("SR.ser");
        // SR.ser denotes the file name in which the data is stored when the 
        //programme is terminated
    }

    //this method have the mechanism to be run and interface to be displayed when the student chooses to register 
    static void register(Student s) throws ClassNotFoundException, IOException{
        
        // taking the roll number with which the student want to register and checks weather 
        //it is already used or not. if the entered roll number is valid then adds the student to the list
        //then gives the student an unique nuber which is used when logging in
        int in_roll = s.getrollNo(); 
        boolean flag =  true;
        for (Student i: list){
            boolean signal;
            if (i.getrollNo() == in_roll){
                signal= false;
            }
            else{
                signal= true;
            }
            flag = flag & signal;
        }
        if (flag){
            list.add(s);
            System.out.println("you have been succesfully registerd fto SPMS\nYour serial number is " + 
                              (list.size()-1)+"\nplease remember this for future purposes");
        }
        else{
            System.out.println("the roll number you are trying to use is already registered please try again");
        }
    }

    //this method have the mechanism to be run and interface to be displayed when the student chooses to login 
    @SuppressWarnings("resource")
    static void login(int ser_no, String password) throws ClassNotFoundException, IOException{
        //check if the entered password is correct for the entered serial number  
        //if correct password runs the following
        if(list.get(ser_no).getPassword().equals(password)){
            Boolean flag = true;
            Scanner sc = new Scanner(System.in);
            
            //used to keep infinite loop till the user wants to exit
            while(flag){
                //code for prompting the user for using available actions
                System.out.println("to see all your details press 1");
                System.out.println("to change your phone number press 2");
                System.out.println("to change your batch press 3");
                System.out.println("to set your tenth percentage press 4");
                System.out.println("to set your twelth percentage press 5");
                System.out.println("to set your CGPA press 6");
                System.out.println("to set number of backlogs press 7");
                System.out.println("to log out press 8");
                System.out.println("*".repeat(75));
                int input= sc.nextInt();
                sc.nextLine();

                //displays all the saved information till now
                if(input==1){
                    System.out.println(list.get(ser_no).toString());
                }

                //code to change the phone number
                else if(input== 2){
                    System.out.println("current phone number: "+list.get(ser_no).getphNo());
                    System.out.println("enter new phone number: ");
                    long newphone =sc.nextLong();
                    sc.nextLine();
                    Student s =list.get(ser_no);
                    s.setphNo(newphone);
                    list.set(ser_no, s);
                    System.out.println("phone Number changed");
                    System.out.println("*".repeat(75));
                }
               
                //code to change the batch
                else if(input== 3){
                    System.out.println("current batch: "+list.get(ser_no).getbatch());
                    System.out.println("enter new batch: ");
                    String newbatch =sc.nextLine();
                    Student s= list.get(ser_no);
                    s.setbatch(newbatch);
                    list.set(ser_no, s);
                    System.out.println("batch changed");
                    System.out.println("*".repeat(75));
                }

                //code to change the 10th percentage
                else if(input== 4){
                    System.out.println("current tenth percentage: "+list.get(ser_no).gettenthPercentage());
                    System.out.println("enter new tenth percentage: ");
                    Float newtenthpercentage =sc.nextFloat();
                    sc.nextLine();
                    Student s = list.get(ser_no);
                    s.settenthPercentage(newtenthpercentage);
                    list.set(ser_no, s);
                    System.out.println("tenth percentage changed");
                    System.out.println("*".repeat(75));
                }

                //code to change the 12th percentage
                else if(input== 5){
                    System.out.println("current twelth percentage: "+list.get(ser_no).gettwelthhPercentage());
                    System.out.println("enter new twelth percentage: ");
                    Float newtwelthpercentage =sc.nextFloat();
                    sc.nextLine();
                    Student s = list.get(ser_no);
                    s.settwelthPercentage(newtwelthpercentage);
                    list.set(ser_no, s);
                    System.out.println("twelth percentage changed");
                    System.out.println("*".repeat(75));
                }

                //code to change CGPA
                else if(input== 6){
                    System.out.println("current CGPA: "+list.get(ser_no).getCGPA());
                    System.out.println("enter new CGPA: ");
                    Float newCGPA =sc.nextFloat();
                    sc.nextLine();
                    Student s = list.get(ser_no);
                    s.setCGPA(newCGPA);
                    list.set(ser_no, s);
                    System.out.println("CGPA changed");
                    System.out.println("*".repeat(75));
                }

                //code to change the number of backlogs
                else if(input== 7){
                    System.out.println("current number of backlogs: "+list.get(ser_no).getnoOfBackLogs());
                    System.out.println("enter new number of backlogs: ");
                    int newbl =sc.nextInt();
                    sc.nextLine();
                    Student s = list.get(ser_no);
                    s.setBackLogs(newbl);
                    list.set(ser_no, s);
                    System.out.println("number of backlogs changed");
                    System.out.println("*".repeat(75));
                }

                //code to logout and exit the infinite loop
                else if(input== 8){
                    flag= false;
                    System.out.println("you have been logged out");
                    System.out.println("*".repeat(75));
                }
                
                //code when the user enters invalid action
                else{
                    System.out.println("invalid input recieved please try another input");
                }
            }
        }

        //code when the password is incorrect
        else{
            System.out.println("the serial number and password didnt match please try again");
            System.out.println("*".repeat(75));
        }
        
    }

    //code to null a student without completely deleting the object from the list so that the action
    //wont change the indexes of the succeeding objects 
    static void nullifyStudent(int i) throws ClassNotFoundException, IOException{
        Student s = new Student();
        list.set(i, s);
    }

    //this method is run when we want to sort the student objects in the list according to their attributes
    static ArrayList<Student> sort(Float tenthpercentage, float twelthPercentage,int noOfBackLogs,float CGPA) throws ClassNotFoundException, IOException{
        start();
        ArrayList<Student> req_student = new ArrayList<Student>();
        for (Student s : list){
            if(s.gettenthPercentage() >= tenthpercentage){
                if(s.gettwelthhPercentage()>=twelthPercentage){
                    if(s.getnoOfBackLogs()<=noOfBackLogs){
                        if(s.getCGPA()>=CGPA){
                            req_student.add(s);
                        }
                        else{}
                    }
                    else{}
                }
                else{}
            }
            else{}
        }
        return req_student;
    }

    //prints all the details of all the students in the list
    static void printList(ArrayList<Student> s){
        for(Student stu: s){
            System.out.println(stu.oneLineString());
        }
    }
}
