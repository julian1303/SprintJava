package om.oreilly.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class HelloRestController {

        private AtomicLong atomicLong = new AtomicLong();

        @GetMapping("/greet")
        public Greeting sayHello(@RequestParam(defaultValue = "wolrd") String name){
            return new Greeting(atomicLong.incrementAndGet(), String.format("Hello, %s!", name));
        }

}
