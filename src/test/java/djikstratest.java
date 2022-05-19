import de.xicefox.Graph;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class djikstratest {

    @Test
    public void test_djikstra(){
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

        String start = "Leipzig";
        G.dijkstra(start);
        String ziel = "Basel";
        Stack<Graph.Edge> stack = G.getShortestPath(ziel);
        Stack<Graph.Edge> control_stack = new Stack<>();
        control_stack.push(G.getEdge("Basel"));
        control_stack.push(G.getEdge("Stuttgart"));
        control_stack.push(G.getEdge("Würzburg"));
        control_stack.push(G.getEdge("Erfurt"));
        control_stack.push(G.getEdge("Leipzig"));
        assertEquals(stack, control_stack);
    }
}
