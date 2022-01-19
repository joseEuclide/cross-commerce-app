package com.crossCommerce.extract;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.crossCommerce.Load.Load;
import com.crossCommerce.model.Numbers;
import com.google.gson.Gson;

/**
 * Esta Classe Tem a Responsabilidade de Extrair os dados
 * Da API Da Cross Commerce para serem PRocessados
 * Pela Class Transform e Load
 * 
 * 
 * @author Jose Dos Santos
 * @see Transform
 * @see Load
 * @version 1.0
 *
 */

@Service
public class ExtractNumbers {

	
	public static String webSeervice = "http://challenge.dienekes.com.br/api/numbers?page=";
	private static int codigoSucesso = 200;
	
	/**
	 * Este Metodo é responsavel em extrair os numeros
	 * De cada Pagina, sendo que ele recebe um parametro do 
	 * tipo int que serve como um contador de paginas.
	 * @param count
	 * 
	 * @return
	 * @throws Exception
	 */
	    private static ArrayList<Double> getNumbers(int count) throws Exception{
		
		String urlParaChamada = webSeervice + count+";";
		Numbers numbersFromPage;
		try {
			URL url = new URL(urlParaChamada);
			HttpURLConnection conexao = (HttpURLConnection)url.openConnection();
			conexao.setRequestMethod("GET");
			//conexao.setRequestProperty("Accept", "application/json");
			
			if(conexao.getResponseCode() != codigoSucesso) {
				throw new RuntimeException("HTTP ERROR CODE :" + conexao.getResponseCode()+"");
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
			String jsonEmString = ExtractNumbers.JsonToString(br);
			
			Gson gson = new Gson();
			numbersFromPage = gson.fromJson(jsonEmString, Numbers.class);
			System.out.println("Chegou aqui");
			return numbersFromPage.getNumbers();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
    /**
     * Este Metodo é um  auxiliar do metodo getNumbers(int count)
     * sendo que ele tem a responsabilidade de extrair todos dados armazenados no 
     * BufferedReader
     * 
     * @param br
     * @return
     * @throws IOException
     */
	    
	private static String JsonToString(BufferedReader br) throws IOException {
		String resposta, jsonEmString = "";
		while((resposta = br.readLine()) != null) {
			jsonEmString += resposta;
		}
		return jsonEmString;
	}
	
	
	/**
	 * Este Metodo Tem o Dever de Extrair os dados da API, colocá~los
	 * Num Vector e Rectornar Esses Dados extraídos de modos a Serem
	 * Ordenados Pela Classe De Transform
	 * no
	 * @return ArrayList<ArrayList<Double>>
	 * @throws Exception
	 */
		
	
	public ArrayList<ArrayList<Double>> extractNumbersFromPages() throws Exception{
		
		int count = 0;
		ArrayList<Double> numbers = new ArrayList<>();
		boolean continuar = true;
		ArrayList<ArrayList<Double>> allNumbers = new ArrayList<>();
		while(continuar) {
			
			++count;
			numbers = getNumbers(count);
			System.out.println(count);
			if(numbers !=  null) {
				allNumbers.add(numbers);
			}else {
				continuar = false;
			}
		}
		return allNumbers;
	}
	
	
}
