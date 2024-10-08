import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);  
        System.out.println("************* Welcome To XYZ Bank **************");
        System.out.print("1. Sign in\nNew User??\n2. Register\n");
        
        if (sc.hasNextInt()) {
            int choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                boolean login=User.signIn();
                    if (login) {
                        //boolean exit = false;
                        System.out.println("1. Withdrawal\n2. Credit\n3. Balance\n4. Transfer\n5. Change Pin\n6. Print Mini Statement\n7. Exit");
                        int number = sc.nextInt();

                        while (number!=7) {
                            System.out.println("1. Withdrawal\n2. Credit\n3. Balance\n4. Transfer\n5. Change Pin\n6. Print Mini Statement\n7. Exit");
                            System.out.print("Enter your choice: ");
                            
                            /*if (sc.hasNextInt()) {  
                                 number = sc.nextInt();

                            } else {
                             number=2;
                            }*/

                            switch (number) {
                                case 1:
                                    User.withdraw(); 
                                    break;
                                case 2:
                                    User.credit(); 
                                    break;
                                case 3:
                                    File f = new File("./ACCOUNTS/" + User.acc + "/balance.csv");
                                    System.out.println("Your current balance is: " + User.getBalance(f));
                                    break;
                                case 4:
                                    User.sendMoney();  
                                    break;
                                case 5:
                                    System.out.println("Enter your previous password: ");
                                    String oldpass = sc.nextLine();
                                    System.out.println("Enter new password: ");
                                    String newpass = sc.nextLine();
                                    boolean isPinChanged = User.changePin(User.acc, oldpass, newpass);
                                    if (isPinChanged) {
                                        System.out.println("PIN changed successfully.");
                                    } else {
                                        System.out.println("Failed to change PIN.");
                                    }
                                    break;
                                case 6:
                                    User.printTransaction();  
                                    break;
                                /*case 7:
                                    exit = true;  
                                    System.out.println("Thank you for banking with XYZ Bank.");
                                    break;*/
                                default:
                                    System.out.println("Invalid choice! Please try again.");
                            }
                        }
                    } else {
                        System.out.println("You entered the wrong account number or password.");
                    }
                    break;

                case 2:
                    System.out.println("Enter your age: ");
                    int age = sc.nextInt();
                    sc.nextLine();  

                    System.out.println("Enter your Name: ");
                    String Name = sc.nextLine();

                    System.out.println("Enter your Aadhaar Number: ");
                    String aadhaar = sc.nextLine();

                    System.out.println("Enter your Email: ");
                    String email = sc.nextLine();

                    System.out.println("Enter your Phone Number: ");
                    String phno = sc.nextLine();

                    String pan = "";
                    if (age >= 18) {
                        System.out.println("Enter Permanent Account Number (PAN): ");
                        pan = sc.nextLine();
                    }

                    System.out.println("Set a Password for your Account: ");
                    String pass = sc.nextLine();

                    System.out.println("Confirm your Password: ");
                    String confirmPass = sc.nextLine();

                    if (pass.equals(confirmPass)) {
                        Registration.createAccount(Name, aadhaar, email, phno, pan);
                        Registration.setPin(confirmPass);
                        System.out.println("Account created successfully!");
                    } else {
                        System.out.println("Passwords do not match. Please try again.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } else {
            System.out.println("Invalid input! Please enter a number.");
        }
        
        sc.close();  
    }
}

