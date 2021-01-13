package laborator3;

import java.io.*;

public class Profesor extends Persoana {


    public Profesor() {
        this.nume = "";
        this.prenume = "";
    }

    public Profesor(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
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

    @Override
    public String toString() {
        return nume + "," + prenume;
    }

    public boolean isEqual(Profesor p) {
        return p.getNume().equals(nume) && p.getPrenume().equals(prenume);
    }

    public void ScrieCSV(String filepath) {
        try {
            File f = new File(filepath);
            BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
            try {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line = br.readLine();
                if (line == null)
                    bw.write("nume, prenume\r\n"); //se scrie antetul

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