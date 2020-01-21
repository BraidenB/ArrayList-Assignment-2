import java.util.Scanner;
import java.util.ArrayList;

class Question1and2 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in); 

        //int nums = sc.nextInt();

        primeNumbers(100);
    }

    public static void primeNumbers(int nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int f = 2; f <= nums; f++) {
            list.add(f);
        }

        System.out.println("The List is: " +list);

        boolean remove = false;

        for(int i = list.size()-1; i >= 0; i--) {
            int check = list.get(i);
            for(int p = 2; p < nums; p++) {
                if(check%p == 0 && check > p) {
                    remove = true;
                }
            }
            if(remove) {
                list.remove(i);
            }
            remove = false;
        }

        System.out.println("The New List is: " +list);

        Goldbach(list);
    }

    public static void Goldbach(ArrayList<Integer> list) {
        Scanner sc = new Scanner(System.in); 
        ArrayList<Integer> newList = new ArrayList<Integer>();
        int number = sc.nextInt();
        boolean cancel = false;

        for(int i = list.size()-1; i >= 0; i--) {
            int check = list.get(i);
            for(int p = list.size()-2; p >= 0; p--) {
                int check2 = list.get(p);
                if((check + check2) == number) {
                    newList.add(check);
                    newList.add(check2);
                    cancel = true;
                }
            }
            if(cancel) {
                i = -1;
            }
        }

        System.out.println("The Prime Numbers that sum to " + number + " are: " + newList.get(0) + " + " + newList.get(1));
    }
}
