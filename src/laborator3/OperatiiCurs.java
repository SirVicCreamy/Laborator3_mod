package laborator3;

public interface OperatiiCurs {
    void UpdateProfesor(Profesor p);

    void AddStudent(Student student);

    void RemoveStudent(Student student);

    void UpdateStudent(Student student);

    void UpdateCurs(String nume, String descriere);

    void CitesteCSVStudenti(String filepath);

    void ScrieStudenti();

    void ScrieProf();

}


