package Pantalla;
import Controlador.ControlGenerarEx;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class PantallaGenerarExpedienteCirugias extends JFrame {
    
    private JTable jTablaCirugias;
    private JScrollPane  panelScroll;
    private JLabel EtiquetaCirugias, EtiquetaCirugias1, EtiquetaCirugias2;
    private JPanel jPanelBase;
    private JButton jButtonCancelar, jButtonGuardar;
    private String titColumna[], datoColumna[][];
    private ControlGenerarEx controladorRegistro;
    int opcion, id;
    String curp; 
    
    //Colores
    Color blanco = new Color(255, 255, 255);
    Color gris = new Color(40, 55, 71 );
    Color rosa = new Color(235, 222, 240);
    Color azulFuerte = new Color(51, 51, 153);
    Color azulMasFuerte = new Color(0, 0, 51);
    
    public PantallaGenerarExpedienteCirugias(){
        this.setSize(620, 500);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setTitle("Cirugías");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(false);
        init();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }
    
    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }
    public ControlGenerarEx getControladorRegistro() {
        return controladorRegistro;
    }

    public void setControladorRegistro(ControlGenerarEx controladorRegistro) {
        this.controladorRegistro = controladorRegistro;
    }
    
    public void init(){
        
        Panel();
        CreaColumnas();
        CargaDatos();
        tabla();
        colocarEtiquetas();
        colocarBotones();     

        jButtonGuardar.addActionListener((ActionEvent e) -> {
            int j=0;
            int resp;
            switch(getOpcion()){
                case 0://agregar
                    
                    resp =  controladorRegistro.validarDatosTabla(jTablaCirugias, j, 3);
                    while(resp==0){
                       for( int iX=0; iX <3; iX++ ) 
                            datoColumna[j][iX]=  (String) (jTablaCirugias.getModel().getValueAt(j, iX));
                        controladorRegistro.agregarExpedienteCirugias(datoColumna[j][0],datoColumna[j][1], datoColumna[j][2], getCurp(), (j+1));
                        j = j+1;
                        resp = controladorRegistro.validarDatosTabla(jTablaCirugias, j, 3);
                    }     
                    if(resp<3){
                        JOptionPane.showMessageDialog(null,"LA "+(j+1)+" CIRUGIA NO SE GUARDADO YA QUE FALTA INFORMACÓN");
                        
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Cirugia Agregada a la Base de Datos");
                    regresar(2); 
                    break;
                case 1://modifica
                    resp=  controladorRegistro.validarDatosTabla(jTablaCirugias, j, 3);
                    while(resp==0){
                        for( int iX=0; iX <3; iX++ ) 
                            datoColumna[j][iX]=  (String) (jTablaCirugias.getModel().getValueAt(j, iX));
                        controladorRegistro.modificarExpedienteCirugias(datoColumna[j][0],datoColumna[j][1], datoColumna[j][2], getCurp(), (j+1));
                        j++;
                        resp=controladorRegistro.validarDatosTabla(jTablaCirugias, j, 3);
                    }     
                    if(resp<3){
                        JOptionPane.showMessageDialog(null,"LA "+(j+1)+" CIRUGIA NO SE HA MODIFICADO YA QUE FALTA INFORMACIÓN");
                    }else
                        JOptionPane.showMessageDialog(null,"Cirugia modificada en la Base de Datos");
                    regresar(2); 
                    break;
                case 2://consultar
                    
                    regresar(3);
                    break;
            }
        });
           
        jButtonCancelar.addActionListener((ActionEvent e) -> {
            regresar(1);
        });
        
    }
    
    public void Panel(){
        jPanelBase =new JPanel();
        jPanelBase.setLayout(null);
        jPanelBase.setBackground(rosa);
        this.getContentPane().add(jPanelBase);//se agrega el panel a la ventana
       }
    public void  CreaColumnas(){
       titColumna = new String[3];
       titColumna[0] = "Fecha:";
       titColumna[1] = "Cirugia";
       titColumna[2] = "Hospital donde se realizo:";

   }
    public void CargaDatos(){
         datoColumna = new String[5][3];
   }
    public void tabla(){

    Color azulFuerte = new Color(51, 51, 153);
    CreaColumnas();
    CargaDatos();
    jTablaCirugias=new JTable(datoColumna, titColumna);
    jTablaCirugias.setShowHorizontalLines( true );
    jTablaCirugias.setRowSelectionAllowed( true );
    jTablaCirugias.setColumnSelectionAllowed( true );
    // Cambiamos el color de la zona seleccionada (rojo/blanco)
    jTablaCirugias.setSelectionForeground( Color.white );
    jTablaCirugias.setSelectionBackground( azulFuerte );
    jTablaCirugias.setBounds(33, 100, 540, 80);
    panelScroll = new JScrollPane(jTablaCirugias);
    jPanelBase.add(panelScroll);
    jPanelBase.add(jTablaCirugias);


   }
    private void colocarEtiquetas(){
         //___________________Etiqueta de texto_____________
        EtiquetaCirugias= new JLabel("Fecha:",SwingConstants.CENTER);//se crea una etiqueta
        EtiquetaCirugias.setOpaque(true);//damos permiso a la etiqueta
        EtiquetaCirugias.setBounds(33, 73,180,30);
       // EtiquetaAlergia.setBackground(blanco);
        EtiquetaCirugias.setFont(new Font("Nunito Sans",0, 12));
        jPanelBase.add(EtiquetaCirugias);
        //__________________________________________________________________________
        EtiquetaCirugias1 = new JLabel("Cirugia:",SwingConstants.CENTER);//se crea una etiqueta
        EtiquetaCirugias1.setOpaque(true);//damos permiso a la etiqueta
        EtiquetaCirugias1.setBounds(213, 73,180,30);
       // EtiquetaAlergia.setBackground(blanco);
        EtiquetaCirugias1.setFont(new Font("Nunito Sans",0, 12));
        jPanelBase.add(EtiquetaCirugias1);
         //__________________________________________________________________________
        EtiquetaCirugias2 = new JLabel("Hospital donde se",SwingConstants.CENTER);//se crea una etiqueta
        EtiquetaCirugias2.setOpaque(true);//damos permiso a la etiqueta
        EtiquetaCirugias2.setBounds(393, 73,180,15);
       // EtiquetaAlergia.setBackground(blanco);
        EtiquetaCirugias2.setFont(new Font("Nunito Sans",0, 12));
        jPanelBase.add(EtiquetaCirugias2);
        EtiquetaCirugias2 = new JLabel("realizo la operacion:",SwingConstants.CENTER);//se crea una etiqueta
        EtiquetaCirugias2.setOpaque(true);//damos permiso a la etiqueta
        EtiquetaCirugias2.setBounds(393, 87,180,12);
       // EtiquetaAlergia.setBackground(blanco);
        EtiquetaCirugias2.setFont(new Font("Nunito Sans",0, 12));
        jPanelBase.add(EtiquetaCirugias2);
          
    }
    
    private void colocarBotones(){
        jButtonCancelar = new JButton("Cancelar"); 
        jButtonCancelar.setEnabled(true);
        jButtonCancelar.setBounds(290, 250, 120, 30);
        jButtonCancelar.setFont(new Font("Nunito Sans",1, 12));
        jButtonCancelar.setBackground(Color.WHITE);
        jPanelBase.add(jButtonCancelar);
        
        
        jButtonGuardar = new JButton("Guardar"); 
        jButtonGuardar.setEnabled(true);
        jButtonGuardar.setBounds(450, 250, 120, 30);
        jButtonGuardar.setFont(new Font("Nunito Sans",1, 12));
        jButtonGuardar.setBackground(Color.WHITE);
        jPanelBase.add(jButtonGuardar); 
    }
    
    public void mostrar(){
        this.setVisible(true);
    }
    
    public void regresar(int opcion){

        switch(opcion){
            case 0:
                JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
                this.dispose();
                controladorRegistro.mostrarDatosGenerales();
                break;
            case 1:
                
                int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro?", "confirmación cancelar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if(respuesta != 1){
                    this.dispose();           
                    controladorRegistro.mostrarDatosGenerales(); 
                }
                break;
            case 2:
                this.dispose();
                controladorRegistro.mostrarDatosGenerales();
                break;
            case 3:
                this.dispose();
                controladorRegistro.mostrarDatosGenerales();
            break;
        }
    }
     public void Consultar(int op){
        
        if(op==2){
                
                jButtonCancelar.setVisible(false);
                jButtonGuardar.setText("Salir");
        }
                
    }
    public void IniciarPantalla(ResultSet respuesta){
              Consultar(getOpcion());
    int i=0;
        try {
            while(respuesta.next()){
                jTablaCirugias.getModel().setValueAt(respuesta.getString("FECHA"),i,0);
                jTablaCirugias.getModel().setValueAt(respuesta.getString("CIRUGIA"),i,1);
                jTablaCirugias.getModel().setValueAt(respuesta.getString("HOSPITAL"),i,2);
                i++;
            }   } catch (SQLException ex) {
            Logger.getLogger(PantallaGenerarExpedienteCirugias.class.getName()).log(Level.SEVERE, null, ex);
        }
    controladorRegistro.cerrarConexio();
}
    
    
}