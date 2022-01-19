package com.crossCommerce.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crossCommerce.Load.Load;
import com.crossCommerce.extract.ExtractNumbers;
import com.crossCommerce.model.Numbers;
import com.crossCommerce.transform.Transform;

/**
 * ESta Classe tem a responsabilidade de Exibir
 * todos os números da Api da cross Commerce de 
 * forma ordenada.
 * 
 * 
 * 
 * @author Jose Dos Santos
 * @see ExtractNumbers
 * @see Load
 * @see Transform
 * @see Numbers
 * @version 1.0
 *
 */


@RestController
public class CrossController {

	@Autowired
	private Load load;
	@Autowired
	private Numbers numbers;
	
	
	@GetMapping("/sort")
	public ResponseEntity<ArrayList<ArrayList<Double>>> ExibirListaOrdenada(){
		ArrayList<ArrayList<Double>> lista = new ArrayList<>();
		lista = load.lista();
		if(lista != null) {
			numbers.setAllNumbers(lista);
			return ResponseEntity.ok(lista);
			
		}else {
			return null;
		}
		
		
	}
}
