package ru.mipt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OutQueue {
    private final MessageQueue<Response> queue = new MessageQueue<>();

    @PutMapping("/putResponse")
    public void put(@RequestBody Response response) {
        queue.put(response);
    }

    @GetMapping("/getResponse")
    public Response get() {
        return queue.get();
    }
}
