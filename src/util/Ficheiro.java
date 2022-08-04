package util;

import dtos.GrupoDTO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Ficheiro{
    private static final Ficheiro INSTACIA = new Ficheiro();
    
    private static final String separador = ";";
    private static final String nomeFicheiroGrupos = "GRUPOS";
    private static final String nomeFicheiroAcoes = "REGISTO_ACOES";
    
    public static Ficheiro getINSTACIA() {
        return INSTACIA;
    }
   
    public boolean exportarGrupoDTOFicheiroTXT(ArrayList<GrupoDTO> grupos){
        try {
            FileWriter writer = new FileWriter(nomeFicheiroGrupos + ".txt");

            for(GrupoDTO g : grupos){
                writer.write(g.getPosicao() + separador +
                            g.getNome() + separador +
                            g.getLocalizacao() + separador +
                            g.getDistrito()+ separador +
                            g.getConcelho()+ separador +
                            g.getEmail()+ separador +
                            g.getContacto()+ separador +
                            g.getnTocadores() + separador +
                            g.getnAcompanhantes() + separador +
                            g.getHoraPrevista() + separador +
                            g.isEspecial()+ separador +
                            g.isTocar() + System.lineSeparator());
            }
            
            writer.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
    
    public ArrayList<GrupoDTO> importarGrupoDTOFicheiroTXT(){
        ArrayList<GrupoDTO> grupos = new ArrayList<>();
        
        try {
            FileReader reader = new FileReader(nomeFicheiroGrupos + ".txt");
            BufferedReader br = new BufferedReader(reader);

            String line;
            String[] lineArray;
            GrupoDTO grupoDTO;
            while ((line = br.readLine()) != null) {
                try{
                    lineArray = line.split(separador);
                    grupoDTO = new GrupoDTO(Integer.parseInt(lineArray[0]), lineArray[1], lineArray[2], lineArray[3], 
                            lineArray[4], lineArray[5], lineArray[6], Integer.parseInt(lineArray[7]), 
                            Integer.parseInt(lineArray[8]), lineArray[9], 
                            (lineArray[10].compareTo("true") == 0), (lineArray[11].compareTo("sim") == 0));
                    grupos.add(grupoDTO);
                } catch(Exception e){  
                }
            }
            return grupos;
        } catch (IOException e) {
            return null;
        }
    }
    
    public boolean escreverRegistoAcoesFicheiroTXT(String ocurrencia){
        try {
            FileWriter writer = new FileWriter(nomeFicheiroAcoes + ".txt", true);
            
            writer.write(new Date() + " --> " + ocurrencia + System.lineSeparator());
            
            writer.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
    
    public HashMap<String, ArrayList<String>> lerLocais(){
        HashMap<String, ArrayList<String>> locais = new HashMap<>();
        
        try {
            FileReader reader = new FileReader("LOCAIS.csv");
            BufferedReader br = new BufferedReader(reader);

            String line;
            String[] lineArray;
            while ((line = br.readLine()) != null) {
                lineArray = line.split(";");
                if(locais.containsKey(lineArray[0])){
                    locais.get(lineArray[0]).add(lineArray[1]);
                }else{
                ArrayList<String> a = new ArrayList<>();
                a.add(lineArray[1]);
                locais.put(lineArray[0], a);}
            }
            return locais;
        } catch (IOException e) {
        }
        return null;
    }
}
