package prototypepattern;

public interface Prototype extends Cloneable {
    AccessControl clone() throws CloneNotSupportedException;
}