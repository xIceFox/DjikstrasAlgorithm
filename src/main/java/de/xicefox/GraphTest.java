package de.xicefox;

import java.util.PriorityQueue;
import java.util.Stack;

public class GraphTest {
    public static void main(String[] args) {
        Graph G = new Graph();
        G.insertEdges("Hamburg", "Münster", 281);
        G.insertEdges("Hamburg", "Hannover", 151);
        G.insertEdges("Hamburg", "Berlin", 280);
        G.insertEdges("Münster", "Aachen", 560);
        G.insertEdges("Aachen", "Koblenz", 154);
        G.insertEdges("Koblenz", "Frankfurt", 125);
        G.insertEdges("Hannover", "Frankfurt", 351);
        G.insertEdges("Frankfurt", "Würzburg", 119);
        G.insertEdges("Würzburg", "Stuttgart", 151);
        G.insertEdges("Stuttgart", "Basel", 273);
        G.insertEdges("Stuttgart", "München", 221);
        G.insertEdges("Koblenz", "Basel", 403);
        G.insertEdges("Aachen", "Basel", 539);
        G.insertEdges("Hannover", "Erfurt", 217);
        G.insertEdges("Erfurt", "Würzburg", 195);
        G.insertEdges("Berlin", "Leipzig", 192);
        G.insertEdges("Leipzig", "Erfurt", 146);
        G.insertEdges("Leipzig", "München", 431);
        G.insertEdges("Basel", "München", 394);
        String start = "Hannover";
        PriorityQueue<Graph.Edge> map = G.dijkstra(start);
        System.out.println("Kürzeste Wege von " + start + ":");
        String format = "%-25s%-20s%s%n";
        while (!map.isEmpty()) {
            Graph.Edge e = map.remove();
            System.out.format(format, "Edge Name: " + e.name, "| Distance: " + e.pathWeight, "| Pre: " + e.pre);
        }
        System.out.println();
        String ziel = "Aachen";
        Stack<Graph.Edge> stack = G.getShortestPath(ziel);
        System.out.println("Kürzester Weg von " + start + " zu " + ziel + ":");
        while (!stack.isEmpty()) {
            Graph.Edge e = stack.pop();
            if (stack.isEmpty()) {
                System.out.println(e.name);
                break;
            }
            System.out.print(e.name + "-> ");
        }
    }
}