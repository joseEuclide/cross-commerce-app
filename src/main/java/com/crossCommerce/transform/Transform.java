package com.crossCommerce.transform;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.crossCommerce.extract.ExtractNumbers;

/**
 * ESta Classe tem a responsabilidade de Ordenar 
 * Todos Os Dados Provenientes Da Classe ExtractNumbers 
 * E disponibilizá~la para a classe Load
 * 
 * 
 * @author Jose Dos Santos
 * @see ExtractNumbers
 * @see Load
 * @version 1.0
 *
 */

@Service
public class Transform {

	
	/**
	 * Este metodo tem o Dever de Ordenar DE
	 * Forma Crescente uma lista
	 * @param numeros
	 */
	 private ArrayList<Double> ordenar(ArrayList<Double> numeros){
		 ArrayList<Double> numerosOrdenados = new ArrayList<>();
		 double limite,aux;
		 double[] vector = new double[numeros.size()];
		 for (int i = 0; i < numeros.size(); i++) {
			vector[i] = numeros.get(i);
		}
		
		 // Este Ciclo controla quantas comparacoes serão feitas
		 for(int i = 0;i<vector.length-1;i++) {
			 //Este ciclo ordena o Array, onde o ciclo não atinge os elementos ja ordenados
			 limite = vector.length-1-i;
			 for(int j = 0;j<limite;j++) {
				 // Troca de posicao no Array caso o elemento actual for maior que o elemento posterior.
				 if(vector[j] > vector[j+1]) {
					 aux = vector[j];
					 vector[j] = vector[j+1];
					 vector[j+1] = aux;
				 }
			 }
			 
		 }
		 // Atribuindo um vector para um ArrayList
		 for (double numero : vector) {
			numerosOrdenados.add(numero);
		}
		 return numerosOrdenados;
		 
	 }
	 
	 /**
	  * Ordenacao de Todods os numeros Pertencentes em todas
	  * As paginas
	  * 
	  * @param lista
	  * @return
	  */
	 public ArrayList<ArrayList<Double>> sortAllPages(ArrayList<ArrayList<Double>> lista){
		 ArrayList<Double> listaOrdenada = null;
		 ArrayList<ArrayList<Double>> lista2 = new ArrayList<>();
		 for (ArrayList<Double> item : lista) {
			 listaOrdenada = ordenar(item);
			 if(listaOrdenada.size() > 0) {
				 lista2.add(listaOrdenada);
			 }
		}
		
		 return lista2;
	 }
}
