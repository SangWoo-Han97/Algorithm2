import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        
        for(int i = 0; i < prices.length; i++) {          
            while(true) {
                // 현재 가격이 남은 가격정보들 보다 크면 반복 중단
                if(map.size() < 1 || prices[i] >= map.lastKey()) {
                    break;
                }
                
                List<Integer> list = map.get(map.lastKey());
                map.remove(map.lastKey());
                
                for(int j = 0; j < list.size(); j++) {
                    answer[list.get(j)] = i - list.get(j);
                }                
            }
            
            // 새로운 주식 가격, 시간 기록
            if(map.get(prices[i]) == null) {
                map.put(prices[i], new ArrayList<>());
            }
            map.get(prices[i]).add(i);            
        }
        
        for(int key : map.keySet()) {
            List<Integer> list = map.get(key);
            for(int i = 0; i < list.size(); i++) {
                answer[list.get(i)] = prices.length - 1 - list.get(i);
            }
        }
        
        return answer;
    }
}