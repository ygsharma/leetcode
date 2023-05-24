class Solution:
    def isPalindrome(self, s: str) -> bool:
        
        s = s.lower()
        s = s.replace(' ', '')
        res = ''
        for i in s:
            if (97 <= ord(i) <=122 ) or (0 <= ord(i) - ord('0') <= 9):
                res += i

        
        left = 0
        right = len(res)-1
       
        while(left<right):
            if(res[left] != res[right]): 
                return False

            left+=1;
            right-=1;

        return True


