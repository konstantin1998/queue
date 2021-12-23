package ru.mipt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class InQueue {
    @Value("${queue.maxSize:1000}")
    private int maxSize = 1000;
    private  MessageQueue<Request> queue = new MessageQueue<>(maxSize);

    @PutMapping("/putRequest")
    public void put(@RequestBody Request request) {
        queue.put(request);
    }

    @GetMapping("/getRequest")
    public Request get() {
        return queue.get();
    }
}
