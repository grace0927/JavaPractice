# Graph

1. [Course Schedule II](#course-schedule-ii)
2. [Reconstruct Itinerary](#reconstruct-itinerary)

## Course Schedule II
Q: There are a total of n courses you have to take, labeled from 0 to n - 1. Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1] Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses. There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.    
good dfs solution: https://leetcode.com/discuss/35605/two-ac-solution-in-java-using-bfs-and-dfs-with-explanation   
```
// bfs
public int[] findOrder(int numCourses, int[][] prerequisites) {
    HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    int[] degree = new int[numCourses];
    for(int i=0; i<prerequisites.length; i++) {
        if(!graph.containsKey(prerequisites[i][1])) {
            graph.put(prerequisites[i][1], new ArrayList<>());
        }
        graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        degree[prerequisites[i][0]]++;
    }
    
    ArrayList<Integer> res = new ArrayList<>();
    LinkedList<Integer> queue = new LinkedList<>();
    for(int i=0; i<numCourses; i++) {
        if(degree[i]==0) {
            queue.add(i);
        }
    }
    while(!queue.isEmpty()) {
        int i = queue.poll();
        res.add(i);
        if(graph.containsKey(i)) {
            for(int j:graph.get(i)) {
                degree[j]--;
                if(degree[j]==0) {
                    queue.add(j);
                }
            }
        }
    }
    
    return (res.size()==numCourses)?convert(res):new int[0];
}

private int[] convert(ArrayList<Integer> res) {
    int n = res.size();
    int[] arr = new int[n];
    for(int i=0; i<n; i++) {
        arr[i] = res.get(i);
    }
    return arr;
}
```

##Reconstruct Itinerary
Q: Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK. Note: If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"]. All airports are represented by three capital letters (IATA code). You may assume all tickets form at least one valid itinerary.   
good ref: https://leetcode.com/discuss/84659/short-ruby-python-java-c   
```
public List<String> findItinerary(String[][] tickets) {
    HashMap<String, ArrayList<String>> graph = new HashMap<>();
    for(int i=0; i<tickets.length; i++) {
        if(!graph.containsKey(tickets[i][0])) {
            graph.put(tickets[i][0], new ArrayList<>());
        }
        graph.get(tickets[i][0]).add(tickets[i][1]);
    }
    
    for(String key:graph.keySet()) {
        Collections.sort(graph.get(key));
    }
    
    List<String> list = new ArrayList<>();
    list.add("JFK");
    helper(list, graph, "JFK", tickets.length+1);
    return list;
}
// dfs
private void helper(List<String> list, HashMap<String, ArrayList<String>> graph, String from, int size) {
    if(!graph.containsKey(from)) {
        return ;
    }
    
    String[] tos = graph.get(from).toArray(new String[0]);
    for(int i=0; i<tos.length; i++) {
        String to = tos[i];
        list.add(to);
        graph.get(from).remove(to);
        helper(list, graph, to, size);
        if(list.size()==size) {
            return ;
        }
        graph.get(from).add(i, to);
        list.remove(list.size()-1);
    }
}
```




