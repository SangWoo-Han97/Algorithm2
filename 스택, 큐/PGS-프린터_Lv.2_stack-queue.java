import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        LinkedList<Paper> printer = new LinkedList<>();
        int answer = 0;
        for(int i = 0; i < priorities.length; i++) {
            printer.add(new Paper(priorities[i], i));
        }
        
        int count = 0;
        while(true) {
            Paper cur = printer.poll();
            boolean isFirst = true;
            for(int i = 0; i < printer.size(); i++) {
                if(cur.p < printer.get(i).p) {
                    isFirst = false;
                    printer.add(cur);
                    break;
                }
            }
            if(isFirst) {
                count++;
                if(cur.l == location) {
                    answer = count;
                    break;
                }
            }
        }
        
        return answer;
    }
}

class Paper {
    int p, l;
    public Paper(int p, int l) {
        this.p = p;
        this.l = l;
    }
}