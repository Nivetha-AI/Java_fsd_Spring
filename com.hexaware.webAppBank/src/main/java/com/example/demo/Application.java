package com.example.demo;

import java.util.Optional;
import java.util.Scanner;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.BankRepo.BankRepository;
import com.example.demo.Entities.Bank;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		BankRepository rep = context.getBean(BankRepository.class);
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1. To open Account.");
			System.out.println("2. To deposit");
			System.out.println("3. To withdraw");
			System.out.println("4. To Search by Account Number");
			System.out.println("5. To Transfer Amount.");
			System.out.println("6. To close account.");
			System.out.println("0. To Exit");
			int ch = sc.nextInt();
			if (ch == 1) {
				// 1.to open an Account

				System.out.println("Enter Account Number : ");
				int Acc = sc.nextInt();
				System.out.println("Enter Name : ");
				String nam = sc.next();
				System.out.println("Enter balance : ");
				double bal = sc.nextDouble();
				System.out.println("Enter email : ");
				String email = sc.next();
				Bank b1 = new Bank(Acc, nam, bal, email);

				if (b1.getBalance() > 1000) {
					rep.save(b1);
					System.out.println("Account opened");
				} else {
					System.out.println("Account not opened.Balance must >1000");
				}
			}
			else if (ch == 2) {

				// 2 deposit
				System.out.println("Enter Account Number : ");
				int Accno = sc.nextInt();
				System.out.println("Enter deposit : ");
				double deposit = sc.nextDouble();
				Optional<Bank> b = rep.findById(Accno);
				if (b.isPresent()) {
					Bank temp = b.get();

					temp.setBalance(temp.getBalance() + deposit);
					rep.save(temp);
					System.out.println("Amount deposited ");
				} else {
					System.out.println("Account Not found");
				}
			}
			else if (ch == 3) {

				// 3 Withdraw (can not be -)
				System.out.println("Enter Account Number : ");
				int Accno = sc.nextInt();
				System.out.println("Enter withdraw : ");
				double withdraw = sc.nextDouble();
				Optional<Bank> b = rep.findById(Accno);
				if (b.isPresent()) {
					Bank temp = b.get();

					if (temp.getBalance() >= withdraw) {
						temp.setBalance(temp.getBalance() - withdraw);
						rep.save(temp);
						System.out.println("Amount withdrawn ");
					} else {
						System.out.println("Insufficient Balance");
					}
				} else {
					System.out.println("Account Not found");
				}
			}
			else if (ch == 4) {

				// 4.Search by Account Number
				System.out.println("Enter Account Number : ");
				int Accno = sc.nextInt();
				Optional<Bank> b = rep.findById(Accno);
				System.out.println(b);
			}
			else if (ch == 5) {

				// 5.Transfer Amount

				System.out.println("Enter Account Number1 : ");
				int Accno1 = sc.nextInt();
				System.out.println("Enter Account Number2 : ");
				int Accno2 = sc.nextInt();
				System.out.println("Enter Amount to transfer  : ");
				double amount = sc.nextDouble();
				Optional<Bank> b1 = rep.findById(Accno1);
				Optional<Bank> b2 = rep.findById(Accno2);

			    if (b1.isPresent() && b2.isPresent()) {
			        Bank sender = b1.get();
			        Bank receiver = b2.get();
			        if (sender.getBalance() >= amount) {
			        	 sender.setBalance(sender.getBalance() - amount);
			             receiver.setBalance(receiver.getBalance() + amount);
			             rep.save(sender);
			             rep.save(receiver);
			             System.out.println("Transfer successful");
			        }
			        else {
			        	System.out.println("Insufficent Balance");
			        }
			    }
			    else {
			    	System.out.println("Account not found");
			    }

			}
			else if (ch == 6) {

				// 6. close account
				System.out.println("Enter Account Number : ");
				int Accno = sc.nextInt();
				Optional<Bank> b = rep.findById(Accno);
				if (b.isPresent()) {
					rep.deleteById(Accno);
					System.out.println("Account Removed");
				}

				else {
					System.out.println("Not Found");
				}
			}
			else if(ch==0)
			{
				break;
			}
			else
			{
				continue;
			}
		}
		sc.close();
	}

}
