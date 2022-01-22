package SPMS;

import java.io.IOException;
import java.util.Scanner;

public class PlacementAdminhome {
    public static void IAmPlacementAdmin() throws ClassNotFoundException, IOException{
        Scanner sc = new Scanner(System.in);
        PAR.start();
        System.out.println("Welcome to SPMS Placement Admin portal");
        System.out.println("enter \n1 to login or \n2 to register ");
        int i2=sc.nextInt();
        sc.nextLine();

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

        //String Organisation

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

        else{
            System.out.println("invalid input recieved please try again");
        }

        sc.close();
    }
}
