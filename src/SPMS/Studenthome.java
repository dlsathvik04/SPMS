package SPMS;

import java.io.IOException;
import java.util.Scanner;

public class Studenthome {
    public static void IAmStudent() throws ClassNotFoundException, IOException{
        Scanner sc = new Scanner(System.in);
        SR.start();
        System.out.println("Welcome to SPMS student portal");
        System.out.println("enter \n1 to login or \n2 to register ");
            
        //choosing the stream based on new or old user
        int i2=sc.nextInt();

        if (i2==1) {

            //serial no
            System.out.println("please enter your SPMS serial number");
			int ent_serialNo= sc.nextInt();
            sc.nextLine();

            //password
			System.out.println("please enter password");
			String ent_password= sc.nextLine(); 
                
            //code for validating login
            SR.login(ent_serialNo, ent_password);
                
        }
            
        //register
		if (i2==2){
            //roll number
            System.out.println("*".repeat(75));
            System.out.println("please enter your rollNo");
			int reg_roll= sc.nextInt();
            sc.nextLine();

            //name
            System.out.println("*".repeat(75));
			System.out.println("please enter your name");
			String reg_name= sc.nextLine();

            //batch
            System.out.println("*".repeat(75));
            System.out.println("please enter your batch eg: 21AIEB");
			String reg_batch = sc.nextLine();

            //phone
            System.out.println("*".repeat(75));
			System.out.println("please set your phone no");
			Long reg_phone= sc.nextLong();
            sc.nextLine();

            //password
            System.out.println("*".repeat(75));
			System.out.println("please set your password");
			String reg_password =sc.nextLine();

            //code for validating the registration
            System.out.println("*".repeat(75));
            Student s =  new Student(reg_phone, reg_roll, reg_name, reg_batch, reg_password);
            SR.register(s);
        }
        sc.close();	
    }
}
