package Controlador;

import BaseDatos.Conexion;
import Pantalla.PantallaGenerarPF;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

public class ControlGenerarPF {
           ControlBuscarEx controlBuscarEx;
           ControlInicio controlInicio;
           ControlLoggin controlLogin;
           ControlGenerarEx controlRegistro;
           ControlBuscarPF controlBuscarPF;
           PantallaGenerarPF miVista;
           Conexion conexion;
           ResultSet respuesta;
           
           
        public Conexion getConexion() {
                return conexion;
        }

        public ResultSet getRespuesta() {
                return respuesta;
        }

        public void setRespuesta(ResultSet respuesta) {
                this.respuesta = respuesta;
        }

        public void setConexion(Conexion conexion) {
                this.conexion = conexion;
        }

        public PantallaGenerarPF getMiVista() {
                return miVista;
        }

        public void setMiVista(PantallaGenerarPF miVista) {
                this.miVista = miVista;
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

        public ControlBuscarPF getControlBuscarPF() {
                return controlBuscarPF;
        }

        public void setControlBuscarPF(ControlBuscarPF controlBuscarPF) {
                this.controlBuscarPF = controlBuscarPF;
        }

         public void mostrarIGenerarPF(String CURP,int opcion, int ID) throws SQLException{
                PantallaGenerarPF PantallaGenerarPF = new PantallaGenerarPF(ID);
                PantallaGenerarPF.setMiControladorGenerarPF(this);
                PantallaGenerarPF.setVisible(true);
                
                PantallaGenerarPF.setOpcion(opcion);
                PantallaGenerarPF.setCURP(CURP);
                PantallaGenerarPF.HabilitarBotones();
                InicializarPantallaGenerar(PantallaGenerarPF,CURP);
        }
         public void mostrarIModificarPF(String CURP,int opcion,String id) throws SQLException{
                PantallaGenerarPF pantallaModificarPF = new PantallaGenerarPF();
                pantallaModificarPF.setMiControladorGenerarPF(this);
                pantallaModificarPF.setVisible(true);
            
                pantallaModificarPF.setOpcion(opcion);
                pantallaModificarPF.setCURP(CURP);
                pantallaModificarPF.HabilitarBotones();
                InicializarPantallaGenerar(pantallaModificarPF,CURP);
                InicializarPantalla(pantallaModificarPF,id,CURP);
                InicializarPantallaMED(pantallaModificarPF,id,CURP);
        }
        public void mostrarIConsultarPF(String CURP,int opcion,String id) throws SQLException{
                PantallaGenerarPF pantallaConsultarPF = new PantallaGenerarPF();
                pantallaConsultarPF.setMiControladorGenerarPF(this);
                pantallaConsultarPF.setVisible(true);
                pantallaConsultarPF.setOpcion(opcion);
                pantallaConsultarPF.setCURP(CURP);
                pantallaConsultarPF.HabilitarBotones();
                 InicializarPantallaGenerar(pantallaConsultarPF,CURP);
                InicializarPantalla(pantallaConsultarPF,id,CURP);
                InicializarPantallaMED(pantallaConsultarPF,id,CURP);
        }
        public Boolean agregarPF(String CURP,String id,String fecha,String IMC){
              
                float imc=Float.parseFloat(IMC);
                int ID=Integer.parseInt(id);
                if(validarFecha(fecha)){ 
                        String sql="insert into perfil_f(CURP,ID_PF,FECHA,IMC)"+"values('"+CURP+"',"+ID+",'"+fecha+"',"+imc+");";
                        agregarAccionBaseDatos("agregar",sql);
                        return true;
                 }
                return false;  
        }
        public void Medicamento(String CURP,String id,String inicio,String problema,String controlado,String gravedad, String medicamento,String dosis, String duracion, String preenscrita,int j){
                int IDD=Integer.parseInt(id);
                String ID=(ID_MEDICAMENTO(CURP,id,j+""));
                if(validarFecha(inicio) && validarTexto(problema) && validarTexto(controlado) && validarTexto(gravedad) && validarTexto(medicamento) && validarDosis(dosis) && validarDuracion(duracion) && validarTexto(preenscrita)){ 
                        
                        String sql="insert into medicamentos(ID_MED,CURP,ID_PF,INICIO,PROBLEMA,CONTROLADO,GRAVEDAD,MEDICAMENTO,DOSIS,DURACION,PRESCRITA)"+"values('"+ID+"','"+CURP+"',"+IDD+",'"+inicio+"','"+problema+"','"+controlado+"','"+gravedad+"','"+medicamento+"','"+dosis+"','"+duracion+"','"+preenscrita+"');";
                        agregarAccionBaseDatos("agregar",sql);
                }
                
                
        }
        
        
        public Boolean modificarPF(String CURP,String id,String fecha){
                 //mandar a validar cada cosa
                 if(validarFecha(fecha)){ 
                        int ID=Integer.parseInt(id);
                      String sql="update  perfil_f set FECHA='"+fecha+"' where ID_PF="+ID+" and CURP='"+CURP+"'";
                       agregarAccionBaseDatos("modificar",sql);
                       return true;
                 } 
                 return false;
        }
        public void modificarMedicamento(String CURP,String id,String inicio,String problema,String controlado,String gravedad, String medicamento,String dosis, String duracion, String preenscrita,int j){
                 //mandar a validar cada cosa
                String IDD=(ID_MEDICAMENTO(CURP,id,j+""));
                 int ID=Integer.parseInt(id);
               String sql="update  medicamentos set INICIO='"+inicio+"',PROBLEMA='"+problema+"',CONTROLADO='"+controlado+"',GRAVEDAD='"+gravedad+"',MEDICAMENTO='"+medicamento+"',DOSIS='"+dosis+"',DURACION='"+duracion+"',PRESCRITA='"+preenscrita+"' where ID_PF="+ID+" and CURP='"+CURP+"' and ID_MED='"+IDD+"'";
               agregarAccionBaseDatos("modificar",sql);
                
        }
        public void eliminarPF(String CURP,String id){
                int ID=Integer.parseInt(id);
                String sql="delete from perfil_f where ID_PF="+ID+" and CURP='"+CURP+"'";
               agregarAccionBaseDatos("eliminar",sql);
                
                String sql1="delete from medicamentos where CURP='"+CURP+"' and ID_PF='"+ID+"'";
                agregarAccionBaseDatos("eliminar",sql1);
        }
       
        public void InicializarPantalla(PantallaGenerarPF pantallaInicializar,String id,String CURP){
                 //mandar a validar cada cosa
                 int IDD=Integer.parseInt(id);
                String sql="select * from perfil_f where ID_PF="+IDD+" and CURP='"+CURP+"'";
                agregarAccionBaseDatos("iniciar",sql);
                
             pantallaInicializar.IniciarPantalla(respuesta,2) ;
        }
         public void InicializarPantallaMED(PantallaGenerarPF pantallaInicializar,String id,String CURP){
                 //mandar a validar cada cosa
                 int IDD=Integer.parseInt(id);
               String sql="select * from medicamentos where ID_PF="+IDD+" and CURP='"+CURP+"'";
                agregarAccionBaseDatos("iniciar",sql);
                
             pantallaInicializar.IniciarPantalla(respuesta,1) ;
        }
       public void InicializarPantallaGenerar(PantallaGenerarPF pantallaInicializar,String curp) throws SQLException{
                 //mandar a validar cada cosa
                String sql="select * from expediente where CURP='"+curp+"'";
                conexion.conectar();
                ResultSet respuesta = conexion.obtenerDatos(sql);
                
              pantallaInicializar.IniciarPantalla(respuesta,0) ;
        }
        public float peso(String curp) throws SQLException{
                float peso=0;
               String sql="select * from expediente where CURP='"+curp+"'";
               conexion.conectar();
                ResultSet respuesta = conexion.obtenerDatos(sql);
                while(respuesta.next()){
                       peso= respuesta.getFloat("PESO");
                }
                  conexion.Off();
             return peso;
        }
        public float IMC(float peso, float talla){     
        return  (peso/(talla*talla));
    }
        public float estatura(String curp) throws SQLException{
                 float estatura=0;
               String sql="select * from expediente where CURP='"+curp+"'";
               conexion.conectar();
                ResultSet respuesta = conexion.obtenerDatos(sql);
                while(respuesta.next()){
                       estatura= respuesta.getFloat("ESTATURA");
                }
                     conexion.Off();   
             return estatura;
        }
        public void agregarAccionBaseDatos(String opcion,String sql){
                switch(opcion){
                        case "agregar" :
                                try {
                                        conexion.conectar();
                                        conexion.escribir(sql);
                                        conexion.Off();
                                } catch (SQLException ex) {
                                        Logger.getLogger(ControlGenerarPF.class.getName()).log(Level.SEVERE, null, ex);
                                }
                          break;
                           case "eliminar" :
                                try {
                                       conexion.conectar();
                                        conexion.Exe(sql);
                                        conexion.Off();
                                } catch (SQLException ex) {
                                        Logger.getLogger(ControlGenerarPF.class.getName()).log(Level.SEVERE, null, ex);
                                }
                          break;
                           case "iniciar" :
                                try {
                                         conexion.conectar();
                                          respuesta = conexion.obtenerDatos(sql);
                                } catch (SQLException ex) {
                                        Logger.getLogger(ControlGenerarPF.class.getName()).log(Level.SEVERE, null, ex);
                                }
                          break;
                            case "modificar" :
                                try {
                                        conexion.conectar();
                                        conexion.actualizar(sql);
                                        conexion.Off();
                                } catch (SQLException ex) {
                                        Logger.getLogger(ControlGenerarPF.class.getName()).log(Level.SEVERE, null, ex);
                                }
                          break;
                                
                }
                
        }
    public void cerrarConexio(){
                   try {
                           conexion.Off();
                   } catch (SQLException ex) {
                           Logger.getLogger(ControlGenerarPF.class.getName()).log(Level.SEVERE, null, ex);
                   }
    }
        
    public boolean validarFecha(String fecha){
            String CaracteresValidos = "1234567890/";
            if(fecha.length() != 10)
                return false;
            else {
                for(int i = 0; i< fecha.length(); i++){
                    char c = fecha.charAt(i);
                    if(!CaracteresValidos.contains(c+"")){
                        return false;
                    }
                    if(i == 2 || i ==5 )
                        if(c != '/')
                            return false;
                }
            }
            return true;
    }
    
    public boolean validarTexto(String cadena){
        String CaracteresValidos = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZáéíóúÁÉÚÍÓ ";
        if(cadena.length() < 1)
            return false;
        else{
            for(int i = 0; i< cadena.length(); i++){
                    char c = cadena.charAt(i);
                    if(!CaracteresValidos.contains(c+""))
                           return false;
            }
        }
        return true;
    }
    
    public boolean validarDosis(String cadena){
        String CaracteresValidos = "0123456789abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZáéíóúÁÉÚÍÓ /.";
        if(cadena.length() < 1)
            return false;
        else{
            for(int i = 0; i< cadena.length(); i++){
                    char c = cadena.charAt(i);
                    if(!CaracteresValidos.contains(c+""))
                           return false;
            }
        }
        return true;
    }
    
    public boolean validarDuracion(String duracion){
        String CaracteresValidos = "0123456789abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZáéíóúÁÉÚÍÓ ";
        if(duracion.length() < 1)
            return false;
        else{
            for(int i = 0; i< duracion.length(); i++){
                    char c = duracion.charAt(i);
                    if(!CaracteresValidos.contains(c+""))
                           return false;
            }
        }
        return true;
    }
   public int validarDatosTabla(JTable tabla ,int i){
          String aux=null;
          int cont=0;
           for( int iX=0; iX <8; iX++ ) {
                aux=  (String) (tabla.getModel().getValueAt(i, iX));
                if(aux==null)
                          cont++;
                             
            }
           return cont;
   }
   public String ID_MEDICAMENTO(String curp, String id,String j){
        return curp+id+j;
    }
}


 
         