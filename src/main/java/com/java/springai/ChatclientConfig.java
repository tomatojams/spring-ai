package com.java.springai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tomatojams on 2024-08-10
 */
@Configuration
public class ChatclientConfig {

  @Bean
  ChatClient chatClient(ChatClient.Builder builder) {
    return builder.build();
  }
}
