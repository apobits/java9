package apo.java.practice.daily;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.SequencedCollection;
import java.util.Set;

public class DailyPractice {
    void main() {

        System.out.println(reverse(Integer.MAX_VALUE));
    }

    public int reverse(int x) {
        long temp;
        if(x < 0){
            temp = x * -1L;
        }else{
            temp = x;
        }

        long reversed = 0L;
        while(temp != 0){
            reversed *= 10;
            reversed += temp % 10;
            temp = temp / 10;
        }

        if(x < 0){
            reversed *= -1;
        }

        if(reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE){
            return 0;
        }

        return (int)reversed;
    }
}