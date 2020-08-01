
private static int optimalbst(int[] frequency,int lo, int hi,int dp[][]) {
    //write your code here
    if(lo==hi){
        return frequency[lo];
    }
    if(dp[lo][hi]!=0){
        return dp[lo][hi];
    }
    int min=Integer.MAX_VALUE;
    int sumOfNodes=0;
    for(int cp=lo;cp<=hi;cp++){
        sumOfNodes+=frequency[cp];
        int lc=cp-1>=lo?optimalbst(frequency,lo,cp-1,dp):0;
        int rc=cp+1<=hi?optimalbst(frequency,cp+1,hi,dp):0;
        int myc=lc+rc;
        min=Math.min(min,myc);
    }
    min+=sumOfNodes;
    dp[lo][hi]=min;
    return min;
}


//tabulation
public static void optimalbst(int frequency[]){
	    int n=frequency.length;
	    int dp[][]=new int[n][n];
	    for(int gap=0;gap<n;gap++){
	        for(int st=0,ed=gap;ed<n;ed++,st++){
	            if(st==ed){
	                dp[st][ed]=frequency[st];
	                continue;
	            }
	            int min=Integer.MAX_VALUE;
                int sumOfNodes=0;
	            for(int cp=st;cp<=ed;cp++){
	                sumOfNodes+=frequency[cp];
	                int lc=cp-1>=st?dp[st][cp-1]:0;
	                int rc=cp+1<=ed?dp[cp+1][ed]:0;
	                int myc=lc+rc;
                    min=Math.min(min,myc);
	            }
	            dp[st][ed]=min+sumOfNodes;
	        }
	    }
	    System.out.println(dp[0][n-1]);
	}