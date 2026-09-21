class Solution {
    boolean solution(String s) {
        boolean answer = false;

        int counter = 0;
        
        for (char c : s.toCharArray()) {
            if (c=='(') {
                counter++;
            }
            else {
                counter--;
            }
            if (counter < 0) {
                return answer;
            }
        }
        
        if (counter == 0) {
            answer = true;
        }

        return answer;
    }
}