package com.example.demo.services;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Post;

@Service
public class PostService {
    private final String BASE_URL = "https://jsonplaceholder.typicode.com/posts";
    private final RestTemplate restTemplate;

    public PostService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Post> getAllPosts() {
        return restTemplate.exchange(
                BASE_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Post>>() {
                }
        ).getBody();
    }
}
