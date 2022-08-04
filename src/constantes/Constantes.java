/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constantes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author ruben
 */
public class Constantes {
    public static final DateFormat FORMATER = new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.ENGLISH);
    public static final int MINUTOS_DELAY_ENTRE_GRUPOS = 2;
    public static final int NUMERO_GRUPO_PARA_INSERIR_ESPECIAL = 6;
    public static final int NUMERO_GRUPO_PARA_AVANCAR = 5;
    public static final String ACESSO = "password";
    
    public static final String SELECIONE_UM_CONCELHO = " SELECIONE UM CONCELHO";
    public static final String SELECIONE_UM_DISTRITO = " SELECIONE UM DISTRITO";
    
    public static final String VISTA_BARRENTA = "VISTA_BARRENTA";
    public static final String VISTA_MOSTRAR_ATUACAO_PALCO = "VISTA_MOSTRAR_ATUACAO_PALCO";
}
