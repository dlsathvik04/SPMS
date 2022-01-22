package SPMS;

import java.io.IOException;
import java.util.Scanner;

import BufferList.GenericBufferList;

public class PAR {
    static GenericBufferList<PlacementAdmin> list;
    static void start() throws ClassNotFoundException, IOException{
        list = new GenericBufferList<PlacementAdmin>("PAR.ser");
    }

    static void register(PlacementAdmin p) throws ClassNotFoundException, IOException{
        Long in_phone = p.getPhone();
        String in_email = p.getEmail();
        boolean flag =  true;
        for (PlacementAdmin i: list){
            boolean signal;
            if (i.getPhone() == in_phone | i.getEmail() == in_email){
                signal= false;
            }
            else{
                signal= true;
            }
            flag = flag & signal;
        }
        if (flag){
            list.add(p);
            System.out.println("you have been succesfully registerd fto SPMS\nYour serial number is " + (list.size()-1)+"\nplease remember this for future purposes");
        }
        else{
            System.out.println("the email or phone number you entered is already in use please try again");
        }
    }

    static void login(int ser_no, String password) throws ClassNotFoundException, IOException{
        if(list.get(ser_no).getPassword().equals(password)){
            Boolean flag = true;
            Scanner sc = new Scanner(System.in);
            while(flag){
                System.out.println("to see all your details press 1");
                System.out.println("to start the sorting process please enter 2");
                System.out.println("to log out enter 3");
                System.out.println("*".repeat(75));
                int input= sc.nextInt();
                sc.nextLine();
                if(input==1){
                    System.out.println(list.get(ser_no).toString());
                }
                else if(input== 2){
                    System.out.println("please enter minimum tenth percentage ");
                    Float req_tenthpercent =sc.nextFloat();
                    sc.nextLine();
                    System.out.println("please enter minimum twelth percentage ");
                    Float req_twelthpercent =sc.nextFloat();
                    sc.nextLine();
                    System.out.println("please enter maximum number of backlogs ");
                    int req_backlogs =sc.nextInt();
                    sc.nextLine();
                    System.out.println("please enter minimum CGPA ");
                    Float req_CGPA =sc.nextFloat();
                    sc.nextLine();
                    System.out.println("*".repeat(75));

                    for(Student s : SR.sort(req_tenthpercent, req_twelthpercent, req_backlogs, req_CGPA)){
                        System.out.println(s.oneLineString());
                    }
                }
                else if(input== 3){
                    flag= false;
                    sc.close();
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
}
