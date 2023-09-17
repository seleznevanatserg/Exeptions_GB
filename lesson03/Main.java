package lesson03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
       
        int sumOfParametrs = 5;

        // запрос на ввод
        messageForStartInput();
        String[] userInputString = userInput().split(" ");

        while(true){

            // проверка ввода 
            int resultParametrs = sumOfParametrs - userInputString.length;
            if(resultParametrs > 0){
                System.out.println("Слишком мало парамметров. Укажите больше параметров.");
                messageForStartInput();
                userInputString = userInput().split(" ");
            }
            if(resultParametrs < 0){
                System.out.println("Слишком много парамметров. Укажите меньше параметров."); 
                messageForStartInput();
                userInputString = userInput().split(" "); 
            }
            if(resultParametrs == 0){
                // System.out.println("Количество парамметров совпадает.");
                try { 
                    for (int i = 0; i < userInputString.length; i++){
                        checkingZeroLenghtString(userInputString[i]);
                        checkingOnlySpaceString(userInputString[i]);

                        Date birthdayDate = (Date) new SimpleDateFormat("dd.MM.yyyy").parse(userInputString[3]);
                        // System.out.println(birthdayDate);
                        // System.out.println("Дата указана в соответствии с правилами.");

                        char [] dataAboutSex = userInputString[4].toCharArray();  
                        if(dataAboutSex.length > 1){
                            System.out.println("Слишком много символов для обозначения пола. Следуйте шаблону.");
                            messageForStartInput();
                            userInputString = userInput().split(" ");
                        }
                        else{
                            if(dataAboutSex[0] == 'f' | dataAboutSex[0] == 'm'){
                                // System.out.println("Обозначение пола указано верно.");
                            }
                            else{
                                System.out.println("Это неверный символ для обозначения пола. Следуйте шаблону.");
                                messageForStartInput();
                                userInputString = userInput().split(" ");
                            }
                        }  
                    }  
                } 
                catch (ArithmeticException e) {
                    System.out.println("Некорректный ввод. Пустые строки недопустимы. Строки из пробелов недопустимы.");
                    messageForStartInput();
                    userInputString = userInput().split(" ");
                }
                catch (ParseException e) {
                    System.out.println("Некорректный ввод даты. Следуйте шаблону.");
                    messageForStartInput();
                    userInputString = userInput().split(" ");
                }
                
                // Cоздание/проверка файла
                String fileName = "";

                try{
                    fileName = userInputString[0] + ".txt";
                    File newFile = new File(fileName);
                    newFile.createNewFile();
                }
                catch (IOException e) {
                    System.out.println("Не удалось создать файл.");
                }

                //сохранение ввода в файл
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < userInputString.length; i++){
                    sb.append("<" + userInputString[i] + ">");
                }
                sb.append("\n");

                try (FileWriter notation = new FileWriter(fileName, true)) {
                    notation.append(sb);
                    notation.close();
                    System.out.println("Запись данных успешно выполнена.");
                    break;
                } 
                catch (IOException e) {
                    System.out.println("Не удалось записать в файл.");
                    break;
                }
            }
        }
     
    }
    


    //----------------------------------------------------------------------------------------------------------------------------------------
    // Приветствие для ввода
    private static void messageForStartInput() {
        System.out.println("Enter the details as shown below:");
        System.out.println("Surname[space]FirstName[space]SecondName[space]Birthday(format: DD.MM.YYYY)[space]Sex(format [f] or [m])");
    }

    // Считывание ввода с клавиатуры
    public static String userInput(){
        Scanner nScanner = new Scanner(System.in);
        String input = nScanner.nextLine();
        return input;
    }

    //----------------------------------------------------------------------------------------------------------------------------------------

    // Метод для проверки того, является ли пустой строка
    private static void checkingZeroLenghtString (String str){
        double check = 1 / str.length();
    }
    // Метод для проверки того, что строка не состоит только из пробелов
    private static void checkingOnlySpaceString (String str){
        int notOnlySpace = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) != ' '){
                notOnlySpace = 1;
            }
        }
        double check = str.length() / notOnlySpace;
    }

    public static void printArray (Object [] arr){
        for (Object i : arr){
            System.out.println(i);
        }
    }  
}
