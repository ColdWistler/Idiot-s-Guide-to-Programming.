package com.example.genericsfx1.util; // Changed package name

import java.util.ArrayList;
import java.util.List;

public class ParcelShelf<T> {
    private List<ParcelBox<T>> boxes;

    public ParcelShelf() {
        this.boxes = new ArrayList<>();
    }

    public void addBox(ParcelBox<T> box) {
        boxes.add(box);
    }

    public void removeBox(int index) {
        if (index >= 0 && index < boxes.size()) {
            boxes.remove(index);
        } else {
            System.out.println("Invalid index for removal.");
        }
    }

    public List<ParcelBox<T>> getBoxes() {
        return boxes;
    }
}