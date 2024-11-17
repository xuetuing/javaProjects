package com.company.test;

import java.util.Objects;

public class State {

    int segment;
    int node;

    State(int segment, int node) {
        this.segment = segment;
        this.node = node;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        State state = (State) obj;
        return segment == state.segment && node == state.node;
    }

    @Override
    public int hashCode() {
        return Objects.hash(segment, node);
    }

    @Override
    public String toString() {
        return "State{" +
                "segment=" + segment +
                ", node=" + node +
                '}';
    }
}
