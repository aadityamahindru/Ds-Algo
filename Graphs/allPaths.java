public static void paths(ArrayList<Edge> graph[] ,int src,int dest,String psf,boolean visited[]){
       if(src==dest){
           psf+=src;
           System.out.println(psf);
           return;
       }
       visited[src]=true;
       for(Edge e:graph[src]){
           if(visited[e.nbr]==false){
               paths(graph,e.nbr,dest,psf+src,visited);
           }
       }
       visited[src]=false;
   }
