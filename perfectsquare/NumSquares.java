package perfectsquare;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * User:Mr.Du
 * Date:2019-05-30
 * Time:20:24
 */
public class NumSquares {
    private int count = 0;
    public static void main(String[] args) {
        System.out.println(numSquares(100));
    }

    /**
     * 定义一个函数f(n)表示我们要求的解。f(n)的求解过程为：
     * f(n) = 1 + min{
     *   f(n-1^2), f(n-2^2), f(n-3^2), f(n-4^2), ... , f(n-k^2) //(k为满足k^2<=n的最大的k)
     * }
     * @param n
     * @return
     */
    public static int numSquares(int n){
        int[] dp = new int[n+1];
        for(int i = 1;i<=n;i++){
            int tmp = Integer.MAX_VALUE;
            for(int j = 1;j * j<=i;j++){
                tmp = Math.min(tmp,dp[i-j*j]);
            }
            dp[i] = tmp + 1;
        }
        return dp[n];
    }
}
