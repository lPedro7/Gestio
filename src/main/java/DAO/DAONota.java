package DAO;

import Model.Nota;

import java.util.LinkedList;

public interface DAONota {
    void createNota(String titulo, String text, int OwnerId, String creationDate);
    LinkedList<Nota> getNotas(int ownerId);
}
