import java.util.*;
import java.util.regex.*;

class Solution {
    
    // 단어 정보(단어 텍스트, 시작 인덱스, 끝 인덱스)를 담는 내부 클래스
    static class Word {
        String text;
        int start;
        int end;

        Word(String text, int start, int end) {
            this.text = text;
            this.start = start;
            this.end = end;
        }
    }

    // 두 구간 [wStart, wEnd]와 [sStart, sEnd]가 한 글자라도 겹치는지 판단하는 메서드
    private boolean isOverlapped(int wStart, int wEnd, int sStart, int sEnd) {
        return wStart <= sEnd && wEnd >= sStart;
    }

    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;

        // 1. message에서 모든 단어와 해당 단어의 (시작, 끝) 위치 추출하기
        List<Word> words = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\S+"); // 공백이 아닌 문자열 단위
        Matcher matcher = pattern.matcher(message);

        while (matcher.find()) {
            String text = matcher.group();
            int start = matcher.start();
            int end = matcher.end() - 1; // matcher.end()는 단어 바로 다음 인덱스이므로 -1
            words.add(new Word(text, start, end));
        }

        // 2. 어떤 스포 방지 구간과도 겹치지 않는 "일반 단어(plainWords)"들 구하기
        Set<String> plainWords = new HashSet<>();
        for (Word word : words) {
            boolean isSpoilerWord = false;

            // 하나의 단어가 여러 스포 구간 중 하나라도 겹치는지 체크
            for (int[] range : spoiler_ranges) {
                if (isOverlapped(word.start, word.end, range[0], range[1])) {
                    isSpoilerWord = true;
                    break;
                }
            }

            // 어떤 스포 구간과도 겹치지 않았다면 노출된 일반 단어!
            if (!isSpoilerWord) {
                plainWords.add(word.text);
            }
        }

        // 3. 스포 방지 구간을 순서대로 클릭하면서 중요한 단어 카운트하기
        Set<String> seenSpoilerWords = new HashSet<>(); // 이미 클릭해서 공개 처리된 스포 단어들

        for (int[] range : spoiler_ranges) {
            int sStart = range[0];
            int sEnd = range[1];

            for (Word word : words) {
                // 현재 클릭한 스포 방지 구간과 겹쳐서 공개되는 단어인가?
                if (isOverlapped(word.start, word.end, sStart, sEnd)) {

                    // 조건 1: 일반 단어로 등장한 적 없음 (!plainWords.contains)
                    // 조건 2: 이전에 이미 공개되었던 스포 단어도 아님 (!seenSpoilerWords.contains)
                    if (!plainWords.contains(word.text) && !seenSpoilerWords.contains(word.text)) {
                        answer++;
                        seenSpoilerWords.add(word.text); // 이제 이 단어는 공개된 단어로 등록
                    }
                }
            }
        }

        return answer;
    }
}