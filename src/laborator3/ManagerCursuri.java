package laborator3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class ManagerCursuri implements OperatiiManagerCursuri {
    ArrayList<Curs> cursuri;
    ArrayList<Profesor> profesori;
    ArrayList<Student> studenti;
    File StudentiFile, ProfesoriFile, CursuriFile;

    public ManagerCursuri() {
        cursuri = new ArrayList<Curs>(0);
        profesori = new ArrayList<Profesor>(0);
        studenti = new ArrayList<Student>(0);
        try {
            StudentiFile = new File("studenti.csv");
            ProfesoriFile = new File("profesori.csv");
            CursuriFile = new File("cursuri.csv");
        } catch (Exception ex) {
            System.out.println(ex);
        }
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
        for (int i = 0; i < cursuri.size(); i++) {
            Curs c = cursuri.get(i);
            if (c.nume.equals(curs.nume))
                cursuri.set(i, curs);

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
        for (Curs c : cursuri) {
            if (c.getNume().equals(numeCurs)) {
                c.noteazaStudent(studentNotat, nota);
            }

        }
    }

    public void RaportNoteTotiStudentii() {
        for (Curs c : cursuri) {
            c.raportNoteStudenti();
        }
    }

    public void mediaNotelorDateDeProfesor(Profesor prof) {
        System.out.println("Media notelor date de profesorul " + prof + ":");
        for (Curs c : cursuri) {
            if (c.getProfu().isEqual(prof)) {
                c.raportMediaStudentilor();
            }
        }
    }

    public void ScrieCursuri() {
        for (Curs c : cursuri)
            c.ScrieCSV(CursuriFile.toString());
    }

    public void CitesteCursuri() {
        try {

            BufferedReader br = new BufferedReader(new FileReader(CursuriFile));
            String line = br.readLine();
            //ignor prima linie (antetul)
            if (line != null) {
                line = br.readLine();
            }
            while (line != null) {
                String[] splituri = line.split(",");

                Curs c = new Curs(splituri[0], splituri[1].trim());
                cursuri.add(c);
                line = br.readLine();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void CitesteStudenti() {
        try {

            BufferedReader br = new BufferedReader(new FileReader(StudentiFile));
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

    public void CitesteProfi() {
        try {

            BufferedReader br = new BufferedReader(new FileReader(ProfesoriFile));
            String line = br.readLine();
            //ignor prima linie (antetul)
            if (line != null) {
                line = br.readLine();
            }
            while (line != null) {
                String[] splituri = line.split(",");

                Profesor p = new Profesor(splituri[0], splituri[1].trim());
                profesori.add(p);
                line = br.readLine();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }


    public void ScrieFisiere() {
        ScrieCursuri();
        for (Curs c : cursuri) {
            c.ScrieStudenti();
            c.ScrieProf();
        }
    }

    public void CitesteFisiere() {
        cursuri.clear();
        studenti.clear();
        profesori.clear();
        CitesteCursuri();
        CitesteProfi();
        CitesteStudenti();
    }

    class ComparaNume implements Comparator<Curs> {
        @Override
        public int compare(Curs o1, Curs o2) {
            return (o1.nume.compareTo(o2.nume));
        }
    }

    class ComparaNume_Prof implements Comparator<Curs> {
        @Override
        public int compare(Curs o1, Curs o2) {
            return (o1.profu.nume.compareTo(o2.profu.nume));
        }
    }

    class ComparaNr_Studenti implements Comparator<Curs> {
        @Override
        public int compare(Curs o1, Curs o2) {
            return (o1.studenti.size() - o2.studenti.size());
        }
    }


}