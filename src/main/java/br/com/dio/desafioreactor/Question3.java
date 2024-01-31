package br.com.dio.desafioreactor;

import reactor.core.publisher.Mono;

public class Question3 {

    /*
    Verifica se o usuário passado é valido, caso seja retorna void, caso contrário deve disparar uma exception
    (para esse desafio vamos considerar que o usário é valido quando ele tem uma senha com mais de 8 caractéres)
     */
    public Mono<Void> userIsValid(final User user){
        if (!user.password().isEmpty() && user.password().length() > 8) {
            return Mono.empty();
        } else {
            return Mono.error(new IllegalArgumentException("Usuário Inválido!"));
        }
    }

    public static void main(String[] args) {
        var question3 = new Question3();

        User validUser = new User(1L, "User Valido", "teste@example.com", "12345678xxxx", true);
        User invalidUser = new User(2L, "User Invalido", "teste2@example.com", "1234", false);

        Mono<Void> validMono = question3.userIsValid(validUser);
        Mono<Void> invalidMono = question3.userIsValid(invalidUser);

        validMono.subscribe(
                value -> System.out.println("Usuário válido!"),
                error -> System.err.println("Erro: " + error),
                () -> System.out.println("Validação completa!")
        );

        invalidMono.subscribe(
                value -> System.out.println("Usuário inválido!"),
                error -> System.err.println("Erro: " + error),
                () -> System.out.println("Validação completa!")
        );
    }

}
