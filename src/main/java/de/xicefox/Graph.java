package de.xicefox;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class Graph {
    ArrayList<Edge> edges = new ArrayList<>();


    public class Edge implements Comparable<Edge>{
        String name;
        int pathWeight;
        Edge pre;
        ArrayList<Path> paths = new ArrayList<>();

        Edge(String name) {
            this.name = name;
        }

        public void appendPath(Edge dest, int weight) {
            Path p = new Path(dest, weight);
            paths.add(p);
        }

        public String toString(){
            return this.name;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.pathWeight, o.pathWeight);
        }
    }

    private class Path {
        Edge dest;
        int weight;

        Path(Edge dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public Edge getEdge(String name) {
        for (Edge e : edges) {
            if (e.name.equals(name)) {
                return e;
            }
        }
        return null;
    }

    public void insertEdges(String name, String dest, int weight) {
        Edge e = getEdge(name);
        if (e == null) {
            e = new Edge(name);
            edges.add(e);
        }

        Edge d = getEdge(dest);
        if (d == null) {
            d = new Edge(dest);
            edges.add(d);
        }

        e.appendPath(d, weight);
        d.appendPath(e, weight);
    }

    public Stack<Edge> getShortestPath(String Destination) {
        Edge a = getEdge(Destination);
        Stack<Edge> stack = new Stack<>();
        while (a.pathWeight > 0) {
            stack.push(a);
            a = a.pre;
        }
        stack.push(a.pre);
        return stack;
    }

    public void resetDijkstra(String name) {
        Edge a = getEdge(name);
        for (Edge e : edges) {
            e.pathWeight = Integer.MAX_VALUE;
            e.pre = null;
        }
        a.pathWeight = 0;
        a.pre = a;
    }


    public PriorityQueue<Edge> dijkstra(String name) {
        Comparator<Edge> edgeComparator = new EdgeComparator();
        PriorityQueue<Edge> Queue = new PriorityQueue<>(edgeComparator);
        resetDijkstra(name);
        Queue.addAll(edges);

        while (!Queue.isEmpty()) {
            Edge now = Queue.remove();
            for (Path p : now.paths) {
                if (Queue.contains(p.dest)) {
                    Edge neighbour = p.dest;
                    int alternative = now.pathWeight + p.weight;
                    if (alternative < neighbour.pathWeight) {
                        neighbour.pathWeight = alternative;
                        neighbour.pre = now;
                        Queue.remove(neighbour);
                        Queue.add(neighbour);
                    }
                }
            }
        }
        Queue.addAll(edges);
        return Queue;
    }
}