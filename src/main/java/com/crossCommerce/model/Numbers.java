package com.crossCommerce.model;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class Numbers {

	// Indica os Numeros de Uma Pagina
	private ArrayList<Double> numbers = new ArrayList<>();
	// Indica os Numeros de Todas as Paginas
	private ArrayList<ArrayList<Double>> allNumbers = new ArrayList<>();
	
	
	
	public ArrayList<Double> getNumbers() {
		return numbers;
	}
	public void setNumbers(ArrayList<Double> numbers) {
		this.numbers = numbers;
	}
	public ArrayList<ArrayList<Double>> getAllNumbers() {
		return allNumbers;
	}
	public void setAllNumbers(ArrayList<ArrayList<Double>> allNumbers) {
		this.allNumbers = allNumbers;
	}

	
}
