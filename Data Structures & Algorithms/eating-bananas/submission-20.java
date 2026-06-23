class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int i=0;
        int max=piles[0];
        while(i<piles.length)
          {
            if(max<piles[i])
               max=piles[i];
               i++;
          }
        int left=1,right=max;
        while(left<right)
        {
           int mid=left+(right-left)/2; 
           if(hForK(piles,mid)<=h)
             right=mid;
           else 
             left=mid+1;
        }
        return left;
    }
}

int hForK(int[] piles, int k)
{
    int h=0,i=0;
    while(i<piles.length)
    {
       int div=piles[i]/k;
       int additive=piles[i++]%k==0?div:div+1;
       h+=additive;
    }
    return h;
}