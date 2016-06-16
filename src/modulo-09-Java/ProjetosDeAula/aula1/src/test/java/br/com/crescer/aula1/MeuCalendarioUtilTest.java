package br.com.crescer.aula1;

import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Carlos H. Nonnemacher
 */
public class MeuCalendarioUtilTest {

    /**
     * Test of diaSemana method, of class MeuCalendarioUtil.
     */
    @Test
    public void testDiaSemana() {
        MeuCalendarioUtil instance = new MeuCalendarioUtil();
        assertEquals("A data é nula", null, instance.diaSemana(null));

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_WEEK, 1 - (calendar.get(Calendar.DAY_OF_WEEK)));
        Date sunday = calendar.getTime();
        assertEquals("A data é SUNDAY", "SUNDAY", instance.diaSemana(sunday));

        calendar.add(Calendar.DAY_OF_WEEK, 1);
        Date monday = calendar.getTime();
        assertEquals("A data é MONDAY", "MONDAY", instance.diaSemana(monday));

        calendar.add(Calendar.DAY_OF_WEEK, 1);
        Date tuesday = calendar.getTime();
        assertEquals("A data é TUESDAY", "TUESDAY", instance.diaSemana(tuesday));

        calendar.add(Calendar.DAY_OF_WEEK, 1);

        Date wednesday = calendar.getTime();
        assertEquals("A data é WEDNESDAY", "WEDNESDAY", instance.diaSemana(wednesday));

        calendar.add(Calendar.DAY_OF_WEEK, 1);
        Date thursday = calendar.getTime();
        assertEquals("A data é THURSDAY", "THURSDAY", instance.diaSemana(thursday));

        calendar.add(Calendar.DAY_OF_WEEK, 1);
        Date friday = calendar.getTime();
        assertEquals("A data é FRIDAY", "FRIDAY", instance.diaSemana(friday));

        calendar.add(Calendar.DAY_OF_WEEK, 1);
        Date saturday = calendar.getTime();
        assertEquals("A data é SATURDAY", "SATURDAY", instance.diaSemana(saturday));

    }

    /**
     * Test of tempoDecorrido method, of class MeuCalendarioUtil.
     */
    @Test
    public void testTempoDecorrido() {
        MeuCalendarioUtil instance = new MeuCalendarioUtil();
        assertEquals("A data é nula", null, instance.tempoDecorrido(null));
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, -1);
        assertEquals("Passou 1 dia", "Ano(s) 0, messes 0, dia(s) 1", instance.tempoDecorrido(c.getTime()));
    }

}
