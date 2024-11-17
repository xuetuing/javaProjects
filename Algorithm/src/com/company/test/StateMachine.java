package com.company.test;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class StateMachine {
    private int numSegments;
    private int numNodesPerSegment;
    private Set<State> visitedStates = new HashSet<>();
    private Stack<State> returnStack = new Stack<>();
    private State currentState;

    StateMachine(int numSegments, int numNodesPerSegment, State initialState) {
        this.numSegments = numSegments;
        this.numNodesPerSegment = numNodesPerSegment;
        this.currentState = initialState;
        visitedStates.add(currentState);
    }

    void run() {
        while (true) {
            System.out.println("Current State: " + currentState);

            State nextState = getNextState();
            if (nextState == null) {
                // No more states to visit, terminate the state machine
                break;
            }

            if (!visitedStates.contains(nextState)) {
                // Only transition to a new state if it hasn't been visited before
                visitedStates.add(nextState);
                currentState = nextState;
            } else {
                // If the next state has been visited, we might need to use the return stack
                // But in this simplified example, we'll just break the loop to avoid infinite loop
                // In a real-world scenario, you would handle this case more gracefully
                System.out.println("State already visited, terminating state machine to avoid infinite loop.");
                break;
            }
        }
    }

    private State getNextState() {
        if (currentState.node == 3 && currentState.node < numNodesPerSegment) {
            // Record the current segment's next node to return to later
            returnStack.push(new State(currentState.segment, currentState.node + 1));

            // Move to the next segment's first node
            int nextSegment = currentState.segment + 1;
            if (nextSegment <= numSegments) {
                return new State(nextSegment, 1);
            } else {
                // No more segments to move to, handle this case as needed
                return null;
            }
        } else {
            // Move to the next node in the current segment
            int nextNode = currentState.node + 1;
            if (nextNode <= numNodesPerSegment) {
                return new State(currentState.segment, nextNode);
            } else {
                // End of current segment, check if we need to return to a previous segment
                if (!returnStack.isEmpty()) {
                    State returnState = returnStack.pop();
                    // Skip nodes that have already been visited (including node 3 and subsequent nodes)
                    while (returnState.node <= numNodesPerSegment && returnState.node != 3) {
                        if (!visitedStates.contains(returnState)) {
                            return returnState;
                        }
                        returnState = new State(returnState.segment, returnState.node + 1);
                    }
                    // If we reach here, it means we need to go to the last node of the returned segment
                    if (returnState.node <= numNodesPerSegment) {
                        return new State(returnState.segment, numNodesPerSegment);
                    }
                }
                // No more states to return to, handle this case as needed
                return null;
            }



        }
    }

    public static void main(String[] args) {
        int numSegments = 4;
        int numNodesPerSegment = 5;
        StateMachine stateMachine = new StateMachine(numSegments, numNodesPerSegment, new State(1, 1));
        stateMachine.run();
    }
}
