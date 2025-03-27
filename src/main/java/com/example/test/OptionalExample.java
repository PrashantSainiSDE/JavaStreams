package com.example.test;

import java.util.Optional;

public class OptionalExample {
public Optional<String> findUserNameById(int userId) {
    if(userId == 0){
        return Optional.empty();
    }else {
        return Optional.ofNullable("Prince");
    }
}

    public static void main(String[] args) {
        OptionalExample userDatabase = new OptionalExample();

        // Without Optional
//        String userNameWithoutOptional = userDatabase.findUserNameById(0);
//        System.out.println("Without Optional: " + userNameWithoutOptional);

        // With Optional
        Optional<String> userNameWithOptional = userDatabase.findUserNameById(1);
        userNameWithOptional.ifPresentOrElse(
                (uname) -> System.out.println(uname),
                () -> System.out.println("Username not found")
        );

        userNameWithOptional.map(u -> u.toUpperCase()).ifPresent(System.out::println);
    }
}
