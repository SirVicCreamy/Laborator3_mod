package laborator3;

import java.util.Arrays;

public class Curs implements OperatiiCurs {
	String nume;
	String descriere;
	Profesor profu;
	Student[] studenti;
	int[] note;

	public Curs()
	{
		this.nume="";
		this.descriere="";
		this.profu=new Profesor();
		this.studenti=new Student[0];
		this.note=new int[0];
	}

	public Curs(String nume, String descriere, Persoana profu, Persoana[] studenti) {
		this.nume = nume;
		this.descriere = descriere;
		this.profu = (Profesor) profu;
		this.studenti = (Student[]) studenti;
		this.note = new int[studenti.length];
	}

	public void UpdateProfesor(Profesor profu) {
		this.profu = profu;
	}

	public void UpdateCurs(String nume, String desc) {this.nume=nume;  this.descriere=desc;   }

	public void AddStudent(Student student) {
		//lucrand cu array trebuie inserat folosind un sir auxiliar
		int noualungime = studenti.length + 1;
		Student[] aux = new Student[noualungime];
		int index = 0;
		for (Student s : studenti) {
			aux[index++] = s;
		}
		//la final adaugam noul student pe ultimul index
		aux[index] = student;
		//si realocam lista de studenti cu aux;
		this.studenti = new Student[noualungime];
		System.arraycopy(aux, 0, studenti, 0, noualungime);
	}

	public void RemoveStudent(Student student) {

		int noualungime = studenti.length - 1;
		Student[] aux = new Student[noualungime];
		int index = 0;
		for (Student s : studenti)
			if (student != s)
				aux[index++] = s;

		this.studenti = new Student[noualungime];
		System.arraycopy(aux, 0, studenti, 0,
				noualungime);
	}

	public void UpdateStudent(Student student) {

		for (Student s : studenti)
			if (s.nume.equals(student.nume) && s.prenume.equals(student.prenume))
				s = student;

	}

	@Override
	public String toString() {
		String str = "Curs: " + "nume=" + nume + ", descriere=" + descriere + ",\nprofu=" + profu + ",\nstudenti:\n";
		for (Student s : studenti) {
			str += s + "\n";
		}
		return str;
	}

	public String getNume() {
		return nume;
	}

	public Student[] getStudenti() {
		return studenti;
	}

	public void setStudenti(Student[] studenti) {
		this.studenti = studenti;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public void noteazaStudent(Student studentNotat, int nota) {
		for ( int i = 0; i < studenti.length; i++) {
			Student student = studenti[i];
			if ( student.getNume().equals(studentNotat.getNume()) && student.getPrenume().equals(studentNotat.getPrenume())) {
				note[i] = nota;
			}
		}		
	}
	
	public void raportStudentiInscrisi() {
		for ( int i = 0; i < studenti.length; i++) {
			System.out.println(studenti[i]);
		}
	}

	public void raportNoteStudenti() {
		for ( int i = 0; i < studenti.length; i++) {
			System.out.println(studenti[i] + " are nota " + note[i]);
		}
	}
	
	public void raportMediaStudentilor() {
		int sum = Arrays.stream(note).sum();
		System.out.println("Media studentilor pentru cursul: " + nume + " este: " + sum/(double)note.length);
	}

	public Profesor getProfu() {
		return profu;
	}
	
	public boolean isEqual(Curs c) {
		return c.getNume().equals(nume);
	}
	
}