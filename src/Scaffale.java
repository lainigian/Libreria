
public class Scaffale 
{
	
	//Attributi
	private static final int NUM_RIPIANI=5;
	private Mensola[] ripiani;
	
	//Costruttori
	public Scaffale()
	{
		ripiani=new Mensola[NUM_RIPIANI];
		
		for (int i = 0; i < NUM_RIPIANI; i++) 
		{
			ripiani[i]=new Mensola();
		}
	}
	
	public Scaffale (Scaffale s) throws EccezionePosizioneNonValida, EccezionePosizioneNonVuota, EccezionePosizioneVuota
	{
		ripiani=new Mensola[NUM_RIPIANI];
		
		for (int i = 0; i < NUM_RIPIANI; i++) 
		{
			ripiani[i]=new Mensola();
			for (int j = 0; j < ripiani[i].getNumMaxVolumi(); j++) 
			{
				if (s.getLibro(i, j)!=null)
					setLibro(new Libro(s.getLibro(i, j)), i, j);
			}
		}
		
		
	}
	
	//Se ripiano non valido --> return -1
	//Se posizione non valida o  occupata return -->-2
	//se ok return 1
	public void setLibro(Libro libro, int ripiano, int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneNonVuota 
	{
		int returnMensola;
		try
		{
			returnMensola=ripiani[ripiano].setVolume(libro, posizione);
			if (returnMensola==-2)
				throw new EccezionePosizioneNonVuota(ripiano, posizione);
		}
		
		catch (ArrayIndexOutOfBoundsException e)
		{
			throw new EccezionePosizioneNonValida(ripiano, posizione);
		}
	
	}
	
	
	
	
	//se ripiano non corretto, posizione non corretta o vuota-->return null
	//se ok return libro
	public Libro getLibro(int ripiano, int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneVuota
	{
		try
		{
			return ripiani[ripiano].getVolume(posizione);
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			throw new EccezionePosizioneNonValida(ripiano, posizione);
		}
		catch (NullPointerException e)
		{
			throw new EccezionePosizioneVuota(ripiano,posizione);
		}
		
		
		/*if (ripiano<0 || ripiano>=NUM_RIPIANI)
			return null;
		if (ripiani[ripiano].getVolume(posizione)==null)
			return null;
		return ripiani[ripiano].getVolume(posizione);	
		*/
	}
	
	//se ripiano non valido-->return -1
	//se posizione non valida o già vuota-->return -2
	//se ok -- return 1
	public void rimuoviVolume(int ripiano, int posizione) throws EccezionePosizioneVuota, EccezionePosizioneNonValida
	{
		int returnMensola;
		try
		{
			returnMensola=ripiani[ripiano].rimuoviVolume(posizione);
			if (returnMensola==-2)
				throw new EccezionePosizioneVuota(ripiano, posizione);
		}
		
		catch (ArrayIndexOutOfBoundsException e)
		{
			throw new EccezionePosizioneNonValida(ripiano, posizione);
		}
	}
	
	public int getNumRipiani()
	{
		return NUM_RIPIANI;
	}
	
	public int getNumMaxLibri()
	{
		int totMaxLibri=0;
		for (int i = 0; i < NUM_RIPIANI; i++) 
		{
			totMaxLibri+=ripiani[i].getNumMaxVolumi();
		}
		return totMaxLibri;
	}
	
	public int getNumLibri (int ripiano)
	{
		if (ripiano<0 || ripiano > NUM_RIPIANI)
			return -1000;
		return (ripiani[ripiano].getNumVolumi());
	}
	
	public int getNumLibri()
	{
		int numTotLibri=0;
		for (int i = 0; i < NUM_RIPIANI; i++) 
		{
			numTotLibri+=getNumLibri(i);
		}
		return numTotLibri;
	}
	
	public int getNumMaxLibri(int ripiano)
	{
		if (ripiano<0 || ripiano > NUM_RIPIANI)
			return -1000;
		return ripiani[ripiano].getNumMaxVolumi();
	}
	
	
	public String[] elencoTitoli (String autore)
	{
		int contatore=0;
		String[] elencoTitoliAutore;
		
		for (int i = 0; i < NUM_RIPIANI; i++) 
		{
			for (int j = 0; j < ripiani[i].getNumMaxVolumi(); j++) 
			{
				if (ripiani[i].getVolume(j)!=null)
				{
					if (ripiani[i].getVolume(j).getAutore().compareTo(autore)==0)
						contatore++;
				}
			}
		}
		elencoTitoliAutore=new String[contatore];
		int k=0;
		for (int i = 0; i < NUM_RIPIANI; i++) 
		{
			for (int j = 0; j < ripiani[i].getNumMaxVolumi(); j++) 
			{
				if (ripiani[i].getVolume(j)!=null)
				{
					if (ripiani[i].getVolume(j).getAutore().compareTo(autore)==0)
					{
						elencoTitoliAutore[k]=ripiani[i].getVolume(j).getTitolo();
						k++;
					}
				}
			}
		}
		return elencoTitoliAutore;
		
		
		
	}
	
	
	public int setElencoLibri(Libro[] elencoLibri, int ripiano) throws EccezionePosizioneNonValida, EccezionePosizioneNonVuota
	{
		if (ripiano<0 || ripiano>NUM_RIPIANI)
			return -1;
		
		int numeroLibriDaInserire=ripiani[ripiano].getNumMaxVolumi();
		if (elencoLibri.length<numeroLibriDaInserire)
			numeroLibriDaInserire=elencoLibri.length;
		
		for (int i = 0; i < numeroLibriDaInserire; i++) 
		{
			setLibro(elencoLibri[i], ripiano, i);
		}
		return 1;
	}
	
	
	
	public String toString()
	{
		String risultato="";
		for (int i = 0; i < NUM_RIPIANI; i++) 
		{
			for (int j = 0; j <getNumMaxLibri(i) ; j++) 
			{
				try 
				{
					if (getLibro(i, j)!=null)
						risultato+="("+i+","+j+")"+getLibro(i, j).toString()+"\n";
				} 
				catch (EccezionePosizioneNonValida e) 
				{
					System.out.println(e.toString());
				} 
				catch (EccezionePosizioneVuota e) 
				{
					
				}
			}
		}
		return risultato;
	}
	
	
	
}
