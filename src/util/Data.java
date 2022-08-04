package util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class Data{
   
    private Calendar calendar;
    private Date data;

    public Data() {
    }

    public Data(Date data) {
        this.data = data;
    }
    
    public Data(String data) {
        try {
            this.data = (constantes.Constantes.FORMATER).parse(data);
        } catch (ParseException ex) {
        }
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
    
    
    
    public String dataToString(){
        return (constantes.Constantes.FORMATER).format(data);
    }
    
    public void adicionarMinutos(int minutos){
        calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(Calendar.MINUTE, minutos);        
        setData(calendar.getTime());
    }
    
    public void retirarMinutos(int minutos){
        calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(Calendar.MINUTE, -minutos);
        setData(calendar.getTime());
    }
    
    public int getMinutosEntreDatas(Data dataMaior){
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(data);
        
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(dataMaior.getData());
        return (int) ((calendar2.getTimeInMillis() - calendar1.getTimeInMillis()) / 1000 / 60);
    }
    
    public int getMinutosEntreDatas(String dataMaior){
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(data);
        
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Data(dataMaior).getData());
        return (int) ((calendar2.getTimeInMillis() - calendar1.getTimeInMillis()) / 1000 / 60);
    }
    
    public String getStringData(){
        return dataToString().split(" ")[0];
    }
    
    public String getStringHoras(){
        return dataToString().split(" ")[1];
    }
}
