class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            indegree[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)q.add(i);
        }

        int fin=0;
        while(!q.isEmpty()){
            int node=q.poll();
            fin++;
            for(int n:adj.get(node)){
                indegree[n]--;
                if(indegree[n]==0)q.add(n);
            }
        }

        return fin==numCourses;
    }
}
