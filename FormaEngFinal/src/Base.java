
import com.github.sarxos.webcam.Webcam;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.InputEvent;
//import java.io.File;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import javax.imageio.ImageIO;

public class Base {   
    
    //Método que efetua o escalonamento de Gauss 
    public float[] solgauss(float[][] matriz) { //recebe uma matriz  
        int ordem = matriz.length;  
        float[] solucao = new float[ordem];
        for ( int i=0; i < ordem; i++) {  
           float pivo = matriz[i][i];  
           if (pivo == 0)  
              System.out.println("Pivo eh zero");  
           for ( int c=i; c <= ordem; c++)  
              matriz[i][c] /= pivo;  
           for ( int l=i+1; l < ordem; l++) {  
              float x = matriz[l][i] * -1;  
              for ( int c=i; c <= ordem; c++)  
                 matriz[l][c] += matriz[i][c] * x;  
           }  
        }  
        if(matriz[ordem-1][ordem-1]!=0){
           solucao[ordem-1] = matriz[ordem-1][ordem] / matriz[ordem-1][ordem-1];
        }
        else{ System.out.printf("Ocorreu um erro!");}
          float soma,aux;
          for(int i=ordem-2; i>-1; i--){
              soma = matriz[i][ordem];
              for(int j=ordem-1; j>i; j--){
                  aux = solucao[j]*matriz[i][j];
                  soma = soma - aux;
              }
              solucao[i] = soma/matriz[i][i];
       }

        return solucao; //retorna o vetor solução
   }  
   
    //esse metodo calcuint cinza2;la eq da projecao e retorna as constantes
    public float[] eqprojecao(int[] k,int[] z){ //recebe os valos x e y em vetores separados dos quatros pontos capturados
        float[][] a = new float[8][9]; //cria uma matriz 8,9
        int[] x_ = k; // o vetor x_ recebe os valores x dos quatro pontos capturados
        int[] y_ = z; // o vetor y_ recebe os valores x dos quatro pontos capturados
        int x1 = 200,x2=700,x3=700,x4=200,y1=200,y2=200,y3=500,y4=500; //esses são as quatros posições para onde o mouse vai durante a calibração
        float a0,a1,a2,b0,b1,b2,c1,c2; //variáveis constantes auxiliares
        
        a[0][0]=x_[0]*x1;	a[0][1]=-x_[0];a[0][2]=0;	a[0][3]=y_[0]*x1;	a[0][4]=-y_[0];a[0][5]=0;	a[0][6]=-1;	a[0][7]=0;	a[0][8]=-x1;	
        a[1][0]=x_[0]*y1;	a[1][1]=0;	a[1][2]=-x_[0];a[1][3]=y_[0]*y1;	a[1][4]=0;	a[1][5]=-y_[0];a[1][6]=0;	a[1][7]=-1;	a[1][8]=-y1;	
        a[2][0]=x_[1]*x2;	a[2][1]=-x_[1];a[2][2]=0;	a[2][3]=y_[1]*x2;	a[2][4]=-y_[1];a[2][5]=0;	a[2][6]=-1;	a[2][7]=0;	a[2][8]=-x2;	
        a[3][0]=x_[1]*y2;	a[3][1]=0;	a[3][2]=-x_[1];a[3][3]=y_[1]*y2;	a[3][4]=0;	a[3][5]=-y_[1];a[3][6]=0;	a[3][7]=-1;	a[3][8]=-y2;	
        a[4][0]=x_[2]*x3;	a[4][1]=-x_[2];a[4][2]=0;	a[4][3]=y_[2]*x3;	a[4][4]=-y_[2];a[4][5]=0;	a[4][6]=-1;	a[4][7]=0;	a[4][8]=-x3;	
        a[5][0]=x_[2]*y3;	a[5][1]=0;	a[5][2]=-x_[2];a[5][3]=y_[2]*y3;	a[5][4]=0;	a[5][5]=-y_[2];a[5][6]=0;	a[5][7]=-1;	a[5][8]=-y3;	
        a[6][0]=x_[3]*x4;	a[6][1]=-x_[3];a[6][2]=0;	a[6][3]=y_[3]*x4;	a[6][4]=-y_[3];a[6][5]=0;	a[6][6]=-1;	a[6][7]=0;	a[6][8]=-x4;	
        a[7][0]=x_[3]*y4;	a[7][1]=0;	a[7][2]=-x_[3];a[7][3]=y_[3]*y4;	a[7][4]=0;	a[7][5]=-y_[3];a[7][6]=0;	a[7][7]=-1;	a[7][8]=-y4;	

        solgauss(a); //soluciona a matriz acima pelo método de gauss
        
        //soluciona o siste e armazena nas variáveis constantes auxiliares
        c2=a[7][8]/a[7][7];
	c1=(a[6][8]-a[6][7]*c2)/a[6][6];
	b2=(a[5][8]-c1*a[5][6]-c2*a[5][7])/a[5][5];
	b1=(a[4][8]-b2*a[4][5]-c1*a[4][6]-c2*a[4][7])/a[4][4];
	b0=(a[3][8]-b1*a[3][4]-b2*a[3][5]-c1*a[3][6]-c2*a[3][7])/a[3][3];
	a2=(a[2][8]-b0*a[2][3]-b1*a[2][4]-b2*a[2][5]-c1*a[2][6]-c2*a[2][7])/a[2][2];
	a1=(a[1][8]-a2*a[1][2]-b0*a[1][3]-b1*a[1][4]-b2*a[1][5]-c1*a[1][6]-c2*a[1][7])/a[1][1];
	a0=(a[0][8]-a1*a[0][1]-a2*a[0][2]-b0*a[0][3]-b1*a[0][4]-b2*a[0][5]-c1*a[0][6]-c2*a[0][7])/a[0][0];
        
        float constantes[] = new float[8]; //vetor constantes de tamanho 8 criado
        constantes[0] = a0; constantes[1] = a1; constantes[2] = a2; //o vetor constantes recebe os valores das constantes
        constantes[3] = b0; constantes[4] = b1; constantes[5] = b2;
        constantes[6] = c1; constantes[7] = c2; 
        
    return constantes; //ocorre o retorno das constantes
    }
    
    /*
     *pega hora e data atuais do sistema operacional
     * teste de capturar e salvar todas as fotos
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat data = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss:SSS"); 
    */
    
    //esse metodo detecta uma bolha, onde a caneta esta
    public int[] bolha(BufferedImage x) throws IOException{ //recebe a imagem capturada

        //BufferedImage imagem = x; //a variável "imagem" recebe a imagem passada ao método
        int K[] = new int[2]; //K é um vetor de tamanho 2
        //int w = imagem.getWidth(); //a variável w recebe a largura da imagem
        //int h = imagem.getHeight(); //a variável h recebe a altura da imagem
        int cinza,corrgb,red,green,blue,Sx=0,Sy=0,S=0; //variáveis auxiliares
        int w = x.getWidth(); 
        int h = x.getHeight();
        
        for(int i=0; i<w; i++){ // os dois for's varrem a imagem completamente
            for(int j=0; j<h; j++){ 
                corrgb = x.getRGB(i, j); // a variável "corrgb" recebe os valor do rgb naquele pixel da imagem
                red = (corrgb >> 16) & 0xff; // a variavel red recebe o valor de 0-255 da cor vermelha naquele pixel
                green = (corrgb >> 8) & 0xff; // a variavel gree recebe o valor de 0-255 da cor verde naquele pixel
                blue = (corrgb) & 0xff; // a variavel blue recebe o valor de 0-255 da cor azul naquele pixel
                cinza = (int)(red + green + blue)/ 3 ; // a variavel cinza recebe o valor de 0-255 da soma das três cores primária e divididas por 3, uma escala cinza
                if( cinza > NewJFrame.limiar.getValue()){ //NewJFrame.jSlider1.getValue() é um método que retorna o valor da barra do limiar, já configurada para trabalhar de 1-254, se cinza for maior que o valor do limiar então um ponto branco foi encontrado
                    Sx = Sx + i; //a variável Sx soma os valores da posição x de cada pixel branco
                    Sy = Sy + j; //a variável Sy soma os valores da posição y de cada pixel branco
                    S++; //a variável S soma o número de pixeis brancos
                }
            }
        }

        /*
        boolean teste = false;
        int cinza2;
        mainLoop: for(int i=0; i<w; i++){ // os dois for's varrem a imagem completamente
            for(int j=0; j<h; j++){ 
                corrgb = x.getRGB(i, j); // a variável "corrgb" recebe os valor do rgb naquele pixel da imagem
                red = (corrgb >> 16) & 0xff; // a variavel red recebe o valor de 0-255 da cor vermelha naquele pixel
                green = (corrgb >> 8) & 0xff; // a variavel gree recebe o valor de 0-255 da cor verde naquele pixel
                blue = (corrgb) & 0xff; // a variavel blue recebe o valor de 0-255 da cor azul naquele pixel
                cinza = (int)(red + green + blue)/ 3 ; // a variavel cinza recebe o valor de 0-255 da soma das três cores primária e divididas por 3, uma escala cinza
                x.setRGB(i, j, 0xFF0000FF);
                if( cinza > NewJFrame.limiar.getValue()){ //NewJFrame.jSlider1.getValue() é um método que retorna o valor da barra do limiar, já configurada para trabalhar de 1-254, se cinza for maior que o valor do limiar então um ponto branco foi encontrado
                    if(i+4<w)
                        i = i+ 20;
                    if(j+4<h)
                        j = j + 20;
                    for(int ii=i-20; ii<i; ii++){
                        for(int jj=j-20;jj<j;jj++){
                            corrgb = x.getRGB(ii, jj); // a variável "corrgb" recebe os valor do rgb naquele pixel da imagem
                            red = (corrgb >> 16) & 0xff; // a variavel red recebe o valor de 0-255 da cor vermelha naquele pixel
                            green = (corrgb >> 8) & 0xff; // a variavel gree recebe o valor de 0-255 da cor verde naquele pixel
                            blue = (corrgb) & 0xff; // a variavel blue recebe o valor de 0-255 da cor azul naquele pixel
                            cinza2 = (int)(red + green + blue)/ 3 ; // a variavel cinza recebe o valor de 0-255 da soma das três cores primária e divididas por 3, uma escala cinza
                            x.setRGB(ii, jj, 0xFF0000FF);
                            if( cinza2 > NewJFrame.limiar.getValue()){
                                Sx = Sx + ii; //a variável Sx soma os valores da posição x de cada pixel branco
                                Sy = Sy + jj; //a variável Sy soma os valores da posição y de cada pixel branco
                                S++;
                                teste = true;
                                x.setRGB(ii, jj, 0xFF00FF00);
                            }
                        }
                    }
                }
                if (teste)
                break mainLoop;
            }
        }
        
        
        if(S>7){ //se existirem mais de 7 pixeis branco
                int X = Sx/S; //a variável X recebe a media da soma das posiçẽs x do pixel branco dividido por S o número de pixeis branco
                int Y = Sy/S; //a variável Y recebe a media da soma das posiçẽs y do pixel branco dividido por S o número de pixeis branco
                K[0]=X; //o vetor K[0] recebe o valor da posição x
                K[1]=Y; //o vetor K[1] recebe o valor da posição 1
        }
        x.setRGB(K[0], K[1], 0xFF800000);
        ImageIO.write(x, "JPG", new File("/home/juniorfarrapo/Área de Trabalho/temp/" + data.format(cal.getTime()) + ".jpg"));
        */
        
        if(S>7){ //se existirem mais de 7 pixeis branco
                int X = Sx/S; //a variável X recebe a media da soma das posiçẽs x do pixel branco dividido por S o número de pixeis branco
                int Y = Sy/S; //a variável Y recebe a media da soma das posiçẽs y do pixel branco dividido por S o número de pixeis branco
                K[0]=X; //o vetor K[0] recebe o valor da posição x
                K[1]=Y; //o vetor K[1] recebe o valor da posição 1
        }
        
        return K; //retorna o vetor K com as posições para o onde o mouse deve ir
    }
    
    //esse metodo calibra a webcam, captura os 4 pontos
    public int[] calibrar(Webcam x) throws IOException, InterruptedException, AWTException{ //recebe o objeto webcam
            //Resumo:
            //Esse método calcula os 4 pontos necessários para a calibração
            //Uma vez escolhido só sai do loop quando cada ponto é capturado
            //Fica capturando imagens até o ponto ser detectado
            int xy[] = new int[8]; //vetor de tamanho 8
            Camera.image = NewJFrame.webcam.getImage(); //a variável image que pode ser acessada por todo o programa recebe uma imagem da webcam
            int w = Camera.image.getWidth(); //a variável w recebe a largura da imagem
            int h = Camera.image.getHeight(); //a variável h recebe a altura da imagem 
            int posicao[] = new int[2]; //vetor posição de tamanho 2
            
            Robot temp = new Robot();//criação do objeto temp que irá move o mouse onde o usuário deve clicar
            
            System.out.printf("Calibração iniciada!\nEsperando Ponto 1!\n"); //texto exibido no terminal
            NewJFrame.textStatusCalibracao.setForeground(Color.blue); //seta a cor azul
            NewJFrame.textStatusCalibracao.setText("Esperando Ponto 1!"); //muda o texto que é exibido no programa
            do{
                //calcula o ponto 1
                temp.mouseMove(200,200); //move o mouse para a posição 200,200
                Camera.image = NewJFrame.webcam.getImage(); //a variável image que pode ser acessada por todo o programa recebe uma imagem da webcam          
                posicao = bolha(Camera.image); //utiliza o método bolha para achar um ponto branco passando a imagem capturada
                xy[0] = posicao[0]; //vetor xy[0] amarzena a posição x do centro da bolha
                xy[1] = posicao[1]; //vetor xy[1] amarzena a posição y do centro da bolha
            }while(xy[0]==0 && xy[1]==0); //loop eterno até a bolha ser encontrada
           // ImageIO.write(image, "JPG", new File("D:\\foto1.jpg"));
            NewJFrame.textStatusCalibracao.setText("Ponto 1 calibrado!"); //muda o texto que é exibido no programa
            System.out.printf("Ponto 1 calibrado!\n"); //texto exibido no terminal
            NewJFrame.webcam.close(); //fecha a webcam para evitar lixo de imagem do ponto anterior
            //Thread.sleep(100); //faz a thread atual parar por 750ms
            NewJFrame.webcam.open(); //abre a webcam 
            NewJFrame.textStatusCalibracao.setText("Esperando Ponto 2!"); //muda o texto que é exibido no programa
            System.out.printf("Esperando Ponto 2!\n"); //texto exibido no terminal
            do{
                //calcula o ponto 2
                temp.mouseMove(700,200); //move o mouse para a posição 700,200
                Camera.image = NewJFrame.webcam.getImage(); //a variável image que pode ser acessada por todo o programa recebe uma imagem da webcam                    
                posicao = bolha(Camera.image); //utiliza o método bolha para achar um ponto branco passando a imagem capturada
                xy[2] = posicao[0]; //vetor xy[2] amarzena a posição x do centro da bolha
                xy[3] = posicao[1]; //vetor xy[3] amarzena a posição y do centro da bolha
            }while(xy[2]==0 && xy[3]==0); //loop eterno até a bolha ser encontrada
            //ImageIO.write(image, "JPG", new File("D:\\foto2.jpg"));
            NewJFrame.textStatusCalibracao.setText("Ponto 2 calibrado!"); //muda o texto que é exibido no programa
            System.out.printf("Ponto 2 calibrado!\n"); //texto exibido no terminal   
            NewJFrame.webcam.close(); //fecha a webcam para evitar lixo de imagem do ponto anterior
            //Thread.sleep(100); //faz a thread atual parar por 750ms
            NewJFrame.webcam.open(); //abre a webcam 
            NewJFrame.textStatusCalibracao.setText("Esperando Ponto 3!"); //muda o texto que é exibido no programa
            System.out.printf("Esperando Ponto 3!\n"); //texto exibido no terminal
            do{
                //calcula o ponto 3
                temp.mouseMove(700,500); //move o mouse para a posição 700,500
                Camera.image = NewJFrame.webcam.getImage(); //a variável image que pode ser acessada por todo o programa recebe uma imagem da webcam          
                posicao = bolha(Camera.image); //utiliza o método bolha para achar um ponto branco passando a imagem capturada
                xy[4] = posicao[0]; //vetor xy[4] amarzena a posição x do centro da bolha
                xy[5] = posicao[1]; //vetor xy[5] amarzena a posição y do centro da bolha
            }while(xy[4]==0 && xy[5]==0); //loop eterno até a bolha ser encontrada
            //ImageIO.write(image, "JPG", new File("D:\\foto3.jpg"));
            NewJFrame.textStatusCalibracao.setText("Ponto 3 calibrado!"); //muda o texto que é exibido no programa
            System.out.printf("Ponto 3 calibrado!\n"); //texto exibido no terminal
            NewJFrame.webcam.close(); //fecha a webcam para evitar lixo de imagem do ponto anterior
            //Thread.sleep(100); //faz a thread atual parar por 750ms
            NewJFrame.webcam.open(); //abre a webcam 
            System.out.printf("Esperando Ponto 4!\n"); //muda o texto que é exibido no programa
            NewJFrame.textStatusCalibracao.setText("Esperando Ponto 4!"); //texto exibido no terminal
            do{
                //calcula o ponto 4
                temp.mouseMove(200,500); //move o mouse para a posição 200,500
                Camera.image = NewJFrame.webcam.getImage(); //a variável image que pode ser acessada por todo o programa recebe uma imagem da webcam            
                posicao = bolha(Camera.image); //utiliza o método bolha para achar um ponto branco passando a imagem capturada
                xy[6] = posicao[0]; //vetor xy[6] amarzena a posição x do centro da bolha
                xy[7] = posicao[1]; //vetor xy[7] amarzena a posição y do centro da bolha
            }while(xy[6]==0 && xy[7]==0); //loop eterno até a bolha ser encontrada
            //ImageIO.write(image, "JPG", new File("D:\\foto4.jpg"));
            NewJFrame.textStatusCalibracao.setText("Ponto 4 calibrado!"); //muda o texto que é exibido no programa
            System.out.printf("Ponto 4 calibrado!\n"); //texto exibido no terminal
            NewJFrame.textStatusCalibracao.setForeground(Color.green); //seta a cor verde
            NewJFrame.textStatusCalibracao.setText("Calibrado com sucesso!"); //muda o texto que é exibido no programa
        return xy; //retorna o vetor xy com os valores x e y dos quatros pontos capturados
    }
    
    //coracao de tudo, atraves de todos os metodos ele faz a aplicacao no mouse
    public void movemouse(BufferedImage x,float[] y) throws AWTException, IOException{ //recebe a imagem capturada e um vetor com as constantes
        //BufferedImage imagem = x; // imagem recebe a imagem capturada
        int c,l; //variaveis c que é a posição x para onde o mouse deve ir e l que é a posição y para onde o mouse deve ir
        int XY_[] = bolha(x); // o vetor XY_ recebe o valor x e y do ponto de onde o mouse está
        //float constt[] = y; // o vetor constt recebe os valores das constantes
        
        //atraves da geometria projetiva é efetuado o cálculo das posições x e y reais do mouse
        //c=Math.round((constt[1]*XY_[0]+constt[4]*XY_[1]+constt[6])/(constt[0]*XY_[0]+constt[3]*XY_[1]+1));
       // l=Math.round((constt[2]*XY_[0]+constt[5]*XY_[1]+constt[7])/(constt[0]*XY_[0]+constt[3]*XY_[1]+1));
    
        c=Math.round((y[1]*XY_[0]+y[4]*XY_[1]+y[6])/(y[0]*XY_[0]+y[3]*XY_[1]+1));
        l=Math.round((y[2]*XY_[0]+y[5]*XY_[1]+y[7])/(y[0]*XY_[0]+y[3]*XY_[1]+1));
        
        Robot robot = new Robot(); //criação do objeto robot que irá move o mouse onde o usuário deve clicar
        
        /*//OBS: corrigir, contem algum erro ou aprimorar
        if(c>0 && l>0){ //
            if(XY_[0]!=0 && XY_[1]!=0){ //se a posição para onde o mouse deve ir for diferente de 0
                robot.mouseMove(c,l); //move o mouse para as coordenadas c,l 
                robot.mousePress(InputEvent.BUTTON1_MASK); //efetua o clique do botão direito do mouse
                robot.mouseRelease(InputEvent.BUTTON1_MASK); //solta o botão direito do mouse
                //System.out.printf("X=%d, Y=%d\n",c,l);
            }
             else{
            robot.mouseRelease(InputEvent.BUTTON1_MASK); //solta o botão direito do mouse
            } //ERRO: se nenhum ponto for capturado continua soltando o botão direito do mouse            
        }
        else{
            robot.mouseRelease(InputEvent.BUTTON1_MASK); //solta o botão direito do mouse
        }*/
        if(NewJFrame.navegar.isSelected()){
            if(c>0 && l>0){ //
                if(XY_[0]!=0 && XY_[1]!=0){ //se a posição para onde o mouse deve ir for diferente de 0
                    robot.mouseMove(c,l); //move o mouse para as coordenadas c,l 
                    robot.mousePress(InputEvent.BUTTON1_MASK); //efetua o clique do botão direito do mouse
                    robot.mouseRelease(InputEvent.BUTTON1_MASK); //solta o botão direito do mouse
                    //System.out.printf("X=%d, Y=%d\n",c,l);
                }
               /* else{
                robot.mouseRelease(InputEvent.BUTTON1_MASK); //solta o botão direito do mouse
                } //ERRO: se nenhum ponto for capturado continua soltando o botão direito do mouse */           
            }
            //else{
            //    robot.mouseRelease(InputEvent.BUTTON1_MASK); //solta o botão direito do mouse
            //}
        }
        
        if(NewJFrame.pintar.isSelected()){
            if(c>0 && l>0){ //
                   if(XY_[0]!=0 && XY_[1]!=0){ //se a posição para onde o mouse deve ir for diferente de 0
                       robot.mouseMove(c,l); //move o mouse para as coordenadas c,l 
                       robot.mousePress(InputEvent.BUTTON1_MASK); //efetua o clique do botão direito do mouse
                       robot.mouseRelease(InputEvent.BUTTON1_MASK); //solta o botão direito do mouse
                       //System.out.printf("X=%d, Y=%d\n",c,l);
                   }
                   else{
                   robot.mouseRelease(InputEvent.BUTTON1_MASK); //solta o botão direito do mouse
                   } //ERRO: se nenhum ponto for capturado continua soltando o botão direito do mouse           
               }
               else{
                   robot.mouseRelease(InputEvent.BUTTON1_MASK); //solta o botão direito do mouse
               }
        }
    
    }
    
}
