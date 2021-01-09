package laborator3;

import java.io.*;

public interface OperatiiCurs {
    public void UpdateProfesor(Profesor p);
    public void AddStudent(Student student);
    public void RemoveStudent(Student student);
    public void UpdateStudent(Student student);
    public void UpdateCurs(String nume, String descriere);
    public void CitesteCSVStudenti(String filepath);
    public void ScrieStudenti();
    public void ScrieProf();

}


