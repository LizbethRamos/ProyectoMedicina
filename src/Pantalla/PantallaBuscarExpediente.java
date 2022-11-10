package Pantalla;
import Controlador.ControlBuscarEx;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;


public class PantallaBuscarExpediente extends JFrame{
    
    //Colores
        Color blanco = new Color(255, 255, 255);
        Color gris = new Color(40, 55, 71 );
        Color rosa = new Color(235, 222, 240);
        Color azulFuerte = new Color(51, 51, 153);
        Color azulMasFuerte = new Color(0, 0, 51);
        //Color Fondo=
    
    JPanel Panel;
    JLabel Etiqueta;
    JLabel EtiquetaAgregar;
    JLabel EtiquetaEliminar;
    JLabel EtiquetaConsultar;
    JLabel EtiquetaModificar;
    JTextField caja;
    JButton BotonBuscar;
    JButton BotonAgregar;
    JButton BotonModificar; 
    JButton  BotonEliminar ;
    JButton BotonConsultar;
    JButton BotonSalir;
    ControlBuscarEx controlBuscarEX;
    JScrollPane panelScroll;
         private JTable tabla;
      
        private String titColumna[];
        private String datoColumna[][];
    private String CURP;
private String TipoUsuario;
        public String getCURP() {
                return CURP;
        }

        public void setCURP(String CURP) {
                this.CURP = CURP;
        }

    public ControlBuscarEx getBuscarEX() {
        return controlBuscarEX;
    }

    public void setBuscarEX(ControlBuscarEx controlBuscarEx) {
        this.controlBuscarEX = controlBuscarEx;
    }
    public PantallaBuscarExpediente(){
        this.TipoUsuario=TipoUsuario;
        setSize(440,500);
        setTitle("Buscar Expediente Medico");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        Iniciarcomponentes();
    }
      private void Iniciarcomponentes(){
        
       Panel();
       Etiquetas();
       cajadeTexto();
       colocarBotones();
        CreaColumnas();
        CargaDatos();
        tabla();
          modificarBotones(false);
       
    }
      
     private void Panel(){
        Panel =new JPanel();
        Panel.setLayout(null);
        Panel.setBackground(rosa);
        this.getContentPane().add(Panel);//se agrega el panel a la ventana
       
    }
     private void Etiquetas(){
         //___________________Etiqueta de texto_____________
        Etiqueta = new JLabel("Digite CURP:",SwingConstants.CENTER);//se crea una etiqueta
        Etiqueta.setOpaque(true);//damos permiso a la etiqueta
        Etiqueta.setBounds(28, 30,100,20);
        
        Etiqueta.setBackground(rosa);//pintamos fondode la etiqueta
        Etiqueta.setFont(new Font("Nunito Sans",0, 10));
        Panel.add(Etiqueta);//agregamos la etiqueta al 
      
        

    }
     
     private void cajadeTexto(){
        caja = new JTextField();
        caja.setBounds(40, 60, 200, 20);
        caja.setText("");
        Panel.add(caja);
        eventosdeTeclado();
    }
     //.selltultip
     private void eventosdeTeclado(){
        KeyListener eventoTeclado = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        }; 
        caja.addKeyListener(eventoTeclado);
    }
    
    private void colocarBotones(){ 
        BotonBuscar =new JButton ();
        BotonBuscar.setEnabled(true);
        BotonBuscar.setBackground(rosa);
        ImageIcon clik = new ImageIcon("E:\\ProyectoIngenieria de software\\Proyecto\\PROYECTO_IS\\src\\Recursos\\consultar.png");
        BotonBuscar.setBounds(250,55,30,30);
        BotonBuscar.setIcon(new ImageIcon(clik.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        Panel.add(BotonBuscar);
        BotonBuscar.setBorderPainted(false);
        BotonBuscar.setToolTipText("Buscar");
        
        //____________________________________
        BotonAgregar =new JButton ();
        BotonAgregar.setEnabled(true);
        BotonAgregar.setBackground(rosa);
        ImageIcon clik1 = new ImageIcon("E:\\ProyectoIngenieria de software\\Proyecto\\PROYECTO_IS\\src\\Recursos\\agregar.png");
        BotonAgregar.setBounds(350,100 ,50, 50);
        BotonAgregar.setIcon(new ImageIcon(clik1.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        BotonAgregar.setToolTipText("Buscar");
        Panel.add(BotonAgregar); 
        BotonAgregar.setBorderPainted(false);
        BotonAgregar.setToolTipText("Agregar");
        //_____________________________________
        BotonModificar =new JButton ();
        BotonModificar.setEnabled(true);
        BotonModificar.setBackground(rosa);
        ImageIcon clik2 = new ImageIcon("E:\\ProyectoIngenieria de software\\Proyecto\\PROYECTO_IS\\src\\Recursos\\editar.png");
        BotonModificar.setBounds(350,165 ,50, 50);
        BotonModificar.setIcon(new ImageIcon(clik2.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        BotonModificar.setToolTipText("Buscar");
        Panel.add(BotonModificar); 
        BotonModificar.setBorderPainted(false);
        BotonModificar.setToolTipText("Modificar");
        //_____________________________________
        BotonEliminar =new JButton ();
        BotonEliminar.setEnabled(true);
        BotonEliminar.setBackground(rosa);
        ImageIcon clik3 = new ImageIcon("E:\\ProyectoIngenieria de software\\Proyecto\\PROYECTO_IS\\src\\Recursos\\eliminar.png");
        BotonEliminar.setBounds(350,230 , 50, 50);
        BotonEliminar.setIcon(new ImageIcon(clik3.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        BotonEliminar.setToolTipText("Buscar");
        Panel.add(BotonEliminar); 
        BotonEliminar.setBorderPainted(false);
        BotonEliminar.setToolTipText("Eliminar");
         //_____________________________________
        BotonConsultar =new JButton ();
        BotonConsultar.setEnabled(true);
        BotonConsultar.setBackground(rosa);
        ImageIcon clik4 = new ImageIcon("E:\\ProyectoIngenieria de software\\Proyecto\\PROYECTO_IS\\src\\Recursos\\Consultardoc (1).png");
        BotonConsultar.setBounds(350,295 , 50, 50);
        BotonConsultar.setIcon(new ImageIcon(clik4.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        BotonConsultar.setToolTipText("Buscar");
        Panel.add(BotonConsultar); 
        BotonConsultar.setBorderPainted(false);
        BotonConsultar.setToolTipText("Consultar");
        
        //______________________________________
        
        BotonSalir =new JButton ("Salir");
        BotonSalir.setEnabled(true);
        BotonSalir.setBackground(Color.WHITE);
        Etiqueta.setFont(new Font("Nunito Sans",0,12));
        BotonSalir.setBounds(240,410 , 100, 30);
        Panel.add(BotonSalir); 
        BotonSalir.setToolTipText("Salir");
        oyenteEventodeBoton();
    }
    private void oyenteEventodeBoton(){
                BotonBuscar.addActionListener((ActionEvent e) -> {
                                int i=0;

                                String nombre = null;
                                if(controlBuscarEX.validarTextoCURP(caja.getText())){

                                           ResultSet respuesta = controlBuscarEX.validarCURP(caja.getText());
                                           try {
                                                   while(respuesta.next()){
                                                           i++;
                                                           nombre = respuesta.getString("NOMBRE");
                                                           tabla.getModel().setValueAt(respuesta.getString("NOMBRE"),0,0);
                                                   }
                                                   controlBuscarEX.getConexion().Off();
                                                   if(i==0){
                                                       JOptionPane.showMessageDialog(null, "NO EXISTE EL EXPEDIENTE DEL PACIENTE "+caja.getText()+"  EN LA BASE DE DATOS"); 
                                                        BotonAgregar.setEnabled(true);
                                                   }
                                                   else{
                                                             JOptionPane.showMessageDialog(null, " EXPEDIENTE DEL PACIENTE: "+nombre+" \nENCONTRADO EN LA BASE DE DATOS"); 
                                                           modificarBotones(true);
                                                           BotonAgregar.setEnabled(false);
                                                           TipoUsuario(controlBuscarEX.getControlLogin().getTipoUsuario() );
                                                   }
                                           } catch (SQLException ex) {
                                                   Logger.getLogger(PantallaBuscarPF.class.getName()).log(Level.SEVERE, null, ex);
                                           }
                                }else{
                                JOptionPane.showMessageDialog(null, " CURP "+caja.getText()+" INGRESADA ES INCORRECTA"); 
                                ocultar();
                                controlBuscarEX.mostrarIBuscarEx();
                                }
                 });       
                BotonAgregar.addActionListener((ActionEvent e) -> {
                       controlBuscarEX.getControlRegistro().mostrarIGenerarEx(controlBuscarEX.getControlLogin().getClues(),caja.getText(), 0);
                                ocultar();
                                
                });
                BotonModificar.addActionListener((ActionEvent e) -> {
                                int y= tabla.getSelectedRow();
                                   int x=tabla.getSelectedColumn();
                                 if(controlBuscarEX.validarTabla(x, y, tabla)){
                                         controlBuscarEX.getControlRegistro().mostrarIModificarEx(caja.getText(), 1);
                                          ocultar();
                            
                                   }else 
                                     JOptionPane.showMessageDialog(null, "SELECCIONE AL ID A MODIFICAR "); 
                });
                BotonEliminar.addActionListener((ActionEvent e) -> {
                                int y= tabla.getSelectedRow();
                                int x=tabla.getSelectedColumn();
                                if(controlBuscarEX.validarTabla(x, y, tabla)){
                                           int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de Eliminar el Expediente.?", "confirmación eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                                        if(respuesta != 1){
                                            controlBuscarEX.getControlRegistro().eliminarExpediente(caja.getText());
                                            JOptionPane.showMessageDialog(null, "Expediente Eliminado Correctamente"); 
                                            ocultar();
                                            controlBuscarEX.mostrarIBuscarEx();
                                        }
                                }else 
                                      JOptionPane.showMessageDialog(null, "SELECCIONE AL EXPEDIENTE A ELIMINAR ");    
                 });
                BotonConsultar.addActionListener((ActionEvent e) -> {
                      int y= tabla.getSelectedRow();
                      int x=tabla.getSelectedColumn();
                      if(controlBuscarEX.validarTabla(x, y, tabla)){
                              controlBuscarEX.getControlRegistro().mostrarIConsultarEx(caja.getText(), 2);  
                              ocultar();
                        }else 
                          JOptionPane.showMessageDialog(null, "SELECCIONE AL ID A CONSULTAR "); 
                });
                BotonSalir.addActionListener((ActionEvent e) -> {
                       controlBuscarEX.getControlInicio().mostrarInicio();
                       ocultar();

                });
    }
    public void CreaColumnas() {
          titColumna = new String[1];
          titColumna[0] = "INICIO";
    }
    public void CargaDatos() {
    datoColumna = new String[1][1];

  }
 
        public void mostrar(){
            this.setVisible(true);
    }
    
        public void ocultar(){
            this.dispose();
    }
        public void tabla(){
        Color azulFuerte = new Color(51, 51, 153);
        CreaColumnas();
        
                CargaDatos();
        tabla=new JTable(datoColumna, titColumna);
        tabla.setShowHorizontalLines( true );
        tabla.setRowSelectionAllowed( true );
        tabla.setColumnSelectionAllowed( true );
        // Cambiamos el color de la zona seleccionada (rojo/blanco)
        tabla.setSelectionForeground( Color.white );
        tabla.setSelectionBackground( azulFuerte );
        tabla.setBounds(40, 100, 300, 300);
        Panel.add(tabla);
}
          public void modificarBotones(Boolean modificarBotones){
              
                BotonAgregar.setEnabled(modificarBotones);
                BotonModificar.setEnabled(modificarBotones); 
                BotonEliminar.setEnabled(modificarBotones) ;
                BotonConsultar.setEnabled(modificarBotones);
                
        }
          public void TipoUsuario(String TipoUsuario ){
                  switch(TipoUsuario){
                          case "ENFERMERO":
                                   BotonEliminar.setEnabled(false) ;
                                  break;
                           case "FARMACEUTICO":
                                        BotonAgregar.setEnabled(false);
                                        BotonModificar.setEnabled(false); 
                                        BotonEliminar.setEnabled(false) ;
                                  break;       
                          
                  }
          }
}
