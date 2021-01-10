package laborator3;

import java.io.*;
import java.util.*;

public class Curs extends Thread implements OperatiiCurs {
	String nume;
	String descriere;
	Profesor profu;
	TreeSet<Student> studenti;
	int[] note;
	File StudentiFile, ProfesoriFile;

	public Curs()
	{
		this.nume="";
		this.descriere="";
		this.profu=new Profesor();
		this.studenti=new TreeSet<Student>();
		this.note=new int[0];

		try {
			StudentiFile = new File("studenti.csv");
			ProfesoriFile = new File("profesori.csv");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public Curs(String nume, String descriere, Persoana profu, Persoana[] studenti) {
		this.nume = nume;
		this.descriere = descriere;
		this.profu = (Profesor) profu;
		this.studenti = new TreeSet<Student>(Arrays.asList((Student[])studenti));
		this.note = new int[studenti.length];

		try {
			StudentiFile = new File("studenti.csv");
			ProfesoriFile = new File("profesori.csv");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void UpdateProfesor(Profesor profu) {
		this.profu = profu;
		profu.ScrieCSV(ProfesoriFile.toString());
	}

	public void UpdateCurs(String nume, String desc) {this.nume=nume;  this.descriere=desc;   }




	public void ScrieStudenti() {
		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter(StudentiFile,true));
			try {
				BufferedReader br = new BufferedReader(new FileReader(StudentiFile));
				String line = br.readLine();
				if(line==null)
					bw.write("nume, prenume, grupa\r\n"); //se scrie antetul
				for(Student s : this.studenti)
					bw.write(s.toString() + "\r\n");
				bw.flush();
			} catch (IOException e) {
				System.out.println(e);
			} finally {
				bw.close();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void ScrieProf() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(ProfesoriFile,true));
			try {
				BufferedReader br = new BufferedReader(new FileReader(ProfesoriFile));
				String line = br.readLine();
				if(line==null)
					bw.write("nume, prenume\r\n"); //se scrie antetul

				bw.write(this.profu.toString()+"\r\n");
				bw.flush();
			} catch (IOException e) {
				System.out.println(e);
			} finally {
				bw.close();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}


	public void CitesteCSVStudenti(String filepath) {
		try {
			File f = new File(filepath);
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = br.readLine();
			//ignor prima linie (antetul)
			if (line != null) {
				line = br.readLine();
			}
			while (line != null) {
				String[] splituri = line.split(",");

				Student s = new Student(splituri[0], splituri[1].trim(), Integer.parseInt(splituri[2].trim()));
				studenti.add(s);
				line = br.readLine();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void AddStudent(Student student) {
		this.studenti.add(student);
		student.ScrieCSV(StudentiFile.toString());
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
		String str = nume+", "+descriere+"\n";
		/*for (Student s : studenti) {
			str += s + "\n";
		}*/
		return str;
	}

	public String getNume() {
		return nume;
	}

	public Set<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(TreeSet<Student> studenti) {
		this.studenti = studenti;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public void noteazaStudent(Student studentNotat, int nota) {
		int i=0;
		for(Student student:studenti)
		{
			if (student.getNume().equals(studentNotat.getNume()) && student.getPrenume().equals(studentNotat.getPrenume()))
				note[i] = nota;
				i++;
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

		Thread medie1 = new Thread () {
			public void run () {

					int sum1 = 0;
					for (int i = 0; i < studenti.size() / 2; i++)
						sum1 += note[i];
				try {System.out.println("Media primei jumatati de studenti pentru cursul: " + nume + " este: " + 2 * sum1 / (double) studenti.size());}
				catch(Exception e) { System.out.println(e);}
				}
		};
		Thread medie2 = new Thread () {
			public void run () {
				int sum2=0;
				for(int i= studenti.size()/2;i<studenti.size();i++)
					sum2+=note[i];
				try{System.out.println("Media din a doua jumatate de studenti pentru cursul: " + nume + " este: " + 2*sum2/(double)studenti.size());}
				catch(Exception e) { System.out.println(e);}
			}
		};
		medie1.start();
		medie2.start();
	}

	public Profesor getProfu() {
		return profu;
	}

	public boolean isEqual(Curs c) {
		return c.getNume().equals(nume);
	}




}