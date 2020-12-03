package laborator3;

public class Profesor extends Persoana{


	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}


	@Override
	public String toString() {
		return "Profesor{" + "nume=" + nume + ", prenume=" + prenume + '}';
	}

	public Profesor()
	{
		this.nume="";
		this.prenume="";
	}

	public Profesor(String nume, String prenume) {
		this.nume = nume;
		this.prenume = prenume;
	}
	
	public boolean isEqual(Profesor p) {
		return p.getNume().equals(nume) && p.getPrenume().equals(prenume);
	}
}