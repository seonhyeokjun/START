package study;

import java.util.Scanner;

public class sohyunstudy {
    public static void avg(int x, int y){
        System.out.println((x+y)/2);
    }
    public static void sum(int x, int y){
        System.out.println(x+y);
    }
    public static void main(String[] args) {

        Scanner left = new Scanner(System.in);
        Scanner right = new Scanner(System.in);

        int x = left.nextInt();
        int y = right.nextInt();

        sum(x, y);
        avg(x, y);

    }
}