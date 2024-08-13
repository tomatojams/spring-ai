package com.apple.shop;

/**
 * Created by tomatojams on 2024-08-13
 */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ShopApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShopApplication.class, args);
    final String Abstract = "tomato";
    final int show = 29;

    System.out.println(Abstract + show + "2");
    // 클래스를 자료형처럼 타입지정으로 쓸수있음
    Hello Test = new Hello();
    Test.hi();
    System.out.println(Test.name);


  }

}

class Hello {

  String name = "soma";

  void hi() {
    System.out.println("hi I'm" + " " + name);
  }
}