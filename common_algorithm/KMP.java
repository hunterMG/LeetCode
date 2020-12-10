
public class KMP {
    public int[] getNext(String s){
        int[] next = new int[s.length()];
        int j = 0;
        next[0] = j;
        for(int i = 1; i < s.length(); i++){
            while(j > 0 && s.charAt(i) != s.charAt(j)){
                j = next[j-1];
            }
            if(s.charAt(i) == s.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public int strStr(String haystack, String needle){

        int[] next = getNext(needle);
        int j = 0;
        for(int i = 0; i < haystack.length(); i++){
            while(j>0 && haystack.charAt(i) != needle.charAt(j)){
                j = next[j-1];
            }
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if(j == needle.length()){
                return (i- needle.length() +1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String pat = "ll";
        String s = "hello";
        KMP k = new KMP();
        System.out.println(k.strStr(s, pat));
    }
}

// aabaabaaf
// aabaaf