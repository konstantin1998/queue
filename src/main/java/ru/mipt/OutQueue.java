package ru.mipt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayDeque;
import java.util.Queue;

@RestController
public class OutQueue {
    private final Queue<Response> queue = new ArrayDeque();
    @Value("${queue.maxSize:1000}")
    private int maxSize;

    @PutMapping("/putResponse")
    public void put(@RequestBody Response response) {
        if (queue.size() < maxSize) {
            queue.add(response);
        }
    }

    @GetMapping("/getResponse")
    public Response get() {
        return queue.poll();
    }
}
