package com.company.designpattern.composite.composite;

import java.util.List;

/**
 * 统一组合对象和叶子节点
 */
public abstract class Component {

    /**
     * 记录父组件的引用，删除场景
     */
    private Component parent = null;

    public Component getParent() {
        return parent;
    }

    public void setParent(Component parent) {
        this.parent = parent;
    }

    /**
     * 定义公共方法
     */
    public abstract void printStruct(String preStr);

    /**
     * 添加组合对象, 针对叶子节点抛出异常
     * @param child
     */
    public void addChild(Component child) {
        throw new UnsupportedOperationException("不支持此类操作.");
    }

    /**
     * 移除组合对象
     * @param child
     */
    public void removeChild(Component child) {
        throw new UnsupportedOperationException("不支持此类操作.");
    }

    public List<Component> getChildren() {
        throw new UnsupportedOperationException("不支持此类操作.");
    }

}
