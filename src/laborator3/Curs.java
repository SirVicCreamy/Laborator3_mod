package laborator3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Curs extends Thread implements OperatiiCurs {
    String nume;
    String descriere;
    Profesor profu;
    TreeSet<Student> studenti;
    int[] note;
    File StudentiFile, ProfesoriFile, CursuriFile;

    public Curs() {
        this.nume = "";
        this.descriere = "";
        this.profu = new Profesor();
        this.studenti = new TreeSet<Student>();
        this.note = new int[0];

        try {
            StudentiFile = new File("studenti.csv");
            ProfesoriFile = new File("profesori.csv");
            CursuriFile = new File("cursuri.csv");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public Curs(String nume, String descriere, Persoana profu, Persoana[] studenti) {
        this.nume = nume;
        this.descriere = descriere;
        this.profu = (Profesor) profu;
        this.studenti = new TreeSet<Student>(Arrays.asList((Student[]) studenti));
        this.note = new int[studenti.length];

        try {
            StudentiFile = new File("studenti.csv");
            ProfesoriFile = new File("profesori.csv");
            CursuriFile = new File("cursuri.csv");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public Curs(String nume, String descriere) {
        this.nume = nume;
        this.descriere = descriere;

        try {
            StudentiFile = new File("studenti.csv");
            ProfesoriFile = new File("profesori.csv");
            CursuriFile = new File("cursuri.csv");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void UpdateProfesor(Profesor profu) {
        this.profu = profu;
        profu.ScrieCSV(ProfesoriFile.toString());
    }

    public void UpdateCurs(String nume, String desc) {
        this.nume = nume;
        this.descriere = desc;
    }


    public void ScrieStudenti() {
        ArrayList<Student> listastudenti = new ArrayList<>();
        for (Student s : studenti)
            listastudenti.add(s);

        try {
            File f = new File(StudentiFile.toString());
            BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
            try {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line = br.readLine();
                if (line == null)
                    bw.write("nume, prenume, grupa\r\n"); //se scrie antetul
                bw.flush();
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                bw.close();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        Thread lista1 = new Thread() {
            public void run() {
                try {
                    for (int i = 0; i < listastudenti.size(); i = i + 2)
                        listastudenti.get(i).ScrieCSV(StudentiFile.toString());


                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        };
        Thread lista2 = new Thread() {
            public void run() {
                try {
                    for (int i = 1; i < listastudenti.size(); i = i + 2)
                        listastudenti.get(i).ScrieCSV(StudentiFile.toString());


                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        };
        lista1.setPriority(10);
        lista2.setPriority(10);
        lista1.start();
        lista2.start();

    }

    public void ScrieProf() {
        this.profu.ScrieCSV(ProfesoriFile.toString());
    }

    public void ScrieCSV(String filepath) {
        try {
            File f = new File(filepath);
            BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
            try {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line = br.readLine();
                if (line == null)
                    bw.write("nume, descriere\r\n"); //se scrie antetul

                bw.write(this.toString() + "\r\n");

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
        String str = nume + "," + descriere;
		/*for (Student s : studenti) {
			str += s + "\n";
		}*/
        return str;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Set<Student> getStudenti() {
        return studenti;
    }

    public void setStudenti(TreeSet<Student> studenti) {
        this.studenti = studenti;
    }

    public void noteazaStudent(Student studentNotat, int nota) {
        int i = 0;
        for (Student student : studenti) {
            if (student.getNume().equals(studentNotat.getNume()) && student.getPrenume().equals(studentNotat.getPrenume()))
                note[i] = nota;
            i++;
        }
    }

    public void raportStudentiInscrisi() {
        for (Student student : studenti) {
            System.out.println(student);
        }
    }

    public void raportNoteStudenti() {
        int i = 0;
        for (Student student : studenti) {
            System.out.println(student + " are nota " + note[i++]);
        }

    }


    public void raportMediaStudentilor() {

        Thread medie1 = new Thread() {
            public void run() {

                int sum1 = 0;
                for (int i = 0; i < studenti.size() / 2; i++)
                    sum1 += note[i];
                try {
                    System.out.println("Media primei jumatati de studenti pentru cursul: " + nume + " este: " + 2 * sum1 / (double) studenti.size());
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        };
        Thread medie2 = new Thread() {
            public void run() {
                int sum2 = 0;
                for (int i = studenti.size() / 2; i < studenti.size(); i++)
                    sum2 += note[i];
                try {
                    System.out.println("Media din a doua jumatate de studenti pentru cursul: " + nume + " este: " + 2 * sum2 / (double) studenti.size());
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        };
        medie1.setPriority(9);
        medie2.setPriority(9);
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

