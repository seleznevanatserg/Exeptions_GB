// Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

package lesson02.task04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       
        
        String userEnter = "";
        try {
            Scanner iScanner = new Scanner(System.in);
            System.out.println("Something enter, pls:");
            userEnter = iScanner.nextLine();
            

            checkingZeroLenghtString (userEnter);
            checkingOnlySpaceString (userEnter);
            System.out.println("Your entered:" + userEnter + "\n");
        }
        catch (ArithmeticException e) {
            System.out.println("Uncorrect input. String length 0 chars. Char [SPACE] not included.\n");
        }
        
        
    }

    // Метод для проверки того, является ли пустой строка
    public static void checkingZeroLenghtString (String str){
        double check = 1 / str.length();
    }
    //Метод для проверки того, что строка не состоит только из пробелов
    public static void checkingOnlySpaceString (String str){
        int notOnlySpace = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) != ' '){
                notOnlySpace = 1;
            }
        }
        double check = str.length() / notOnlySpace;
    }

    //Оба метода в случае пустой или пробельной строки создают условия для арифметического исключения (деление на 0)

}
