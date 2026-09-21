import java.util.*;
class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        int length = cards.length; // cards 길이 
        
        // 열린 상자인가?
        boolean[] visited = new boolean[length];
        List<Integer> groupSizes = new ArrayList<>();
        
        for (int i = 0; i < length; i++) {
            // 이미 방문한 상자라면 건너뜀
            if (visited[i]) continue;
            
            int currentIndex = i;
            int count = 0;
            
            // 방문하지 않은 상자라면 계속 방문
            while (!visited[currentIndex]) {
                visited[currentIndex] = true;
                currentIndex = cards[currentIndex] - 1;
                count++;
            }
            groupSizes.add(count);
        }
        
        if (groupSizes.size() < 2) {
            return 0;
        }
        
        groupSizes.sort(Collections.reverseOrder());
        
        answer = groupSizes.get(0) * groupSizes.get(1);
        
        return answer;
    }
}