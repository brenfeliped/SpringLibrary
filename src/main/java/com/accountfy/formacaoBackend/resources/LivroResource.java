package com.accountfy.formacaoBackend.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.accountfy.formacaoBackend.entities.AnoMes;
import com.accountfy.formacaoBackend.entities.Livro;
import com.accountfy.formacaoBackend.repositories.LivroRepository;
import com.accountfy.formacaoBackend.services.LivroService;


@RestController
@RequestMapping(value= "/api/livros")
public class LivroResource {
	
	@Autowired
	LivroService livroService;
	
	@Autowired
	LivroRepository livroRepository;
	
	@GetMapping
	public ResponseEntity<List<Livro>> findAll(){
		List<Livro> list = livroService.obterTodos();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/publicadosEm")
	public  ResponseEntity<List<Livro>> getPublicadosEm(@RequestBody AnoMes obj){
		
		List<Livro> list = livroService.obterPublicadosEm(obj);
		System.out.println("AnoMes toString: "+obj.toString());
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/publicadosEmLista")
	public  ResponseEntity<List<Livro>> getPublicadosEmLista(@RequestBody AnoMes[] obj){
		
		List<Livro> list = livroService.obterPublicadosEm(obj);
		System.out.println("AnoMes toString: "+obj.toString());
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Long id){
		Livro obj = livroService.encontrarPeloId(id);
		
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		livroService.excluirPeloId(id);
		return ResponseEntity.noContent().build();
		
	}
	
	
	@DeleteMapping(value = "/delete")
	public ResponseEntity<Void> delete(@RequestBody Livro obj){
		
		//livroService.excluir(obj);
		livroService.excluir(obj);
		return ResponseEntity.noContent().build();
		
	}
	
	
	@DeleteMapping(value = "/deleteAll")
	public ResponseEntity<Void> deleteAll(){
		
		livroService.excluirTodos();
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping(value="/estaVazio")
	public  ResponseEntity<Boolean> isEmpty(){
		Boolean obj = livroService.estaVazio();
		
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value="/naoEstaVazio")
	public  ResponseEntity<Boolean> isNotEmpty(){
		Boolean obj = livroService.naoEstaVazio();
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Livro> insert(@RequestBody Livro obj){
		Long num = livroService.salvar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id")
					.buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
		
	}
}
