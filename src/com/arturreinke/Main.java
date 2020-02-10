package com.arturreinke;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank("E_Corp");

    public static void main(String[] args) {

        bank.addBranch(new Branch("Konopnickiej"));
        bank.addBranch(new Branch("Mickiewicza"));
        bank.printBranchesList();
        bank.closeBranch(bank.queryBranch("Konopnickiej"));    // check

        Customer igor = new Customer("Igor", 1000, "7899");
        bank.depositCustomerMoneyInBank("Igor", 500);
        igor.getMoney();

        boolean quit = false;
        System.out.println("Hi. Where would you like to create your new bank account?\n " +
                " \tPresz 0 - you will create your account in bank\n" +
                " \tPresz 1 - you wll create your account in one of the bank's branches ");
        while (!quit) {
            int choice = scanner.nextInt();
            switch (choice) {

                //// for bank
                case 0:
                    printOperationsBank();
                    int choice2 = scanner.nextInt();
                    switch (choice2) {
                        case 0:
                            printOperationsBank();
                            break;
                        case 1:
                            addClientInBank();
                            break;
                        case 2:
                            findClientInBank();
                            break;
                        case 3:
                            depositClientsMoneyInBank();
                            break;
                        case 4:
                            withdrawalClientsMoneyInBank();
                            break;
                        case 5:
                            displayClientListForTheBranch();
                            break;
                        case 6:
                            addABranch();
                            break;
                        case 7:
                            bank.printBranchesList();
                            break;
                        case 8:
                            closeABranch();
                            break;
                        case 9:
                            queryABranch();
                            break;

                    }
                    break;
                //// for branch
                case 1:
                    printOperationsBranch();
                    choice2 = scanner.nextInt();
                    switch (choice2) {
//                        Branch branch = new Branch("default adress");
                        case 0:
                            printOperationsBranch();
                            break;
                        case 1:
                            addClientInBranch();
                            break;
                        case 2:
                            findClientInBranch();
                            break;
                        case 3:
//                            depositClientsMoneyInBranch();
                            break;
                        case 4:
//                            withdrawalClientsMoneyInBranch();
                            break;
                        case 5:
//                            displayClientsList();
                            break;
                        case 6:
//                            giveCLientCredit();
                    }
                    break;
            }
        }
    }
    
    public static void printOperationsBank(){
        System.out.println("\nAvailable operations:\npress");
        System.out.println("0 - to print operations\n"+
                            "1 - to add client\n" +
                            "2 - to find a client\n"+
                            "3 - to deposit client's money\n" +
                            "4 - to withdrawal client's money\n" +
                            "5 - to display a customer list for a particular branch\n" + // w mainie
                            "6 - to add a branch\n" +
                            "7 - to print a branches list\n" +
                            "8 - to close a branch\n" +
                            "9 - to query a branch\n" +
                            "10 - to ");
    }

    private static void addClientInBank(){
        System.out.println("Enter the name of the new client:");
        String name = scanner.nextLine();
        System.out.println("Enter how much money does he have:");
        double money = scanner.nextInt();
        scanner.nextLine(); // bufer
        System.out.println("Enter his account number:");
        String accountNo = scanner.nextLine();
        bank.addCustomerInBank(new Customer(name, money,accountNo));

        System.out.println("Would you like to deposit money?");
        System.out.println("yes / no");
        String clientsChoice = scanner.nextLine();
        switch(clientsChoice){
            case "yes":
                System.out.println("How much money would you like to deposit?");
                int ammount = scanner.nextInt();
                scanner.nextLine();
                bank.depositCustomerMoneyInBank(name,ammount);
                break;
            case "no":
                System.out.println("O.K. Maybe next time.");
                break;
        }
    }

    public static void findClientInBank (){
        System.out.println("Enter the name of client:");
        String name = scanner.nextLine();
        Customer getToCustomer = bank.findCustomer(name);
        System.out.println("The client "+ name + " was found.\n"+
                            getToCustomer.getName()+ "\n" +
                            "money: " + getToCustomer.getMoney()+ "\n"+
                            "account number: "+ getToCustomer.getAccountNo()+ "\n" +
                            "transactions completed: " + getToCustomer.getTransactions());
    }

    private static void depositClientsMoneyInBank(){
        System.out.println("Enter the name of client who wants to deposit money:");
        String name = scanner.nextLine();
        System.out.println("Enter how much money would you like to deposit:");
        double ammount = scanner.nextInt();
        bank.depositCustomerMoneyInBank(name, ammount);
        System.out.println("The "+ ammount + " now is on your account");
    }

    private static void withdrawalClientsMoneyInBank(){
        System.out.println("Enter the name of client who wants to withdrawal money:");
        String name = scanner.nextLine();
        System.out.println("Enter how much money would you like to witdraw:");
        double ammount = scanner.nextInt();
        bank.depositCustomerMoneyInBank(name, ammount);
        System.out.println("The "+ ammount + " was witdrawn");
    }

    private static void displayClientListForTheBranch(){
        System.out.println("Enter the branch in which you want to see the client's list:");
        String nameOfBranch = scanner.nextLine();
        Branch branchRecord = bank.queryBranch(nameOfBranch);
        System.out.println("The branch has the following list of customers: \n " + branchRecord.getCustomersList());
    }
    private static void addABranch(){
        String adressOfBranch = scanner.nextLine();
        if (adressOfBranch != null){           ///  JESLI ROZNY OD NULL TO ZNACZY ZE ISTNIEJE
            System.out.println("The branch already exsists.");
        }else{
            bank.addBranch(new Branch(adressOfBranch));
        }
    }

    private static void closeABranch() {
        System.out.println("Enter the adress of branch you would like to close:");
        String adressOfBranch = scanner.nextLine();
        Branch branch = bank.queryBranch(adressOfBranch);
        if (branch == null) {   //// OBIEKT PUSTY ==>> nie przypisano mu referencji nei ma go
            System.out.println("Branch was nto found");
        } else {

            bank.closeBranch(branch);
        }
    }

    private static void queryABranch () {
        System.out.println("Enter the adress of branch you would like to search for:");
        String name = scanner.nextLine();
        Branch branchRecord = bank.queryBranch(name);
        System.out.println("The branch has the following list of customers: \n " + branchRecord.getCustomersList());
    }

    //Branch
    private static void printOperationsBranch(){
        System.out.println("\nAvailable operations:\npress");
        System.out.println("0 - to print operations\n"+
                "1 - to add client\n" +
                "2 - to find a client\n"+
                "3 - to deposit client's money\n" +
                "4 - to withdrawal client's money\n" +
                "5 - to display a customer list \n" +
                "6 - to give credit to customer\n" );
    }

    private static void addClientInBranch (){
        System.out.println("Enter the name:");
        String name = scanner.nextLine();
        System.out.println("Enter the ammount of money:");
        double ammount = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the account number:");
        String accountNo = scanner.nextLine();
        Branch branch = new Branch("default adress");

        bank.addBranch(branch); // dodalem branch do listu branchesList
        branch.addCustomer(new Customer(name, ammount, accountNo));
        System.out.println("The customer has been added.");

    }
    private static void findClientInBranch(){

    }
}
