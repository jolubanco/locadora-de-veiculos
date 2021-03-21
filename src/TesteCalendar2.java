import java.text.Format;
        import java.text.SimpleDateFormat;
        import java.util.Date;
        import java.util.Calendar;
public class TesteCalendar2 {
    public static void main(String[] args) throws Exception {
        // displaying current date and time
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat simpleformat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss Z");
        System.out.println("Today's date and time = "+simpleformat.format(cal.getTime()));
        // displaying date
        simpleformat = new SimpleDateFormat("dd/MMMM/yyyy");
        String str = simpleformat.format(new Date());
        System.out.println("Current Date = "+str);
        // current time
        simpleformat = new SimpleDateFormat("HH:mm:ss");
        String strTime = simpleformat.format(new Date());
        System.out.println("Current Time = "+strTime);
        // displaying hour in HH format
        simpleformat = new SimpleDateFormat("HH");
        String strHour = simpleformat.format(new Date());
        System.out.println("Hour in HH format = "+strHour);



        //formato ideal
        simpleformat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        String strTimeDay = simpleformat.format(new Date());
        System.out.println("Dia e Hora = " + strTimeDay);

    }
}
