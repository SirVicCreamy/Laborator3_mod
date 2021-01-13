package laborator3;

import java.io.*;

public class Student extends Persoana implements Comparable<Student> {

    int grupa;

    public Student() {
        this.nume = "";
        this.prenume = "";
        this.grupa = 0;

    }

    public Student(String nume, String prenume, int grupa) {
        this.nume = nume;
        this.prenume = prenume;
        this.grupa = grupa;
    }

    @Override
    public String toString() {
        return nume + "," + prenume + "," + grupa;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getGrupa() {
        return grupa;
    }

    public void setGrupa(int grupa) {
        this.grupa = grupa;
    }

    @Override
    public int compareTo(Student o) {
        return this.grupa - o.grupa;
    }

    public void ScrieCSV(String filepath) {

        try {
            File f = new File(filepath);
            BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
            try {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line = br.readLine();
                if (line == null)
                    bw.write("nume, prenume, grupa\r\n"); //se scrie antetul

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


}


