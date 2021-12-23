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
    @Value("${queue.maxSize:1000}")
    private int maxSize;
    private  MessageQueue<Response> queue = new MessageQueue<>(maxSize);

    @PutMapping("/putResponse")
    public void put(@RequestBody Response response) {
        queue.put(response);
    }

    @GetMapping("/getResponse")
    public Response get() {
        return queue.get();
    }
}
