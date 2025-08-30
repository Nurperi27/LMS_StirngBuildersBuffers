import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isTure = true;
        while(true) {
            try {
                    System.out.println("Task 1.\nEnter text:");
                    String str1 = new Scanner(System.in).nextLine();
                    System.out.println("Reversed string: " + reversedMethod(str1));
                    System.out.println("Task 2.\nEnter 5 words: ");
                    String[] str2 = new String[5];
                    for (int i = 0; i < str2.length; i++) {
                        str2[i] = new Scanner(System.in).nextLine();
                    }
                    System.out.println("Joined words from array: " + joinElements(str2));
                    System.out.println("Task 3.\nEnter the text: ");
                    String str3 = new Scanner(System.in).nextLine();
                    vowelLetters(str3);
                    System.out.println("Task 4.\nEnter word: ");
                    String str4 = new Scanner(System.in).nextLine();
                    palindrome(str4);
                    System.out.println("Task 5.\nEnter the text: ");
                    String str5 = new Scanner(System.in).nextLine();
                    toUpper(str5);
                    System.out.println("Task 6.\nEnter the text: ");
                    String str6 = new Scanner(System.in).nextLine();
                    countWords(str6);
                    System.out.println("Task 7.\nEnter charachter: ");
                    char ch7 = new Scanner(System.in).next().charAt(0);
                    System.out.println("ASCII code of " + ch7 + " = " + toASCII(ch7));
                    System.out.println("Task 8.\nEnter text: ");
                    String str8 = new Scanner(System.in).nextLine();
                    System.out.println("After removing spaces: " + removeSpaces(str8));
                if(str1.isEmpty() || Arrays.toString(str2).isEmpty() || str3.isEmpty() || str4.isEmpty()
                        || str5.isEmpty() || str6.isEmpty() || ch7 == ' ' || str8.isEmpty()) {
                    throw new RuntimeException("Вы ввели пустое значение");
                }
            }catch (RuntimeException e){
                System.err.println(e.getMessage());
            }
            isTure = false;
            System.out.println("Program is closed!");
        }
    }
    static String reversedMethod(String word){
        StringBuffer stringBuffer = new StringBuffer(word);
        stringBuffer.reverse();
        return stringBuffer.toString();
        //return new StringBuilder(word).reverse().toString(); //reverse() - выводит строку в обратном порядке
    }
    static String joinElements(String[] str){
        System.out.println(Arrays.toString(str));
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<str.length; i++){
            stringBuilder.append(str[i]); //append() - преобразовывает переданный объект в строку и добавляет к текущей строке
        }
        return stringBuilder.toString();
    }
    static void vowelLetters(String str){
        StringBuffer stringBuffer = new StringBuffer("AEIOUYaeiouy");
        int count = 0;
        for(int i=0; i<str.length(); i++){
            if(stringBuffer.indexOf(String.valueOf(str.charAt(i))) >= 0){ //если индекс элемента >= 0
                //indexOf() - находит индекс символа в строке
                //String.valueOf() - используется для преобразования различных типов данных в строку
                //charAt() - возвращает символ из строки по индексу
                count++;
            }
        }
        System.out.println("Quantity of vowel letters in the text: " + count);
    }
    static void palindrome(String word){
        StringBuilder stringBuilder = new StringBuilder(word);
        StringBuilder reversed = stringBuilder.reverse();
        if((!word.isEmpty()) && word.equalsIgnoreCase(reversed.toString())){
            System.out.println( word + " is Palindrome!");
        }else{
            System.out.println("No!");
        }
    }
    static void toUpper(String text){
        StringBuilder stringBuilder = new StringBuilder();
        String[] str = text.split(" "); //split() - разделяет строки на подстроки
        System.out.println(Arrays.toString(str));
        for(String s : str){
            char ch = Character.toUpperCase(s.charAt(0)); //строки с 0-ми индексами превращаем в верхний регистр
            String newStr = ch + s.substring(1); //substring(1) - кроме 0-го индекса остальные части слова оставляем
            stringBuilder.append(newStr).append(" ");
        }
        System.out.println("Result: " + stringBuilder);
    }
    static void countWords(String text){
        StringBuilder stringBuilder = new StringBuilder();
        String[] str = text.split(" ");
        System.out.println(Arrays.toString(str));
        int count = str.length;
        System.out.println("Количество слов в тексте: " + count);
    }
    static int toASCII(char ch){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((int)ch); //символ возвращает числововй код из ASCII и append() добавляет в StringBuilder
        return Integer.parseInt(stringBuilder.toString());
    }
    static String removeSpaces(String text){
        String newStr = text.trim().replaceAll(" ", ""); //trim() - удаляет начальные и конечные пробелы
        StringBuilder stringBuilder = new StringBuilder(newStr);         //replaceAll() - используется для замены всех вхождений строк на новое заданное выражение
        return  stringBuilder.toString();
    }
}