class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            else {
                if (st.isEmpty() || st.peek() != map.get(ch))
                    return false;
                st.pop();
            }
        }
        return st.isEmpty();
    }
}

//The thing to learn from this question is the usage of Maps that have key value pair of opening and closing parenthesis.