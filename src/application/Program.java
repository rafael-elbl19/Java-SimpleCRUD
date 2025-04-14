package application;

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
        System.out.println("9. Quit.");
        System.out.println("======================================");
        System.out.println("Escolha a opção desejada: ");
        int mainMenuOption = sc.nextInt();
    }

    public static void addMenu() {
        System.out.println("Enter the name: ");
    }

    public static void deleteMenu() {

    }

    public static void listMenu() {

    }

    public static void quitOption() {
        System.out.println("Shutting down the system....");
        System.exit(0);
    }

}