package com.wikingowie.myecinema.services.impl;

import com.wikingowie.myecinema.repositories.ExampleRepository;
import com.wikingowie.myecinema.services.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExampleServiceImpl implements ExampleService {

    private final ExampleRepository exampleRepository;
}
