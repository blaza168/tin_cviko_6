package com.company;

import com.company.comparator.LinkComparator;
import com.company.entity.Link;
import com.company.entity.Node;

import java.util.*;

public class Graph<T> {

   public static class Path<T> {

      private final Map<T, Node<T>> nodes;
      private final LinkedList<Node<T>> path;

      private Path(Map<T, Node<T>> nodes) {
         this.nodes = nodes;
         this.path = new LinkedList<>();
      }

      public void add(T data) {
         path.add(this.nodes.get(data));
      }

      public Integer getPrice() {
         int weight = 0;
         if (path.size() == 0) return weight;
         Iterator<Node<T>> iterator = path.iterator();
         Node<T> tmp = iterator.next();

         while (iterator.hasNext()) {
            Node<T> next = iterator.next();
            weight += tmp.getWeight(next);
            tmp = next;
         }

         return weight;
      }
   }

   private final Map<T, Node<T>> nodes = new HashMap<>();

   public void addLink(T from, T to, int weight) {
      Node<T> fromNode = nodes.getOrDefault(from, new Node<>(from));
      Node<T> toNode = nodes.getOrDefault(to, new Node<>(to));
      Link<T> fromLink = new Link<>(toNode, weight);
      Link<T> toLink = new Link<>(fromNode, weight);

      fromNode.addLink(fromLink);
      toNode.addLink(toLink);

      nodes.put(from, fromNode);
      nodes.put(to, toNode);
   }

   public Graph.Path<T> emptyPath() {
      return new Graph.Path<>(this.nodes);
   }
}
