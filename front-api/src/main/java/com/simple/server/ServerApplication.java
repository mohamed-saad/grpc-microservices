package com.simple.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication {

	static String auditNode;
	static String[] computeNodes;

	public static void main(String[] args) {
		if (args.length < 2) {
			System.err.println("Missing argument, please specify the audit and compute nodes");
			System.exit(1);
		}
		auditNode = args[0];
		computeNodes = args[1].split(",");
		SpringApplication.run(ServerApplication.class, args);
	}

}
