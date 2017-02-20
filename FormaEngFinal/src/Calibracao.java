
import java.awt.AWTException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Calibracao implements Runnable{ 
    
    public static float constantes[]; //constante é um vetor com as contantes após a calibraçao acessível por todo o programa
    
    //método que efetua a calibração por completo
    public void calibrando() throws IOException, InterruptedException, AWTException{
        int xy_[] = Camera.comandos.calibrar(NewJFrame.webcam); //vetor xy_ receber os valores retornados pelos pontos capturados na calibração
        int x[] = new int[4]; //cria-se um vetor x de tamanho 4 
        int y[] = new int[4]; //cria-se um vetor y de tamanho 4 
        x[0] = xy_[0]; x[1] = xy_[2]; x[2] = xy_[4]; x[3] = xy_[6]; //o vetor x recebe os valores x dos pontos capturados na calibração
        y[0] = xy_[1]; y[1] = xy_[3]; y[2] = xy_[5]; y[3] = xy_[7]; //o vetor y recebe os valores y dos pontos capturados na calibração
        constantes = Camera.comandos.eqprojecao(x,y);//variavel constantes recebes os valores retornados após o método eqprojecao com as contantes que serão utilizadas para corrigir o ponto capturado na bolha
        NewJFrame.botaoIniciaPrograma.setText("Calibrado!"); //altera o nome do botão calibrar
        NewJFrame.botaoIniciaPrograma.setText("Clique para iniciar!"); //altera o nome do botão que espera a calibração
    }
    
    @Override
    public void run () { //thread que executa a calibração
        try {
            calibrando();
        } catch (IOException | InterruptedException | AWTException ex) {
            Logger.getLogger(Calibracao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
