import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> list = new LinkedList<>();
        runProgram(scanner, list);
    }

    private static void runProgram(Scanner scanner, List<Person> list) {
        int choice;
        do {
            menu();
            System.out.println("Enter choice : ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    Person person = initPerson(scanner);
                    list.add(person);
                    break;
                }
                case 2: {
                    displayList(list);
                    break;
                }
                case 3: {
                    Collections.sort(list);
                    break;
                }
                case 4: {
                    sortFromFemaleToMale(list);
                    break;
                }
                case 0: {
                    System.exit(0);
                }
            }

        } while (choice != 0);
    }

    private static void menu() {
        System.out.println("----------------");
        System.out.println("MENU");
        System.out.println("1: Add");
        System.out.println("2: Display");
        System.out.println("3: Sort date of birth");
        System.out.println("4: Sort sex");
        System.out.println("0: Exit");
        System.out.println("----------------");
    }

    private static void displayList(List<Person> list) {
        for (Person p : list) {
            System.out.println(p);
        }
    }

    private static Person initPerson(Scanner scanner) {
        System.out.print("Enter name : ");
        String name = scanner.nextLine();
        System.out.print("Enter sex : ");
        String sex = scanner.nextLine();
        System.out.print("Enter date of birth : ");
        String dateOfBirth = scanner.nextLine();
        return new Person(name, sex, LocalDate.parse(dateOfBirth));
    }

    private static void sortFromFemaleToMale(List<Person> list) {
        Queue<Person> queueMale = new LinkedList<>();
        Queue<Person> queueFemale = new LinkedList<>();

        for (Person p : list) {
            if (p.getSex().equals("Male")) {
                queueMale.add(p);
            } else if (p.getSex().equals("Female")) {
                queueFemale.add(p);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (!queueFemale.isEmpty()) {
                list.set(i, queueFemale.remove());
            } else {
                list.set(i, queueMale.remove());
            }
        }
    }
}
