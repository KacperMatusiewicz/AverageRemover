package model;

import org.dyn4j.BinarySearchTree;

public class ValueList {
    public static ValueList INSTANCE;

    private BinarySearchTree<Value> valueList;
    private int maximumCapacity;

    private ValueList(){
    }
    public ValueList getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ValueList();
        }
        return INSTANCE;
    }
    public ValueList initializeValueList(BinarySearchTree<Value> valueList, int maximumCapacity){
        this.valueList = valueList;
        valueList.setSelfBalancing(true);
        this.maximumCapacity = maximumCapacity;
        while(valueList.size()>maximumCapacity){
            valueList.remove(getAverageValue());
        }
        return this;
    }

    public void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public void addValue(Value value){
        if(valueList.size() >= maximumCapacity){
            valueList.remove(getAverageValue());
            valueList.insert(value);
        }else{
            valueList.insert(value);
        }

    }
    public Value getAverageValue(){
        return valueList.getRoot();
    }
}
