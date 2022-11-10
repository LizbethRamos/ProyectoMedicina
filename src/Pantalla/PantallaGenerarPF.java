package Pantalla;
import Controlador.ControlGenerarPF;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PantallaGenerarPF extends JFrame implements ActionListener{
        Color blanco = new Color(255, 255, 255);
     Color gris = new Color(40, 55, 71 );
     Color rosa = new Color(235, 222, 240);
     Color azulFuerte = new Color(51, 51, 153);
     Color azulMasFuerte = new Color(0, 0, 51);
        private JButton  bAgregar,bModificar,bConsultar,bCancelar,bsalir;
        private JLabel nombre,fecha,IMC,edad,sexo, idPF,id,ex1,ex2;
        private JTextField txtNombre,txtIMC,txtEdad,txtSexo;
        private JPanel pTablas,pSuperior, pFecha, pBase , pGuardar;
        private JTextField txtFecha;
        
        private JTable tabla,tablaMed;
        private JScrollPane panelScroll,panelBase;
        private String titColumna[],titColumnaMed[];
        private String datoColumna[][];
        private String CURP="VACIO";
        private int opcion;
        ControlGenerarPF controlGenerarPF;
        private int ID;
        String TipoUsuario;
       
        
      
        public PantallaGenerarPF(){
                super("PERFIL FARMACOTERÁPEUTICO");
                this.setLocation(0, 0);
                initComponentes(0);
                this.setSize(1100, 300);
                this.setLocationRelativeTo(null);
                this.setResizable(false);
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                setVisible(true);
              
        }
        public PantallaGenerarPF(int ID){
                super("PERFIL FARMACOTERÁPEUTICO");
                   this.setLocation(0, 0);
                initComponentes(ID);
                this.setSize(1100, 300);
                this.setLocationRelativeTo(null);
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                setVisible(true);

              
        }

        public ControlGenerarPF getMiControladorGenerarPF() {
                return controlGenerarPF;
        }

        public void setMiControladorGenerarPF(ControlGenerarPF miControladorGenerarPF) {
                this.controlGenerarPF = miControladorGenerarPF;
        }
         
         public void initComponentes(int IDD){               
                Color azulFuerte = new Color(51, 51, 153);
                txtFecha = new JTextField();
               idPF=new JLabel("   ID Perfil Farmacoterapéutico");
                idPF.setFont(new Font("Nunito Sans",0, 12));
                 id=new JLabel(""+(IDD+1));
                id.setFont(new Font("Nunito Sans",0, 12));
                ex1=new JLabel("");
                ex2=new JLabel("");
                nombre=new JLabel("                                                                       Nombre: ");
                nombre.setFont(new Font("Nunito Sans",0, 12));
                IMC=new JLabel("                                                                               IMC:");
                IMC.setFont(new Font("Nunito Sans",0, 12));
                edad = new JLabel("                                                                             Edad:");
                edad.setFont(new Font("Nunito Sans",0, 12));
                sexo=new JLabel("                                                                          Sexo:");
                sexo.setFont(new Font("Nunito Sans",0, 12));
                fecha=new JLabel("                                     Fecha:");
                fecha.setFont(new Font("Nunito Sans",0, 12));
                txtNombre= new JTextField("");
                txtIMC= new JTextField("");
                txtEdad= new JTextField("");
                txtSexo= new JTextField("");
                pFecha = new JPanel(new GridLayout(0,6));
                pFecha.setBackground(rosa);
                
                pFecha.add(idPF);
                pFecha.add(id);
                pFecha.add(ex1);
                pFecha.add(ex2);
                pFecha.add(fecha);
                pFecha.add(txtFecha);
                pSuperior = new JPanel(new GridLayout(2,20));
                pSuperior.setBackground(rosa);
                pSuperior.add(nombre);
                pSuperior.add(txtNombre);
                pSuperior.add(edad);
                pSuperior.add(txtEdad);
                pSuperior.add(sexo);
                pSuperior.add(txtSexo);
                pSuperior.add(IMC);
                pSuperior.add(txtIMC);
         
                pGuardar = new JPanel();
                pGuardar.setBackground(rosa);
                
                bAgregar = new JButton("Guardar y Salir");
                bAgregar.setFont(new Font("Nunito Sans",0, 14));
                bAgregar.setBackground(blanco);
                //bAgregar.setBorder(new Boton(15));
             
                bModificar = new JButton("Modificar y Salir");
                bModificar.setFont(new Font("Nunito Sans",0, 14));
                bModificar.setBackground(blanco);
               // bModificar.setBorder(new Boton(15));
           
                bConsultar = new JButton("Consultar y Salir");
                bConsultar.setFont(new Font("Nunito Sans",0, 14));
                bConsultar.setBackground(blanco);
               // bConsultar.setBorder(new Boton(15));
                
                bCancelar = new JButton("Cancelar y Salir");
                bCancelar.setFont(new Font("Nunito Sans",0, 14));
                bCancelar.setBackground(blanco);
               // bCancelar.setBorder(new Boton(15));
                
                DeshabilitarBotones();
                pGuardar.add(bAgregar);
                pGuardar.add(bModificar);
                pGuardar.add(bConsultar);
                pGuardar.add(bCancelar);
                
        
                pBase = new JPanel(new BorderLayout());
                pBase.add(pFecha, BorderLayout.NORTH);
                pBase.add(pSuperior);
                CreaColumnas();
                CargaDatos();
                // Creamos una instancia del componente Swing
                tabla = new JTable( datoColumna,titColumna );
                
                // Aquí se configuran algunos de los parámetros que permite 
                // variar la JTable
                tabla.setShowHorizontalLines( true );
                tabla.setRowSelectionAllowed( true );
                tabla.setColumnSelectionAllowed( true );
                // Cambiamos el color de la zona seleccionada (rojo/blanco)
                tabla.setSelectionForeground( Color.white );
                tabla.setSelectionBackground( azulFuerte );
                tabla.setBounds(1, 100, 620, 500);
                // Incorporamos la tabla a un panel que incorpora ya una barra
                // de desplazamiento, para que la visibilidad de la tabla sea
                // automática
                panelScroll = new JScrollPane( tabla );
                pTablas = new JPanel(new GridLayout(1,1));
      
               pTablas.add(panelScroll);
                add(pBase,BorderLayout.NORTH);
                add( pTablas,BorderLayout.CENTER);
                add(pGuardar, BorderLayout.SOUTH);
            
                bAgregar.addActionListener((ActionEvent e) -> {
                        
                  if(controlGenerarPF.agregarPF(getCURP(),id.getText(),txtFecha.getText()+"",txtIMC.getText())){
                  int j=0;
                   int resp;
                   resp=  controlGenerarPF.validarDatosTabla(tabla,j);
                   while(resp==0){
                        for( int iX=0; iX <8; iX++ ) 
                              datoColumna[j][iX]=  (String) (tabla.getModel().getValueAt(j, iX));
                        controlGenerarPF.Medicamento(getCURP(),id.getText(),datoColumna[j][0],datoColumna[j][1],datoColumna[j][2],datoColumna[j][3],datoColumna[j][4],datoColumna[j][5],datoColumna[j][6],datoColumna[j][7],j);
                        j++;
                        resp=controlGenerarPF.validarDatosTabla(tabla,j);
                   }     
                   if(resp<8) 
                       JOptionPane.showMessageDialog(null,"EL "+(j+1)+" MEDICAMENTO NO SE GURADO YA QUE FALTA INFROMACÓN");
                   
                   JOptionPane.showMessageDialog(null,"Pefil  Agregado a la Base de Datos");
                  }else
                           JOptionPane.showMessageDialog(null,"Pefil No Agregado a la Base de Datos");
                  cerrar();
                    
                 });
                
                bModificar.addActionListener((ActionEvent e) -> {

                  if(  controlGenerarPF.modificarPF(getCURP(),id.getText(),txtFecha.getText())  ){
                        int j=0;
                         int resp;
                         resp=  controlGenerarPF.validarDatosTabla(tabla,j);
                         while(resp==0){
                              for( int iX=0; iX <8; iX++ ) 
                                    datoColumna[j][iX]=  (String) (tabla.getModel().getValueAt(j, iX));
                              controlGenerarPF.modificarMedicamento(getCURP(),id.getText(),datoColumna[j][0],datoColumna[j][1],datoColumna[j][2],datoColumna[j][3],datoColumna[j][4],datoColumna[j][5],datoColumna[j][6],datoColumna[j][7],j);
                              j++;
                              resp=controlGenerarPF.validarDatosTabla(tabla,j);
                         }     
                         if(resp<8) 
                             JOptionPane.showMessageDialog(null,"EL "+(j+1)+" MEDICAMENTO NO SE GURADO YA QUE FALTA INFROMACÓN");

                         JOptionPane.showMessageDialog(null,"Pefil  Modificado en la Base de Datos");
                  }else
                           JOptionPane.showMessageDialog(null,"Pefil No Modificado en la Base de Datos");
                  cerrar();
                });

                bCancelar.addActionListener((ActionEvent e) -> {
                        
                        if(bCancelar.getText()=="SALIR")
                                cerrar();
                        else
                                cancelar();
                });
                
         
        }
        public void cancelar(){
                int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro ?", "confirmación cancelar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if(respuesta != 1){
                    this.dispose();
                     controlGenerarPF.getControlBuscarPF().mostrarIBuscarPF();
                }
   }
     
      public void cerrar(){
  
                    this.dispose();
                     controlGenerarPF.getControlBuscarPF().mostrarIBuscarPF();
                
   }
      public void HabilitarBotones(){
              switch(opcion){
                      case 0:
                              bAgregar.setVisible(true);
                              break;
                      case 1:
                              bModificar.setVisible(true);
                              break;
                     case 2:
                           
                             bCancelar.setText("SALIR");
                              break;
              }
      }
      public void DeshabilitarBotones(){
                 bAgregar.setVisible(false);
                 bModificar.setVisible(false);
                 bConsultar.setVisible(false);
      }
  public void CreaColumnas() {
          titColumna = new String[8];
          titColumna[0] = "INICIO";
          titColumna[1] = "PROBLEMAS DE SALUD";
          titColumna[2] = "CONTROLADO";
          titColumna[3] = "GRAVEDAD";
          titColumna[4] = "MEDICAMENTO";
          titColumna[5] = "DOSIS";
          titColumna[6] = "DURACION";
          titColumna[7] = "PRESCRITA";
  
     
    
  }
  public void CargaDatos() {
    datoColumna = new String[20][8];

  }

    
      public void IniciarPantalla(ResultSet respuesta,int op){
              switch(op){
                      case 0://generar modificar
                                String curp = null ;
                                        try {
                                                while(respuesta.next()){
                                                         curp = respuesta.getString("CURP");
                                                         txtNombre.setText(respuesta.getString("NOMBRE"));
                                                          txtEdad.setText(respuesta.getFloat("EDAD")+"");
                                                          txtSexo.setText(respuesta.getString("SEXO"));
                                                }
                                               float peso=controlGenerarPF.peso(curp);
                                               float estatura=controlGenerarPF.estatura(curp);
                                               float imc=controlGenerarPF.IMC(peso, estatura);
                                               txtIMC.setText(imc+"");
                                                controlGenerarPF.cerrarConexio();
                                           } catch (SQLException ex) {
                                                   Logger.getLogger(ControlGenerarPF.class.getName()).log(Level.SEVERE, null, ex);
                                           }
                              break;
                      case 1:
                                try {//modificar
                                                int i=0;
                                                while(respuesta.next()){
                                                     tabla.getModel().setValueAt(respuesta.getString("INICIO"),i,0);
                                                     tabla.getModel().setValueAt(respuesta.getString("PROBLEMA"),i,1);
                                                     tabla.getModel().setValueAt(respuesta.getString("CONTROLADO"),i,2);
                                                     tabla.getModel().setValueAt(respuesta.getString("GRAVEDAD"),i,3);
                                                     tabla.getModel().setValueAt(respuesta.getString("MEDICAMENTO"),i,4);
                                                     tabla.getModel().setValueAt(respuesta.getString("DOSIS"),i,5);
                                                     tabla.getModel().setValueAt(respuesta.getString("DURACION"),i,6);
                                                     tabla.getModel().setValueAt(respuesta.getString("PRESCRITA"),i,7);
                                                     i++;
                                                }
                                        
                                                controlGenerarPF.cerrarConexio();
                                           } catch (SQLException ex) {
                                                   Logger.getLogger(ControlGenerarPF.class.getName()).log(Level.SEVERE, null, ex);
                                           }
                                break;
                      case 2:
                                try {
                                                while(respuesta.next()){
                                                         curp = respuesta.getString("CURP");
                                                         txtFecha.setText(respuesta.getString("FECHA"));
                                                         id.setText(respuesta.getInt("ID_PF")+"");
                                                        
                                                }
                                                controlGenerarPF.cerrarConexio();
                                           } catch (SQLException ex) {
                                                   Logger.getLogger(ControlGenerarPF.class.getName()).log(Level.SEVERE, null, ex);
                                           }
                              break;
                }
 }
  
        public String getCURP() {
                return CURP;
        }

        public int getOpcion() {
                return opcion;
        }

        public void setOpcion(int opcion) {
                this.opcion = opcion;
        }

        public void setCURP(String CURP) {
                System.out.println(CURP);
                this.CURP = CURP;
        }
     
       
        @Override
        public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } 
          public void modificarBotones(Boolean modificarBotones){
                  
          }
           public int regresarID() {
                return ID;
        }

        public void setID(int ID) {
                System.out.println("sett .: "+ID);
                this.ID = ID;
        }
}