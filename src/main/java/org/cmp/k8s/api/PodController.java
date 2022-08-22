package org.cmp.k8s.api;

import org.cmp.k8s.model.http.HttpResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pods")
public class PodController {

    @GetMapping
    public ResponseEntity<HttpResponseBody<?>> list(){
        return null;
    }
}
