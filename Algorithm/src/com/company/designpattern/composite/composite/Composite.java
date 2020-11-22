package com.company.designpattern.composite.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component{

    private String name = "";

    /**
     * 子节点集合，包含组合对象和叶子节点
     */
    private List<Component> childComponents = null;

    public Composite(String name) {
        this.name = name;
    }

    @Override
    public void printStruct(String preStr) {
        System.out.println(preStr + "+" + this.name);

        if(this.childComponents != null) {
            preStr += " ";

            for(Component c: this.childComponents) {
                c.printStruct(preStr);
            }
        }
    }

    /**
     * 添加组合对象
     * @param child
     */
    public void addChild(Component child) {
        if(this.childComponents == null) {
            childComponents = new ArrayList<Component>();
        }
        this.childComponents.add(child);

        //设置父组件
        child.setParent(this);
    }

    /**
     * 移除组合对象
     * @param child
     */
    public void removeChild(Component child) {
        int idx = this.childComponents.indexOf(child);
        if(idx != -1) {
            //删除前将其子节点上移一层
            for(Component c: child.getChildren()) {
                c.setParent(this);
                this.childComponents.add(c);
            }
            //删除此节点
            this.childComponents.remove(child);
        }
    }

    /**
     * 获取子节点
     * @return
     */
    public List<Component> getChildren() {
        return this.childComponents;
    }

}
