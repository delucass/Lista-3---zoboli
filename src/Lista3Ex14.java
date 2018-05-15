
import br.furb.furbot.Booleano;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;
import br.furb.furbot.Tesouro;

public class Lista3Ex14 extends Furbot {

    @Override
    public void inteligencia() throws Exception {
        while (!ehFim(ESQUERDA)) {
            andarEsquerda();
        }
        while (!ehFim(ACIMA)) {
            andarAcima();
        }

        verifica();

        while (!ehFim(ABAIXO)) {
            while (!ehFim(DIREITA)) {
                andarDireita();

                verifica();

            }
            andarAbaixo();

            verifica();

            while (!ehFim(ESQUERDA)) {
                andarEsquerda();

                verifica();

            }
            if (!ehFim(ABAIXO)) {
                andarAbaixo();

                verifica();

            }
        }
        while (!ehFim(DIREITA)) {
            andarDireita();

            verifica();

        }
        diga("Booleanos Criados: " + boolcriados);
        diga("Números primos encontrados: " + primos);
        diga("Números não primos encontrados: " + nprimos);
        diga("Tesouros removidos: " + tesremovidos);
    }

    private void verifica() {
        if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
            Numero n = getObjeto(AQUIMESMO);
            int num = n.getValor();
            if ((num%1==0) && (num%num==0)){
                removerObjetoDoMundo(n);
                Booleano s = null;
                s.setValor(true);
                adicionarObjetoNoMundo(s, AQUIMESMO);
                boolcriados++;
                primos++;
            } else{
                Booleano s = null;
                s.setValor(false);
                adicionarObjetoNoMundo(s, AQUIMESMO);
                boolcriados++;
                nprimos++;
            }
        }
        
        if (ehObjetoDoMundoTipo("Tesouro", AQUIMESMO)){
            Tesouro t = getObjeto(AQUIMESMO);
            int n = t.getValor();
            Numero n1 = new Numero();
            n1.setValor(n);
            removerObjetoDoMundo(t);
            adicionarObjetoNoMundo(n1, AQUIMESMO);
            tesremovidos++;
        }
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista3Ex14.xml");
    }
    
    int boolcriados = 0;
    int tesremovidos = 0;
    int primos = 0;
    int nprimos = 0;
}
