/*cpp program to find Levenshtein distance (edit distance) between two strings*/

#include <bits/stdc++.h>
using namespace std;

//we will try to convert str1 to str2
int editDistance(string str1, string str2, int m, int n) 
{ 
    // Create a table to store results of subproblems 
    int dp[m+1][n+1]; 
  
    // Fill d[][] in bottom up manner 
    for (int i=0; i<=m; i++) 
    { 
        for (int j=0; j<=n; j++) 
        {              
            if (i==0) 
                dp[i][j] = j;  // Min. operations = j insertions

            else if (j==0) 
                dp[i][j] = i; // Min. operations = i deletions
  
            // If last characters are same, ignore last char and recur for remaining string 
            else if (str1[i-1] == str2[j-1]) 
                dp[i][j] = dp[i-1][j-1]; 
  
            // If the last character is different, find the min for all possiblities of operations
            else
                dp[i][j] = 1 + min(min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]); //Insert, Remove and Replace respectively
        } 
    }   
    return dp[m][n]; 
} 
int main()  //main function body. takes two strings and their lengths and calls 
{
	int t;
    cout<<"enter number of test cases: "<<endl;
	cin>>t;
	while(t--)
	{
	    int n,m;
        cout<<"enter lengths of string 1 and 2"<<endl;
	    cin>>m>>n;
	    char a[m];
	    char b[n];
        cout<<"enter string 1: ";
	    for(int i=0;i<m;i++)
	    {
	        cin>>a[i];
	    }
        cout<<"enter string 2: ";
	    for(int i=0;i<n;i++)
	    {
	        cin>>b[i];
	    }
	    cout<<"Levenshtein distance between both strings is:  "<<editDistance(a,b,m,n)<<endl;;
	}
	return 0;
}