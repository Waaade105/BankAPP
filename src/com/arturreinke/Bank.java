package com.arturreinke;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Branch> branchesList;
    private String name;

    private ArrayList<Customer> bankClients;

    public Bank(String name) {
        this.branchesList = new ArrayList<Branch>();
        this.name = name;

        this.bankClients = new ArrayList<>();
    }
    public boolean addCustomerInBank(Customer customer){
        if(findCustomer(customer) != null){   // IDZIE TO SPR POZA APLIKACJA ?
            System.out.println("The customer has already exists");
            return false;
        }

        bankClients.add(customer);
        //  dodać mozliwosc wplacenia kasy na konto, podczas jego tworzenia -> scanner
        System.out.println("The customer "+ customer.getName() + " has been added");
        return true;
    }

//    public boolean addCustomerInBank (Customer customer){
//        if(findCustomer(customer) != null){   // IDZIE TO SPR POZA APLIKACJA ?
//            System.out.println("The customer has already exists");
//            return false;
//        }
//        for (int i=0 ; i< branchesList.size(); i++){
//            Branch branch = branchesList.get(i);
////            branchesList.get(i).addCustomer(customer);
//            branch.getCustomersList().add(customer);
//            System.out.println("The customer "+ customer.getName() + " has been added to your list. ");
//        }
//        return true;
//    }

    public void printCustomersListInBank() {
        for (int i = 0; i < bankClients.size(); i++) {
            Customer getToCustomer = bankClients.get(i);
            System.out.println(i + 1 + "." + getToCustomer.getName());
        }
    }

    public void printCustomersListForTheParticularBranch(String  nameOfBranch){

        int foundedBranch = findBranch(nameOfBranch);
        Branch branch = branchesList.get(foundedBranch);
        branch.getCustomersList();
    }


//    public void printCustomersListInBank(){
//        for (int i=0; i<branchesList.size(); i++){
//            Branch branch = branchesList.get(i);
////                branch.printCustomersList();
//            System.out.println("Customers list:\n" +
//                                i + 1 + "." + branch.getCustomersList().get(i).getName());
//            System.out.println("%%%%%%%%%%%");
//            branch.printCustomersList();
//        }
//    }

    public void depositCustomerMoneyInBank (String name, double ammount) {
        Customer foundCustomer = findCustomer(name);
        foundCustomer.depositMoney(ammount);
//        customer.depositMoney(ammount);

    }
    public void withdrawalCustomerMoneyInBank (String name, double ammount) {
        Customer foundCustomer = findCustomer(name);
        foundCustomer.depositMoney(ammount);
    }

    public boolean addBranch( Branch branch){
        if(findBranch(branch)>=0){
            System.out.println("The branch has already exists.");
            return false;
        }
        branchesList.add(branch);
        System.out.println("The branch at the  "+ branch.getAdress() + " street was added. Congrats.");
        return true;
    }

    public void printBranchesList(){
        System.out.println("In bank "+ this.name + " are "+ branchesList.size() + " branches.");
        for (int i=0 ; i<branchesList.size(); i++){
            Branch branch = branchesList.get(i);
            System.out.println(i+1 + "."+ branch.getAdress());
        }
    }

    public boolean closeBranch (Branch branch){
        if(findBranch(branch) < 0){
            System.out.println("The branch does not exists.");
            return false;
        }
        branchesList.remove(branch);
        System.out.println("The branch at the "+ branch.getAdress() + " street was closed. " +
                                                " Now you have only "+ branchesList.size()+ " branches." );
        return true;
    }

    public String findCustomer(Customer customer) {
        for (int i = 0; i < branchesList.size(); i++) {
            Branch branch = branchesList.get(i);
            if (branch.queryCustomer(customer) != null) {
                return customer.getName();
            }
        }
        return null;
    }

    public Customer findCustomer (String name) {
        for (int i = 0; i < branchesList.size(); i++) {
            Branch branch = branchesList.get(i);
            if (branch.queryCustomer(name) != null) {
                int position = branch.getCustomersList().indexOf(name);
//                return this.branchesList.get(i).getCustomersList().
                return branch.getCustomersList().get(position);   // czy dobrze ???
            }
        }
        return null;
    }

    public String queryBranch (Branch branch){
        int position = findBranch(branch);
        if (position < 0 ){
            System.out.println("The branch does not exists.");
            return null;
        }
        return branch.getAdress();
    }

    public Branch queryBranch (String branchAdress){


        int position = findBranch(branchAdress);
        if (position < 0){
            return null;
        }
        return this.branchesList.get(position);   //
    }

    private int findBranch(Branch branchAdress){
        return branchesList.indexOf(branchAdress);
    }

    private int findBranch(String branchAdress){
        for ( int i = 0 ; i < branchesList.size(); i++){
            Branch branch = branchesList.get(i);
            if (branch.getAdress().equals(branchAdress)){
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Branch> getBranchesList() {
        return branchesList;
    }

    public String getName() {
        return name;
    }
}
