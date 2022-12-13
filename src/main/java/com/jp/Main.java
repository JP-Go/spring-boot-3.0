package com.jp;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {
  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @GetMapping("/")
  public Person greet() {
    return new Person("Kyle", List.of("JavaScript", "Java", "Python"));
  }

  private record Person(String name,
                        List<String> favoriteProgrammingLanguages) {}
}
