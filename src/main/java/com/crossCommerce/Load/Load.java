package com.crossCommerce.Load;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossCommerce.extract.ExtractNumbers;
import com.crossCommerce.model.Numbers;
import com.crossCommerce.transform.Transform;

/**
 * Esta Classe PRocessa os dados ja realizados pela
 * Classe Transform e ExtractNumbers e os Exibi por meio 
 * Da classe actual 
 * 
 * @author Jose Dos Santos
 * @see Transform
 * @see ExtractNumbers
 * @version 1.0
 *
 */

@Service
public class Load {

   /**
    * Este Metodo Irá Mostrar os numeros de 
    * Todas as paginas ordenados.
    * A ordenado pagina por pagina.
    * 
    * 
    * @return ArrayList<ArrayList<Double>>
    * @throws Exception
    */
	
   @Autowired
   private ExtractNumbers en;
   @Autowired
   private Transform t;
   @Autowired
   private Numbers listaOrganizada;
   
   /**
    * Este Metodo tem a responsabilidade de 
    * Mostrar todos numeros de cada pagina
    * de maneira ordenada.
    * 
    * @return ArrayList<ArrayList<Double>>
    * @throws Exception
    */
   public ArrayList<ArrayList<Double>> lista() {
		
		
		 
		// Extraindo Todos os Numeros Das Paginas
		ArrayList<ArrayList<Double>> list;
		
		try {
			list = en.extractNumbersFromPages();
			// Ordenando todos os numeros de cada pagina
			ArrayList<ArrayList<Double>> list2 = t.sortAllPages(list);
			listaOrganizada.setAllNumbers(list2);
			return listaOrganizada.getAllNumbers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
