package com.tenup.hackathon.interviewscore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class OpenAIWebClient {
	
	@Bean("openAIWebClient")
	public WebClient openAIWebClient() {
		
		return WebClient.builder()
				.exchangeStrategies(ExchangeStrategies.builder()
						.codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024)).build())
				.defaultHeaders(httpHeaders -> {
					httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
					httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer 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");
				})
				.baseUrl("https://api.openai.com/v1/chat/completions").build();
	}
}
