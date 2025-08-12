package com.moodleap.server.controller;

import com.moodleap.server.model.TestEntity;
import com.moodleap.server.repository.TestEntityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestController {

    private final TestEntityRepository repository;

    public TestController(TestEntityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<TestEntity> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public TestEntity create(@RequestBody TestEntity entity) {
        return repository.save(entity);
    }
}
