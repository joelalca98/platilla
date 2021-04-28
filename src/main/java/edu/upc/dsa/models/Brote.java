package edu.upc.dsa.models;
import edu.upc.dsa.util.RandomUtils;
import java.util.LinkedList;
import java.util.List;

public class Brote {
    private  String idBrote; /** Solo tiene estos dos atributos, id y una lista de casos*/
    List<Caso> casosList;

    public String getIdBrote(){
        return idBrote;
    }
    public Brote(){
        this.idBrote = RandomUtils.getId();
    }
    public Brote(String idBrote) { /** Constructor*/
        this();
        this.idBrote = idBrote;
        this.casosList = new LinkedList<Caso>();
    }
    public void addCaso(Caso caso){ /**Añadimos casos al brote */
        this.casosList.add(caso);
    }

    public List<Caso> getCasosList() { /** Devolver Uns lista de casos */
        return casosList;
    }

    @Override
    public String toString() {
        return "Track [id="+idBrote+"]";
    }

}
