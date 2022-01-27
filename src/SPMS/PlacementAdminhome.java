package SPMS;

import java.io.IOException;
import java.util.Scanner;

// this class is for the interactive interface between a placement admin and the system
public class PlacementAdminhome {

    @SuppressWarnings("resource")
    //this is a static method this will run when the user is a placement admin
    public static void IAmPlacementAdmin() throws ClassNotFoundException, IOException{
        //open a scanner for taking input
        Scanner sc = new Scanner(System.in);

        PAR.start();
        // this method is to ready the placement admin register 
        
        //priompting the user and taking the input 
        System.out.println("Welcome to SPMS Placement Admin portal");
        System.out.println("enter \n1 to login or \n2 to register ");

        //denotes weather the user want to use the login or register methods in placement admin register
        int i2=sc.nextInt();
        sc.nextLine();

        // code when login is choosen and taking the parameters required for the method login in PAR
        if (i2==1) {

            //serial no
            System.out.println("please enter your SPMS serial number");
			int ent_serialNo= sc.nextInt();
            sc.nextLine();

            //password
			System.out.println("please enter password");
			String ent_password= sc.nextLine(); 
                
            //code for validating login
            PAR.login(ent_serialNo, ent_password);
                
        }


        // code when register is choosen and taking the parameters required for the method register in PAR
        else if (i2==2){
            //name
            System.out.println("*".repeat(75));
			System.out.println("please enter your name");
			String reg_name= sc.nextLine();

            //organisation name
            System.out.println("*".repeat(75));
			System.out.println("please enter your organisation name");
			String reg_organisation= sc.nextLine();

            //email
            System.out.println("*".repeat(75));
            System.out.println("please enter your email address");
			String reg_email = sc.nextLine();

            //phone
            System.out.println("*".repeat(75));
			System.out.println("please set your phone no");
			Long reg_phone= sc.nextLong();
            sc.nextLine();

            //password
            System.out.println("*".repeat(75));
			System.out.println("please set your password");
			String reg_password =sc.nextLine();

            PAR.register(new PlacementAdmin(reg_password, reg_phone, reg_email, reg_name, reg_organisation));
        }

        //runns when user didnt choose either of the valid options  
        else{
            System.out.println("invalid input recieved please try again");
        }

    }
}
