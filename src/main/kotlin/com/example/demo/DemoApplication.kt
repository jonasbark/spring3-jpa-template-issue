package com.example.demo

import com.example.demo.test.*
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@SpringBootApplication
@EnableJpaRepositories
class DemoApplication(
	private val ancestorTrackingRepository: ServiceAncestorTrackingRepository,
) {

	@PostConstruct
	fun handle() {

		val found = ancestorTrackingRepository.findAllParentsByAncestors(1337)
		println(found)
	}
}

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
