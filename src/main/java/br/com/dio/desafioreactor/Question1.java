package br.com.dio.desafioreactor;

import reactor.core.publisher.Flux;

import java.awt.desktop.QuitEvent;
import java.util.List;

public class Question1 {

    /*
    Recebe uma lista de longs, incrementa 1 nos valores e retorna um flux dos resultados
    */
    public Flux<Long> inc(final List<Long> numbers){
        return Flux.fromIterable(numbers)
                .map(n -> n + 1L);
    }
    public static void main(String[] args) {
        var question1 = new Question1();
        List<Long> numbers = List.of(20L, 30L, 40L);
        Flux<Long> result = question1.inc(numbers);

        result.subscribe(value -> System.out.println("Valor incrementado: " + value),
                error -> System.out.println("Erro:" + error),
                () -> System.out.println("Processo completo")
        );
    }

}
