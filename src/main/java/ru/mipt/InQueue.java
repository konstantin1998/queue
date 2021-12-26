package ru.mipt;

import org.springframework.web.bind.annotation.*;

@RestController
public class InQueue {
    private final MessageQueue<Request> queue = new MessageQueue<>();

    @PutMapping("/putRequest")
    public void put(@RequestBody Request request) {
        queue.put(request);
    }

    @GetMapping("/getRequest")
    public Request get() {
        return queue.get();
    }
}
