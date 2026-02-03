/*
Given two numbers N and M, find the Nth root of M. The nth root of a number M is defined as a number X when raised to the power N equals M. If the 'nth root is not an integer, return -1.

Examples
Input: N = 3, M = 27
Output: 3
Explanation: The cube root of 27 is equal to 3.
Input : N = 4, M = 69
Output: -1
Explanation : The 4th root of 69 does not exist. So, the answer is -1.
*/

// code
public class NthRootOfANumber{
    public static void main(String[] args) {
        System.out.println(solution(4,69));
    }
    public static int solution(int N,int M){
        int low= 1;
        int high= M;
        while (low <= high){
            int mid= low + (high-low)/2;
            int root= root(mid,N);
            if(root== M){
                return mid;
            }else if(root > M){
                high= mid-1;
            }else {
                low= mid+1;
            }
        }
        return -1;
    }
    public static int root(int mid,int N){
        int ans= 1;
        for (int i = 1; i <= N; i++) {
            ans *= mid;
        }
        return ans;
    }
}
