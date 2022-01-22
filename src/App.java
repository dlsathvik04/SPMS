import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        boolean flag = true;
        System.out.println("Welcome to Student Placement Management System");
        Scanner appread = new Scanner(System.in);
        while (flag){
            System.out.println("-".repeat(75));
            System.out.println("enter \n1 if you are a student \n2 if your a placement administrator \n3 if you are college management \n4 to exit");
            System.out.println("-".repeat(75));
            int inp =appread.nextInt();
            if (inp==1){
                try {
                    SPMS.Studenthome.IAmStudent();
                } catch (ClassNotFoundException | IOException e) {
                    System.out.println("some error occured please try again");
                } catch (IndexOutOfBoundsException s){
                    System.out.println("invalid serial number recieved");
                }
            }
            else if (inp==2){
                try {
                    SPMS.PlacementAdminhome.IAmPlacementAdmin();
                } catch (ClassNotFoundException | IOException e) {
                    System.out.println("some error occured please try again");
                } catch (IndexOutOfBoundsException s){
                    System.out.println("invalid serial number recieved");
                }
            }
            else if (inp==3){
                try {
                    SPMS.Managementhome.IAmManagement();
                } catch (ClassNotFoundException | IOException e) {
                    System.out.println("some error occured please try again");
                }
            }
            else if (inp==4){
                flag= false;
                appread.close();
            }
            else{
                System.out.println("invalid input please try again");
            }
        }
    }
}
