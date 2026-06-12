//String compression

class Solution {
    public int compress(char[] chars) {
        //two pointer approach

        int read = 0;
        int write = 0;

        while(read < chars.length) {
            char curr = chars[read];
            int count = 0;
            while(read < chars.length && chars[read] == curr) {
                read++;
                count++;
            }

            chars[write++] = curr;

            if(count > 1) {
                //int -> string -> char
                for(char countVal : String.valueOf(count).toCharArray()) {
                    chars[write++] = countVal;
                }
            }
        }
        return write;
    }
}
