package util;

import modelos.Grupo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
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
   
    public boolean exportarGrupoFicheiroTXT(ArrayList<Grupo> grupos){
        try {
            FileWriter writer = new FileWriter(nomeFicheiroGrupos + ".txt");

            for(Grupo g : grupos) {
                String concelho = g.getConcelho();

                writer.write(
                        g.getPosicao() + separador +
                        g.getNome() + separador +
                        g.getLocalizacao() + separador +
                        g.getDistrito()+ separador +
                        (concelho == null ? "" : concelho) + separador +
                        g.getEmail()+ separador +
                        g.getContacto()+ separador +
                        g.getnTocadores() + separador +
                        g.getnAcompanhantes() + separador +
                        g.getDataHoraPrevistaString() + separador +
                        g.isTocar() + System.lineSeparator()
                );
            }
            
            writer.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
    
    public ArrayList<Grupo> importarGruposFicheiroTXT(){
        ArrayList<Grupo> grupos = new ArrayList<>();


        try {
            FileReader reader = new FileReader(nomeFicheiroGrupos + ".txt");
            BufferedReader br = new BufferedReader(reader);

            String line;
            String[] lineArray;
            Grupo grupo;

            while ((line = br.readLine()) != null) {
                try{
                    lineArray = line.split(separador);

                    Calendar data = Calendar.getInstance();
                    String[] dataHora = lineArray[9].split(" ");
                    String[] datas = dataHora[0].split("/");
                    String[] horas = dataHora[1].split(":");

                    data.set(Integer.parseInt(datas[0]), Integer.parseInt(datas[1]), Integer.parseInt(datas[2]),
                            Integer.parseInt(horas[0]), Integer.parseInt(horas[1]));

                    String concelho = lineArray[4];

                    grupo = new Grupo(Integer.parseInt(lineArray[0]), lineArray[1], lineArray[2], lineArray[3],
                            concelho.length() == 0 ? constantes.Constantes.SELECIONE_UM_CONCELHO : concelho, lineArray[5], lineArray[6], Integer.parseInt(lineArray[7]),
                            Integer.parseInt(lineArray[8]), (Calendar) data.clone(),
                            (lineArray[10].compareTo("sim") == 0));

                    grupos.add(grupo);
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
