
package Controlador;

import BaseDatos.Conexion;
import Pantalla.PantallaBuscarPF;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
public class ControlBuscarPF {
        ControlBuscarEx controlBuscarEx;
       ControlInicio controlInicio;
       ControlLoggin controlLogin;
       ControlGenerarEx controlRegistro;
       ControlGenerarPF controlGenerarPF;
       Conexion conexion;
       
    PantallaBuscarPF BuscarPF;

        public Conexion getConexion() {
                return conexion;
        }

        public void setConexion(Conexion conexion) {
                this.conexion = conexion;
        }
    
    public PantallaBuscarPF getBuscarPF() {
        return BuscarPF;
    }

    public void setBuscarPF(PantallaBuscarPF BuscarPF) {
        this.BuscarPF = BuscarPF;
    }

        public ControlBuscarEx getControlBuscarEx() {
                return controlBuscarEx;
        }

        public void setControlBuscarEx(ControlBuscarEx controlBuscarEx) {
                this.controlBuscarEx = controlBuscarEx;
        }

        public ControlInicio getControlInicio() {
                return controlInicio;
        }

        public void setControlInicio(ControlInicio controlInicio) {
                this.controlInicio = controlInicio;
        }

        public ControlLoggin getControlLogin() {
                return controlLogin;
        }

        public void setControlLogin(ControlLoggin controlLogin) {
                this.controlLogin = controlLogin;
        }

        public ControlGenerarEx getControlRegistro() {
                return controlRegistro;
        }

        public void setControlRegistro(ControlGenerarEx controlRegistro) {
                this.controlRegistro = controlRegistro;
        }

        public ControlGenerarPF getControlGenerarPF() {
                return controlGenerarPF;
        }

        public void setControlGenerarPF(ControlGenerarPF controlGenerarPF) {
                this.controlGenerarPF = controlGenerarPF;
        }

     public void mostrarIBuscarPF(){
               
                PantallaBuscarPF pantallaBuscarPF = new PantallaBuscarPF();
                pantallaBuscarPF.setBuscarPF(this);
                pantallaBuscarPF.setVisible(true);
        }
     public Boolean validarExisteCURP(String curp){
                ResultSet respuesta;
                Boolean aux=false;
                if(validarTextoCURP(curp)){// validar que este escrita correctamente 
                        String sql="select * from expediente where CURP='"+curp+"'";
                           int i=0;
                        try {
                                conexion.conectar();
                                respuesta = conexion.obtenerDatos(sql);
                             while(respuesta.next()){
                                    aux=true;
                             }
                             conexion.Off();
                        } catch (SQLException ex) {
                             Logger.getLogger(ControlLoggin.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if(aux) return true;
                }
             return false;
     }
     public ResultSet validarCURP(String curp){
                ResultSet respuesta;
                boolean aux;
                if(aux=true){// validar que este escrita correctamente 
                        String sql="select * from perfil_f where CURP='"+curp+"'";
                           int i=0;
                        try {
                                conexion.conectar();
                                respuesta=conexion.obtenerDatos(sql);
                                return respuesta;
                        } catch (SQLException ex) {
                             Logger.getLogger(ControlLoggin.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
             return null;
     }
     
    public Boolean validarTabla(int x,int y, JTable tabla){
               String select;
                if(x>-1 && y>-1){
                        select= tabla.getModel().getValueAt(y, x)+"";
                        return true;
                }
                return false;
     }

     public int calcularID(String CURP){
             int id=0;
                String sql="SELECT * FROM perfil_f WHERE CURP='"+CURP+"' ORDER BY ID_PF DESC LIMIT 1";
                  try {
                          conexion.conectar();
                          ResultSet respuesta = conexion.obtenerDatos(sql);
                             while(respuesta.next()){
                                     id=respuesta.getInt("ID_PF");
                             }
                             conexion.Off();
                  } catch (SQLException ex) {
                          Logger.getLogger(ControlGenerarPF.class.getName()).log(Level.SEVERE, null, ex);
                  }
                
                return id;
     }
      public boolean validarTextoCURP(String curp){
        String caracteresValidos = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String numeros = "1234567890";
        if(curp.length()!= 18)
            return false;
        else{
            for(int i = 0; i< curp.length(); i++){
                char c = curp.charAt(i);
                if(i == 0 || i == 1 || i == 2 || i == 3 || i == 10 || i ==11 || i == 12 || i == 13 || i ==14 || i == 15){
                    if(!caracteresValidos.contains(c+""))
                        return false;
                }
                else{
                    if(!numeros.contains(c+""))
                            return false;
                }
                    
            }
        }
        return true;
    }
    
    
}
