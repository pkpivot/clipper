package io.pivotal.example.clipper.clipperserver.controller;

import io.pivotal.example.clipper.clipperserver.model.DataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class ClipperController {

    @Autowired
    private DataStore store ;

    @PostMapping("/api/clip")
    public void clipData(HttpEntity<String> request){
        store.putData((request.getBody()));

    }

    @GetMapping("/api/clip")
    public ResponseEntity<String> pasteData(){
        return new ResponseEntity<String>(store.fetchData(), HttpStatus.OK);
    }
}
