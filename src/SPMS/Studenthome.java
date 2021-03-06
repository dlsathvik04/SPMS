package SPMS;

import java.io.IOException;
import java.util.Scanner;

//this class is for the interactive interface between a student and the system
public class Studenthome {
    
    @SuppressWarnings("resource")
    //this is a static method this will run when the user is a placement admin
    public static void IAmStudent() throws ClassNotFoundException, IOException{
        //open a scanner for taking input
        Scanner sc2 = new Scanner(System.in);
        
        SR.start();
        //this method is to ready the student register
        
        //priompting the user and taking the input 
        System.out.println("Welcome to SPMS student portal");
        System.out.println("enter \n1 to login or \n2 to register ");
            
        //choosing the stream based on new or old user
        int i2=sc2.nextInt();

        // code when login is choosen and taking the parameters required for the method login in SR
        if (i2==1) {

            //serial no
            System.out.println("please enter your SPMS serial number");
			int ent_serialNo= sc2.nextInt();
            sc2.nextLine();

            //password
			System.out.println("please enter password");
			String ent_password= sc2.nextLine(); 
                
            //code for validating login
            SR.login(ent_serialNo, ent_password);
                
        }
            
        // code when register is choosen and taking the parameters required for the method register in SR
		else if (i2==2){
            //roll number
            System.out.println("*".repeat(75));
            System.out.println("please enter your rollNo");
			int reg_roll= sc2.nextInt();
            sc2.nextLine();

            //name
            System.out.println("*".repeat(75));
			System.out.println("please enter your name");
			String reg_name= sc2.nextLine();

            //batch
            System.out.println("*".repeat(75));
            System.out.println("please enter your batch eg: 21AIEB");
			String reg_batch = sc2.nextLine();

            //phone
            System.out.println("*".repeat(75));
			System.out.println("please set your phone no");
			Long reg_phone= sc2.nextLong();
            sc2.nextLine();

            //password
            System.out.println("*".repeat(75));
			System.out.println("please set your password");
			String reg_password =sc2.nextLine();

            //code for validating the registration
            System.out.println("*".repeat(75));
            Student s =  new Student(reg_phone, reg_roll, reg_name, reg_batch, reg_password);
            SR.register(s);
        }

        //dcode when user enters invalid action
        else{
            System.out.println("invalid input recieved please try again");
        }	
    }
}
