package test;

import java.util.Calendar;

public class TesteCalendar {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();

        System.out.println("Data e hora atual " + c.getTime());
        System.out.println("Ano: "+c.get(Calendar.YEAR));
        System.out.println("Mês: "+c.get(Calendar.MONTH));
        System.out.println("Dia do Mês: "+c.get(Calendar.DAY_OF_MONTH));
        System.out.println("Hora: "+c.get(Calendar.HOUR_OF_DAY));
        System.out.println("Hora: "+c.get(Calendar.HOUR));
        System.out.println("Minuto: "+c.get(Calendar.MINUTE));
        System.out.println("Segundo: "+c.get(Calendar.SECOND));
        System.out.println("Horário: " + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND));

    }
}
