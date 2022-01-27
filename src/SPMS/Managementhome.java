package SPMS;

import java.io.IOException;
import java.util.Scanner;

//this class is for the interactive interface between a student and the system
public class Managementhome {

    //this is a static method this will run when the user is a placement admin
    public static void IAmManagement() throws ClassNotFoundException, IOException{
        //create an object for management class
        Management m = new Management();

        //open a scanner for taking input
        Scanner sc = new Scanner(System.in);

        //take the entered passcode and verify it
        String passcode = sc.nextLine();

        //runs when the passcode is correct
        if(m.getCode().equals(passcode)){
            boolean flag = true;
            
            //used to keep infinite loop til the user wants to exit
            while(flag){
                
                //prompting user for different actions
                System.out.println("to get the list of all the data enter 1");
                System.out.println("to remove a student from portal enter 2");
                System.out.println("to delete all the data of the registered students enter 3");
                System.out.println("to logout and exit enter 4");
                System.out.println("*".repeat(75));
                int in1= sc.nextInt();
                sc.nextLine();

                //code to print all the data of registered student
                if(in1==1){
                    m.getAll();
                    System.out.println("*".repeat(75));
                }

                //code for nulling a student
                else if(in1==2){
                    System.out.println("enter the serial number of the student you want to remove: ");
                    int ind= sc.nextInt();
                    sc.nextLine();
                    m.nullStudent(ind);
                }

                //code for resetting the application
                else if(in1==3){
                    System.out.println("if you really want to delete all the data enter 'YES': ");
                    String res = sc.nextLine();
                    if (res.equals("YES")){
                        m.reset();
                    }
                    else{
                        System.out.println("operation cancelled");
                    }

                }

                //code for logging out
                else if(in1==4){
                    flag= false;
                    System.out.println("you have been logged out succesfully");
                    sc.close();
                }

                else{
                    System.out.println("invalid action try again");
                }
            }
        }
        else{
            System.out.println("the passcode entered by you is incorrect please try again");
        }
    }
}
