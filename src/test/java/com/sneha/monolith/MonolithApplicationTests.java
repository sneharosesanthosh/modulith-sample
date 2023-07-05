package com.sneha.monolith;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;

@SpringBootTest
class MonolithApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	void createApplicationModuleModel() {
		ApplicationModules modules = ApplicationModules.of(MonolithApplication.class);
		modules.forEach(System.out::println);
	}
	@Test
	void verifiesModularStructure() {
		ApplicationModules modules = ApplicationModules.of(MonolithApplication.class);
		modules.verify();
	}

}
