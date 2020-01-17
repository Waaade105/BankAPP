package com.arturreinke;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;
    private double money;
    private String accountNo;

    public Customer(String name, double money, String accountNo){
        if(money < 0){
            System.out.println("Enter a positive value.");
        }else {
            this.name = name;
            this.transactions = new ArrayList<Double>();
            this.money = money;
            this.accountNo = accountNo;
        }
    }

    public double depositMoney(double ammount){
        if(ammount < 0){
            System.out.println("Invalid value.");
            return -1;
        }
        this.money += ammount;
        this.transactions.add(ammount);
        System.out.println(ammount + " are deposited. Now You have " + this.money);
        return this.money;
    }

    public double withdrawalMoney(double ammount){
        if(ammount < 0){
            System.out.println("Invalid value.");
            return -1;
        }
        if (ammount > this.money){
            System.out.println("You don't have enough money for this transaction. You have "+ this.money);
            return -1;
        }
        this.money -= ammount;
        System.out.println("You have taken "+ ammount + " money. Now you have "+ this.money);
        this.transactions.add(-ammount);

        return this.money;
    }
//    public static Customer createCustomer (String name){
//        return new Customer(name,0,"0000");
//    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public double getMoney() {
        return money;
    }

    public String getAccountNo() {
        return accountNo;
    }
}
