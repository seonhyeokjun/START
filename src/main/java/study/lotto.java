package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class lotto {
    public static void main(String[] args) {
        int [] lotto = new int[6];
        Random random = new Random();
        List<Integer> number = new ArrayList<>();

        System.out.println("로또번호");

        for (int i=0;i<45;i++){
            number.add(i);
        }
        for (int x=0;x< lotto.length;x++){
            int select = number.get(random.nextInt(number.size())+1);
            lotto[x] = select;
            number.remove(Integer.valueOf(select));
        }
        System.out.println(Arrays.toString(lotto));
    }
}
