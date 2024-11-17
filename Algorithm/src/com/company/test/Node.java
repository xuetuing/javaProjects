package com.company.test;

public class Node {
    int section; // 段号，从1开始
    int number;  // 节点号，从1开始

    Node(int section, int number) {
        this.section = section;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Section " + section + ", Node " + number;
    }
}
