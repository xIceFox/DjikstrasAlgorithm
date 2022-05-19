package de.xicefox;

import java.util.Comparator;

public class EdgeComparator implements Comparator<Graph.Edge> {

    @Override
    public int compare(Graph.Edge o1, Graph.Edge o2) {
        return Integer.compare(o1.pathWeight, o2.pathWeight);
    }
}
