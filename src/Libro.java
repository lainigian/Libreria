/**
 * La classe rapprenta un libro. Il libro è costituito
 * da un titolo, un autore, un numero di pagine, il costo di 
 * ciascuna pagina e il costo fisso per ogni copia del libro. Il costo di 
 * ciascuna pagina e il costo fisso sono uguali per ogni istanza di Libro,
 * se modificati cambiano il loro valore per ogni istanza.
 * 
 * La classe consente di impostare e rilevare i valori degli attributi pubblici
 * e di calcolare il prezzo di un libro.
 * 
 * @author Laini Gian Marco
 * @version 1.0
 *
 */
public class Libro 
{
	// ATTRIBUTI
	private String titolo;
	private String autore;
	private int numero_pagine;
	private static double costo_pagina=0.05;
	private final double COSTO_FISSO=5.5;
	
	//COSTRUTTORI
	/**
	 * Costruttore di Libro
	 * @param titolo titolo del libro
	 * @param autore autore del libro
	 * @param numero_pagine numero di pagine del libro
	 */
	public Libro(String titolo, String autore, int numero_pagine)
	{
		this.titolo=titolo;
		this.autore=autore;
		setNumero_pagine(numero_pagine);
	}
	/**
	 * Costruttore di copia. Istanzia un libro copia di un altro libro.
	 * @param libro da copiare
	 */
	//COSTRUTTORE DI COPIA
	public Libro(Libro libro) 
	{
		titolo=libro.getTitolo();
		autore=libro.getAutore();
		numero_pagine=libro.getNumero_pagine();
		
	}
	/**
	 * Costuttore di default. Istanzia un libro senza titolo, senza autore 
	 * e con numeroPagine=0;
	 */
	//COSTRUTTORE DI DEFAULT
	public Libro() 
	{
		titolo="";
		autore="";
		numero_pagine=0;
		
	}
	
	//getter e setter
	/**
	 * 
	 * @return il titolo del libro inserito
	 */
	public String getTitolo() 
	{
		return titolo;
	}
	public String getAutore()
	{
		return autore;
	}
	public int getNumero_pagine()
	{
		return numero_pagine;
	}
	public static double getCosto_pagina()
	{
		return costo_pagina;
	}
	public double COSTO_FISSO()
	{
		return COSTO_FISSO;
	}
	
	/**
	 * 
	 * @param titolo Titolo del libro
	 */
	public void setTitolo(String titolo) 
	{
		this.titolo=titolo;
	}
	public void setAutore(String autore) 
	{
		this.autore=autore;
	}
	/**
	 * Imposta il numero di pagine. Se il numero di pagine è <0
	 * il numero di pagine viene posto a 0.
	 * @param numero_pagine Numero di pagine di cui è costituito il libro
	 */
	public void setNumero_pagine(int numero_pagine) 
	{
		if (numero_pagine>0) 
		{
			this.numero_pagine=numero_pagine;
		}
		else 
		{
			this.numero_pagine=0;
		}
	}
	
	public static void setCosto_pagina(double Costo) 
	{
		costo_pagina=Costo;
	}
	
	// ALTRI METODI
	/**
	 * 	Calcola e restituisce il prezzo del libro
	 * @return il prezzo del libro
	 */
	public double prezzo() 
	{
		return ((numero_pagine*costo_pagina)+COSTO_FISSO);
	}
	
	public String toString()
	{
		String risultato;
		risultato=getTitolo()+" "+getAutore()+" "+prezzo()+" €";
		return risultato;
	} 
	public boolean equals(Libro l)
	{
		if (getTitolo()==l.getTitolo() && getAutore()==l.getAutore() && getNumero_pagine()==l.getNumero_pagine())
			return true;
		else
			return false;
	}
}
