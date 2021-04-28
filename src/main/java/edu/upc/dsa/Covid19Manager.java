package edu.upc.dsa;

import edu.upc.dsa.models.Brote;
import edu.upc.dsa.models.Caso;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface Covid19Manager {
    public void addBrote(String idBrote);
    public Brote getBrote(String idBrote);
    public Brote addBrote(Brote brote);
    //public Brote addbrote(Brote b);
    public Collection<Brote> brotesDisp();
    public Caso addCaso (Caso o);
    public Caso addCaso(String nombre, String apellidos, String idCaso, Date fechaNacimiento, Date fechaInforme, String clasificación, String genero, String correo, String telefono, String direccion );
    public List<Caso> ordersByClasificacion (String idBrote);
    public int sizeBrotes();
    public int sizeCasos();

}
