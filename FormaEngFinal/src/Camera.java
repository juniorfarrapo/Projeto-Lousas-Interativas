
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamDiscoveryListener;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Camera {
    public static int w, h; //variaveis de tamanho da imagem
    public static Base comandos = new Base(); //cria um objeto da classe base
    //public static Webcam webcam = Webcam.getWebcams().get(0);
    public static Webcam webcam0; //cria uma variavel do tipo webcam
    public static Webcam webcam1;
    public static Webcam webcam2;
    public static Webcam webcam3;
    public static WebcamDiscoveryListener[] webcamlist = Webcam.getDiscoveryListeners(); //webcamlist recebe uma lista das webcams conectadas
    public static BufferedImage image; //variável que recebe a imagem a ser trabalhada no processamento
   
    //método temporário, lista 4 webcams "gambiarra"
    public void opcaoCamera(){
        for(int i = 0; i < 4; i++){ //for que varia de acordo com o número de webcams conectadas
            if(i==0){
                webcam0 = Webcam.getWebcams().get(0); //webcam0 recebe a webcam conectada na porta 0
                if(webcam0 != null){ //se a webcam existe seta o seu nome
                    NewJFrame.opcaoCamera0.setText(webcam0.getName());
                    NewJFrame.testCamera0 = true; //se a câmera 0 existir seu teste é verdade
                }
            }
            
            if(i==1){
                webcam1 = Webcam.getWebcams().get(1); //webcam1 recebe a webcam conectada na porta 1
                if(webcam1 != null){ //se a webcam existe seta o seu nome
                    NewJFrame.opcaoCamera1.setText(webcam1.getName());
                    NewJFrame.testCamera1 = true; //se a câmera 1 existir seu teste é verdade
                }
            }
            
            if(i==2){
                webcam2 = Webcam.getWebcams().get(2); //webcam2 recebe a webcam conectada na porta 2
                if(webcam2 != null){ //se a webcam existe seta o seu nome
                    NewJFrame.opcaoCamera2.setText(webcam2.getName());
                    NewJFrame.testCamera2 = true; //se a câmera 2 existir seu teste é verdade
                }
            }
            
            if(i==3){
                webcam3 = Webcam.getWebcams().get(3); //webcam3 recebe a webcam conectada na porta 3
                if(webcam3 != null){ //se a webcam existe seta o seu nome
                    NewJFrame.opcaoCamera3.setText(webcam3.getName());
                    NewJFrame.testCamera3 = true; //se a câmera 3 existir seu teste é verdade
                }
            }
        }
    }
    
    //metodo para criar o objeto câmera escolhido pelo usuario
    public void criarCamera() throws IOException, InterruptedException, AWTException{
	NewJFrame.webcam.setViewSize(new Dimension(320, 240)); //a câmera recebe as dimensão 320,240, pode ser alterada mas acarreta em uma maior peso no processamento
        NewJFrame.webcam.open(); //abre a webcam
        image = NewJFrame.webcam.getImage(); //image recebe uma imagem capturada pela webcam
        w = image.getWidth(); //a variável w recebe a largura da imagem
        h = image.getHeight(); //a variável h recebe a altura da imagem
    }
}