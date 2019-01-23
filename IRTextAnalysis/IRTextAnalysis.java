

import java.io.*;

import org.apache.commons.math3.stat.inference.OneWayAnova;

import java.util.*;


public class IRTextAnalysis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Estrazione di tutti i dati dai file
		
		//BM25-NoStoplist-PorterStemmerVAL
		int count = 1350;
		String bmny[][] = new String[count][3];
		BufferedReader fin=null;
		String [] split;
		int i = 0;
	    try {
			fin = new BufferedReader (new FileReader("BM25-NoStoplist-PorterStemmerVAL.txt"));
			String s;
			s=fin.readLine();
			while (s !=null) {
				split = s.split("\\s+");
				if(!split[1].equals("all")) bmny[i][0] = split[0];
				if(!split[1].equals("all")) bmny[i][1] = split[1];
				if(!split[1].equals("all")) bmny[i][2] = split[2];
				s = fin.readLine();
				i++;
			}
		fin.close();
		}
	    catch (IOException e) {
	    	System.err.println("Errore in una operazione sul file");
	    	e.printStackTrace();
	    	System.exit(1);  //termina con codice d'errore 1
	    }
	    
	    
	    //BM25-Stoplist-PorterStemmerVAL
	    String bmyy[][] = new String[count][3];
		
		fin=null;
		i = 0;
	    try {
			fin = new BufferedReader (new FileReader("BM25-Stoplist-PorterStemmerVAL.txt"));
			String s;
			s=fin.readLine();
			while (s !=null) {
				split = s.split("\\s+");
				if(!split[1].equals("all")) bmyy[i][0] = split[0];
				if(!split[1].equals("all")) bmyy[i][1] = split[1];
				if(!split[1].equals("all")) bmyy[i][2] = split[2];
				s = fin.readLine();
				i++;
			}
		fin.close();
		}
	    catch (IOException e) {
	    	System.err.println("Errore in una operazione sul file");
	    	e.printStackTrace();
	    	System.exit(1);  //termina con codice d'errore 1
	    }
	    
	    //TF_IDF-NoStopList-NoStemmerVAL
	    String idfnn[][] = new String[count][3];
		
		fin=null;
		i = 0;
	    try {
			fin = new BufferedReader (new FileReader("TF_IDF-NoStopList-NoStemmerVAL.txt"));
			String s;
			s=fin.readLine();
			while (s !=null) {
				split = s.split("\\s+");
				if(!split[1].equals("all")) idfnn[i][0] = split[0];
				if(!split[1].equals("all")) idfnn[i][1] = split[1];
				if(!split[1].equals("all")) idfnn[i][2] = split[2];
				s = fin.readLine();
				i++;
			}
		fin.close();
		}
	    catch (IOException e) {
	    	System.err.println("Errore in una operazione sul file");
	    	e.printStackTrace();
	    	System.exit(1);  //termina con codice d'errore 1
	    }
	    
	    //TF_IDF-StopList-PorterStemmerVAL
	    String idfyy[][] = new String[count][3];
		
		fin=null;
		i = 0;
	    try {
			fin = new BufferedReader (new FileReader("TF_IDF-StopList-PorterStemmerVAL.txt"));
			String s;
			s=fin.readLine();
			while (s !=null) {
				split = s.split("\\s+");
				if(!split[1].equals("all")) idfyy[i][0] = split[0];
				if(!split[1].equals("all")) idfyy[i][1] = split[1];
				if(!split[1].equals("all")) idfyy[i][2] = split[2];
				s = fin.readLine();
				i++;
			}
		fin.close();
		}
	    catch (IOException e) {
	    	System.err.println("Errore in una operazione sul file");
	    	e.printStackTrace();
	    	System.exit(1);  //termina con codice d'errore 1
	    }
	
	    //Estrazione e conversione dei valori di MAP
		double mapbmny[] = new double [50];
		double mapbmyy[] = new double [50];
		double mapidfnn[] = new double [50];
		double mapidfyy[] = new double [50];
	    //BM25-NoStoplist-PorterStemmerVAL
		int j1 = 0;
		for (int j = 0; j < count; j++) {
			if (bmny[j][0].equals("map")) {
				mapbmny[j1] = Double.parseDouble(bmny[j][2]);
				j1++;
			}
		}
		//BM25-Stoplist-PorterStemmerVAL
		j1 = 0;
		for (int j = 0; j < count; j++) {
			if (bmyy[j][0].equals("map")) {
				mapbmyy[j1] = Double.parseDouble(bmyy[j][2]);
				j1++;
			}
		}
		//TF_IDF-NoStopList-NoStemmerVAL
		j1 = 0;
		for (int j = 0; j < count; j++) {
			if (idfnn[j][0].equals("map")) {
				mapidfnn[j1] = Double.parseDouble(idfnn[j][2]);
				j1++;
			}
		}		
		//TF_IDF-StopList-PorterStemmerVAL
		j1 = 0;
		for (int j = 0; j < count; j++) {
			if (idfyy[j][0].equals("map")) {
				mapidfyy[j1] = Double.parseDouble(idfyy[j][2]);
				j1++;
			}
		}
		
		//Estrazione e conversione dei valori di R_Prec
		double precbmny[] = new double [50];
		double precbmyy[] = new double [50];
		double precidfnn[] = new double [50];
		double precidfyy[] = new double [50];
	    //BM25-NoStoplist-PorterStemmerVAL
		j1 = 0;
		for (int j = 0; j < count; j++) {
			if (bmny[j][0].equals("R-prec")) {
				precbmny[j1] = Double.parseDouble(bmny[j][2]);
				j1++;
			}
		}
		//BM25-Stoplist-PorterStemmerVAL
		j1 = 0;
		for (int j = 0; j < count; j++) {
			if (bmyy[j][0].equals("R-prec")) {
				precbmyy[j1] = Double.parseDouble(bmyy[j][2]);
				j1++;
			}
		}
		//TF_IDF-NoStopList-NoStemmerVAL
		j1 = 0;
		for (int j = 0; j < count; j++) {
			if (idfnn[j][0].equals("R-prec")) {
				precidfnn[j1] = Double.parseDouble(idfnn[j][2]);
				j1++;
			}
		}		
		//TF_IDF-StopList-PorterStemmerVAL
		j1 = 0;
		for (int j = 0; j < count; j++) {
			if (idfyy[j][0].equals("R-prec")) {
				precidfyy[j1] = Double.parseDouble(idfyy[j][2]);
				j1++;
			}
		}
		
		
		//Estrazione e conversione dei valori di R_Prec
		double p10bmny[] = new double [50];
		double p10bmyy[] = new double [50];
		double p10idfnn[] = new double [50];
		double p10idfyy[] = new double [50];
	    //BM25-NoStoplist-PorterStemmerVAL
		j1 = 0;
		for (int j = 0; j < count; j++) {
			if (bmny[j][0].equals("P10")) {
				p10bmny[j1] = Double.parseDouble(bmny[j][2]);
				j1++;
			}
		}
		//BM25-Stoplist-PorterStemmerVAL
		j1 = 0;
		for (int j = 0; j < count; j++) {
			if (bmyy[j][0].equals("P10")) {
				p10bmyy[j1] = Double.parseDouble(bmyy[j][2]);
				j1++;
			}
		}
		//TF_IDF-NoStopList-NoStemmerVAL
		j1 = 0;
		for (int j = 0; j < count; j++) {
			if (idfnn[j][0].equals("P10")) {
				p10idfnn[j1] = Double.parseDouble(idfnn[j][2]);
				j1++;
			}
		}		
		//TF_IDF-StopList-PorterStemmerVAL
		j1 = 0;
		for (int j = 0; j < count; j++) {
			if (idfyy[j][0].equals("P10")) {
				p10idfyy[j1] = Double.parseDouble(idfyy[j][2]);
				j1++;
			}
		}
		
		//Media MAP
		//mapbmny
		double mediamapbmny = 0;
		for (int j = 0; j < 50; j++)
			mediamapbmny = mediamapbmny + mapbmny[j];
		mediamapbmny = mediamapbmny / 50;
		System.out.println("Media mapbmny: " + mediamapbmny);
		
		//mapbmny
		double mediamapbmyy = 0;
		for (int j = 0; j < 50; j++)
			mediamapbmyy = mediamapbmyy + mapbmyy[j];
		mediamapbmyy = mediamapbmyy / 50;
		System.out.println("Media mapbmyy: " + mediamapbmyy);
		
		//mapbmny
		double mediamapidfnn = 0;
		for (int j = 0; j < 50; j++)
			mediamapidfnn = mediamapidfnn + mapidfnn[j];
		mediamapidfnn = mediamapidfnn / 50;
		System.out.println("Media mapidfnn: " + mediamapidfnn);
				
		//mapbmny
		double mediamapidfyy = 0;
		for (int j = 0; j < 50; j++)
			mediamapidfyy = mediamapidfyy + mapidfyy[j];
		mediamapidfyy = mediamapidfyy / 50;
		System.out.println("Media mapidfyy: " + mediamapidfyy);
		
		
		//Media p10
		//p10bmny
		double mediap10bmny = 0;
		for (int j = 0; j < 50; j++)
			mediap10bmny = mediap10bmny + p10bmny[j];
		mediap10bmny = mediap10bmny / 50;
		System.out.println("Media p10bmny: " + mediap10bmny);
		
		//p10bmny
		double mediap10bmyy = 0;
		for (int j = 0; j < 50; j++) 
			mediap10bmyy = mediap10bmyy + p10bmyy[j];
		
		
		mediap10bmyy = mediap10bmyy / 50;
		System.out.println("Media p10bmyy: " + mediap10bmyy);
		
		//p10bmny
		double mediap10idfnn = 0;
		for (int j = 0; j < 50; j++)
			mediap10idfnn = mediap10idfnn + p10idfnn[j];
		mediap10idfnn = mediap10idfnn / 50;
		System.out.println("Media p10idfnn: " + mediap10idfnn);
				
		//p10bmny
		double mediap10idfyy = 0;
		for (int j = 0; j < 50; j++)
			mediap10idfyy = mediap10idfyy + p10idfyy[j];
		mediap10idfyy = mediap10idfyy / 50;
		System.out.println("Media p10idfyy: " + mediap10idfyy);
		
		//Media prec
		//precbmny
		double mediaprecbmny = 0;
		for (int j = 0; j < 50; j++)
			mediaprecbmny = mediaprecbmny + precbmny[j];
		mediaprecbmny = mediaprecbmny / 50;
		System.out.println("Media precbmny: " + mediaprecbmny);
		
		//precbmny
		double mediaprecbmyy = 0;
		for (int j = 0; j < 50; j++)
			mediaprecbmyy = mediaprecbmyy + precbmyy[j];
		mediaprecbmyy = mediaprecbmyy / 50;
		System.out.println("Media precbmyy: " + mediaprecbmyy);
		
		//precbmny
		double mediaprecidfnn = 0;
		for (int j = 0; j < 50; j++)
			mediaprecidfnn = mediaprecidfnn + precidfnn[j];
		mediaprecidfnn = mediaprecidfnn / 50;
		System.out.println("Media precidfnn: " + mediaprecidfnn);
				
		//precbmny
		double mediaprecidfyy = 0;
		for (int j = 0; j < 50; j++)
			mediaprecidfyy = mediaprecidfyy + precidfyy[j];
		mediaprecidfyy = mediaprecidfyy / 50;
		System.out.println("Media precidfyy: " + mediaprecidfyy);
		
		
		//ANOVA PVALUE
		System.out.println("ANOVA PVALUE");
		List<double[]> listMap = Arrays.asList(mapidfnn, mapbmny, mapbmyy,mapidfyy);
		
		//oneway anova
		OneWayAnova map = new OneWayAnova();
        System.out.println("MAP:\t " + map.anovaPValue(listMap));
	    
        List<double[]> listRprec = Arrays.asList(precidfnn, precbmny, precbmyy, precidfyy);
		
		//oneway anova
		OneWayAnova rprec = new OneWayAnova();
        System.out.println("R-Prec:\t " + rprec.anovaPValue(listRprec));
      
        List<double[]> listP10 = Arrays.asList(p10idfnn, p10bmny, p10bmyy, p10idfyy);
		
		//oneway anova
		OneWayAnova p10 = new OneWayAnova();
        System.out.println("P10:\t " + p10.anovaPValue(listP10));
        
        //ANOVA fvalue
		System.out.println("ANOVA FVALUE");
		listMap = Arrays.asList(mapidfnn, mapbmny, mapbmyy,mapidfyy);
		
		//oneway anova
		map = new OneWayAnova();
		System.out.println("MAP:\t " + map.anovaFValue(listMap));
		
		listRprec = Arrays.asList(precidfnn, precbmny, precbmyy, precidfyy);
		
		//oneway anova
		rprec = new OneWayAnova();
		System.out.println("R-Prec:\t " + rprec.anovaFValue(listRprec));
		
		listP10 = Arrays.asList(p10idfnn, p10bmny, p10bmyy, p10idfyy);
		
		//oneway anova
		p10 = new OneWayAnova();
		System.out.println("P10:\t " + p10.anovaFValue(listP10));	
	}
}


/*
 ciao
ANOVA PVALUE
0.999496128359957
0.9999158918424002
0.9999158918424002
ANOVA FVALUE
0.005106527970367879
0.0015447662771456798
0.0015447662771456798

 */
