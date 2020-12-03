package laborator3;

import java.util.List;

public interface OperatiiManagerCursuri {
    public void AddCurs(Curs curs);
    public void UpdateCurs(Curs curs);
    public void DeleteCurs(Curs curs);
    public void SortByNume(List<Curs> cursuri);
    public void SortByNume_Prof(List<Curs> cursuri);
    public void SortByNr_Studenti(List<Curs> cursuri);
}
