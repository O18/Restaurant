package com.o18.restaurant.eventbus;

/**
 * Created by Александр on 24.11.2016.
 */
public interface Handler<T extends Event> {

    void handle(T event);
}
