package com.company.work;

public class Node {
    int segmentId; // 段号，从1开始
    int nodeId;  // 节点号，从1开始
    String nodeName; // 节点名称
    BaseInfo baseInfo; // 所属的BaseInfo
    int workEfficiency;
    String processInfo;

    Node(int segmentId, int nodeId) {
        this.segmentId = segmentId;
        this.nodeId = nodeId;
    }

    @Override
    public String toString() {
        return "Node [segmentId=" + segmentId + ", nodeId=" + nodeId + ", " +
                "nodeName=" + nodeName + ", baseInfo=" + baseInfo + ", workEfficiency=" +
                workEfficiency + ", processInfo=" + processInfo + "]";
    }
}
