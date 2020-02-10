# BankAPP
The application in which customer can create an account, witraw or deposit money and so. The app uses principles of OOP

There is a Bank class. It has an arraylist of Branches
Each Branch have an arraylist of Customers.
The Customer class have an arraylist of Doubles (transactions).
Customer: Name, and the ArrayList of doubles.
Branch is able to:
- add a new customer and initial transaction amount,
- add additional transactions for that customer/branch.

Bank can:
- add a new branch
- add a customer to that branch with initial transaction
- add a transaction for an existing customer for that branch
- show a list of customers for a particular branch and optionally a list
of their transactions
