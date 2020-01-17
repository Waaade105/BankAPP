package com.arturreinke;

import java.util.ArrayList;

public class Branch {

    private ArrayList<Customer> customersList;
    private String adress;

    public Branch(String adress){
        this.adress = adress;
        this.customersList = new ArrayList<Customer>();
    }

    public boolean addCustomer(Customer customer){

        if(findCustomer(customer) >= 0){
            System.out.println("The customer has already exists.");
            return false;
        }

        customersList.add(customer);

        System.out.println("The customer was added.");
        return true;
    }

    public void printCustomersList (){
        System.out.println("In branch at "+ this.adress + " are "+ customersList.size() + " clients.");
        for (int i = 0 ; i < customersList.size(); i++){
            Customer customer = customersList.get(i);
            System.out.println(i+1 +". "+ customer.getName());
        }
    }
    public double depositCustomerMoney (Customer customer, double ammount){
        int foundCustomer = findCustomer(customer);
        Customer getToCustomer = customersList.get(foundCustomer);
        return getToCustomer.depositMoney(ammount);
    }

    public double withdrawalCustomerMoney (Customer customer, double ammount){
        int foundCustomer = findCustomer(customer);
        Customer getToCustomer = customersList.get(foundCustomer);
        return getToCustomer.withdrawalMoney(ammount);
    }

    public boolean giveCustomerCredit (Customer customer, double ammountOfCredit ){
        int foundCustomer = findCustomer(customer);
        Customer getToCustomer = customersList.get(foundCustomer);
        if (getToCustomer.getMoney()*0.5 > ammountOfCredit){
            System.out.println("You have the creditworthiness (more than 50% of capital). You can take a credit.");
            return true;
        }
        System.out.println("You haven't got creditworthiness (capital 50% of loan value " + " - " +
                getToCustomer.getMoney()+ " on your account). \nYou have to have more money to get credit.");
        return false;
    }

    public Customer queryCustomer(String customerName){
        int position = findCustomer(customerName);
        if(position >=0){
            return this.customersList.get(position); // to mi zwróci referencje do obiektu ?? a potem .getName
        }
        return null;
    }

    public String queryCustomer (Customer customer){
        int position = findCustomer(customer);
            if(position >=0){
                return customer.getName();
            }
        return null;
    }


    private int findCustomer(String name){
        for (int i = 0 ; i < this.customersList.size(); i++){
            Customer customer = this.customersList.get(i);
            if (customer.getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
    private int findCustomer(Customer customer){
        return this.customersList.indexOf(customer);
    }


    public ArrayList<Customer> getCustomersList() {
        return customersList;
    }

    public String getAdress() {
        return adress;
    }

}
