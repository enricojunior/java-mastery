import java.util.*;
import java.util.stream.*;
import java.time.LocalDate;

public class SchoolHELPSystem {
    private static SchoolHELP SchoolHELP = new SchoolHELP(); 
    private static User loggedUser = null;

    public static School registerSchool(){
        while(true){
            try {
                String schoolName, schoolAddress, schoolCity;

                System.out.print("Enter the school's name: ");
                schoolName = (System.console().readLine());
                System.out.print("Enter the school's address: ");
                schoolAddress = (System.console().readLine());
                System.out.print("Enter the school's city: ");
                schoolCity = (System.console().readLine());

                if(SchoolHELP.getSchoolList().stream().anyMatch(e -> e.getSchoolName().equals(schoolName))){
                    System.out.println("\nSorry. This school has been registered to the system.\n");    
                } else {
                    School newSchool = new School(schoolName, schoolAddress, schoolCity);
                    System.out.println("\nSuccessfully registered a new school.");
                    Stream.of("\nDetails of the registered school: ",
                          "Registered School's Name:\t" + newSchool.getSchoolName(),
                          "Registered School's ID:\t\t" + newSchool.getSchoolID(),
                          "Registered School's Address:\t" + newSchool.getAddress(),
                          "Registered School's City:\t" + newSchool.getCity() + "\n").forEach(System.out::println);
                    return newSchool;
                }
            } catch(Exception e){
                System.out.println("ALERT: " + e.getMessage());
            }
        }
    }
    private static SchoolAdmin registerSchoolAdmin(School school){
        while(true){
            try {
                String username, password, fullname, email, phone, position;
                int staffID;

                System.out.print("Enter the new school administrator's username: ");
                username = (System.console().readLine());
                System.out.print("Enter the new school administrator's password: ");
                password = (System.console().readLine());
                System.out.print("Enter the new school administrator's full name: ");
                fullname = (System.console().readLine());
                System.out.print("Enter the new school administrator's email: ");
                email = (System.console().readLine());
                System.out.print("Enter the new school administrator's phone number: ");
                phone = (System.console().readLine());
                System.out.print("Enter the new school administrator's staff ID: ");
                staffID = Integer.parseInt((System.console().readLine()));
                System.out.print("Enter the new school administrator's phone position: ");
                position = (System.console().readLine());
                
                if(SchoolHELP.getSchoolAdminList().stream().anyMatch(e -> e.getUsername().equals(username) && e.getEmail().equals(email) && e.getStaffID() == staffID)){
                    System.out.println("\nSorry. The school administrator's data has already been taken.\n");
                } else {
                    SchoolAdmin schoolAdmin = new SchoolAdmin(username, password, fullname, email, phone, staffID, position, school);
                    System.out.println("\nSuccessfully registered a new school administrator.");
                    Stream.of("\nNew School Administrator's credentials: ",
                          "Username: " + schoolAdmin.getUsername(),
                          "Password: " + schoolAdmin.getPassword()).forEach(System.out::println);
                    return schoolAdmin;
                }
            } catch(Exception e){
                System.out.println("ALERT: " + e.getMessage());
            }
        }
    }
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

                        System.out.print("School Administrator's username: ");
                        adminInputUsername = (System.console().readLine());
                        System.out.print("School Administrator's password: ");
                        adminInputPassword = (System.console().readLine());

                        if(adminInputUsername.equals(adminUsername) && adminInputPassword.equals(adminPassword)){
                            System.out.println("\n\nWelcome onboard! School Administrator.");
                            SchoolAdminMenu();
                        } else {
                            System.out.println("\n\nALERT: Invalid username or password.");
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
    public static void SchoolAdminMenu(){
        int schoolAdminOpt = -1;

        while(true){
            generateSchoolAdminMenu();
            try {
                System.out.print("Option: ");
                schoolAdminOpt = Integer.parseInt(System.console().readLine());

                switch(schoolAdminOpt){
                    case 1:
                        try {
                            School newSchool = registerSchool();
                            SchoolHELP.addSchool(newSchool);
                            SchoolAdmin newSchoolAdmin = registerSchoolAdmin(newSchool);
                            SchoolHELP.addUser(newSchoolAdmin);
                        } catch(Exception e){
                            System.out.println("\nALERT: " + e.getMessage());
                        }
                        break;
                    case 0:
                        System.out.println("Logging out as School Administrator.\n\n");
                        main(null);
                        break;
                    default:
                        System.out.println("ALERT: Invalid input. Please try again.\n\n");
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
    public static void generateSchoolAdminMenu(){
        Stream.of("School Administrator's Home Page",
                  "------------------------------------",
                  "[1] Register School",
                  "[2] Register School Administrator\n",
                  "[0] Log Out").forEach(System.out::println);
    }
}