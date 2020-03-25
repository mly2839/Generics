//Description: Class that stores two objects of any data type
//Author: Michael Ly
//Date: 3/25/2020
//Version: 1.0

public class Pair<E1, E2> {

    private E1 obj;
    private E2 obj1;

    public Pair(){
    } //default constructor

    public Pair(E1 obj, E2 obj1){
        this.obj = obj;
        this.obj1 = obj1;
    } //detailed constructor

    /**
     * Function the will return the first object
     * @return obj
     */

    public E1 getObj() {
        return obj;
    }

    /**
     * Function that will return the second object
     * @return obj1
     */

    public E2 getObj1() {
        return obj1;
    }

    /**
     * Function the will set the first object
     * @param obj
     */

    public void setObj(E1 obj) {
        this.obj = obj;
    }

    /**
     * Function that will set the second object
     * @param obj1
     */

    public void setObj1(E2 obj1) {
        this.obj1 = obj1;
    }

    /**
     * Function the converts object one and two to a string format
     * @return formatted string
     */

    public String toString() {
        return "(" + obj + ", " + obj1 + ")";
    }

    /**
     * Function that compares two objects and will return if they are the same or not
     * @param obj
     * @return eq
     */

    public boolean equals(Object obj) {
        Pair<E1, E2> pair = (Pair<E1, E2>) obj;
        boolean eq = pair.getObj().equals(obj);
        eq = eq && pair.getObj1().equals(obj1);
        return eq;
    }
}
