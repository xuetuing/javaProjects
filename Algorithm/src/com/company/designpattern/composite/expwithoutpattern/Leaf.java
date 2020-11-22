package com.company.designpattern.composite.expwithoutpattern;

public class Leaf {

    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    /**
     * 打印叶子节点结构
     * @param preStr
     */
    public void printStruct(String preStr) {
        System.out.println(preStr + "-" + this.name);
    }
}
