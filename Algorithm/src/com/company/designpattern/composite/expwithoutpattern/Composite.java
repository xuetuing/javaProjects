package com.company.designpattern.composite.expwithoutpattern;

import java.util.ArrayList;
import java.util.Collection;

public class Composite {
    /**
     * 组合对象的名字
     */
    private String name;
    /**
     * 包含的其他组合对象
     */
    private Collection<Composite> childComposite = new ArrayList<Composite>();

    /**
     * 包含的其他叶子节点
     */
    private Collection<Leaf> childLeaf = new ArrayList<Leaf>();

    public Composite(String name) {
        this.name = name;
    }

    public void addComposite(Composite c) {
        this.childComposite.add(c);
    }

    public void addLeaf(Leaf l){
        this.childLeaf.add(l);
    }

    /**
     * 打印组合对象结构
     * @param preStr
     */
    public void printStruct(String preStr){
        //打印组合对象名字
        System.out.println(preStr + "+" + this.name);
        preStr += " ";
        for(Leaf leaf : childLeaf) {
            leaf.printStruct(preStr);
        }
        for(Composite composite : childComposite) {
            composite.printStruct(preStr);
        }
    }

}
