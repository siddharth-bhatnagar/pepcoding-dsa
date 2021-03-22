// Leetcode 895 - maximum frequency stack
// time - O(1), space - O(n)
class FreqStack {
    
    HashMap<Integer, Stack<Integer>> st = new HashMap<>();
    HashMap<Integer, Integer> fmap = new HashMap<>();
    int maxFreq = 0;
    
    public FreqStack() {
        
    }
    
    public void push(int val) {
        int freq = fmap.getOrDefault(val, 0);
        freq++;
        fmap.put(val, freq);
        
        if(st.containsKey(freq)==false){
            st.put(freq, new Stack<Integer>());        
        }
        
        st.get(freq).add(val);
        maxFreq = Math.max(freq, maxFreq);
        
    }
    
    public int pop() {
        int ans = st.get(maxFreq).pop();
        int freq = fmap.get(ans);
        freq--;
        fmap.put(ans, freq);
        if(freq==0){
            fmap.remove(ans);
        }
        if(st.get(maxFreq).size()==0){
            st.remove(maxFreq);
            maxFreq--;
        }
        
        return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */