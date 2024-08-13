package com.java.springai;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
public class SpringAiApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringAiApplication.class, args);
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  CommandLineRunner run(RestTemplate restTemplate, AiConfig aiConfig) {
    return args -> {
      // Print the API key to verify it is read correctly

      String apiKey = aiConfig.getApiKey();
      String model = "gpt-4o-mini"; // 하드코딩된 모델
      String endpoint = "https://api.openai.com/v1/chat/completions";
      String systemCommand = "친구처럼 다정하게 말해줘"; // 하드코딩된 systemCommand
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.setBearerAuth(apiKey);

      Scanner scanner = new Scanner(System.in);

      while (true) {
        System.out.print("사용자: ");
        String userInput = scanner.nextLine();

        if ("exit".equalsIgnoreCase(userInput)) {
          break; // 사용자가 "exit"을 입력하면 프로그램 종료
        }

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", model);
        requestBody.put("messages", List.of(
            Map.of("role", "system", "content", systemCommand),
            Map.of("role", "user", "content", userInput)
        ));

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<Map> responseEntity = restTemplate.exchange(endpoint, HttpMethod.POST,
            requestEntity, Map.class);

        Map<String, Object> responseBody = responseEntity.getBody();
        if (responseBody != null) {
          List<Map<String, Object>> choices = (List<Map<String, Object>>) responseBody.get(
              "choices");
          if (choices != null && !choices.isEmpty()) {
            Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
            String content = (String) message.get("content");
            System.out.println("GPT: " + content);
          }
        }
      }

      scanner.close();
    };
  }
}
