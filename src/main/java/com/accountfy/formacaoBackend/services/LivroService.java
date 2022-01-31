package com.accountfy.formacaoBackend.services;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.accountfy.formacaoBackend.entities.AnoMes;
import com.accountfy.formacaoBackend.entities.Livro;
import com.accountfy.formacaoBackend.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	public Long salvar(Livro livro) {
		
		Livro l = livroRepository.save(livro);
		if(l == null) {
			return 0L;
		}
		else 
			return 1L;
	}
	
	public Livro encontrarPeloId(Long id){
		Optional<Livro> obj  = livroRepository.findById(id);
		
		return obj.get();
	}
	
	public void excluirPeloId(Long id) {
		livroRepository.deleteById(id);
		// implementar exception depois
	}
	
	public void excluir(Livro livro) {
		//livroRepository.deleteById());
		var list = livroRepository.findAll(Example.of(livro));
		
		for(var i : list) {
			
			livroRepository.deleteById(i.getId());
		}
	}
	
	public List<Livro> obterTodos(){
		
		return livroRepository.findAll();
	}
	
	public List<Livro> obterPublicadosEm(AnoMes anoMes) {
		List<Livro> livros = livroRepository.findAll();
		List<Livro> livrosAnoMes = new ArrayList<>();
		String anoMesF = anoMes.getAno() + "-" + anoMes.getMes(); 
		
		for(Livro l : livros) {
			if(anoMesF.equalsIgnoreCase(l.getAnoMesDePublicacao().toString())) {
				livrosAnoMes.add(l);
			}
		}
		return livrosAnoMes;
	}
	
	public List<Livro> obterPublicadosEm(AnoMes[] anoMes) {
		List<Livro> livros = livroRepository.findAll();
		List<Livro> livrosAnoMes = new ArrayList<>();
			
		for(AnoMes aM : anoMes){
			String anoMesF = aM.getAno() + "-" + aM.getMes(); 
		
			for(Livro l : livros) {
				if(anoMesF.equalsIgnoreCase(l.getAnoMesDePublicacao().toString())) {
					livrosAnoMes.add(l);
				}
			}
		}
		return livrosAnoMes;
	}
	
	public List<Livro> obterComTituloContendo(String termo){
		throw new NotYetImplementedException();
	}
	
	public Boolean estaVazio() {
		if( livroRepository.count() == 0) {
			return true;
		}
		else
			return false;
	}
	
	public Boolean naoEstaVazio() {
		if( livroRepository.count() != 0) {
			return true;
		}
		else
			return false;
		
	}
	
	public void excluirTodos() {
		livroRepository.deleteAll();
		
	}
	
	public int contarTodos() {
		return (int) livroRepository.count();
	}
}
