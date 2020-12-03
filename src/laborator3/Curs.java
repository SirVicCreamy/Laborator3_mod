package laborator3;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Curs implements OperatiiCurs {
	String nume;
	String descriere;
	Profesor profu;
	Set<Student> studenti;
	int[] note;

	public Curs()
	{
		this.nume="";
		this.descriere="";
		this.profu=new Profesor();
		this.studenti=new HashSet<Student>();
		this.note=new int[0];
	}

	public Curs(String nume, String descriere, Persoana profu, Persoana[] studenti) {
		this.nume = nume;
		this.descriere = descriere;
		this.profu = (Profesor) profu;
		this.studenti = new HashSet<Student>(Arrays.asList((Student[])studenti));
		this.note = new int[studenti.length];
	}

	public void UpdateProfesor(Profesor profu) {
		this.profu = profu;
	}

	public void UpdateCurs(String nume, String desc) {this.nume=nume;  this.descriere=desc;   }

	public void AddStudent(Student student) {
		this.studenti.add(student);
	}

	public void RemoveStudent(Student student) {
		this.studenti.remove(student);
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

	public Set<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(Set<Student> studenti) {
		this.studenti = studenti;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public void noteazaStudent(Student studentNotat, int nota) {
		int i=0;
		for(Student student:studenti)
			if (student.getNume().equals(studentNotat.getNume()) && student.getPrenume().equals(studentNotat.getPrenume())) {
				note[i++] = nota;
			}
	}

	public void raportStudentiInscrisi() {
		for(Student student:studenti) {
			System.out.println(student);
		}
	}

	public void raportNoteStudenti() {
		int i=0;
		for(Student student: studenti) {
			System.out.println(student+ " are nota " + note[i++]);
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