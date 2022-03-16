package com.company.entity;

import java.util.Objects;

public class Link<T> {

    private final Node<T> to;
    private final int weight;

    public Link(Node<T> to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    public Node<T> getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link<?> link = (Link<?>) o;
        return to.equals(link.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(to);
    }
}
