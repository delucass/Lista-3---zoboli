
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;


public class Lista3Ex12 extends Furbot {

    @Override
    public void inteligencia() throws Exception {
       while(!ehFim(ESQUERDA)){
           andarEsquerda();
       }
       while(!ehFim(ACIMA)){
           andarAcima();
       }
       
       realizaOperacao();
       
       andarAbaixo();
       andarEsquerda();
       andarEsquerda();
       
       realizaOperacao();
       
       andarAbaixo();
       andarEsquerda();
       andarEsquerda();
       
       realizaOperacao();
       
       andarEsquerda();
    }
    
    private void realizaOperacao(){
       Numero n1 = getObjeto(AQUIMESMO);
       int n1int = n1.getValor();
       
       andarDireita();
       
       Numero n2 = getObjeto(AQUIMESMO);
       int n2int = n2.getValor();
       
       andarDireita();
       
       int resuint = n1int-n2int;
       
       Numero resu = new Numero();
       
       resu.setValor(resuint);
       adicionarObjetoNoMundo(resu, AQUIMESMO);
       
    }
    public static void main(String[] args) {
        MundoVisual.iniciar("Lista3Ex12.xml");
    }
}
