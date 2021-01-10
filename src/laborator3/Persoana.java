package laborator3;

public abstract class Persoana {
    String nume;
    String prenume;

    @Override
    public String toString() {
        return nume + ", " + prenume;
    }
}
