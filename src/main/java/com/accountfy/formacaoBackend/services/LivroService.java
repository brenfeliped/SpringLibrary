package com.accountfy.formacaoBackend.services;

import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		throw new NotYetImplementedException();
	}
	
	public List<Livro> obterTodos(){
		
		return livroRepository.findAll();
	}
	
	public List<Livro> obterPublicadosEm(YearMonth anoMes) {
		throw new NotYetImplementedException();
	}
	
	public List<Livro> obterPublicadosEm(List<YearMonth> anoMes) {
		throw new NotYetImplementedException();
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
