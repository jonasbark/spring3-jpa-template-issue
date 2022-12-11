package com.example.demo

import com.example.demo.test.ServiceAncestorRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [DemoApplication::class])
class DemoApplicationTests {

	@Autowired
	lateinit var repository: ServiceAncestorRepository

	@Test
	fun contextLoads() {
		repository.findAllParentsByAncestors(1337)
	}

}
