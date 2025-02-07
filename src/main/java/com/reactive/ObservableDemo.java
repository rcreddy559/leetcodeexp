package com.reactive;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

public class ObservableDemo {
    public static void main(String[] args) {

    }

    void fulxDemo() {
        Publisher<Integer> fluxInt = Flux.just(1, 2, 3, 4);

        fluxInt.subscribe(null);

    }
}