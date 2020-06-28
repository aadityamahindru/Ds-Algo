// Question
// 1. You are given a graph, representing people and their connectivity.
// 2. You are also given a src person (who got infected) and time t.
// 3. You are required to find how many people will get infected in time t, if the infection spreads to neighbors of infected person in 1 unit of time.
// Input Format
// Input has been managed for you
// Output Format
// count of people infected by time t
// Constraints
// None
// Sample Input
// 7
// 8
// 0 1 10
// 1 2 10
// 2 3 10
// 0 3 10
// 3 4 10
// 4 5 10
// 5 6 10
// 4 6 10
// 6
// 3
// Sample Output
// 4



import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }
    static class Pair {
        int vtx;
        int time;
        Pair(int vtx, int time) {
            this.vtx = vtx;
            this.time = time;
        }
    }
    public static int spreadOfInfection(ArrayList < Edge > [] graph, int src, int t) {
        boolean visited[] = new boolean[graph.length];
        Queue < Pair > q = new ArrayDeque < > ();
        q.add(new Pair(src, 1));
        int count = 0;
        while (q.size() > 0) {
            Pair temp = q.remove();
            if (!visited[temp.vtx]) {
                visited[temp.vtx] = true;
                count++;
                for (Edge e: graph[temp.vtx]) {
                    if (!visited[e.nbr] && temp.time < t) {
                        q.add(new Pair(e.nbr, temp.time + 1));
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList < Edge > [] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList < > ();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        System.out.println(spreadOfInfection(graph, src, t));
        // write your code here
    }

}