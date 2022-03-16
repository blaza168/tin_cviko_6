package com.company.entity;

import com.company.exception.LinkMissingException;

import java.util.*;

public class Node<T> {

    private final T data;
    private final Map<T, Link<T>> links = new HashMap<>();

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public Integer getWeight(T data) {
        Link<T> link = this.links.get(data);
        if (link == null) {
            throw new LinkMissingException(data.toString() + " link is missing in node " + this.getData().toString());
        }
        return link.getWeight();
    }

    public Integer getWeight(Node<T> node) {
        return this.getWeight(node.getData());
    }

    public void addLink(Link<T> fromLink) {
        this.links.put(fromLink.getTo().getData(), fromLink);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.data);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Node)) return false;

        Node<T> anotherNode = (Node<T>) obj;

        return anotherNode.getData().equals(this.getData());
    }
}
