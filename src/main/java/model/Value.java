package model;

public class Value implements Comparable<Value> {
    private final int number;

    public Value (int number){
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public int compareTo(Value value) {
        if(this.number == value.number){
            return 0;
        }else if(this.number > value.number){
            return 1;
        }else{
            return -1;
        }
    }
}
