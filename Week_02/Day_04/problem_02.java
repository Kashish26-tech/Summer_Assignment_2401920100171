//Decode Strings

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();

        StringBuilder curr = new StringBuilder();
        int n = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                n = n * 10 + (ch - '0');
            }

            else if (ch == '[') {
                countStack.push(n);
                strStack.push(curr);

                n = 0;
                curr = new StringBuilder();
            }

            else if (ch == ']') {
                int repeat = countStack.pop();
                StringBuilder prev = strStack.pop();

                for (int i = 0; i < repeat; i++) {
                    prev.append(curr);
                }

                curr = prev;
            }

            else {
                curr.append(ch);
            }
        }

        return curr.toString();
    }
}
