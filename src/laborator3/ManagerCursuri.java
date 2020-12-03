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
	public void SortByNume(List<Curs> cursuri) {


	}

	@Override
	public void SortByNume_Prof(List<Curs> cursuri) {

	}

	@Override
	public void SortByNr_Studenti(List<Curs> cursuri) {

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







}