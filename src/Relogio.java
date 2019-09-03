import java.util.Calendar;
import java.util.GregorianCalendar;

public class Relogio {
    public static void main(String[] args) {
        // criando o objeto horario do tipo GregorianCalendar, para ter acesso ao horário atual
        GregorianCalendar horario = new GregorianCalendar();
        // introduzindo o valor do retorno do método retornaAnguloRelogio (tem como retorno o ângulo entre os dois ponteiros do relógio) na variável anguloRelogio
        long anguloRelogio = retornaAnguloRelogio(horario);
        // chamada do método que imprime no console o ângulo entre os ponteiros do relógio
        mostrarAnguloRelogio(anguloRelogio);
    }

    public static long retornaAnguloRelogio(GregorianCalendar horario) {
        long anguloRelogio; // variável que vai receber o ângulo final entre os ponteiros
        int hora = horario.get(Calendar.HOUR); // passando a hora atual para a variável "hora", utilizando o método "get" da classe GregorianCalendar
        int minuto = horario.get(Calendar.MINUTE); // passando o minuto atual para a variável "minuto", utilizando o método "get" da classe GregorianCalendar

        System.out.println("O horário atual é " + hora + ":" + minuto); // imprime no console o horário atual

        long anguloHora = retornaAnguloDaHora(hora); // introduzindo o retorno do método retornaAnguloDaHora para a variável anguloHora
        long anguloMinuto = retornaAnguloDoMinuto(minuto); // introduzindo o retorno do método retornaAnguloDoMinuto para a variável anguloMinuto

        // utilizando o if para ver qual é o maior ângulo, e assim fazer a subtração entre eles corretamente, como resultado teremos o ângulo entre os ponteiros
        if(anguloHora > anguloMinuto){
            anguloRelogio = anguloHora - anguloMinuto;
        } else {
            anguloRelogio = anguloMinuto - anguloHora;
        }

        return anguloRelogio; // retorna o ângulo entre os ponteiros
    }

    // método que retorna o ângulo do ponteiro do minuto em relação ao 0 ou 12 do relógio
    private static long retornaAnguloDoMinuto(int minuto) {
        int anguloACadaMinuto = 6;
        long anguloDoMinuto = minuto * anguloACadaMinuto;
        return anguloDoMinuto;
    }

    // método que retorna o ângulo do ponteiro do minuto em relação ao 0 ou 12 do relógio
    private static long retornaAnguloDaHora(int hora) {
        int anguloACadaHora = 30;
        long anguloDaHora = hora * anguloACadaHora;
        return anguloDaHora;
    }

    // método que imprime o ângulo entre os ponteiros no console
    private static void mostrarAnguloRelogio(long angulo) {
        System.out.println("O ângulo entre os ponteiros é de " + angulo + "º");
    }
}
