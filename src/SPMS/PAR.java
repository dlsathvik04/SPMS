package SPMS;

import java.io.IOException;
import java.util.Scanner;

import BufferList.GenericBufferList;
//BufferList is a self written package whic works with the isea of lists
//which wont loose data when the program is terminated

//this class PAR acts as a type of data register and manager for all the placement admin users
public class PAR {
    //this list acts as a storage for all the PlacementAdmin objects created
    //this GenericBufferList is a generic datatype defined in BufferList package
    static GenericBufferList<PlacementAdmin> list;
    
    //this method initiates the list
    static void start() throws ClassNotFoundException, IOException{
        list = new GenericBufferList<PlacementAdmin>("PAR.ser");
        // PAR.ser denotes the file name in which the data is stored when the 
        //programme is terminated
    }

     //this method have the mechanism to be run and interface to be displayed when the placement admin chooses to register
    static void register(PlacementAdmin p) throws ClassNotFoundException, IOException{

        //taking the phone number with which the user want to register and checks weather 
        //it is already used or not. if the entered phone number is valid then adds the PlacementAdmin to the list
        //then gives the user an unique nuber which is used when logging in
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


    //this method have the mechanism to be run and interface to be displayed when the user chooses to login 
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
                System.out.println("to start the sorting process please enter 2");
                System.out.println("to log out enter 3");
                System.out.println("*".repeat(75));
                int input= sc.nextInt();
                sc.nextLine();

                //displays all the saved information till now
                if(input==1){
                    System.out.println(list.get(ser_no).toString());
                }

                //code to sort the students
                else if(input== 2){
                    //taking required inputs for the sorting process
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

                    //for(Student s : SR.sort(req_tenthpercent, req_twelthpercent, req_backlogs, req_CGPA)){
                       // System.out.println(s.oneLineString());
                    //}
                    
                    SR.printList(SR.sort(req_tenthpercent, req_twelthpercent, req_backlogs, req_CGPA));

                }

                //code to logout and exit the infinite loop
                else if(input== 3){
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
}
