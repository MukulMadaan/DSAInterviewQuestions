import java.util.Scanner;
class pair{
    int max;
    int min;
}
public class MinMax {
    public static pair find(int[] arr, int lo, int hi){
        pair p = new pair();
        pair p1 = new pair();
        pair p2 = new pair();
        if(lo == hi){
            p.max = arr[lo];
            p.min = arr[lo];
            return p;
        } else if(lo == hi - 1) {
            if (arr[lo] > arr[hi]) {
                p.max = arr[lo];
                p.min = arr[hi];
            } else {
                p.max = arr[hi];
                p.min = arr[lo];
            }
            return p;
        } else{
            int mid = lo + (hi - lo)/2;
            p1  = find(arr,0, mid);
            p2 = find(arr,mid + 1, hi);
        }

        if (p1.min < p2.min) {
            p.min = p1.min;
        } else {
            p.min = p2.min;
        }

        /* compare maximums of two parts*/
        if (p1.max > p2.max) {
            p.max = p1.max;
        } else {
            p.max = p2.max;
        }

        return p;
    }
    public static void main (String[] args) {
        int n;
        pair ans = new pair();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = sc.nextInt();
        }
        ans = find(arr, 0, n - 1);
        System.out.println("Min in the array is : " + ans.min);
        System.out.println("Max in the array is : " + ans.max);
    }
}

//Time Complexity: O(n) 
//Total number of comparisons: let the number of comparisons be T(n). T(n) can be written as follows: 
//Algorithmic Paradigm: Divide and Conquer 
//Thus, the approach does 3n/2 -2 comparisons if n is a power of 2. And it does more than 3n/2 -2 comparisons if n is not a power of 2.
