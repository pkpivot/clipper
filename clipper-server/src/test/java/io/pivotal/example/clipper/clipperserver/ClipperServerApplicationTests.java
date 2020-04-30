package io.pivotal.example.clipper.clipperserver;

import io.pivotal.example.clipper.clipperserver.model.DataStore;
import static org.hamcrest.core.IsNot.not;
import org.hamcrest.Matchers;
import org.hamcrest.core.IsNot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

@SpringBootTest
class ClipperServerApplicationTests {

    @Autowired
    private DataStore store ;

    @Test
    void contextLoads() {
    }

    @Test
    void DataStoreExists() {
        assertNotNull("No datastore", store);
    }

    @Test
    void storesAndRetrievesSameData() {
        String testData = "Hello World";
        store.putData(testData);
        assertEquals("Did not fetch data", testData, store.fetchData());
    }
}
