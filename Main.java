import java.util.Scanner;

public class Main {

    static Student[] students = new Student[100];
    static int count = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {

                
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Age: ");
                int age = sc.nextInt();

                students[count] = new Student(id, name, age);
                count++;

                System.out.println("Student added successfully!");
            }

            else if (choice == 2) {

                
                if (count == 0) {
                    System.out.println("No students found.");
                } else {

                    System.out.println("\n----- Student List -----");

                    for (int i = 0; i < count; i++) {

                        System.out.println("Student " + (i + 1));
                        System.out.println("ID   : " + students[i].id);
                        System.out.println("Name : " + students[i].name);
                        System.out.println("Age  : " + students[i].age);
                        System.out.println("------------------------");
                    }
                }
            }

            else if (choice == 3) {

               
                System.out.print("Enter Student ID to Search: ");
                int searchId = sc.nextInt();

                boolean found = false;

                for (int i = 0; i < count; i++) {

                    if (students[i].id == searchId) {

                        System.out.println("\nStudent Found");
                        System.out.println("ID   : " + students[i].id);
                        System.out.println("Name : " + students[i].name);
                        System.out.println("Age  : " + students[i].age);

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student not found.");
                }
            }

            else if (choice == 4) {


                System.out.print("Enter Student ID to Update: ");
                int updateId = sc.nextInt();

                boolean found = false;

                for (int i = 0; i < count; i++) {

                    if (students[i].id == updateId) {

                        sc.nextLine();

                        System.out.print("Enter New Name: ");
                        students[i].name = sc.nextLine();

                        System.out.print("Enter New Age: ");
                        students[i].age = sc.nextInt();

                        System.out.println("Student updated successfully!");

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student not found.");
                }
            }

            else if (choice == 5) { 

                
                System.out.print("Enter Student ID to Delete: ");
                int deleteId = sc.nextInt();

                boolean found = false;

                for (int i = 0; i < count; i++) {

                    if (students[i].id == deleteId) {

                        for (int j = i; j < count - 1; j++) {
                            students[j] = students[j + 1];
                        }

                        students[count - 1] = null;
                        count--;

                        System.out.println("Student deleted successfully!");

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student not found.");
                }
            }

            else if (choice == 6) {

                System.out.println("Thank You!");
                break;
            }

            else {

                System.out.println("Invalid Choice!");
            }
        }

        sc.close();
    }
}