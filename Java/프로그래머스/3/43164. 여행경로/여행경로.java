import java.util.*;
class Solution {
    static List<String> route = new ArrayList<>();
    static boolean[] visited;
    static Map<String, List<String>> flightMap = new HashMap<>();
    public String[] solution(String[][] tickets) {
        for(String[] ticket : tickets){
            String from = ticket[0];
            String to = ticket[1];
            
            flightMap.putIfAbsent(from, new ArrayList<>());
            flightMap.get(from).add(to);
        }
        
        for(List<String> destination : flightMap.values()){
            Collections.sort(destination);
        }
        
        dfs("ICN", tickets.length);
        
        return route.toArray(new String[route.size()]);
    }
    
    static boolean dfs(String airport, int cnt){
        route.add(airport);
        
        if(route.size() == cnt+1){
            return true;
        }
        
        if(flightMap.containsKey(airport)){
            List<String> destinations = flightMap.get(airport);
            List<String> temp = new ArrayList<>(destinations);
            
            for(int i=0; i<temp.size(); i++){
                String next = temp.get(i);
                destinations.remove(next);
                
                if(dfs(next, cnt)) {
                    return true;
                }
                
                destinations.add(i, next);
            }
        }
        
        route.remove(route.size()-1);
        return false;
    }
}