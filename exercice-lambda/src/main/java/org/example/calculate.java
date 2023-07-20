package org.example;

@FunctionalInterface
public interface calculate<T,E,K> {
    K calculate(T a,E b);
}
