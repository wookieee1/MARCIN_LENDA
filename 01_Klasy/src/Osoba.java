import java.util.Scanner;

public class Osoba {
	//zwykle zmienne skladowe klasy - kazdy obiekt ma swoj zestaw takich zmiennych
	private String imie;
	private String nazwisko;
	private int wiek;
	private double waga;
	//zmienna statyczna
	private static double wspolczynnikPremia = 0.5; //zmienna statyczna jest zmienna, ktora jest wspolna
	//dla calej klasy, dla wszystkich obiektow klasy
	//trzeba pamietac ze zmienna statyczna powstae w twojej klasie dlugo przed tym kiedy powstanie
	//jakikolwiek obiekt klasy
	
	//this - pozwala odroznic zmienne skladowe od zmiennych nieskladowych np przekazanych
	//przez argument
	//this to referencja do obiektu po lewej stronie kropki, do obiektu na rzec zktorego
	//wywolujesz metode
	public String getImie() {
		return this.imie;
	}
	public void setImie(String imie) {
		if (Character.isUpperCase(imie.charAt(0)) == true)
		{
			this.imie = imie;
		}
		else
		{
			System.out.println("Niepoprawne imie");
			this.imie = "Adam";
		}
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public int getWiek() {
		return wiek;
	}
	public void setWiek(int wiek) {
		this.wiek = wiek;
	}
	public double getWaga() {
		return waga;
	}
	public void setWaga(double waga) {
		this.waga = waga;
	} 
	
	//metoda statyczna to metoda ktora moze operowac TYLKO NA ZMIENNYCH STATYCZNYCH
	public static void setWspolczynnikPremia(double wspolczynnikPremia)
	{
		Osoba.wspolczynnikPremia = wspolczynnikPremia;
		//wiek = 10; //niedozwolone jest w metodzie statycznej uzywanie zmiennych niestatycznych
	}
	
	//konstruktor
	//konstruktor to metoda, jej zadaniem jest inicjalizowac wartosci poczatkowe pol twojej klasy
	//napiszemy konstruktor bezargumentowy
	public Osoba()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Podaj wiek");
		int wiek = Integer.parseInt(sc.nextLine());
		
		System.out.println("Podaj wage");
		double waga = Double.parseDouble(sc.nextLine());
		
		System.out.println("Podaj imie");
		String imie = sc.nextLine();
		
		System.out.println("Podaj nazwisko");
		String nazwisko = sc.nextLine();
		
		setImie(imie);
		setNazwisko(nazwisko);
		setWiek(wiek);
		setWaga(waga);
	}
	
	public Osoba(String imie, String nazwisko, int wiek, double waga)
	{
		setImie(imie);
		setNazwisko(nazwisko);
		setWiek(wiek);
		setWaga(waga);
	}
	
	public Osoba(Osoba kopia)
	{
		setImie(kopia.getImie());
		setNazwisko(kopia.getNazwisko());
		setWiek(kopia.getWiek());
		setWaga(kopia.getWaga());
	}
	
	
	@Override
	public String toString()
	{
		return getImie() + " " + getNazwisko() + " " + getWiek() + " " + getWaga() + " " + wspolczynnikPremia;
	}
	
	//hashCode przerabia obiekt twojej klasy na int
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imie == null) ? 0 : imie.hashCode());
		result = prime * result + ((nazwisko == null) ? 0 : nazwisko.hashCode());
		long temp;
		temp = Double.doubleToLongBits(waga);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + wiek;
		return result;
	}

	//metoda ktora sprawdza czy this jest takie samo jak o przekazane jako argument
	//metoda sluzy do porownywania obiektow naszej klasy element po elemencie
	@Override
	public boolean equals(Object obj) {
		//jezeli okaze sie ze this jest taki sam jak obj
		//to zadziala w przypadku o.equals(o)
		if (this == obj)
			return true;
		//jezeli obiekt ktory przekazesz jako argument jest null to porownanie tez nie ma sensu
		//od razuwiadomo ze nie sa rowne
		if (obj == null)
			return false;
		//moze byc sytuacja ze przyszedl do poronwnaia obiekt innej klasy
		//np ty masz Osoba a jako argument przyszed lRower to tez nie ma co porownywac
		if (getClass() != obj.getClass())
			return false;
		//do prownania wlasciwego czyli element po elemencie musisz zrobic rzutowanie
		//obj trzeba przerobic na Object
		Osoba other = (Osoba) obj;
		//teraz kiedy masz juz obiekt przerzutowany
		//najpierw sprawdz czy imie jest null
		//jezeli imie jest null to dwa obiekty sa takie same jezeli w drugim imie roniez jest null
		if (imie == null) {
			if (other.imie != null)
				return false;
		} else if (!imie.equals(other.imie))
			return false;
		
		if (nazwisko == null) {
			if (other.nazwisko != null)
				return false;
		} else if (!nazwisko.equals(other.nazwisko))
			return false;
		//doubleToLongBits pozwala zamienic liczbe double na jeden standardowym format liczbowy
		if (Double.doubleToLongBits(waga) != Double.doubleToLongBits(other.waga))
			return false;
		
		if (wiek != other.wiek)
			return false;
		//jezeli nci wczesniej sie nie popsulo dopiero teraz mozesz zwrocic true
		return true;
	}
	
	
	
}
