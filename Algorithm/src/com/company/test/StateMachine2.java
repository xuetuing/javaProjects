package com.company.test;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class StateMachine2 {
    private int numSegments;
    private int numNodesPerSegment;
    private int lastNode;
    private Set<State> visitedStates = new HashSet<>();
    private Stack<State> returnStack = new Stack<>();
    private State currentState;

    StateMachine2(int numSegments, int numNodesPerSegment, int lastNode, State initialState) {
        this.numSegments = numSegments;
        this.numNodesPerSegment = numNodesPerSegment;
        this.lastNode = lastNode;
        this.currentState = initialState;
        visitedStates.add(currentState);
    }

    void run() {
        while (true) {
            System.out.println("Current State: " + currentState);

            State nextState = getNextState();
            if (nextState == null) {
                break;
            }

            if (!visitedStates.contains(nextState)) {
                visitedStates.add(nextState);
                currentState = nextState;
            } else {
                System.out.println("State already visited, terminating state machine to avoid infinite loop.");
                break;
            }
        }
    }

    private State getNextState() {
        if (currentState.node == 3 && currentState.node < numNodesPerSegment) {
            if (currentState.segment== numSegments && currentState.node == lastNode) {
                return null;
            }
            // Record the current segment's next node to return to later
            returnStack.push(new State(currentState.segment, currentState.node + 1));

            // Move to the next segment's first node
            int nextSegment = currentState.segment + 1;
            if (nextSegment <= numSegments) {
                return new State(nextSegment, 1);
            } else {
                // No more segments to move to, handle this case as needed
                return returnStack.pop();
            }
        } else {
            if (!returnStack.isEmpty()) {
                return returnStack.pop();
            }
            // Move to the next node in the current segment
            int nextNode = currentState.node + 1;
            if (nextNode <= numNodesPerSegment) {
                if (currentState.segment == numSegments && nextNode > lastNode) {
                    return null;
                }
                return new State(currentState.segment, nextNode);
            } else {
                // No more nodes to move to, handle this case as needed
                int segment = ++currentState.segment;
                if (segment > numSegments) {
                    return null;
                }
                int node = 2;
                if (segment == numSegments && node > lastNode) {
                    return null;
                }
                return new State(segment, node);
            }
        }
    }

    public static void main(String[] args) {
        int numSegments = 3;
        int numNodesPerSegment = 5;
        int lastNode = 1;
        StateMachine2 stateMachine = new StateMachine2(numSegments, numNodesPerSegment, lastNode, new State(1, 1));
        stateMachine.run();
    }
}
