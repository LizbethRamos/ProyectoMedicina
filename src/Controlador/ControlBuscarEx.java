
package Controlador;

import BaseDatos.Conexion;
import Pantalla.PantallaBuscarExpediente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;


public class ControlBuscarEx {
       ControlBuscarPF controlBuscarPF;
       ControlInicio controlInicio;
       ControlLoggin controlLogin;
       ControlGenerarEx controlGenerarEx;
       ControlGenerarPF controlGenerarPF;
       Conexion conexion;
        PantallaBuscarExpediente BuscarEx;
       
        public Conexion getConexion() {
                return conexion;
        }

        public void setConexion(Conexion conexion) {
                this.conexion = conexion;
        }
     
    public PantallaBuscarExpediente getBuscarEx() {
        return BuscarEx;
    }

    public void setBuscarEx(PantallaBuscarExpediente BuscarEx) {
        this.BuscarEx = BuscarEx;
    }

        public ControlBuscarPF getControlBuscarPF() {
                return controlBuscarPF;
        }

        public void setControlBuscarPF(ControlBuscarPF controlBuscarPF) {
                this.controlBuscarPF = controlBuscarPF;
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
                return controlGenerarEx;
        }

        public void setControlRegistro(ControlGenerarEx controlRegistro) {
                this.controlGenerarEx = controlRegistro;
        }

        public ControlGenerarPF getControlGenerarPF() {
                return controlGenerarPF;
        }

        public void setControlGenerarPF(ControlGenerarPF controlGenerarPF) {
                this.controlGenerarPF = controlGenerarPF;
        }
       
         public void mostrarIBuscarEx(){
                PantallaBuscarExpediente PantallaBuscarEx = new PantallaBuscarExpediente();
                PantallaBuscarEx.setBuscarEX(this);
                PantallaBuscarEx.setVisible(true);
        }
         public int obtenerId(String curp){
        int id = 0;
        String sql = "SELECT * FROM alergias WHERE CURP='"+curp+"' ORDER BY ID DESC LIMIT 1";
        try{
            conexion.conectar();
            ResultSet respuesta = conexion.obtenerDatos(sql);
            while(respuesta.next()){
                id = respuesta.getInt("ID");
            }
            conexion.Off();
        }catch(SQLException ex){
            Logger.getLogger(ControlGenerarEx.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
  public ResultSet validarCURP(String curp){
                ResultSet respuesta;
                boolean aux;
                if(aux=true){// validar que este escrita correctamente 
                        String sql="select * from expediente where CURP='"+curp+"'";
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
    public ResultSet validarCURP(String curp, int opcion){
        ResultSet respuesta = null;
        boolean aux;
        
        switch(opcion){
            case 0://expedientes
                if(aux=true){
                    String sql="select * from expediente where CURP='"+curp+"'";
                   int i=0;
                    try {
                        conexion.conectar();
                        respuesta = conexion.obtenerDatos(sql);
                        return respuesta;
                    } catch (SQLException ex) {
                        Logger.getLogger(ControlGenerarEx.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            break;
            case 1://alergias
                if(aux=true){
                    String sql="select * from alergias where CURP='"+curp+"'";
                       int i=0;
                    try {
                        conexion.conectar();
                        respuesta = conexion.obtenerDatos(sql);
                        return respuesta;
                    } catch (SQLException ex) {
                        Logger.getLogger(ControlGenerarEx.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 2://cirugias
                if(aux=true){
                    String sql="select * from cirugias where CURP='"+curp+"'";
                       int i=0;
                    try {
                        conexion.conectar();
                        respuesta = conexion.obtenerDatos(sql);
                        return respuesta;
                    } catch (SQLException ex) {
                        Logger.getLogger(ControlGenerarEx.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            break;
            case 3://pf
                if(aux=true){
                    String sql="select * from perfil_f where CURP='"+curp+"'";
                       int i=0;
                    try {
                        conexion.conectar();
                        respuesta = conexion.obtenerDatos(sql);
                        return respuesta;
                    } catch (SQLException ex) {
                        Logger.getLogger(ControlGenerarEx.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case 4:
                if(aux=true){
                    String sql="select * from medicamentos where CURP='"+curp+"'";
                       int i=0;
                    try {
                        conexion.conectar();
                        respuesta = conexion.obtenerDatos(sql);
                        return respuesta;
                    } catch (SQLException ex) {
                        Logger.getLogger(ControlGenerarEx.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
        }
        return null;
    }
}
