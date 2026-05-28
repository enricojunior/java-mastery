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
                    System.out.println("\nThis school has been registered to the system.");  
                    System.out.println("Skipping to the school administrator's registration.\n");
                    School findSchool = SchoolHELP.findSchoolByName(schoolName);
                    return findSchool;  
                } else {
                    School newSchool = new School(schoolName, schoolAddress, schoolCity);
                    System.out.println("\nSuccessfully registered a new school.");
                    Stream.of("\nDetails of the registered school: ",
                          "Registered School's Name\t:" + newSchool.getSchoolName(),
                          "Registered School's ID\t\t:" + newSchool.getSchoolID(),
                          "Registered School's Address\t:" + newSchool.getAddress(),
                          "Registered School's City\t:" + newSchool.getCity() + "\n").forEach(System.out::println);
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
                System.out.print("Enter the new school administrator's position: ");
                position = (System.console().readLine());
                
                if(SchoolHELP.getSchoolAdminList().stream().anyMatch(e -> e.getUsername().equals(username) && e.getEmail().equals(email) && e.getStaffID() == staffID)){
                    System.out.println("\nSorry. The school administrator's data has already been taken.\n");
                } else {
                    SchoolAdmin schoolAdmin = new SchoolAdmin(username, password, fullname, email, phone, staffID, position, school);
                    System.out.println("\nSuccessfully registered a new school administrator.");
                    Stream.of("\nNew School Administrator's credentials: ",
                          "Username: " + schoolAdmin.getUsername(),
                          "Password: " + schoolAdmin.getPassword() + "\n").forEach(System.out::println);
                    return schoolAdmin;
                }
            } catch(Exception e){
                System.out.println("ALERT: " + e.getMessage());
            }
        }
    }
    private static SchoolAdmin schoolAdminChangePassword(SchoolAdmin schoolAdmin){
        while(true){
            try {
                String oldPassword, newPassword, confirmNewPassword;

                System.out.print("Enter the current password: ");
                oldPassword = (System.console().readLine());
                if(schoolAdmin.getPassword().equals(oldPassword)){
                    while(schoolAdmin.getPassword().equals(oldPassword)){
                        System.out.print("Enter the new password: ");
                        newPassword = (System.console().readLine());
                        System.out.print("Confirm the new password: ");
                        confirmNewPassword = (System.console().readLine());
                        
                        if(newPassword.equals(confirmNewPassword)){
                            System.out.println("\nSuccessfully changed the password.");
                            schoolAdmin.setPassword(newPassword);
                            return schoolAdmin;
                        } else {
                            System.out.println("ALERT: New Password and Confirmed New Password do not match. Try again.\n");
                        }
                    }
                } else { 
                    System.out.println("ALERT: Incorrect current password. Please try again.\n");
                }
            } catch(Exception e){
                System.out.println("ALERT: " + e.getMessage());
            }
        }
    }
    private static SchoolAdmin schoolAdminUpdateProfile(SchoolAdmin schoolAdmin){
        while(true){
            try {
                String ufullName, uemail, uphone, uposition;
                int ustaffID;

                System.out.print("Enter to update the administrator's full name: ");
                ufullName = (System.console().readLine());
                System.out.print("Enter to update the administrator's email: ");
                uemail = (System.console().readLine());
                System.out.print("Enter to update the administrator's phone number: ");
                uphone = (System.console().readLine());
                System.out.print("Enter to update the administrator's staff ID: ");
                ustaffID = Integer.parseInt((System.console().readLine()));
                System.out.print("Enter to update the administrator's position: ");
                uposition = (System.console().readLine());

                System.out.println("Successfully updated the administrator's profile.\n");
                schoolAdmin.setfullName(ufullName);
                schoolAdmin.setEmail(uemail);
                schoolAdmin.setPhone(uphone);
                schoolAdmin.setStaffID(ustaffID);
                schoolAdmin.setPosition(uposition);
                return schoolAdmin;
            } catch(Exception e){
                System.out.println("ALERT: " + e.getMessage());
            }
        }
    }
    private static TutorialRequest submitTutorialRequest(School school){
        while(true){
            try {
                System.out.print("\nSubmitting a Tutorial Request.\n");
                String description, proposedDate, proposedTime;
                int studentLevel, numStudents;

                System.out.print("Enter the tutorial request's description: ");
                description = (System.console().readLine());
                System.out.print("Enter the tutorial request's proposed date (Format dd-mm-yyyy): ");
                proposedDate = (System.console().readLine());
                System.out.print("Enter the tutorial request's proposed time (Format hh:mm): ");
                proposedTime = (System.console().readLine());
                System.out.print("Enter the tutorial request's student level: ");
                studentLevel = Integer.parseInt(System.console().readLine());
                System.out.print("Enter the tutorial request's number of students: ");
                numStudents = Integer.parseInt(System.console().readLine());

                LocalDate tutorialRequestDate = LocalDate.now();
                System.out.println("Successfully added new tutorial request.\n");
                TutorialRequest tutorialRequest = new TutorialRequest(tutorialRequestDate, description, school, proposedDate, proposedTime, studentLevel, numStudents);
                return tutorialRequest;
            } catch(Exception e){
                System.out.println("ALERT: " + e.getMessage());
            }
        }
    }
    private static ResourceRequest submitResourceRequest(School school){
        while(true){
            try {
                System.out.print("\nSubmitting a Resource Request.\n");
                String description, resourceType;
                int numRequired;

                System.out.print("Enter the resource request's description: ");
                description = (System.console().readLine());
                System.out.print("Enter the resource's type ('M'obile device, 'P'ersonal computer, 'N'etworking equipment): ");
                resourceType = (System.console().readLine());
                System.out.print("Enter the number required for the specified resource request: ");
                numRequired = Integer.parseInt(System.console().readLine());

                LocalDate resourceRequestDate = LocalDate.now();
                System.out.print("Successfully added new resource request.\n");
                ResourceRequest resourceRequest = new ResourceRequest(resourceRequestDate, description, school, resourceType, numRequired);
                resourceRequest.setResourceType(checkResourceType(resourceType));
                return resourceRequest;
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

                        System.out.print("SchoolHELP Admin's username: ");
                        adminInputUsername = (System.console().readLine());
                        System.out.print("SchoolHELP Admin's password: ");
                        adminInputPassword = (System.console().readLine());

                        if(adminInputUsername.equals(adminUsername) && adminInputPassword.equals(adminPassword)){
                            System.out.println("\n\nWelcome onboard! SchoolHELP Admin.");
                            SchoolHELPAdminMenu();
                        } else {
                            System.out.println("\n\nALERT: Invalid username or password.");
                        }
                        break;
                    case 2:
                        // Prepare the credentials
                        String schoolAdminUsername, schoolAdminPassword;
                        System.out.println("Logging in as SchoolHELP Administrator.\n");

                        System.out.print("School Administrator's username: ");
                        schoolAdminUsername = (System.console().readLine());
                        System.out.print("School Administrator's password: ");
                        schoolAdminPassword = (System.console().readLine());

                        if(SchoolHELP.isUserSchoolAdmin(schoolAdminUsername, schoolAdminPassword)){
                            loggedUser = SchoolHELP.getUser(schoolAdminUsername, schoolAdminPassword);
                            System.out.println("\n\nWelcome onboard. School Administrator.");
                            SchoolAdministratorMenu();
                        } else {
                            System.out.println("\n\nALERT: Invalid username or password.");
                        }
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
                    case 1:
                        try {
                            School newSchool = registerSchool();
                            if(!(SchoolHELP.isSchoolRegistered(newSchool.getSchoolName()))){
                                SchoolHELP.addSchool(newSchool);
                            } 
                            SchoolAdmin newSchoolAdmin = registerSchoolAdmin(newSchool);
                            SchoolHELP.addUser(newSchoolAdmin);
                        } catch(Exception e){
                            System.out.println("\nALERT: " + e.getMessage());
                        }
                        break;
                    case 0:
                        System.out.println("Logging out as SchoolHELP Admin.\n\n");
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
    public static void SchoolAdministratorMenu(){
        int schoolAdministratorOpt = -1;
        SchoolAdmin loggedSchoolAdmin = ((SchoolAdmin) loggedUser);
        School thisSchool = loggedSchoolAdmin.getSchool();

        while(true){
            generateSchoolAdministratorMenu(loggedSchoolAdmin);
            try {
                System.out.print("Option: ");
                schoolAdministratorOpt = Integer.parseInt(System.console().readLine());

                switch(schoolAdministratorOpt){
                    case 1:
                        System.out.println("Setting up a new password.\n");
                        SchoolAdmin schoolAdmin = schoolAdminChangePassword(loggedSchoolAdmin);
                        break;
                    case 2:
                        System.out.println("Updating school administrator's profile.\n");
                        SchoolAdmin schooladmin = schoolAdminUpdateProfile(loggedSchoolAdmin);
                        break;
                    case 3:
                        int submitChoice = -1;
                        System.out.println("Submitting a request for assistance.\n");
                        generateRequestMenu();
                        System.out.print("\nSelect the request type: ");
                        submitChoice = Integer.parseInt(System.console().readLine());

                        switch(submitChoice){
                            case 1:
                                TutorialRequest tutorialRequest = submitTutorialRequest(loggedSchoolAdmin.getSchool());
                                thisSchool.addRequest(tutorialRequest);
                                break;
                            case 2:
                                ResourceRequest resourceRequest = submitResourceRequest(loggedSchoolAdmin.getSchool());
                                thisSchool.addRequest(resourceRequest);
                                break;
                            default:
                                System.out.println("ALERT: Invalid request selection.");
                                SchoolAdministratorMenu();
                                break;
                        }                        
                        break;
                    case 0:
                        System.out.println("Logging out as School Administrator.\n\n");
                        main(null);
                        break;
                    default:
                        System.out.println("ALERT: Invalid input. Please try again.\n");
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
        Stream.of("SchoolHELP Admin's Home Page",
                  "----------------------------",
                  "[1] Register School and Administrator\n",
                  "[0] Log Out").forEach(System.out::println);
    }
    public static void generateSchoolAdministratorMenu(SchoolAdmin schoolAdmin){
        Stream.of("School Administrator's Home Page",
                  "--------------------------------",       
                  "Login as: " + schoolAdmin.getfullName() + ". Position: " + schoolAdmin.getPosition() + ".",
                  "School ID\t: " + schoolAdmin.getSchool().getSchoolID() + ".",
                  "School Name\t: " + schoolAdmin.getSchool().getSchoolName() + ".",
                  "--------------------------------",
                  "[1] Change Password",
                  "[2] Update Profile",
                  "[3] Submit Request For Assistance\n",
                  "[0] Log Out").forEach(System.out::println);
    }
    public static void generateRequestMenu(){
        Stream.of("Submit Request Category",
                  "-----------------------",
                  "[1] Tutorial Request",
                  "[2] Resource Request",
                  "-----------------------").forEach(System.out::println);
    }
    public static String checkResourceType(String resourceType){
        if(resourceType.equalsIgnoreCase("m")){
            return "Mobile Device"; 
        } else if(resourceType.equalsIgnoreCase("p")){
            return "Personal Computer";
        } else if(resourceType.equalsIgnoreCase("n")){
            return "Networking Equipment";
        } else {
            return "Invalid Resource";
        }
    }
}