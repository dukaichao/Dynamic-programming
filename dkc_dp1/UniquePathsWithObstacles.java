package dkc_dp1;

import java.util.ArrayList;
import java.util.List;

public class UniquePathsWithObstacles {
	public static void main(String[] args) {
		int[][] arr = new int[][] {{0,0,0},{0,1,0},{0,0,0,0}};
		System.out.println(arr.length);
		System.out.println(uniquePathsWithObstacles(arr));
	}
	public static int uniquePathsWithObstacles(int[][] arr) {
		int m = arr.length;
		int n = arr[0].length;
		if(arr[0][0] == 1 || arr[m-1][n-1] == 0) return 0;
		if(m == 1) {
			for(int j = 1;j<n;j++) {
				if(arr[0][j] == 1) 
					return 0;
			}
			return 1;
		}
		if(n == 1) {
			for(int i = 1;i < m;i++) {
				if(arr[i][0] == 1) 
					return 0;
			}
			return 1;
		}
		int[][] array = new int[m][n];
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		for(int i = 1;i<n;i++) {
			list1.add(arr[0][i]);
		}
		for(int i = 1;i<m;i++) {
			list1.add(arr[i][0]);
		}
		if(list1.contains(1)) {
			for(int i = 1;i<n;i++)
				array[0][i] = 0;
		}else {
			for(int i = 1;i<n;i++)
				array[0][i] = 1;
		}
		if(list2.contains(1)) {
			for(int i = 1;i<m;i++) {
				arr[i][0] = 0;
			}
		}else {
			for(int i = 1;i<n;i++)
				array[0][i] = 1;
		}
		for(int i = 1;i<m;i++) {
			for(int j = 1;j<n;j++) {
				if(arr[i][j] == 1) {
					array[i][j] = 0;
				}else {
					
					array[i][j] = array[i-1][j] + array[i][j - 1];
				}
			}
		}
		return array[m-1][n-1];
	}
}
