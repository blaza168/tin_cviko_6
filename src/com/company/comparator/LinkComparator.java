package com.company.comparator;

import com.company.entity.Link;

import java.util.Comparator;

public class LinkComparator<T> implements Comparator<Link<T>> {
    @Override
    public int compare(Link<T> tLink, Link<T> t1) {
        return Integer.compare(tLink.getWeight(), t1.getWeight());
    }
}
