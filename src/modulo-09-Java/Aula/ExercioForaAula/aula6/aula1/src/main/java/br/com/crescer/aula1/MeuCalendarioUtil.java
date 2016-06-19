package br.com.crescer.aula1;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Carlos H. Nonnemacher
 */
public class MeuCalendarioUtil {

    /**
     * 1. Deve possuir um metodo que recebe a data de nascimento e retorne o dia
     * da semana que a pessoa nasceu. (Segunda, Terça ...)
     *
     * @param date
     * @return SUNDAY - MONDAY - TUESDAY - WEDNESDAY - THURSDAY - FRIDAY -
     * SATURDAY
     */
    public String diaSemana(final Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.get(Calendar.DAY_OF_WEEK);
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                return "SUNDAY";
            case 2:
                return "MONDAY";
            case 3:
                return "TUESDAY";
            case 4:
                return "WEDNESDAY";
            case 5:
                return "THURSDAY";
            case 6:
                return "FRIDAY";
            case 7:
                return "SATURDAY";
            default:
                return null;
        }
    }

    /**
     * 2. Deve possuir um metodo que recebe uma data e informe o tempo decorrido
     * até a data atual. 30 ano(s), 3 messe(s) e 12 dia(s)
     *
     * @param date
     * @return "Ano(s) %s, messes %s, dia(s) %s"
     */
    public String tempoDecorrido(final Date date) {
        Calendar c = Calendar.getInstance();
        if (date == null) {
            return null;
        }
        long diff = new Date().getTime() - date.getTime();
        c.setTime(new Date(diff));

        return String.format("Ano(s) %s, messes %s, dia(s) %s", c.get(Calendar.YEAR) - 1970, c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
    }
    
}
