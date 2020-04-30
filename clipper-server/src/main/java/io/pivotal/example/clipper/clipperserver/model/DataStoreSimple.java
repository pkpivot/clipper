package io.pivotal.example.clipper.clipperserver.model;

import org.springframework.stereotype.Component;

@Component
public class DataStoreSimple implements DataStore {

    String testString;

    @Override
    public void putData(String someData) {
        this.testString = someData;

    }

    @Override
    public String fetchData() {
        return this.testString;
    }
}
