package laborator3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;




public class ManagerCursuri implements OperatiiManagerCursuri{
	List<Curs> cursuri;

	public ManagerCursuri() {
		cursuri = new ArrayList<Curs>();
	}


	public void AddCurs(Curs curs) {

		cursuri.add(curs);

	}
	
	public void DeleteCurs(Curs curs) {

		cursuri.remove(curs);

			}

	@Override
	public void SortByNume() {
		ComparaNume compNume = new ComparaNume();
		Collections.sort(cursuri, compNume);
	}

	@Override
	public void SortByNume_Prof() {
		ComparaNume_Prof compNume_Prof = new ComparaNume_Prof();
		Collections.sort(cursuri, compNume_Prof);
	}

	@Override
	public void SortByNr_Studenti() {
		ComparaNr_Studenti compNr_Studenti = new ComparaNr_Studenti();
		Collections.sort(cursuri, compNr_Studenti);
	}


	public void UpdateCurs(Curs curs) {
		for(int i = 0; i < cursuri.size();i++)
		{
			Curs c=cursuri.get(i);
			if ( c.nume.equals(curs.nume))
				cursuri.set(i,curs);

		}
	}

	public void AfiseazaCursuriLaConsola() {
		for (Curs c : cursuri)
			System.out.println(c);
	}
	
	public void RaportStudentiInscrisiLaCurs(String numeCurs) {
		for (Curs c : cursuri) {
			if (c.getNume().equals(numeCurs)) {
				c.raportStudentiInscrisi();
				return;
			}
		}	
	}
	
	public void NoteazaStudent(String numeCurs, Student studentNotat, int nota) {
		for(Curs c: cursuri) {
			if ( c.getNume().equals(numeCurs)) {
				c.noteazaStudent(studentNotat, nota);
			}

		}
	}
	
	public void RaportNoteTotiStudentii() {
		for (Curs c : cursuri ) {
			c.raportNoteStudenti();
		}
	}
	
	public void mediaNotelorDateDeProfesor(Profesor prof) {
		System.out.println("Media notelor date de profesorul " + prof + ":");
		for ( Curs c: cursuri) {
			if ( c.getProfu().isEqual(prof)) {
				c.raportMediaStudentilor();
			}
		}		
	}

	class ComparaNume implements Comparator<Curs>
	{
		@Override
		public int compare(Curs o1, Curs o2) {
			return(o1.nume.compareTo(o2.nume));
		}
	}

	class ComparaNume_Prof implements Comparator<Curs>
	{
		@Override
		public int compare(Curs o1, Curs o2) {
			return (o1.profu.nume.compareTo(o2.profu.nume));
		}
	}

	class ComparaNr_Studenti implements Comparator<Curs>
	{
		@Override
		public int compare(Curs o1, Curs o2) {
			return (o1.studenti.size()-o2.studenti.size());
		}
	}




}