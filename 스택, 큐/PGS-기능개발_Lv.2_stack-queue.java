import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        
        int p = 0;  // 완료된 작업 다음을 가리킬 포인터
        while(p < speeds.length) {
            for(int i = 0; i < speeds.length; i++) {
                progresses[i] += speeds[i];
            }
            
            int count = 0;
            for(int i = p; i < speeds.length; i++) {
                // 작업량 달성 못했다면 탈락
                if(progresses[i] < 100) {
                    break;
                }
                count++;
                p++;
            }
            // 작업량 있다면
            if(count > 0) {
                result.add(count);
            }
        }
                
        int[] answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
