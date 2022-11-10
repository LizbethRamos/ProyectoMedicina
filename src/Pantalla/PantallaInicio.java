
package Pantalla;

import Controlador.ControlInicio;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class PantallaInicio extends JFrame {
    
    //Colores
     Color blanco = new Color(255, 255, 255);
     Color gris = new Color(40, 55, 71 );
     Color rosa = new Color(235, 222, 240);
     Color azulFuerte = new Color(51, 51, 153);
     Color azulMasFuerte = new Color(0, 0, 51);

    JPanel Panel;
    JLabel Etiqueta;
    JButton BotonEx;
    JButton BotonPF;
    JButton BotonSalir;
    RoundedBorder Bordear;
    ControlInicio controlInicio;
  

    public ControlInicio getInicio() {
        return controlInicio;
    }

    public void setInicio(ControlInicio Inicio) {
        this.controlInicio = Inicio;
    }
    
    public PantallaInicio(){
        setSize(620,500);
        this.setResizable(false);
        setTitle("CONME");
        setLocationRelativeTo(null);
        Iniciarcomponentes();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
     private void Iniciarcomponentes(){
       crearPanele();
       colocarBotones();
       crearEtiqueta();
    }
    private void crearPanele(){
        Panel =new JPanel();
        Panel.setLayout(null);
       Panel.setBackground(rosa);
        this.getContentPane().add(Panel);
    }
    private void crearEtiqueta(){
  
        Etiqueta = new JLabel("Seleccione el menú que dese ingresar: ",SwingConstants.CENTER);
        Etiqueta.setOpaque(true);
        Etiqueta.setBounds(180, 70,250,30);
      Etiqueta.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Etiqueta.setBackground(Color.WHITE);
        Etiqueta.setFont(new Font("Nunito Sans",0,12));
        Panel.add(Etiqueta);
}
   
      private void colocarBotones(){
        BotonEx =new JButton ();
        BotonEx.setEnabled(true);
        ImageIcon clik = new ImageIcon("E:\\ProyectoIngenieria de software\\Proyecto\\PROYECTO_IS\\src\\Recursos\\Expedientes.jpg");
        BotonEx.setBounds(80,150,200,128);
        BotonEx.setIcon(new ImageIcon(clik.getImage().getScaledInstance(200, 128, Image.SCALE_SMOOTH)));
        //BotonEx.setBorder(new RoundedBorder(20));
        Panel.add(BotonEx);
        BotonEx.setToolTipText("Expediente Medico");
        //_________________________________ 
        BotonPF=new JButton ();
        BotonPF.setEnabled(true);
        ImageIcon clik1 = new ImageIcon("E:\\ProyectoIngenieria de software\\Proyecto\\PROYECTO_IS\\src\\Recursos\\Perfiles.jpg");
        BotonPF.setBounds(330,150,200,128);
        BotonPF.setIcon(new ImageIcon(clik1.getImage().getScaledInstance(200, 128, Image.SCALE_SMOOTH)));
        //BotonPF.setBorder(new RoundedBorder(20));
        Panel.add(BotonPF);
        BotonPF.setToolTipText("Perfil-Farmacoterapeutico");
        //_________________________________
        BotonSalir = new JButton("Cerrar sesión");
       // BotonSalir.setBackground(gris);
        BotonSalir.setBounds(100, 320, 100, 30);
        BotonSalir.setEnabled(true);
        BotonSalir.setBackground(blanco);
        BotonSalir.setFont(new Font("Nunito Sans",0, 10));
       // BotonSalir.setBorder(new RoundedBorder(20));
        BotonSalir.setToolTipText("Cerrar sesiónr");
        
        Panel.add(BotonSalir);
        oyenteEventodeRaton();

     }
                 
       private void oyenteEventodeRaton(){
        //agregando oyente de Expediente Medico
        MouseListener Raton = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    cerrar();
                    controlInicio.getControlBuscarEx().mostrarIBuscarEx();
            }
             
            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        BotonEx.addMouseListener(Raton);
        
         //agregando oyente de Perfil Farmacoterapeutico
        MouseListener Raton1 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    cerrar();
                     controlInicio.getControlBuscarPF().mostrarIBuscarPF();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        BotonPF.addMouseListener(Raton1);
        //agregando oyente de Expediente Medico
        MouseListener Raton2 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                   
                    cerrar();
                    
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        BotonSalir.addMouseListener(Raton2);
        
       
    }
     public void cerrar(){
         this.dispose();
     }
     
        public void mostrar() {
                this.setVisible(true);
        }
     
    
       
}
