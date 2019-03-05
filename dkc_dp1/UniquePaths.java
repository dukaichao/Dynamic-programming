package dkc_dp1;
/*
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * 
 
 */

 
public class UniquePaths {
	
	public static void main(String[] args) {
		System.out.println(dp_uniquePaths(70, 9));
	}
	/**
	 * 
	 * @param m
	 * @param n
	 * @return
	 * 
	 * 递归方法：根据题意我们可以分析得出，计F(m,n)为到达横坐标为m,纵坐标为n的路径数，则
	 * F(m,n) = F(m-1,n) + F(m,n-1) 
	 * 当m = 1,n = 1时，此时就是起始位置，直接返回1;
	 * 当m = 1 时，n为任意值时，则F(1,n) = F(1,n - 1)
	 * 当n = 1 时，m为任意值，则F(m,1) = F(m - 1,1)
	 * 
	 */

	//递归法,数据如果大的话，会发生栈溢出，一般不建议使用递归
	public static int rec_uniquePaths(int m,int n) {
		if(m == 1 && n == 1) return 1;
		if(m == 1) return rec_uniquePaths(m, n - 1);
		if(n == 1) return rec_uniquePaths(m - 1, n);
		return rec_uniquePaths(m-1, n) + rec_uniquePaths(m, n - 1);
	}
	/**
	 * 
	 * @param m
	 * @param n
	 * @return
	 * 
	 * 动态规划：我们可以定义二维数组arr，横坐标为m，纵坐标为n
	 * 根据题意，我们令arr[0][0] = 1,arr[0][j] = 1,arr[i][0] = 1,其中0<i<m,0<j<n
	 * arr[i][j] = arr[i-1][j] + arr[i][j - 1]
	 * 最后直接返回二维数组最后一个数组
	 */
	//动态规划方法
	public static long dp_uniquePaths(int m,int n) {
		if(m == 1 || n == 1) return 1;
		long[][] arr = new long[m][n];
		arr[0][0] = 1;
		for(int i = 1;i<m;i++) {
			for(int j = 1;j<n;j++) {
				if(i - 1 == 0 ) {
					arr[i - 1][j] = 1;
				}
				if(j - 1 == 0) {
					arr[i][j - 1] = 1;
				}
				arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
			}
		}
		return arr[m-1][n-1];
	}
}
