package laborator3;

public class Main {

    public static void main(String[] args) {
        //definire studenti
        Student[] studenti = new Student[]{new Student("Andrei","Negoita",3333),new Student("Ion","Mateescu",2222)};
        Student[] studenti2 = new Student[]{new Student("Mihai","George",2231)};
        Student[] studenti3 = new Student[]{new Student("Bogdan","Bratu",3333),new Student("Tiberiu","Iordache",1111),new Student("Vlad","Savu",2222)};
        Student[] studenti4 = new Student[]{new Student("Andrei","Negoita",2231),new Student("Ion","Mateescu",4221)};

        //definire profesor
        Profesor prof = new Profesor("Aanton","Panaitescu");
        Profesor prof2 = new Profesor("Banton","Panaitescu");
        Profesor prof3 = new Profesor("Canton","Panaitescu");
        Profesor prof4 = new Profesor("Danton","Panaitescu");
        //definire curs nou
        Curs curs = new Curs("Rezistenta Materialelor", "Desc 1.....", prof, studenti);
        Curs curs2 = new Curs("Analiza matematica", "Desc 2.....", prof2, studenti2);
        Curs curs3 = new Curs("Engleza", "Desc 3.....", prof3, studenti3);
        Curs curs4 = new Curs("Dispozitive electrice", "Desc 4.....", prof4, studenti4);
        //adaugare curs in lista de cursuri
        ManagerCursuri cursuri = new ManagerCursuri();
        cursuri.AddCurs(curs3);
        cursuri.AddCurs(curs);
        cursuri.AddCurs(curs4);
        cursuri.AddCurs(curs2);
        System.out.print("-----------------------PRE SORT---------------------\n");
        cursuri.AfiseazaCursuriLaConsola();
        /*cursuri.NoteazaStudent(curs.getNume(), studenti[0], 10);
        cursuri.NoteazaStudent(curs.getNume(), studenti[1], 9);

        cursuri.RaportStudentiInscrisiLaCurs(curs.getNume());
        cursuri.RaportNoteTotiStudentii();
        curs.raportMediaStudentilor();

        cursuri.mediaNotelorDateDeProfesor(prof);
        */
        System.out.print("-----------------------SORT NUME---------------------\n");
        cursuri.SortByNume();
        cursuri.AfiseazaCursuriLaConsola();


        System.out.print("-----------------------SORT PROF---------------------\n");
        cursuri.SortByNume_Prof();
        cursuri.AfiseazaCursuriLaConsola();


        System.out.print("-----------------------SORT NR STUD---------------------\n");
        cursuri.SortByNr_Studenti();
        cursuri.AfiseazaCursuriLaConsola();






    }
}
