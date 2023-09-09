class Solution {
public:
    int romanToInt(string s) {
        map<char,int>mpp;
        
        mpp['I'] = 1;
        mpp['V']=5;
        mpp['X']=10;
        mpp['L']=50;
        mpp['C']=100;
        mpp['D']=500;
        mpp['M']=1000;
        
        vector<int>ans;
        
        for(int i=0;i<s.length();i++){
            ans.push_back(mpp[s[i]]);
        }
        int sum=0;
        sum+=ans[0];
        
        for(int i=1;i<ans.size();i++){
            if(ans[i-1]<ans[i]) sum-=(2*ans[i-1]);
            sum+=ans[i];
        }
        
        return sum;
    }
    
};