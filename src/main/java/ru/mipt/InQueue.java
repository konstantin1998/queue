package ru.mipt;

import java.util.ArrayDeque;
import java.util.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class InQueue {
    private final Queue<Request> queue = new ArrayDeque();
    @Value("${queue.maxSize:1000}")
    private int maxSize = 1000;

    @PutMapping("/putRequest")
    public void put(@RequestBody Request request) {
        if (queue.size() < maxSize) {
            queue.add(request);
        }
    }

    @GetMapping("/getRequest")
    public Request get() {
        return queue.poll();
    }
}
