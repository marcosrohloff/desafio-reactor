package br.com.dio.desafioreactor;

import reactor.core.publisher.Mono;

import java.awt.desktop.QuitEvent;
import java.util.List;

public class Question2 {

    /*
    Recebe uma lista de usuários e retorna a quantos usuários admin tem na lista
     */
   public Mono<Long> countAdmins(final List<User> users) {
       return Mono.just(users)
               .flatMapIterable(userList -> userList)
               .filter(User::isAdmin)
               .count();
   }

    public static void main(String[] args) {
       var question2 = new Question2();
        List<User> users = List.of(
                new User(1L, "User1", "user1@example.com", "123", false),
                new User(2L, "User2", "user2@example.com", "123", true),
                new User(3L, "User3", "user3@example.com", "123", false),
                new User(4L, "User4", "user4@example.com", "123", true),
                new User(5L, "User5", "user5@example.com", "123", false)
        );

        Mono<Long> adminCountMono = question2.countAdmins(users);
        adminCountMono.subscribe(count -> System.out.println("Quantos usuários são admin? " + count),
                error -> System.out.println("Erro:" + error),
                () -> System.out.println("Processo completo")
        );
    }

}
