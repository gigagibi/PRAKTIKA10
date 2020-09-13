package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static String triangSeq(int n) //Задание 1. Треугольная последовательность.
    {
        int s = 0;
        int j = 0;
        if (n == 1){
            System.out.print("1");
        }
        else {
            for (int i = 1; s < n; i++) {
                s += i;
                j = i;
            }
            System.out.print(triangSeq(--n) + " " + j);
        }
        return "";
    }

    public static void oneToN()
    {
        int n;
        System.out.println("Введите число n: ");
        n = sc.nextInt();
        for (int i = 1;i <= n; i++) System.out.print(i + " ");
    }


    public static void AtoB(){
        int A, B;
        System.out.println("Введите число A.");
        A = sc.nextInt();
        System.out.println("Введите число B.");
        B = sc.nextInt();
        if(A<B){
            for(int i = A; i <= B; i++) System.out.print(i + " ");
        }
        else if(A>B){
            for(int i = A; i >= B; i--) System.out.print(i + " ");
        }
        else System.out.println("A равно B.");
    }

    public static void sumOfDigits(){
        int k, s, sum = 0, tmp, count = 0;
        System.out.println("Введите число k.");
        k = sc.nextInt();
        System.out.println("Введите число s.");
        s = sc.nextInt();
        for(int i = (int)Math.pow(10, k - 1); i<(int)Math.pow(10, k); i++){
            tmp = i;
            while(tmp>0){
                sum += (tmp%10);
                tmp /= 10;
            }
            if(sum == s) count++;
            sum = 0;
        }
        System.out.println("Cуществует " + count + " k-значных натуральных чисел, сумма цифр которых равна s");
    }

    public static int sumOfNumbersDigits(int num){
        if(num <= 0) return num;
        return num % 10 + sumOfNumbersDigits(num / 10);
    }

    public static void isSimple(long num, long cons) {
        if (num > 1) {
            if (num % cons != 0) {
                cons++;
                isSimple(num, cons);
            }
            else if (num % cons == 0) {
                if (cons == num) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    public static void factorization(int num, int cons){
        if (num % cons == 0 & cons != num) {
            System.out.print(cons + " ");
            factorization(num / cons, cons);
        }
        else{
            if(cons == num) System.out.println(cons);
            else{
                cons++;
                factorization(num, cons);
            }
        }
    }

    public static void palindrome(){
        String str = new String();
        sc.nextLine();
        str = (sc.nextLine());
        if(str.equals(new StringBuffer(str).reverse().toString())) System.out.println("YES");
        else System.out.println("NO");
    }

    public static int withoutTwoZeros(int a, int b){
        if(a > b + 1) return 0;
        if(a == 0 || b ==0) return 1;
        return withoutTwoZeros(a, b-1) + withoutTwoZeros(a-1, b-1);
    }

    public static int numberReversal(int num, int b){
        if(num == 0) return b;
        else{
            b = b * 10 + num % 10;
            num /= 10;
            return numberReversal(num, b);
        }
    }

    public static void amOfUnits(){
        int fir = sc.nextInt();
        int sec = sc.nextInt();
        int count = 0;
        while(fir != 0 || sec != 0){
            if(fir == 1) count++;
            fir = sec;
            sec = sc.nextInt();
        }
        System.out.println(count);
    }

    public static void oddSeqNums(){
        int[] arr = new int[100];
        int k = 0;
        int tmp = sc.nextInt();
        while(tmp != 0){
            if(tmp % 2 != 0) {
                arr[k] = tmp;
                k++;}
            tmp = sc.nextInt();
        }
        for (int i = 0;i<k;i++) System.out.print(arr[i] + " ");
    }

    public static void oddNumberedSequenceMembers(){
        int[] arr = new int[100];
        int k = 0;
        int tmp = sc.nextInt();
        while(tmp != 0){
            arr[k] = tmp;
            k++;
            tmp = sc.nextInt();
        }
        for (int i = 0;i < k;i += 2) System.out.print(arr[i] + " ");
    }

    public static String digitsNumbersFromLeftToRight(int num){
        if (num < 10){
            return Integer.toString(num);
        }
        else{
            return digitsNumbersFromLeftToRight(num / 10) + " " + num % 10;
        }
    }

    public static int digitsNumbersFromRightToLeft(int num){
        if (num <= 0) {
            return num;
        }
        else {
            System.out.print(num % 10 + " ");
            return digitsNumbersFromRightToLeft(num / 10);
        }
    }

    public static void numberOfElementsEqualToMaximum(int max, int count) {
        int n = sc.nextInt();
        if (n > 0){
            if (n > max){
                numberOfElementsEqualToMaximum(n, 1);
            }
            else if (n == max){
                numberOfElementsEqualToMaximum(max, ++count);
            }
            else{
                numberOfElementsEqualToMaximum(max, count);
            }
        }
        else{
            System.out.println(count);
        }

    }

    public static int maximumConsistency(){
        int num = sc.nextInt();
        if (num == 0) {
            return 0;
        }
        else {
            return Math.max(num, maximumConsistency());
        }
    }

    public static void main(String[] args) {


        System.out.println("Задание 1. Треугольная последовательность.");
        triangSeq(sc.nextInt());

        System.out.println("\nЗадание 2. От 1 до n.");
        oneToN();

        System.out.println("\nЗадание 2. От A до B.");
        AtoB();

        System.out.println("\nЗадание 4. Заданная сумма цифр.");
        sumOfDigits();

        System.out.println("Задание 5. Сумма цифр числа.");
        System.out.println(sumOfNumbersDigits(sc.nextInt()));

        System.out.println("Задание 6. Проверка числа на простоту.");
        isSimple(sc.nextInt(), 2);

        System.out.println("Задание 7. Разложение на множители.");
        factorization(sc.nextInt(),2);

        System.out.println("Задание 8. Палиндром.");
        palindrome();

        System.out.println("Задание 9. Без двух нулей.");
        System.out.println(withoutTwoZeros(sc.nextInt(), sc.nextInt()));

        System.out.println("Задание 10. Разворот числа.");
        System.out.println(numberReversal(sc.nextInt(), 0));

        System.out.println("Задание 11. Количество единиц.");
        amOfUnits();

        System.out.println("Задание 12. Нечетные числа последовательности.");
        oddSeqNums();

        System.out.println("\nЗадание 13. Члены последовательности с нечетными номерами.");
        oddNumberedSequenceMembers();

        System.out.println("\nЗадание 14. Цифры числа слева направо.");
        System.out.println(digitsNumbersFromLeftToRight(sc.nextInt()));

        System.out.println("Задание 15. Цифры числа справа налево.");
        digitsNumbersFromRightToLeft(sc.nextInt());

        System.out.println("\nЗадание 16. Количество элементов, равных максимуму.");
        numberOfElementsEqualToMaximum(0,0);

        System.out.println("Задание 17. Максимум последовательности.");
        System.out.println(maximumConsistency());
    }

}
