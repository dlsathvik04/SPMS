package SPMS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import BufferList.*;

public class SR {
    static GenericBufferList<Student> list;
    static void start() throws ClassNotFoundException, IOException{
        list = new GenericBufferList<Student>("SR.ser");
    }

    static void register(Student s) throws ClassNotFoundException, IOException{
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
            System.out.println("you have been succesfully registerd fto SPMS\nYour serial number is " + (list.size()-1)+"\nplease remember this for future purposes");
        }
        else{
            System.out.println("the roll number you are trying to use is already registered please try again");
        }
    }

    @SuppressWarnings("resource")
    static void login(int ser_no, String password) throws ClassNotFoundException, IOException{
        if(list.get(ser_no).getPassword().equals(password)){
            Boolean flag = true;
            Scanner sc = new Scanner(System.in);
            while(flag){
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
                if(input==1){
                    System.out.println(list.get(ser_no).toString());
                }
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
                else if(input== 8){
                    flag= false;
                    System.out.println("you have been logged out");
                    System.out.println("*".repeat(75));
                }
                else{
                    System.out.println("invalid input recieved please try another input");
                }
            }
        }
        else{
            System.out.println("the serial number and password didnt match please try again");
            System.out.println("*".repeat(75));
        }
        
    }

    static void nullifyStudent(int i) throws ClassNotFoundException, IOException{
        Student s = new Student();
        list.set(i, s);
    }

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

    static void printList(ArrayList<Student> s){
        for(Student stu: s){
            System.out.println(stu.oneLineString());
        }
    }
}
