package ru.mipt;

import java.util.ArrayDeque;
import java.util.Queue;

public class MessageQueue<T> {
    private final int maxSize;
    private final Queue<T> queue;

    public MessageQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new ArrayDeque<>();
    }

    public void put(T incomingMessage) {
        if (queue.size() < maxSize) {
            queue.add(incomingMessage);
        }
    }

    public T get() {
        return queue.poll();
    }
}
