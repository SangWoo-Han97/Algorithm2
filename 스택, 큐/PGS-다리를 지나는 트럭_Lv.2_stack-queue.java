import java.util.;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int[] bridge = new int[bridge_length + 1];
        QueueInteger trucks = new LinkedList();
        for(int i = 0; i  truck_weights.length; i++) {
            trucks.offer(truck_weights[i]);
        }
        
        int weightSum = 0, time = 0;
        while(true) {
            time++;            
            weightSum -= bridge[0];
            
             대기 트럭이 다리에 들어갈 수 있으면 다리 끝 + 1에 진입
            if(!trucks.isEmpty() && weightSum + trucks.peek() = weight) {
                bridge[bridge_length] = trucks.poll();
                weightSum += bridge[bridge_length];
            }            
            
             다리 한칸 씩 당기기
            for(int i = 0; i  bridge_length; i++) {
                bridge[i] = bridge[i + 1];
            }
            bridge[bridge_length] = 0;
            
            if(weightSum == 0 && trucks.isEmpty()) {
                break;
            }
        }
        
        return time;
    }
}