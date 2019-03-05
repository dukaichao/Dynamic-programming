package dkc_dp1;

public class FindCount {
	public static void main(String[] args) {
		int[] arr = {3,34,4,12,5,2};
		System.out.println(find_count(arr, arr.length - 1, 13));
	}
	public static boolean find_count(int[] arr,int i,int k) {
		if(i == 0) return arr[i] == k;
		if(k == 0) return true;
		if(arr[i] > k) return find_count(arr,i - 1,k);
		boolean a = find_count(arr,i-1,k - arr[i]);
		boolean b = find_count(arr,i - 1,k);
		if(a) return a;
		return b;
	}
}
