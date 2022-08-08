package gestores;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import util.Ficheiro;

public class GestaoLocal {
    private static final GestaoLocal INSTACIA = new GestaoLocal();
    private final Ficheiro FICHEIRO_INS = Ficheiro.getINSTACIA();
    
    Map<String, ArrayList<String>> locaisLidos = null;
    ArrayList<String> locais = new ArrayList<>();

    public GestaoLocal() {
        locaisLidos = new TreeMap<>();
        lerLocais();
    }
    
    public static GestaoLocal getINSTACIA() {
        return INSTACIA;
    }
    
    public void lerLocais(){
        locaisLidos = FICHEIRO_INS.lerLocais();
        
        locais.add(constantes.Constantes.SELECIONE_UM_DISTRITO);
        for(String key : locaisLidos.keySet()){
            locais.add(key);
        }
        locais.sort(Comparator.naturalOrder());
    }
    
    public ArrayList<String> getDistritos(){
        if(locais == null){
            lerLocais();
        }
        return locais;
    }
    
    public ArrayList<String> getConcelhos(String distrito){
        if(distrito == null) return new ArrayList<>();

        if(locais == null){
            lerLocais();
        }

        ArrayList<String> concelhos = new ArrayList<>(locaisLidos.get(distrito));
        concelhos.add(constantes.Constantes.SELECIONE_UM_CONCELHO);
        concelhos.sort(Comparator.naturalOrder());

        return concelhos;
    }
    
}
