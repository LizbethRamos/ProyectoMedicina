package Pantalla;
import Controlador.ControlGenerarEx;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class PantallaGenerarExpedienteAlergias extends JFrame {
    private ControlGenerarEx controladorRegistro;;
    private String curp;
    private int opcion, id=0;
        
    private JTable jTablaAlergias;
    JScrollPane  panelScroll;
    JLabel EtiquetaAlergia;
    JLabel EtiquetaAlergia2;
    JPanel Panel;
    private String titColumna[];
    private String datoColumna[][];
    JButton jButtonCancelar;
    JButton jButtonGuardar;
    //Colores
        Color blanco = new Color(255, 255, 255);
        Color gris = new Color(40, 55, 71 );
        Color rosa = new Color(235, 222, 240);
        Color azulFuerte = new Color(51, 51, 153);
        Color azulMasFuerte = new Color(0, 0, 51);
    
    public PantallaGenerarExpedienteAlergias(){
        this.setSize(620, 500);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setTitle("Alergias");
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
        Consultar(getOpcion());
        jButtonGuardar.addActionListener((ActionEvent e) -> {
            int j=0;
            int resp;
            switch(getOpcion()){
                case 0://agregar
                    
                    resp = controladorRegistro.validarDatosTabla(jTablaAlergias, j, 2);
                    while(resp==0){
                        for( int iX=0; iX <2; iX++ ) 
                            datoColumna[j][iX]=  (String) (jTablaAlergias.getModel().getValueAt(j, iX));
                        controladorRegistro.agregarExpedienteAlergias(datoColumna[j][0],datoColumna[j][1], getCurp(), (controladorRegistro.getControlBuscarEx().obtenerId(getCurp()) + 1));
                        j = j+1;
                        resp = controladorRegistro.validarDatosTabla(jTablaAlergias, j, 2);
                    }     
                    if(resp<2){
                        JOptionPane.showMessageDialog(null,"LA "+(j+1)+" ALERGIA NO SE GUARDADO YA QUE FALTA INFORMACÓN");
                        
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Alergia  Agregado a la Base de Datos");
                    regresar(2); 
                    break;
                case 1://modifica
                    resp=  controladorRegistro.validarDatosTabla(jTablaAlergias, j, 2);
                    while(resp==0){
                        for( int iX=0; iX <2; iX++ ) 
                            datoColumna[j][iX]=  (String) (jTablaAlergias.getModel().getValueAt(j, iX));
                        controladorRegistro.modificarExpedienteAlergias(datoColumna[j][0],datoColumna[j][1], getCurp(), (j+1));
                        j++;
                        resp=controladorRegistro.validarDatosTabla(jTablaAlergias, j, 2);
                    }     
                    if(resp<2){
                        JOptionPane.showMessageDialog(null,"LA "+(j+1)+" ALERGIA NO SE MODIFICADO YA QUE FALTA INFORMACIÓN");
                    }else
                        JOptionPane.showMessageDialog(null,"Alergia modificada en la Base de Datos");
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
        Panel =new JPanel();
        Panel.setLayout(null);
        Panel.setBackground(rosa);
        this.getContentPane().add(Panel);//se agrega el panel a la ventana
    }
    
    public void  CreaColumnas(){
           titColumna = new String[2];
           titColumna[0] = "Alergia a:";
           titColumna[1] = "Desccribir que sucede";
           
       }
    
       public void CargaDatos(){
             datoColumna = new String[10][2];
       }
       
       public void tabla(){
            
        CreaColumnas();
        CargaDatos();
        jTablaAlergias=new JTable(datoColumna, titColumna);
        jTablaAlergias.setShowHorizontalLines( true );
        jTablaAlergias.setRowSelectionAllowed( true );
        jTablaAlergias.setColumnSelectionAllowed( true );
        // Cambiamos el color de la zona seleccionada (rojo/blanco)
        jTablaAlergias.setSelectionForeground( Color.white );
        jTablaAlergias.setSelectionBackground( azulFuerte );
        jTablaAlergias.setBounds(33, 100,  540, 161);
        panelScroll = new JScrollPane(jTablaAlergias);
        Panel.add(panelScroll);
        Panel.add(jTablaAlergias);
        
        
       }

       private void colocarEtiquetas(){
         //___________________Etiqueta de texto_____________
        EtiquetaAlergia = new JLabel("Alergía a:",SwingConstants.CENTER);//se crea una etiqueta
        EtiquetaAlergia.setOpaque(true);//damos permiso a la etiqueta
        EtiquetaAlergia.setBounds(33, 80,270,20);
       // EtiquetaAlergia.setBackground(blanco);
        EtiquetaAlergia.setFont(new Font("Nunito Sans",0, 12));
        Panel.add(EtiquetaAlergia);
        
        //__________________________________________________________________________
        EtiquetaAlergia2 = new JLabel("Describir que sucede:",SwingConstants.CENTER);//se crea una etiqueta
        EtiquetaAlergia2.setOpaque(true);//damos permiso a la etiqueta
        EtiquetaAlergia2.setBounds(303, 80,270,20);
       // EtiquetaAlergia.setBackground(blanco);
        EtiquetaAlergia2.setFont(new Font("Nunito Sans",0, 12));
        Panel.add(EtiquetaAlergia2);
    }
       
    private void colocarBotones(){
        jButtonCancelar = new JButton("Cancelar"); 
        jButtonCancelar.setEnabled(true);
        jButtonCancelar.setBounds(290, 300, 120, 30);
        jButtonCancelar.setFont(new Font("Nunito Sans",1, 12));
        jButtonCancelar.setBackground(Color.WHITE);
        
        jButtonGuardar = new JButton("Guardar"); 
        jButtonGuardar.setEnabled(true);
        jButtonGuardar.setBounds(450, 300, 120, 30);
        jButtonGuardar.setFont(new Font("Nunito Sans",1, 12));
        jButtonGuardar.setBackground(Color.WHITE);
        if(getOpcion() == 2){
            jButtonGuardar.setText("Aceptar");
            jButtonCancelar.setVisible(false);
        }
        Panel.add(jButtonCancelar);
        Panel.add(jButtonGuardar);
     
    }
    
    public void mostrar(){
        this.setVisible(true);
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
                jTablaAlergias.getModel().setValueAt(respuesta.getString("Alergia"),i,0);
                jTablaAlergias.getModel().setValueAt(respuesta.getString("Descripcion"),i,1);
                i++;
            }   } catch (SQLException ex) {
            Logger.getLogger(PantallaGenerarExpedienteAlergias.class.getName()).log(Level.SEVERE, null, ex);
        }
    controladorRegistro.cerrarConexio();
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
   
}