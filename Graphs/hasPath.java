public static boolean hasPath(ArrayList<Edge> graph[],int src,int dest, boolean visited[]){
    if(src==dest){
        return true;
    }
    visited[src]=true;
    for(Edge e:graph[src]){
        if(visited[e.nbr]==false){
            return hasPath(graph,e.nbr,dest,visited);
        }
    }
    return false;
}
