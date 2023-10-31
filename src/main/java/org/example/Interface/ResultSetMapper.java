package org.example.Interface;

public interface ResultSetMapper<T> {
    T map(String column1, String column2);
}
