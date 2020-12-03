package laborator3;

public class Main {

    public static void main(String[] args) {
        //definire studenti
        Student[] studenti = new Student[]{new Student("Andrei","Negoita",2231),new Student("Ion","Mateescu",4221)};
        //definire profesor
        Profesor prof = new Profesor("Aanton","Panaitescu");
        Profesor prof2 = new Profesor("Banton","Panaitescu");
        Profesor prof3 = new Profesor("Canton","Panaitescu");
        Profesor prof4 = new Profesor("Danton","Panaitescu");
        //definire curs nou
        Curs curs = new Curs("Rezistenta Materialelor", "Desc Rezistenta materialelor.....", prof, studenti);
        Curs curs2 = new Curs("Rezistenta Materialelor", "Desc Rezistenta materialelor.....", prof2, studenti);
        Curs curs3 = new Curs("Rezistenta Materialelor", "Desc Rezistenta materialelor.....", prof3, studenti);
        Curs curs4 = new Curs("Rezistenta Materialelor", "Desc Rezistenta materialelor.....", prof4, studenti);
        //adaugare curs in lista de cursuri
        ManagerCursuri cursuri = new ManagerCursuri();
        cursuri.AddCurs(curs3);
        cursuri.AddCurs(curs);
        cursuri.AddCurs(curs4);
        cursuri.AddCurs(curs2);
       cursuri.AfiseazaCursuriLaConsola();
        /*cursuri.NoteazaStudent(curs.getNume(), studenti[0], 10);
        cursuri.NoteazaStudent(curs.getNume(), studenti[1], 9);

        cursuri.RaportStudentiInscrisiLaCurs(curs.getNume());
        cursuri.RaportNoteTotiStudentii();
        curs.raportMediaStudentilor();

        cursuri.mediaNotelorDateDeProfesor(prof);
*/      System.out.print("-----------------------SORT---------------------\n");
        cursuri.SortByNume_Prof();
        cursuri.AfiseazaCursuriLaConsola();


    }
}
