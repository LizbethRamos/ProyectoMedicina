package Controlador;
import BaseDatos.Conexion;
import Pantalla.PantallaLogin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ControlLoggin {
       private PantallaLogin pantallaLoggin;
       ControlBuscarEx controlBuscarEx;
       ControlBuscarPF controlBuscarPF;
       ControlInicio controlInicio;
       ControlGenerarEx controlRegistro;
       ControlGenerarPF controlGenerarPF;
       Conexion conexion;
       String TipoUsuario;
        String clues;
        public Conexion getConexion() {
                return conexion;
        }

        public void setConexion(Conexion conexion) {
                this.conexion = conexion;
        }

        public String getClues() {
                return clues;
        }

        public void setClues(String clues) {
                this.clues = clues;
        }
       
        
    public PantallaLogin getPantallaLoggin() {
        return pantallaLoggin;
    }

    public void setPantallaLoggin(PantallaLogin pantallaLoggin) {
        this.pantallaLoggin = pantallaLoggin;
    }

        public ControlBuscarEx getControlBuscarEx() {
                return controlBuscarEx;
        }

        public void setControlBuscarEx(ControlBuscarEx controlBuscarEx) {
                this.controlBuscarEx = controlBuscarEx;
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
        
        public void ocultarPantlla(){
                pantallaLoggin.ocultar();
        }
        
        public void mostrarPantalla(){
                pantallaLoggin.mostrar();
        }
         public Boolean validarLoggin(String clues,String password, String cedula){
                ResultSet respuesta;
                Boolean res = null;
                
             
                if(validarCLUES(clues)  && ValidarCedula(cedula) && ValidarPassword(password)){
                        int i=0;
                        int tipoUsuario = -1;
                        int CEDULA_PROFESIONAL = Integer.parseInt(cedula);
                        String sql="select * from usuarios where CEDULA_PROFECIONAL="+CEDULA_PROFESIONAL+" and PASSWORD='"+password+"' and CLUES='"+clues+"'";
                        try {
                                conexion.conectar();
                                respuesta=conexion.obtenerDatos(sql);
                               while(respuesta.next()){
                                         i++;
                                         tipoUsuario=respuesta.getInt("TIPO_USUARIO");
                                         clues = respuesta.getString("CLUES");
                                    }  
                                 conexion.Off();
                                 res = i==1;
                                TipoUsuario(tipoUsuario);
                                 setClues(clues);
                                 
                                 
                        } catch (SQLException ex) {
                             res=false; 
                             Logger.getLogger(ControlLoggin.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }else 
                        res=false;
            return res;
    }
         public boolean ValidarCedula(String cedula){

        String numeros = "1234567890";
         if(cedula.length()!=8){
             return false;
         }else{
          for (int i=0; i<cedula.length(); i++) {
              char c = cedula.charAt(i);
              if(!numeros.contains(c+"")){
                  return false;
              }
            }
         }
         return true;
    } 
    
        public boolean ValidarPassword(String password){
        String Letras = "01234567890qwertyuiopasdfghjklñzxcvbnmQWERTYUIOPASDFGHJKLÑZXCVBNM";
       
       if(password.length() > 16 || password.length() < 1){
         return false;
       }
       else{
        for (int i=0; i < password.length(); i++) {
                char c = password.charAt(i);
                if(!Letras.contains(c+"") )
                  return false;
              }
       }
      
     return true;   
   }
         public boolean validarCLUES(String clues){
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "1234567890";
        if(clues.length() != 11){
            return false;
        }
        else{
            for(int i = 0; i < clues.length(); i++){
                char c = clues.charAt(i);
                if(i <= 4 ){
                    if(!letras.contains(c+"")){
                        return false;
                    }
                }
                else{
                    if(!numeros.contains(c+"")){
                        return false;
                    }
                } 
            }
        }
        return true;
    }

        public String getTipoUsuario() {
                return TipoUsuario;
        }

        public void setTipoUsuario(String TipoUsuario) {
                this.TipoUsuario = TipoUsuario;
        }
         public void TipoUsuario(int usuario){
                 switch(usuario){
                         case 1:
                                 setTipoUsuario("DOCTOR");
                                
                                 break;
                        case 2:
                                 setTipoUsuario("ENFERMERO");
                                  break;
                        case 3:
                                setTipoUsuario("FARMACEUTICO");
                                  break;
                 }
         }
         
         
         public void cerrar(){
            try {
                    conexion.Off();
            } catch (SQLException ex) {
                    Logger.getLogger(ControlLoggin.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
    
}
