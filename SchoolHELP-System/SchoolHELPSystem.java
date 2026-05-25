import java.util.*;
import java.util.stream.*;
import java.time.LocalDate;

public class SchoolHELPSystem {
    // Init the var first, will be using it for later on.
    private static SchoolHELP SchoolHELP = new SchoolHELP(); 
    private static User loggedUser = null;

    public static void main(String args[]){
        int userOpt = -1;

        while(true){
            generateOnboarding();
            try {
                System.out.print("Option: ");
                userOpt = Integer.parseInt(System.console().readLine());

                switch(userOpt){
                    case 1:
                        // Hardcode the credentials
                        String adminUsername = "admin", adminPassword = "admin123", adminInputUsername, adminInputPassword;
                        System.out.println("Logging in as SchoolHELP Admin.\n");

                        System.out.print("SchoolHELP administrator's username: ");
                        adminInputUsername = (System.console().readLine());
                        System.out.print("SchoolHELP administrator's password: ");
                        adminInputPassword = (System.console().readLine());

                        if(adminInputUsername.equals(adminUsername) && adminInputPassword.equals(adminInputPassword)){
                            System.out.println("\n\nWelcome onboard! SchoolHELP Administrator.");
                            SchoolHELPAdminMenu();
                        } else {
                            System.out.println("ALERT: Invalid username or password.");
                        }
                        break;
                    case 2:
                        System.out.println("Logging in as SchoolHELP Administrator.\n");
                        break;
                    case 0:
                        Stream.of("SYSTEM: Exiting program.", 
                                  "Thank you and have a nice day.").forEach(System.out::println);
                        System.exit(0);
                        break;
                    default:
                        System.out.println("ALERT: Invalid input. Please try again.");
                        break;
                }
            } catch(Exception e){
                System.out.println("\n\nALERT: " + e.getMessage());
                main(null);
            }
        }
    }
    public static void SchoolHELPAdminMenu(){
        int schoolAdminOpt = -1;

        while(true){
            generateSchoolHELPAdminMenu();
            try {
                System.out.print("Option: ");
                schoolAdminOpt = Integer.parseInt(System.console().readLine());

                switch(schoolAdminOpt){
                    case 0:
                        System.out.println("Logging out as SchoolHELP Administrator.\n\n");
                        main(null);
                        break;
                    default:
                        System.out.println("ALERT: Invalid input. Please try again.");
                        break;
                }
            } catch(Exception e){
                System.out.println("\n\nALERT: " + e.getMessage());
            }
        }
    }
    public static void generateOnboarding(){
        Stream.of("SchoolHELP System", 
                  "-----------------",
                  "Welcome to the SchoolHELP System\n",
                  "[1] Login as SchoolHELP Admin",
                  "[2] Login as School Administrator\n",
                  "[0] Exit Program").forEach(System.out::println);
    }
    public static void generateSchoolHELPAdminMenu(){
        Stream.of("SchoolHELP Administrator's Home Page",
                  "------------------------------------",
                  "[1] Register School",
                  "[2] Register School Administrator\n",
                  "[0] Log Out").forEach(System.out::println);
    }
}