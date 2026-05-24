import java.util.*;
import java.util.stream.*;

public class SchoolHELPSystem {
    /* private static SchoolHELP SchoolHELP = new SchoolHELP(); */

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
                        System.out.println("ALERT: Your input is invalid. Try again.");
                        break;
                }
            } catch(Exception e){
                System.out.println("\n\nALERT: " + e.getMessage());
                main(null);
            }
        }
    }
    public static void generateOnboarding(){
        Stream.of("SchoolHELP System", 
                  "-----------------",
                  "Welcome to the SchoolHELP System\n",
                  "[1] Login as SchoolHELP Admin",
                  "[2] Login as SchoolHELP Administrator\n",
                  "[0] Exit Program").forEach(System.out::println);
    }
}