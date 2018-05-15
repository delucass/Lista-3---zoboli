
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;

public class Lista3Ex07 extends Furbot {

    @Override
    public void inteligencia() throws Exception {
        while (!ehFim(DIREITA)) {
            verifica();
            andarDireita();
        }
        diga(resultado);
        resultado = 0;
        andarAbaixo();
        verifica();
        while (!ehFim(ESQUERDA)) {
            andarEsquerda();
            verifica();
        }
        diga(resultado);
        resultado = 0;
        andarAbaixo();
        verifica();
        while (!ehFim(DIREITA)) {
            andarDireita();
            verifica();
        }
        diga(resultado);
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista3Ex07.xml");
    }

    private void verifica() {
        if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
            Numero n = getObjeto(AQUIMESMO);
            int num = n.getValor();
            switch (num) {
                case 1:
                    resultado = resultado + 10;
                    break;
                case 2:
                    resultado = resultado - 2;
                    break;
                case 3:
                    resultado = resultado * 2;
                    break;
                case 4:
                    if (resultado % 2 == 1) {
                        resultado = resultado + 2;
                        break;
                    } else {
                        resultado = resultado - 5;
                        break;
                    }

            }
    
        }
    }
    int resultado;
}
