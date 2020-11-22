package com.company.designpattern.composite;

import com.company.designpattern.composite.composite.Component;
import com.company.designpattern.composite.composite.Composite;
import com.company.designpattern.composite.composite.Leaf;

public class Client {
    public static void main(String[] args) {
        Component root = new Composite("服装");
        Component treeNode1 = new Composite("男装");
        Component treeNode2 = new Composite("女装");

        Component leaf1 = new Leaf("夹克");
        Component leaf2 = new Leaf("衬衣");
        Component leaf3 = new Leaf("裙子");
        Component leaf4 = new Leaf("套装");

        treeNode1.addChild(leaf1);
        treeNode1.addChild(leaf2);

        treeNode2.addChild(leaf3);
        treeNode2.addChild(leaf4);

        root.addChild(treeNode1);
        root.addChild(treeNode2);

        root.printStruct("");

        System.out.println("----------------------");
        root.removeChild(treeNode1);

        root.printStruct("");

    }
}
