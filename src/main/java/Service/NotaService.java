package Service;

import Model.Nota;

import java.util.LinkedList;

public interface NotaService {
    void createNota(String titulo, String text, int ownerId, String creationDate);
    LinkedList<Nota> getNotas(int idOwner);
}
