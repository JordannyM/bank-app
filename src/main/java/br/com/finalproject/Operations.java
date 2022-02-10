package br.com.finalproject;

import lombok.*;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString

public class Operations {

    public static void withdraw(String account, String value, double balance){
        try {
            double withdrawalMoney = Double.parseDouble(value);

            if (balance > withdrawalMoney){
                balance-=withdrawalMoney;
                System.out.println(account+": R$"+balance);
            }
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static void deposit(String account, String value, double balance){
        try {
            double depositMoney = Double.parseDouble(value);

            balance+=depositMoney;
            System.out.println(account+": R$"+balance);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static void executeOperation(Collection groups, String id, String type, String value, double balance) {
        //Logic to identify the groups and only make operations with same id
            switch (type) {
                case "DEPOSITO":
                    deposit(id, value, balance);
                case "SAQUE":
                    withdraw(id, value, balance);
                case "TIPO":
            }


    }

}
