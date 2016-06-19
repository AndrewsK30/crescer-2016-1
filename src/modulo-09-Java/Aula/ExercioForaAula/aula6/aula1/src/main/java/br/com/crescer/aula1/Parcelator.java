package br.com.crescer.aula1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Carlos H. Nonnemacher
 */
public final class Parcelator {

    private static final String PATTERN = "dd/MM/yyyy";
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat(PATTERN);
    private static final NumberFormat NUMBER_FORMAT = NumberFormat.getCurrencyInstance();

    private final BigDecimal valor;
    private int parcelas;
    private double juros;
    private Date vencimento;

    private Parcelator(BigDecimal valor) {
        this.valor = valor;
    }

    public static Parcelator novoParcelamento(final BigDecimal valor) {
        return new Parcelator(valor);
    }

    public Parcelator quantidadeParcelas(int parcelas) {
        this.parcelas = parcelas;
        return this;
    }

    public Parcelator taxaDeJuros(final Double juros) {
        this.juros = juros;
        return this;
    }

    public Parcelator primeiroVencimento(final Date vencimento) {
        this.vencimento = vencimento;
        return this;
    }

    public Map<String, String> calcular() {

        final BigDecimal qtdParcelas = BigDecimal.valueOf(parcelas);
        final BigDecimal vlTotal = valor.multiply(BigDecimal.valueOf(juros).divide(BigDecimal.valueOf(100)).add(BigDecimal.ONE));
        final BigDecimal vlParcela = vlTotal.divide(qtdParcelas, 2, RoundingMode.HALF_UP);
        // Calcula se existe resto na soma das parcelas.
        BigDecimal vlResto = vlParcela.multiply(qtdParcelas).subtract(vlTotal);

        Map<String, String> map = new LinkedHashMap<String, String>();

        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(vencimento);

        for (int i = 0; i < parcelas; i++) {
            map.put(DATE_FORMAT.format(calendar.getTime()), NUMBER_FORMAT.format(vlParcela.subtract(vlResto)));
            vlResto = BigDecimal.ZERO;
            calendar.add(Calendar.MONTH, 1);
        }
        return map;
    }

}
