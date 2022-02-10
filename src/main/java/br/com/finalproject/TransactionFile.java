package br.com.finalproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static br.com.finalproject.Operations.executeOperation;

public class TransactionFile {

    public static void readFile() {
        String path = "/home/jordanny/bank-app/src/main/java/resources/operacoes.csv";
        String line;
        HashSet<Transaction> list = new HashSet<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                String[] vector = line.split(",");

                String dateAndTime = vector[0];
                String id = vector[1];
                String bank = vector[2];
                String agency = vector[3];
                String number = vector[4];
                String operator = vector[5];
                String type = vector[6];
                String value = vector[7];

                Transaction transaction = new Transaction(dateAndTime, id, bank, agency, number, operator, type, value);
                list.add(transaction);

                List<List<Transaction>> groups = new ArrayList<>( list.stream().collect(
                        Collectors.groupingBy( p -> p.getId() ) ).values() );

                executeOperation(groups, id, type, value, 0.0);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
