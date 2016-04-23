
public class Main {

	public static void wypelnijTablice(Osoba[] tab)
	{
		for (int i = 0; i < tab.length; i++) {
			tab[i] = new Osoba(); //kazdy element tablicy MUSI zostac zainicjalziowany
		}
	}
	public static void pokazOsoby(Osoba[] tab)
	{
		
		/*for (int i = 0; i < tab.length; i++)
		{
			//tab[i] to obiekt klasy osoba
			System.out.println(tab[i].getImie());
		}*/
		
		//petla foreach przeglada kolejne elemeny tablicy i kazdy element w kolejnym obiegu
		//jest podstawiony do o, ta petle stosuj raczej do odczytu, nie pzydzielja nowej instancji
		//obiektom w tej petli
		for (Osoba o : tab)
		{
			//o = new Osoba(); //lepiej tak nie rob
			System.out.println(o);
		}
	}
	public static void main(String[] args) {
		//Osoba o = new Osoba();
		Osoba o = new Osoba("Adam", "Nowak", 22, 34.4);
		Osoba o2 = new Osoba("Adam", "Nowak", 22, 34.4);
		/*System.out.println(o.getImie());
		o.setImie("adam");
		System.out.println(o.getImie());*/
		
		System.out.println(o);
		
		//to jest porownnaie adresow obiekto o i o2
		//to na pewno nie porowna zawartosci tych obiektow
		/*if (o == o2)
		{
			System.out.println("ROWNE");
		}*/
		
		//tworzenie tablicy obiektow
		//Osoba[] tablicaOsob = new Osoba[2];
		//wypelnijTablice(tablicaOsob);
		//pokazOsoby(tablicaOsob);
		
		
		//zmienne statyczne
		Osoba adam = new Osoba("Adam", "Nowak", 33, 12);
		Osoba ewa = new Osoba("Ewa", "Malpa", 23, 42);
		//Osoba.wspolczynnikPremia = 0.4; 
		Osoba.setWspolczynnikPremia(0.5);
		System.out.println(adam);
		System.out.println(ewa);
		
		//komentarz
		Osoba oGit = new Osoba();
		System.out.println(oGit);
	}

}
