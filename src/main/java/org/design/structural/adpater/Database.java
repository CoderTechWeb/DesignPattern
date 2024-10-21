package org.design.structural.adpater;

// Target Interface (Database)
public interface Database {
    void save(Object data);
    Object fetch(String query);
    void delete(String query);
}
