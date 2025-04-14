package application;

import entities.Person;
import services.TaxService;
import util.BrazilianTaxes;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        mainMenu();
    }
    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
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
        sc.close();
    }

    public static void addMenu() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
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

        if (country == 'y') {
            TaxService taxService = new BrazilianTaxes();
            Person p = new Person(name, email, age, sex, room, taxService);
            double days = p.calculateDays(firstDay, lastDay);
            double finalBill = taxService.afterTaxes(days, dailyValue, taxService.getTaxes());
        }
        sc.close();
    }

    public static void deleteMenu() {
        System.out.println("In development function...");
    }

    public static void listMenu() {
        System.out.println("In development function...");
    }

    public static void updateMenu() {
        System.out.println("In development function...");
    }

    public static Double totalAccount() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");



        return null;
    }

    public static void quitOption() {
        System.out.print("Shutting down the system....");
        System.exit(0);
    }

}