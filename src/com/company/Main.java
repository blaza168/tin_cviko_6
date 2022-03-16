package com.company;

public class Main {

    public static void main(String[] args) {

        Graph<Integer> graph = new Graph<>();
        graph.addLink(5, 4, 1); // Will be replaced
        graph.addLink(5, 4, 3);
        graph.addLink(4, 3, 2);
        graph.addLink(3, 1, 1);

        Graph.Path<Integer> path = graph.emptyPath();
        path.add(5);
        path.add(4);
        path.add(3);
        path.add(1);

        System.out.println(path.getPrice());
    }
}
