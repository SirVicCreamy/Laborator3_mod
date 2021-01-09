package laborator3;


import java.io.File;

public class Main {


    public static void main(String[] args) {

        //new ManagerGUI();

        //definire studenti
        Student[] studenti = new Student[]{new Student("Negoita","Andrei",3333),new Student("Mateescu","Ion",2222)};
        Student[] studenti2 = new Student[]{new Student("George","Mihai",2231)};
        Student[] studenti3 = new Student[]{new Student("Bratu","Bogdan",2222),new Student("Iordache","Tiberiu",1111),
                new Student("Savu","Vlad",5555),new Student("Panait","Alexandra",3333)};
        Student[] studenti4 = new Student[]{new Student("Andone","Nicolae",2231),new Student("Ionescu","Octavian",4221)};

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
   /*
        System.out.print("-----------------------PRE SORT---------------------\n");
        cursuri.AfiseazaCursuriLaConsola();
        cursuri.NoteazaStudent(curs.getNume(), studenti[0], 10);
        cursuri.NoteazaStudent(curs.getNume(), studenti[1], 9);

        cursuri.RaportStudentiInscrisiLaCurs(curs.getNume());
        cursuri.RaportNoteTotiStudentii();
        curs.raportMediaStudentilor();

        cursuri.mediaNotelorDateDeProfesor(prof);

        System.out.print("-----------------------SORT NUME---------------------\n");
        cursuri.SortByNume();
        cursuri.AfiseazaCursuriLaConsola();


        System.out.print("-----------------------SORT PROF---------------------\n");
        cursuri.SortByNume_Prof();
        cursuri.AfiseazaCursuriLaConsola();


        System.out.print("-----------------------SORT NR STUD---------------------\n");
        cursuri.SortByNr_Studenti();
        cursuri.AfiseazaCursuriLaConsola();
*/

        System.out.print("-----------------------MULTITHREAD---------------------\n");
      for(int i=0;i<studenti3.length;i++)
           curs3.noteazaStudent(studenti3[i],i+5);
        curs3.raportNoteStudenti();
        curs3.raportMediaStudentilor();

    }


}
