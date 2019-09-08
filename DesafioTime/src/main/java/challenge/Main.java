package challenge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
	public int q1() {
		String csvFile = "C:/Users/hugog/codenation/java-3/src/main/resources/data.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<String> paises = new ArrayList<String>();
		boolean primeiraLinha = true;
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				if (primeiraLinha) {//pula primeira linha
					primeiraLinha = false;
					continue;
				}
				// use comma as separator
				String[] data = line.split(cvsSplitBy);
				if(!paises.contains(data[14])){
					paises.add(data[14]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		//System.out.println(paises.size()); //qtd de paises distintos
		return(paises.size());
	}
	
	// Quantos clubes (coluna `club`) diferentes existem no arquivo?
	// Obs: Existem jogadores sem clube.
	public int q2() {
		String csvFile = "C:/Users/hugog/codenation/java-3/src/main/resources/data.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<String> clubes = new ArrayList<String>();
		boolean primeiraLinha = true;
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				if (primeiraLinha) {//pula primeira linha
					primeiraLinha = false;
					continue;
				}
				// use comma as separator
				String[] data = line.split(cvsSplitBy);

				if(!clubes.contains(data[3]) && !data[3].trim().equals("")){
					clubes.add(data[3]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return(clubes.size()); //qtd clubes diferentes
	}

	// Liste o primeiro nome (coluna `full_name`) dos 20 primeiros jogadores.
	public List<String> q3() {
		String csvFile = "C:/Users/hugog/codenation/java-3/src/main/resources/data.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<String> names = new ArrayList<String>();
		boolean primeiraLinha = true;
		int count = 0;
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				if (primeiraLinha) {//pula primeira linha
					primeiraLinha = false;
					continue;
				}
				// use comma as separator
				String[] data = line.split(cvsSplitBy);
				if(count < 20)
				{
					names.add(data[2]);
					count ++;
				}
				else
				{
					break;
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		//20 primeiros nomes
		return names;     
	}

	// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
	// (utilize as colunas `full_name` e `eur_release_clause`)
	public List<String> q4() {
		String csvFile = "C:/Users/hugog/codenation/java-3/src/main/resources/data.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		List<ArrayList<String>> names = new ArrayList<ArrayList<String>>();
		boolean primeiraLinha = true;
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				if (primeiraLinha) {//pula primeira linha
					primeiraLinha = false;
					continue;
				}
				// use comma as separator
				String[] data = line.split(cvsSplitBy);   
				names.add(new ArrayList<String>(Arrays.asList(data[18], data[2])));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		//      ordena do maior p/ o menor
		Collections.sort(names, new Comparator<ArrayList<String>>() {    
			@Override
			public int compare(ArrayList<String> o1, ArrayList<String> o2) {  
				String aux1 = o2.get(0);
				String aux2 = o1.get(0);
				if(aux1.trim().equals("")) aux1 = "0";
				if(aux2.trim().equals("")) aux2 = "0";
				return (int) (Double.parseDouble(aux1) - Double.parseDouble(aux2));            	
				//return aux1 - aux2;
			}            
		});     
		ArrayList<String> namesTop = new ArrayList<String>();
		int cont = 0;
		//20 primeiros nome
		for (List<String> list : names) 
		{
			namesTop.add(list.get(1));
			if(cont == 9)break;
			cont++;
		}
		return namesTop;    
	}

	// Quem são os 10 jogadores mais velhos (use como critério de desempate o campo `eur_wage`)?
	// (utilize as colunas `full_name` e `birth_date`)
	public List<String> q5() {
		String csvFile = "C:/Users/hugog/codenation/java-3/src/main/resources/data.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		List<ArrayList<String>> names = new ArrayList<ArrayList<String>>();
		boolean primeiraLinha = true;
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				if (primeiraLinha) {//pula primeira linha
					primeiraLinha = false;
					continue;
				}
				// use comma as separator
				String[] data = line.split(cvsSplitBy);   
				names.add(new ArrayList<String>(Arrays.asList(data[8], data[2])));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		//      ordena do mais velho para o mais novo
		Collections.sort(names, new Comparator<ArrayList<String>>() {    
			@Override
			public int compare(ArrayList<String> o1, ArrayList<String> o2) {    
				String aux1 = o2.get(0).replace("-","");
				String aux2 = o1.get(0).replace("-","");
				return (int) (Double.parseDouble(aux2) - Double.parseDouble(aux1));            	
			}            
		});     
		ArrayList<String> namesTop = new ArrayList<String>();
		int cont = 0;		
		for (List<String> list : names) //10 primeiros nome
		{
			namesTop.add(list.get(1));
			if(cont == 9)break;
			cont++;
		}
		return namesTop;
	}

	// Conte quantos jogadores existem por idade. Para isso, construa um mapa onde as chaves são as idades e os valores a contagem.
	// (utilize a coluna `age`)
	public Map<Integer, Integer> q6() {
		String csvFile = "C:/Users/hugog/codenation/java-3/src/main/resources/data.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<String> idadeKeys = new ArrayList<String>();
		ArrayList<String> idadeAll = new ArrayList<String>();
		boolean primeiraLinha = true;
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				if (primeiraLinha) {//pula primeira linha
					primeiraLinha = false;
					continue;
				}
				// use comma as separator
				String[] data = line.split(cvsSplitBy);
				idadeAll.add(data[6]);
				if(!idadeKeys.contains(data[6])) idadeKeys.add(data[6]);	
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		int cont = 0;
		Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < idadeKeys.size(); i++) {
			for(int x = 0; x < idadeAll.size(); x ++)
			{
				int aux1= Integer.parseInt(idadeKeys.get(i)) ;
				int aux2 = Integer.parseInt(idadeAll.get(x));
				if(aux1 == aux2)cont++;
				myMap.put(Integer.parseInt(idadeKeys.get(i)),cont);
			}		
			cont = 0;
		}
		return myMap;
	}	
}
