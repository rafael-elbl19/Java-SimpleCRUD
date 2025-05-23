package application;

import entities.Person;
import services.TaxService;
import util.BrazilianTaxes;
import util.OtherCountriesTaxes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Program {
    public static Double finalBill;
    public static Scanner sc = new Scanner(System.in);
    public static List<Person> persons = new ArrayList<>();

    public static void main(String[] args) {
        mainMenu();
    }

    public static void listMenu() {
        for (Person p : persons) {
            System.out.println("Name: " + p.getName() +
                    ", email: " + p.getEmail() +
                    ", room: " + p.getRoom() +
                    ", sex: " + p.getSex() +
                    ", age: " + p.getAge() + ".");
        }
        backMenu();
    }

    public static void updateMenu() {
        sc.nextLine();
        System.out.print("Enter the guest name for update: ");
        String name = sc.nextLine();

        Person newPerson = null;

        for (Person p : persons) {
            if (p.getName().equalsIgnoreCase(name)) {
                newPerson = p;
                break;
            }
        }
        if (newPerson == null) {
            System.out.println("Guest does not exist.");
            backMenu();
            return; //PARA IMPEDIR CONTINUAÇÃO
        }

        System.out.print("New check-in date (dd/MM/yyyy HH:mm): ");
        String newCheckIn = sc.nextLine();
        System.out.print("New check-out date (dd/MM/yyyy HH:mm): ");
        String newCheckOut = sc.nextLine();
        System.out.print("New value per day: ");
        Double newDailyValue = sc.nextDouble();

        double days = newPerson.calculateDays(newCheckIn, newCheckOut);
        newPerson.finalBill(days, newDailyValue);

        backMenu();
    }

    public static void totalAccount() {
        System.out.print("Enter the room number: ");
        int roomNumber = sc.nextInt();

        boolean found = false;
        for (Person p : persons) {
            if(p.getRoom() == roomNumber) {
                System.out.printf("Final bill for room %d is $%.2f%n", roomNumber, p.total);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Can't find the room");
        }

        backMenu();
    }

    public static void backMenu() {
        sc.nextLine();
        System.out.println("Back to principal menu or quit (b/q)?");
        char backOrQuit = sc.next().charAt(0);
        switch (backOrQuit) {
            case 'b':
                mainMenu();
                break;
            case 'q':
                quitOption();
                break;
            default:
                System.out.println("Select a valid option.");
                backMenu();
        }
    }

    public static void deleteMenu() {
        System.out.print("Write the guest name to delete: ");
        String name = sc.next();

        boolean removed = persons.removeIf(p -> Objects.equals(p.getName(), name));
        if (removed) {
            System.out.println("Guest " + name + " removed.");
        }

        if (persons.isEmpty()) {
            System.out.println("No more guests.");
        } else if (persons.isEmpty() != true) {
            System.out.println("Remaining guests: ");
            listMenu();
        }

        backMenu();
    }

    public static void quitOption() {
        System.out.print("Shutting down the system....");
        System.exit(0);
    }

    public static void addMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("==========ADD MENU==========");
        System.out.print("Enter the guest name: ");
        String name = sc.next();
        System.out.print("Enter the guest email: ");
        String email = sc.next();
        System.out.print("Enter the guest age: ");
        int age = sc.nextInt();
        System.out.print("Enter the guest sex: ");
        String sex = sc.next();
        System.out.print("Which room: ");
        int room = sc.nextInt();
        System.out.print("Enter the first day (dd/MM/yyyy HH:mm): ");
        sc.nextLine();
        String firstDay = sc.nextLine();
        System.out.print("Enter the last day (dd/MM/yyyy HH:mm): ");
        String lastDay = sc.nextLine();
        System.out.print("Is the guest brazilian (y/n)? ");
        char country = sc.next().charAt(0);
        System.out.print("Enter the value per day: ");
        Double dailyValue = sc.nextDouble();
        System.out.println("============================");

        TaxService taxService = null;
        if (country == 'y') {
            taxService = new BrazilianTaxes();
        } else if (country == 'n') {
            taxService = new OtherCountriesTaxes();
        }

        if (taxService != null) {
            Person p = new Person(name, email, age, sex, room, taxService);
            double days = p.calculateDays(firstDay, lastDay);
            p.finalBill(days, dailyValue);
            finalBill = p.total;
            persons.add(p);
        } else {
            System.out.println("Invalid country option.");
        }

        backMenu();
    }

    public static void mainMenu() {
        System.out.println("==========BEM-VINDO AO HOTEL==========");
        System.out.println("1. Add new guest.");
        System.out.println("2. List guests.");
        System.out.println("3. Update guests.");
        System.out.println("4. Delete guest.");
        System.out.println("5. Get total account.");
        System.out.println("9. Quit.");
        System.out.println("======================================");
        System.out.println("Escolha a opção desejada: ");
        int mainMenuOption = sc.nextInt();

        switch (mainMenuOption) {
            case 1:
                addMenu();
                break;
            case 2:
                listMenu();
                break;
            case 3:
                updateMenu();
                break;
            case 4:
                deleteMenu();
                break;
            case 5:
                totalAccount();
                break;
            case 9:
                quitOption();
        }
    }
}