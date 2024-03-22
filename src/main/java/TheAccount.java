import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class TheAccount {
    class Settings implements AccountManagement {

        int validate;

        private List<UUID> UUIDlist; // assuming this list is defined in another class and accessible

        // Constructor to initialize UUIDlist
        public Settings() {
            this.UUIDlist = UUIDlist;
        }

        public void validateUsername(UUID username1, UUID username2, UUID Username, int hash1, int hash2) throws NoSuchMethodException {
            while (true) {

                if (Main.str.equals("assistant") || Main.str.equals("Assistant")) {
                    if (Username.equals(username1)) {
                        Assistant theAssistant = new Assistant();
                        theAssistant.password(Main.str);
                        break;
                    } else if (Username.equals(username2)) {
                        Assistant theAssistant = new Assistant();
                        theAssistant.password(Main.str);
                        break;
                    } else {
                        System.out.println("Invalid username");
                        Assistant theAssistant = new Assistant();
                        theAssistant.username(Main.str);
                        break;
                    }
                }

                if (Main.str.equals("student") || Main.str.equals("Student")) {
                    if (Username.equals(username1)) {
                        Student theStudent = new Student(Main.str);
                        theStudent.password(Main.str);
                        break;
                    } else if (Username.equals(username2)) {
                        Student theStudent = new Student(Main.str);
                        theStudent.password(Main.str);
                        break;
                    } else {
                        System.out.println("Invalid username");
                        Student theStudent = new Student(Main.str);
                        theStudent.password(Main.str);
                        break;
                    }
                }

                if (Main.str.equals("teacher") || Main.str.equals("Teacher")) {
                    if (Username.equals(username1)) {
                        Teacher theTeacher = new Teacher();
                        theTeacher.password(Main.str);
                        break;
                    } else if (Username.equals(username2)) {
                        Teacher theTeacher = new Teacher();
                        theTeacher.password(Main.str);
                        break;
                    } else {
                        System.out.println("Invalid username");
                        Teacher theTeacher = new Teacher();
                        theTeacher.password(Main.str);
                        break;
                    }
                }
            }
        }

        public boolean validatePassword(UUID username1, UUID username2, UUID Username, String passCode, String str, int hash1, int hash2) throws NoSuchMethodException {
            validate = passCode.hashCode();

            if (Main.str.equals("assistant") || Main.str.equals("Assistant")) {
                if (Username.equals(username1)) {
                    if (hash1 == validate) {
                        Assistant.assistant();
                        return true;
                    } else {
                        System.out.println("Invalid password. Please try again.");
                        Assistant theAssistant = new Assistant();
                        theAssistant.password(Main.str);
                        return false;
                    }
                } else if (Username.equals(username2)) {
                    if (hash2 == validate) {
                        Assistant.assistant();
                        return true;
                    } else {
                        System.out.println("Invalid password. Please try again.");
                        Assistant theAssistant = new Assistant();
                        theAssistant.password(Main.str);
                        return false;
                    }
                } else {
                    System.out.println("Invalid username.");
                    return false;
                }
            } else if (Main.str.equals("student") || Main.str.equals("Student")) {
                if (Username.equals(username1)) {
                    if (hash1 == validate) {
                        Student.student();
                        return true;
                    } else {
                        System.out.println("Invalid password. Please try again.");
                        Student theStudent = new Student(Main.str);
                        theStudent.password(Main.str);
                        return false;
                    }
                } else if (Username.equals(username2)) {
                    if (hash2 == validate) {
                        Student.student();
                        return true;
                    } else {
                        System.out.println("Invalid password. Please try again.");
                        Student theStudent = new Student(Main.str);
                        theStudent.password(Main.str);
                        return false;
                    }
                } else {
                    System.out.println("Invalid username.");
                    return false;
                }
            } else if (Main.str.equals("teacher") || Main.str.equals("Teacher")) {
                if (Username.equals(username1)) {
                    if (hash1 == validate) {
                        Teacher.teacher();
                        return true;
                    } else {
                        System.out.println("Invalid password. Please try again.");
                        Teacher theTeacher = new Teacher();
                        theTeacher.password(Main.str);
                        return false;
                    }
                } else if (Username.equals(username2)) {
                    if (hash2 == validate) {
                        Teacher.teacher();
                        return true;
                    } else {
                        System.out.println("Invalid password. Please try again.");
                        Teacher theTeacher = new Teacher();
                        theTeacher.password(Main.str);
                        return false;
                    }
                } else {
                    System.out.println("Invalid username.");
                    return false;
                }
            } else {
                System.out.println("Invalid user type.");
                return false;
            }

        }

        public void changeUsername(String str, UUID username1, UUID username2) {
            if (Main.str.equals("assistant") || Main.str.equals("Assistant")) {
                if (Assistant.Username.equals(username1)) {
                    Assistant assistant1 = new Assistant("Hagrid_TheBest", "19281206hagrid");
                    System.out.println("Enter your new username:");
                    Scanner scanner = new Scanner(System.in);
                    String newAssistantValue = scanner.nextLine();

                    // Modify the assistant value indirectly using the setter method
                    assistant1.setAssistant(newAssistantValue);

                }
            } else if (Main.str.equals("student") || Main.str.equals("Student")) {
                if (Student.Username.equals(username1)) {
                }
            } else if (Main.str.equals("teacher") || Main.str.equals("Teacher")) {
                if (Teacher.Username.equals(username1)) {
                }
            }
        }

        public void changePassword(String str, UUID username1, UUID username2) {

            if (Main.str.equals("assistant") || Main.str.equals("Assistant")) {
                if (Assistant.Username.equals(username1)) {
                    if (Assistant.hash1 == validate) {
                        Assistant assistant1 = new Assistant("Hagrid_TheBest", "19281206hagrid");

                        // Prompt the user to enter the new password
                        System.out.println("Enter your new password:");
                        Scanner scanner = new Scanner(System.in);
                        String newPasswordValue = scanner.nextLine();

                        // Modify the password value indirectly using the setter method
                        assistant1.setPassWord(newPasswordValue);
                    }
                }
            } else if (Main.str.equals("student") || Main.str.equals("Student")) {
                if (Assistant.Username.equals(username1)) {
                    if (Assistant.hash1 == validate) {
                        Student student1 = new Student("H@arrythe_CHOSENone", "19800731harry");

                        // Prompt the user to enter the new password
                        System.out.println("Enter your new password:");
                        Scanner scanner = new Scanner(System.in);
                        String newPasswordValue = scanner.nextLine();

                        // Modify the password value indirectly using the setter method
                        student1.setPassWord(newPasswordValue);
                    }
                }
            } else if (Main.str.equals("teacher") || Main.str.equals("Teacher")) {
                if (Assistant.Username.equals(username1)) {
                    if (Assistant.hash1 == validate) {
                        Teacher teacher1 = new Teacher("M!nerv@_mcG0N", "19351004minerva");

                        // Prompt the user to enter the new password
                        System.out.println("Enter your new password:");
                        Scanner scanner = new Scanner(System.in);
                        String newPasswordValue = scanner.nextLine();

                        // Modify the password value indirectly using the setter method
                        teacher1.setPassWord(newPasswordValue);
                    }
                }
            }
        }
    }
}

