// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение. 
// Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.

package lesson02.task01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       
        while (true){
            float userNumber;
            try {
                System.out.print("Number enter:");
                userNumber = userInputFloat();
                System.out.println("Your entered number:" + userNumber + "\n");
            }
            catch (Exception e) {
                System.out.println("Uncorrect input. Only numbers [0-9] and symbols [,].\n");
            }
        }
    }
    
    public static float userInputFloat(){
        Scanner iScanner = new Scanner(System.in);
        return iScanner.nextFloat();
    } 

}
