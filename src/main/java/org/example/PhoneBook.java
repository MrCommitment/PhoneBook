package org.example;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PhoneBook {

    public void open() {
        Scanner scanner = new Scanner(System.in);
        int userChoice = -1;
        while (userChoice != 4){
            printMenu();
            userChoice = readUserChoice(scanner);
            executeUserAction(userChoice, scanner);
        }
    }

    private void executeUserAction(int userChoice, Scanner scanner) {
        switch (userChoice){
            case 0:
                addPhoneBookContact(scanner);
                break;
            case 1:
                searchUserByName(scanner);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                System.out.println("Please try again ");
                break;
        }
    }

    private void searchUserByName(Scanner scanner) {
        System.out.println("Please provide user name: ");
        String searchFraze = readInput(scanner);
        //TODO zrobic implementacje wyszukania po swojemu
        List<PhoneBookRecord> allRecordsFromFile = FileUtils.getAllRecordsFromFile();
        List<PhoneBookRecord> searchedRecords = allRecordsFromFile.stream()
                .filter(record -> record.getFirstName().toUpperCase().contains(searchFraze.toUpperCase()))
                .collect(Collectors.toList());
        System.out.println(searchedRecords);
    }
    //TODO imprempentacje po telefonie
    private void addPhoneBookContact(Scanner scanner) {
        System.out.println("Please write contact first name: ");
        String firstName = readInput(scanner);
        System.out.println("Please write contact second name: ");
        String secondName = readInput(scanner);
        System.out.println("Please write contact phone number: ");
        String phoneNumber = readInput(scanner);

        PhoneBookRecord phoneBookRecord = new PhoneBookRecord(firstName, secondName, phoneNumber);

        boolean isRecordAdded = FileUtils.saveRecord(phoneBookRecord);
        if (isRecordAdded){
            System.out.println(phoneBookRecord);
        }
    }

    private String readInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private int readUserChoice(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private void printMenu() {
        System.out.println("\nChoose one of the options:");
        System.out.println("\n0 - Add a new contact.");
        System.out.println("1 - Search by name.");
        System.out.println("2 - Search by phone number.");
        System.out.println("3 - Delete a contact.");
        System.out.println("4 - Exit the program.");
        System.out.println("\nChoose your number: ");
    }
}
