package io.pivotal.example.clipper.clipperserver.model;

public interface DataStore {
    public void putData(String someData ) ;

    public String fetchData() ;
}
