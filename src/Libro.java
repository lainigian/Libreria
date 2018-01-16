
public class Libro 
{
	// ATTRIBUTI
	private String titolo;
	private String autore;
	private int numero_pagine;
	private static double costo_pagina=0.05;
	private final double COSTO_FISSO=5.5;
	
	//COSTRUTTORI
	public Libro(String titolo, String autore, int numero_pagine)
	{
		this.titolo=titolo;
		this.autore=autore;
		setNumero_pagine(numero_pagine);
	}
	//getter e setter
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
	
	public void setTitolo(String titolo) 
	{
		this.titolo=titolo;
	}
	public void setAutore(String autore) 
	{
		this.autore=autore;
	}
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
	public double prezzo() 
	{
		return ((numero_pagine*costo_pagina)+COSTO_FISSO);
	}
	
	
}
