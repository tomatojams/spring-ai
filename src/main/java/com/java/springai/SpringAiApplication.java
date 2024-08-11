package com.java.springai;

import com.google.protobuf.Message;
import java.util.List;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.model.ModelRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class SpringAiApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringAiApplication.class, args);
    final String Abstract = "tomato";
    final int show = 29;

    System.out.println(Abstract + show+"2");
    // 클래스를 자료형처럼 타입지정으로 쓸수있음
    Hello Test = new Hello();
    Test.hi();
    System.out.println(Test.name);

  }

}

class Hello {
  String name = "soma";
  void hi(){
    System.out.println("hi I'm"+" "+ name);
  }
}
