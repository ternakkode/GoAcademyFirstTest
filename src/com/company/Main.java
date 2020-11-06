package com.company;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public double val = 0;
    public String[] acceptedOperators = {"add", "substract", "multiply", "divide"};

    public static void main(String[] args) {
        try {
            Main obj = new Main();
            Scanner scanner = new Scanner(System.in);
            DecimalFormat formatter = new DecimalFormat("#0.0");

            String input;
            Boolean isContinued = true;
            do {
                input = scanner.nextLine();
                if (!obj.processInput(input) && input.equals("exit")) isContinued = false;
                if(isContinued) System.out.println(formatter.format(obj.val));
            } while (isContinued);

            return;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public boolean processInput(String input){
        String[] inputs = input.split(" ");
        String operator = inputs[0];

        boolean found = Arrays.stream(this.acceptedOperators).anyMatch(operator::equals);
        if(found){
            try{
                int value = Integer.parseInt(inputs[1]);
                doMath(operator, value);
            } catch(ArrayIndexOutOfBoundsException | NumberFormatException | NullPointerException e) {
                return false;
            }
            return true;
        }

        return false;
    }

    public void doMath(String operator, int value){
        switch (operator){
            case "add":
                this.val += value;
                break;
            case "substract":
                this.val -= value;
                break;
            case "multiply":
                this.val *= value;
                break;
            case "divide":
                if(value == 0){
                    this.val = 0;
                } else {
                    this.val /= value;
                }
                break;
        }
    }
}
