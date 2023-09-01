package org.gsc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class DefaultCmsDao implements CommandLineRunner {
	@Autowired

	public String findPageById(String id) {
		return "";
	}

	@Override
	public void run(String... args) throws Exception {
	

	}
}
