import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> userMap = new HashMap<>();
        
        // 최종 닉네임 저장
        for (int i = 0; i < record.length; i++) {
            String[] parts = record[i].split(" ");
            // Leave가 아니면 (Enter 또는 Change) 닉네임 정보가 포함됨
            if (!parts[0].equals("Leave")) {
                userMap.put(parts[1], parts[2]);
            }
        }
        
        // 메시지 생성 
        List<String> answerList = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            String[] parts = record[i].split(" ");
            
            if (parts[0].equals("Enter")) {
                answerList.add(userMap.get(parts[1]) + "님이 들어왔습니다.");
            } else if (parts[0].equals("Leave")) {
                answerList.add(userMap.get(parts[1]) + "님이 나갔습니다.");
            }
        }
        
        // List를 String[] 배열로 변환하여 반환
        return answerList.toArray(new String[0]);
    }
}