package Pantalla;
import Controlador.ControlLoggin;
import com.placeholder.PlaceHolder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class PantallaLogin extends JFrame {
    private JPanel jPanelBase, jPanelBotones, jPanelCampos;
    private JLabel jLabelClues, jLabelContrasena, jLabelCedulaProfesional, jLabelImagen;
    private JTextField jTextClues, jTextCedulaProfesional;
    private JPasswordField jPasswordContrasena;
    private JButton jButtonIniciarSesion, jButtonImagen;
    
    private ControlLoggin controlLoggin;
    
    public PantallaLogin(){
        this.setSize(440,500);
        this.setTitle("Login");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
       
        init();
    }//Fin Constructor

    public ControlLoggin getControlLoggin() {
        return controlLoggin;
    }

    public void setControlLoggin(ControlLoggin controlLoggin) {
        this.controlLoggin = controlLoggin;
    }
    private void init(){
          //Colores
        Color blanco = new Color(255, 255, 255);
        Color rosa = new Color(235, 222, 240);
        
        //Eqtiqueta de imagen
       ImageIcon Imagen = new ImageIcon("E:\\ProyectoIngenieria de software\\Proyecto\\PROYECTO_IS\\src\\Recursos\\conmedlogo.png");
        jLabelImagen = new JLabel();
        jLabelImagen.setBounds(80,80,276,56);
        jLabelImagen.setIcon(new ImageIcon(Imagen.getImage().getScaledInstance(276,56, Image.SCALE_AREA_AVERAGING)));
        
        jButtonImagen =new JButton ();
        jButtonImagen.setEnabled(true);
        jButtonImagen.setBackground(blanco);
        ImageIcon clik = new ImageIcon("Icono1.PNG");
        jButtonImagen.setBounds(230,40,150,150);
        jButtonImagen.setIcon(new ImageIcon(clik.getImage().getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING)));
        
        // Etiqueta.setFont(new Font("arial",0,12));
        jButtonIniciarSesion = new JButton("Iniciar sesión");
        jButtonIniciarSesion.setFont(new Font("Nunito Sans",0, 10));
        jButtonIniciarSesion.setEnabled(true);
        jButtonIniciarSesion.setBackground(blanco);
        jButtonIniciarSesion.setBounds(243,370,100,30);
        
        //Campos de texto
        jTextClues = new JTextField(12); 
        jTextClues.setBounds(93, 190,250, 30);
        jTextClues.setEditable(true);
        jTextClues.setBackground(blanco);
        PlaceHolder holder1 = new PlaceHolder(jTextClues, "CLUES");
        holder1.setFont("Nunito Sans");
        
        jTextCedulaProfesional = new JTextField(15); 
        jTextCedulaProfesional.setBounds(93,250,250, 30);
        jTextCedulaProfesional.setEditable(true);
        jTextCedulaProfesional.setBackground(blanco);
        PlaceHolder holder3 = new PlaceHolder(jTextCedulaProfesional, "Cédula Profesional");
        holder3.setFont("Nunito Sans");
        
        jPasswordContrasena = new JPasswordField(30); 
        jPasswordContrasena.setBounds(93, 310,250, 30);
        jPasswordContrasena.setEditable(true);
        jPasswordContrasena.setBackground(blanco);
        PlaceHolder holder = new PlaceHolder(jPasswordContrasena, "Contraseña");
        holder.setFont("Nunito Sans");
      
        //Paneles
        jPanelBase = new JPanel();
        jPanelBase.setLayout(null);
        jPanelBase.setBackground(rosa);
        
        //Agregar todo al panel;
        jPanelBase.add(jLabelImagen);
        jPanelBase.add(jButtonIniciarSesion);
        jPanelBase.add(jPasswordContrasena);
        jPanelBase.add(jTextClues);
        jPanelBase.add(jTextCedulaProfesional);
       
        this.getContentPane().add(jPanelBase);
        jButtonIniciarSesion.addActionListener((ActionEvent e) -> {
                Boolean validar=controlLoggin.validarLoggin(jTextClues.getText(), jPasswordContrasena.getText(), jTextCedulaProfesional.getText());
                if(validar){
                        JOptionPane.showMessageDialog(null,"*BIENVENIDO "+controlLoggin.getTipoUsuario()+" *" );
                        controlLoggin.cerrar();
                        controlLoggin.getControlInicio().mostrarInicio();
                         ocultar();
              }
              else
                        JOptionPane.showMessageDialog(null,"USUARIO INCORRECTO");
          }) ;
        
        
    }
 
   
    public void mostrar(){
           
            this.setVisible(true);
    }
    
    public void ocultar(){
           this.dispose();
    }
    
}//Fin clase