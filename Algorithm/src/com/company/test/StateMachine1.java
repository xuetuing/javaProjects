package com.company.test;

public class StateMachine1 {
    private static final int NUM_SECTIONS = 4;
    private static final int NODES_PER_SECTION = 5;
    private Node currentState;
    private boolean[] visitedFirstNode = new boolean[NUM_SECTIONS]; // 标记每段的首节点是否已访问

    public StateMachine1() {
        currentState = new Node(1, 1); // 初始状态为第1段第1节点
    }

    public void triggerEvent() {
        int currentSection = currentState.section;
        int currentNode = currentState.number;

        // 根据当前状态和访问情况决定下一个状态
        if (currentNode < 3) {
            // 在第1段内，从第1节点到第3节点直接顺序转移
            currentState = new Node(currentSection, currentNode + 1);
        } else if (currentNode == 3) {
            // 从第1段的第3节点跳到第2段的第1节点（首次）
            currentState = new Node(2, 1);
            visitedFirstNode[1] = true; // 标记第2段的首节点已访问
        } else {
            // 寻找下一个未访问的首节点所在的段，或者按顺序遍历当前段后续节点
            boolean foundNextUnvisited = false;
            for (int i = 1; i <= NUM_SECTIONS; i++) {
                if (!visitedFirstNode[i - 1] && (currentSection != i || currentNode == NODES_PER_SECTION)) {
                    // 找到未访问的首节点，或者当前段已遍历完
                    currentState = new Node(i, 1);
                    visitedFirstNode[i - 1] = true;
                    foundNextUnvisited = true;
                    break;
                } else if (i == currentSection && currentNode < NODES_PER_SECTION) {
                    // 继续在当前段内顺序遍历
                    currentState = new Node(currentSection, currentNode + 1);
                    foundNextUnvisited = true;
                    break;
                }
            }

            // 如果没有找到直接的下一个状态（理论上不应该发生，因为我们确保了遍历的完整性）
            if (!foundNextUnvisited) {
                throw new IllegalStateException("No valid next state found!");
            }

            // 如果已经访问了某个段的首节点，并且当前节点不是该段的最后一个节点，则按顺序遍历该段后续节点
            if (visitedFirstNode[currentSection - 1] && currentNode < NODES_PER_SECTION) {
                // 这里其实上面的逻辑已经处理了这种情况，但为了保险起见，我们再次检查
                currentState = new Node(currentSection, currentNode + 1);
            }
        }

        // 输出当前状态
        System.out.println(currentState);
    }

    public static void main(String[] args) {
        StateMachine1 sm = new StateMachine1();
        // 触发事件直到遍历完所有节点
        for (int i = 0; i < NUM_SECTIONS * NODES_PER_SECTION; i++) {
            sm.triggerEvent();
        }
    }
}
