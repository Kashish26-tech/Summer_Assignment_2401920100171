//Reverse words in a string

class Solution {
    public String reverseWords(String s) { //O(n)
        char arr[] = s.toCharArray();
        int start = 0;
        for(int end=0; end<=arr.length; end++) {
            if(end == arr.length || arr[end] == ' ') {
                reverseWord(arr, start, end-1);
                start = end+1;
            }
        }
        return new String(arr);
    }

    public void reverseWord(char arr[], int le, int re) {
        while(le < re) {
            char temp = arr[le];
            arr[le] = arr[re];
            arr[re] = temp;
            le++; //left end
            re--; //right end
        }
    }
}
