package com.company;
import java.util.*;

public class Account {
    private final String name;
    private final int accountNo;
    private  int amount;

    Account(String name, int accountNo, int amount) {
        this.name = name;
        this.accountNo = accountNo;
        this.amount = amount;
    }

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        String action;
        do {
            System.out.println("Would you like to: \n[create] and account \n[check] your balance \n[deposit] money \n[withdraw] money? \n[close] your account \n[q] to quit");
            action = in.nextLine();
            switch (action) {
                case "create":
                    System.out.print("Enter your name: ");
                    String aName = in.nextLine();
                    System.out.print("Enter your account number: ");
                    int aNo = in2.nextInt();
                    System.out.print("Enter your starting balance: ");
                    int aBal = in2.nextInt();
                    accounts.add(new Account(aName, aNo, aBal));
                    break;
                case "check":
                    boolean found = false;
                    System.out.println("Enter your name: ");
                     aName = in.nextLine();
                    System.out.print("Enter your account number: ");
                    int num = in2.nextInt();
                    for (Account a : accounts) {
                        if (aName.equals(a.name) && num == a.accountNo) {
                            System.out.println("Your balance is $" + a.amount);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Incorrect name or password");
                    }
                    break;
                case "deposit":
                    found = false;
                    System.out.println("Enter your name: ");
                    aName = in.nextLine();
                    System.out.print("Enter your account number: ");
                    num = in2.nextInt();
                    for (Account a : accounts) {
                        if (aName.equals(a.name) && num == a.accountNo) {
                            System.out.println("How much are you depositing? : ");
                            int depositAmount = in2.nextInt();
                            a.amount += depositAmount;
                            System.out.println("Your new balance is $" + a.amount);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Incorrect name or password");
                    }
                    break;
                case "withdraw":
                    found = false;
                    System.out.println("Enter your name: ");
                    aName = in.nextLine();
                    System.out.print("Enter your account number: ");
                    num = in2.nextInt();
                    for (Account a : accounts) {
                        if (aName.equals(a.name) && num == a.accountNo) {
                            System.out.println("How much are you withdrawing? : ");
                            int withdrawAmount = in2.nextInt();
                            while (withdrawAmount > a.amount) {
                                System.out.println("Insufficient funds.  How much are you withdrawing? : ");
                                withdrawAmount = in2.nextInt();
                            }
                            a.amount -= withdrawAmount;
                            System.out.println("Your new balance is $" + a.amount);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Incorrect name or password");
                    }
                    break;
                case "close":
                    found = false;
                    System.out.println("Enter your name: ");
                    aName = in.nextLine();
                    System.out.print("Enter your account number: ");
                    num = in2.nextInt();
                    Iterator<Account>i = accounts.iterator();
                    while (i.hasNext()) {
                        Account a = i.next();
                        if (aName.equals(a.name) && num == a.accountNo) {
                            System.out.println("Are you sure you want to close this account? Y/N : ");
                            String closeIt = in.nextLine();
                            if (closeIt.equals("Y")) {
                                i.remove();
                                System.out.println("Account closed successfully");
                            } else {
                                System.out.println("Action cancelled");
                            }
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Incorrect name or password");
                    }
                    break;
            }
        } while (!action.equals("q"));
    }
}

