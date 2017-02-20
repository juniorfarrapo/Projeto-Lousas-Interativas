import java.awt.AWTException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RodaCamera implements Runnable {
    int i = 1;
    
    //método que executa a camera depois da calibração
    public void lousaExecucao() throws AWTException, IOException{
        while( i == 1 ){ //loop eterno
            //Camera.image = NewJFrame.webcam.getImage(); //efetua a captura de uma imagem na webcam
            //Camera.comandos.movemouse(Camera.image, Calibracao.constantes); //chama o método que move o mouse, dentro do movemouse ocorre a detecção da bolha
            Camera.comandos.movemouse(NewJFrame.webcam.getImage(), Calibracao.constantes);
        } 
    }
    
    @Override
    public void run () { //thread que roda o lousaExecucao
        try {
            try {
                lousaExecucao();
            } catch (IOException ex) {
                Logger.getLogger(RodaCamera.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (AWTException ex) {
            Logger.getLogger(RodaCamera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
