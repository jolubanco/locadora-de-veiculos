import java.util.GregorianCalendar;
import java.util.Calendar;
public class TestaGregorian {
    public static void main(String[] args) {
        GregorianCalendar vencimento = new GregorianCalendar();
        int inteiro;
        System.out.println(vencimento.getTime());
        vencimento.add(Calendar.DAY_OF_MONTH, 15);
        int dia = vencimento.get(Calendar.DAY_OF_MONTH);
        System.out.println(dia);
        System.out.print(vencimento.getTime());
    }
}
