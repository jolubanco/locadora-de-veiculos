package test;

import java.util.Calendar;
        import java.text.DateFormat;
        import java.util.Date;

public class TesteDateFormat{

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();

        DateFormat f = DateFormat.getDateInstance(DateFormat.FULL); //Data COmpleta
        System.out.println("Data brasileira: "+f.format(data));

        f = DateFormat.getDateInstance(DateFormat.LONG);
        System.out.println("Data sem o dia descrito: "+f.format(data));

        f = DateFormat.getDateInstance(DateFormat.MEDIUM);
        System.out.println("Data resumida 1: "+f.format(data));

        f = DateFormat.getDateInstance(DateFormat.SHORT);
        System.out.println("Data resumida 2: "+f.format(data));
    }
}