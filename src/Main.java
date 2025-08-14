import java.time.LocalDate;

import model.Bootcamp;
import model.Curso;
import model.Dev;
import model.Mentoria;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("Java Básico");
        curso1.setDescricao("Curso introdutório de Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("POO com Java");
        curso2.setDescricao("Aprenda POO na prática");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria Java");
        mentoria.setDescricao("Mentoria sobre carreira e Java");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Aprenda Java do zero ao avançado");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devLucas = new Dev();
        devLucas.setNome("Lucas");
        devLucas.inscreverBootcamp(bootcamp);

        System.out.println("Conteúdos inscritos de Lucas: " + devLucas.getConteudosInscritos());
        devLucas.progredir();
        devLucas.progredir();
        System.out.println("Conteúdos restantes de Lucas: " + devLucas.getConteudosInscritos());
        System.out.println("Conteúdos concluídos de Lucas: " + devLucas.getConteudosConcluidos());
        System.out.println("Total XP: " + devLucas.calcularTotalXp());
    }
}
