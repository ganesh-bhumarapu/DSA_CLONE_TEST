import java.util.*;
class MinNoOfDeletion{
    static int lpsTopDown(String str,int start,int end,Integer[][] arr){
        if(start>end){
            return 0;
        }
        if(start==end){
            return 1;
        }
        if(arr[start][end]==null){
            if(str.charAt(start)==str.charAt(end)){
                arr[start][end]=2+lpsTopDown(str,start+1,end-1,arr);
            }
            else{
                arr[start][end]=Math.max(lpsTopDown(str,start+1,end,arr),lpsTopDown(str,start,end-1,arr));
            }
        }
        return arr[start][end];
    }
    static int minDeletionForPalindrome(String str){
        int n=str.length();
        if(str==null || n==0){
            return 0;
        }
        Integer[][] arr=new Integer[n][n];
        return n-lpsTopDown(str,0,n-1,arr);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(minDeletionForPalindrome(str));
    }
}