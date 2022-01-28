package com.accountfy.formacaoBackend.config;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.accountfy.formacaoBackend.entities.Livro;
import com.accountfy.formacaoBackend.repositories.LivroRepository;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private LivroRepository livroRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Livro l1 = new Livro(null, "Neuromance",300, Date.from(Instant.parse("2019-06-20T19:53:07Z")), new BigDecimal(20.0));
		Livro l2 = new Livro(null, "Java",300, Date.from( Instant.parse("2007-06-20T19:53:07Z")), new BigDecimal(26.0));
		Livro l3 = new Livro(null, "Test",500, Date.from( Instant.parse("2009-06-20T19:53:07Z")), new BigDecimal(27.0));
		
		livroRepository.saveAll(Arrays.asList(l1,l2,l3));
	}

}
