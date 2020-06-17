
public class longest_common_subsequence {
	public static void main(String[] args) {
		String str1 = "bqdrcvefgh";
		String str2 = "abcvdefgh";
		
		int longestLen = computeLongestCommon(str1, str2);
		
		System.out.println("The length of the longest common subsequence: " + longestLen);
	}
	
	private static int computeLongestCommon(String str1, String str2) {
		int rows = str2.length() + 1, cols = str1.length() + 1;
		int[][] dp = new int[rows][cols];
		
		for (int i = 0; i < cols; i++)
			dp[0][i] = 0;
		for (int i = 1; i < rows; i++)
			dp[i][0] = 0;
		
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				if (str2.charAt(i-1) != str1.charAt(j-1))
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				else
					dp[i][j] = dp[i-1][j-1] + 1;
			}
		}
		
		return dp[rows-1][cols-1]; 
	}
}
