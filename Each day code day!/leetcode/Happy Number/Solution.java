/* 

Write an algorithm to determine if a number n is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Return True if n is a happy number, and False if not.


--> the catch if too find when to stop, i.e when digits start to repeat itself
*/


public class Solution{

    public static void main(String[] args) {

        System.out.println(isAHappyNumber(19));
        System.out.println(isAHappyNumber(11));
        System.out.println(isAHappyNumber(2));
    }

    static boolean isAHappyNumber(int number){
        int slow = number;
        int fast = squaredSum(number);

        while(slow != fast){
            slow = squaredSum(slow);
            //increment the fast pointer x2 times
            fast = squaredSum(fast);
            fast = squaredSum(fast);

        }
        //return true if slow == 1 else false
        return slow == 1;
    }

    static int squaredSum(int number){
        int squaredSum = 0;
        while(number != 0){
            int digit = number %10;
            squaredSum += (digit * digit);
            number/=10;
        }
        return squaredSum;
    }
}


// Intuition:
//Floyd's Cycle detection algorithm! Here's why, the main problem 
// is when we should stop or return false and here is the answer to it if a  
// number isn't happy then it'd have a cycle in it and we'd repeat to see 
// numbers we've seen before. How do I know it ?? Analyse the pattern for
// any unhappy number.

// Whether the number is happy or not, by using Floyd's cycle algorithm or
// Tortoise and hare algo, we'd see that regardless of happy or unhappy the
// the two pointers will meet and if they are 1 then return true else return false.

// example,
//input: 2 (unhappy number)
// slow = 2 -> 4 -> 16 -> 37 -> 89 -> 145 -> 42 -> 20 -> 4 -> 16 -> 37......-> 42
// fast = 2 -> 16 -> 89 -> 42 -> 4 -> 37 -> 4 -> 37 -> 145 -> 42 -> 4.......-> 42

//input: 19(happy number)
// slow = 7 -> 49 -> 97 -> 130 -> 10 -> 1
// fast = 7 -> 97 -> 10 -> 1 -> 1 -> 1

// after many iterations, both pointers will meet and if it's a happy number 
// both will have 1 value in them and if it's a unhappy number they will
// have some value other than 1.
