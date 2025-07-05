package com.example.genericsfx1.util;

public class ParcelBox<T> {
    private T item;

    public ParcelBox(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    @Override
    public String toString() {
        return item.toString();
    }
}