package ru.mipt;

import java.util.ArrayDeque;
import java.util.Queue;

public class MessageQueue<T> {

    private final int maxSize = 1000;
    private final Queue<T> queue = new ArrayDeque<>();

    public void put(T message) {
        if (queue.size() < maxSize) {
            queue.add(message);
        }
    }

    public T get() {
        return queue.poll();
    }
}
