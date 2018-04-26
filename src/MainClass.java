public class MainClass 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Libro l1=new Libro("I promessi sposi", "Manzoni", 600);
		Libro l2=new Libro("Moby Dick", "Melville", 650);
		Libro l3=new Libro("Adelchi", "Manzoni", 200);
		Libro l4=new Libro("Raccolta di poesie", "Manzoni", 220);
		
		Scaffale s1=new Scaffale();
		
		try 
		{
			s1.setLibro(l1, 0, 0);
			s1.setLibro(l2, 1, 0);
		} 
		catch (EccezionePosizioneNonValida e) 
		{
			System.out.println(e.toString());
		} 
		catch (EccezionePosizioneNonVuota e) 
		{
			System.out.println(e.toString());
		}
			
		
		
		try 
		{
			s1.rimuoviVolume(0, 10);
		} 
		catch (EccezionePosizioneVuota e) 
		{
			System.out.println(e.toString());
		} 
		catch (EccezionePosizioneNonValida e) 
		{
			System.out.println(e.toString());
		}
/*		
		String autore="Manzoni";
		String[] elencoTitoliAutore;
		
		elencoTitoliAutore=s1.elencoTitoli(autore);
		for (int i = 0; i < elencoTitoliAutore.length; i++) 
			System.out.println(elencoTitoliAutore[i]);
		
		elencoTitoliAutore[0]="I racconti di Pierone";
		
		System.out.println(s1.toString());
		
	//	System.out.println(s1.toString());
		
		//System.out.println(s1.setLibro(l2, 0, 90));
		
/*		System.out.println(s1.getLibro(0, 0));
		System.out.println(s1.getLibro(1, 0));
		System.out.println(s1.getLibro(-2, 0));
		System.out.println(s1.getLibro(2, -4));
*/		
/*		System.out.println(s1.rimuoviVolume(0, 0));
		System.out.println(s1.rimuoviVolume(0, 10));
		System.out.println(s1.rimuoviVolume(9, 10));
		System.out.println(s1.rimuoviVolume(0, 900));
*/ 
		
//-----------Test inserimento libro------------
		//Mensola m1=new Mensola();
	
		
	//	m1.setVolume(l1,0);
	//	m1.setVolume(l2,1);
	//	m1.setVolume(l3,2);
		

		
	
		
//-----------Test recupero libro------------	
	//	System.out.println(m1.getVolume(1).toString());
		
//-------------test numero volumi-------------
	//	System.out.println(m1.getNumVolumi());
		
//-------------test rimuoviVolume---------------
	//	m1.rimuoviVolume(0);
	//	System.out.println(m1.getNumVolumi());
		
	
	}
}
