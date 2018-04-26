
public class Mensola 
{
	//Attributi
	private static final int NUM_MAX_VOLUMI=15;
	private Libro[] volumi;
	
	//Costruttori
	public Mensola()
	{
		volumi=new Libro[NUM_MAX_VOLUMI];
	}
	
	public Mensola(Mensola m)
	{
		volumi=new Libro[NUM_MAX_VOLUMI];
		for (int i = 0; i <NUM_MAX_VOLUMI; i++) 
		{
			if (m.getVolume(i)!=null)
				//setVolume(m.getVolume(i), i);
				setVolume(new Libro(m.getVolume(i)),i);
		}
	}
	//Altri metodi
	
	//se posizione sbagliata-->return -1
	//se posizione occupata-->return -2
	//se ok-->return posizione
	public int setVolume (Libro volume,int posizione)
	{
		
		if (volumi[posizione]==null)
			volumi[posizione]=new Libro(volume);
		else
			return -2;
	
		return posizione;
	
	}
	
	//se posizione sbagliata -->return null
	//se posizione vuota --> return null
	//se ok--> return libro in posizione
	
	public Libro getVolume(int posizione)
	{
			return new Libro(volumi[posizione]);
	}
	
	//se posizione sbagliata-->return -1
	//se posizione è già vuota -->return -2
	//se ok-->return posizione 
	public int rimuoviVolume(int posizione)
	{
		
		if (volumi[posizione]==null)
			return -2;
		volumi[posizione]=null;
		return posizione;
		
		/*if (posizione<0 || posizione>=NUM_MAX_VOLUMI)
			return -1;
		if (volumi[posizione]==null)
			return-2;
		volumi[posizione]=null;
		return posizione;
	*/
	}
	
	public static int getNumMaxVolumi()
	{
		return NUM_MAX_VOLUMI;
	}
	
	public int getNumVolumi()
	{
		int c=0;
		for (int i = 0; i < NUM_MAX_VOLUMI; i++) 
		{
			if (volumi[i]!=null)
				c++;
		}
		return c;
	}
	
	public String toString()
	{
		String risultato="";
		for (int i = 0; i <NUM_MAX_VOLUMI; i++) 
		{
			if(volumi[i]!=null)
				risultato+=volumi[i].toString()+"\n";
		}
		return risultato;
		
	}
	
	
}
