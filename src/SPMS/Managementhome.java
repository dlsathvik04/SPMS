package SPMS;

import java.io.IOException;
import java.util.Scanner;

public class Managementhome {
    public static void IAmManagement() throws ClassNotFoundException, IOException{
        Management m = new Management();
        Scanner sc = new Scanner(System.in);
        String passcode = sc.nextLine();
        if(m.getCode().equals(passcode)){
            boolean flag = true;
            while(flag){
                System.out.println("to get the list of all the data enter 1");
                System.out.println("to remove a student from portal enter 2");
                System.out.println("to delete all the data of the registered students enter 3");
                System.out.println("to logout and exit enter 4");
                System.out.println("*".repeat(75));
                int in1= sc.nextInt();
                sc.nextLine();
                if(in1==1){
                    m.getAll();
                    System.out.println("*".repeat(75));
                }
                else if(in1==2){
                    System.out.println("enter the serial number of the student you want to remove: ");
                    int ind= sc.nextInt();
                    sc.nextLine();
                    m.nullStudent(ind);
                }
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
                else if(in1==4){
                    flag= false;
                    System.out.println("you have been logged out succesfully");
                    sc.close();
                }
            }
        }
        else{
            System.out.println("the passcode entered by you is incorrect please try again");
        }
    }
}
