package br.com.crescer.aula1;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Carlos H. Nonnemacher
 */
public class Run {

    public static enum Estados {

        AC("Acre"), AL("Alagoas"), ES("EspíritoSanto"), AP("Amapá"),
        BA("Bahia"), CE("Ceará"), DF("DistritoFederal"), GO("Goiás"),
        MA("Maranhão"), SC("SantaCatarina"), MG("MinasGerais"),
        MT("MatoGrosso"), MS("MatoGrossodoSul"), PA("Pará"),
        RS("RioGrandedoSul"), PE("Pernambuco"), PI("Piauí"),
        AM("Amazonas"), PR("Paraná"), RJ("RiodeJaneiro"),
        RN("RioGrandedoNorte"), PB("Paraíba"), RO("Rondônia"),
        RR("Roraima"), SE("Sergipe"), SP("SãoPaulo"), TO("Tocantins");

        private String nome;

        private Estados(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

    }

    private static String normalize(String nome) {
        return Normalizer.normalize(nome, Normalizer.Form.NFD).replaceAll("[^\\x00-\\x7F]", "");
    }

    public static void main(String[] args) {

        // Usando o java 7  
        final List<Estados> estados = Arrays.asList(Estados.values());
        Collections.sort(estados, new Comparator<Estados>() {
            @Override
            public int compare(Estados e, Estados e1) {
                return normalize(e.getNome()).compareTo(normalize(e1.getNome()));
            }
        });

        final StringBuilder builder = new StringBuilder();
        for (final Estados estado : estados) {
            builder.append(estado.getNome()).append(", ");
        }

        builder.deleteCharAt(builder.toString().trim().length() - 1);
        System.out.println(builder);

        // Usando java 8 
//        System.out.println(String.join(", ", estados.stream().map(Estados::getNome).sorted((e, e1) -> normalize(e).compareTo(normalize(e1))).collect(Collectors.toList())));

    }

}
