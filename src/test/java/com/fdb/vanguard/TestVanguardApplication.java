package com.fdb.vanguard;

import org.springframework.boot.SpringApplication;

public class TestVanguardApplication {

	public static void main(String[] args) {
		SpringApplication.from(VanguardApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
