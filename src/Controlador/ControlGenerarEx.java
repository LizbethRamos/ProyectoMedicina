package Controlador;
import BaseDatos.Conexion;
import Pantalla.PantallaGenerarExpediente;
import Pantalla.PantallaGenerarExpedienteAlergias;
import Pantalla.PantallaGenerarExpedienteCirugias;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.*;
import javax.swing.*;
public class ControlGenerarEx {
    ControlBuscarEx controlBuscarEx;
    ControlBuscarPF controlBuscarPF;
    ControlInicio controlInicio;
    ControlLoggin controlLoggin;
    ControlGenerarPF controlGenerarPF;
    Conexion conexion;
    ResultSet respuesta;

    private PantallaGenerarExpedienteAlergias pantallaAlergias;
    private PantallaGenerarExpedienteCirugias pantallaCirugias;
    private PantallaGenerarExpediente pantallaDatosGenerales;

    public Conexion getConexion() {
            return conexion;
    }

    public void setConexion(Conexion conexion) {
            this.conexion = conexion;
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

    public ControlLoggin getControlLoggin() {
            return controlLoggin;
    }

    public void setControlLoggin(ControlLoggin controlLoggin) {
            this.controlLoggin = controlLoggin;
    }

    public ControlGenerarPF getControlGenerarPF() {
            return controlGenerarPF;
    }

    public void setControlGenerarPF(ControlGenerarPF controlGenerarPF) {
            this.controlGenerarPF = controlGenerarPF;
    }

    public PantallaGenerarExpedienteAlergias getPantallaAlergias() {
        return pantallaAlergias;
    }

    public void setPantallaAlergias(PantallaGenerarExpedienteAlergias pantallaAlergias) {
        this.pantallaAlergias = pantallaAlergias;
    }

    public PantallaGenerarExpedienteCirugias getPantallaCirugias() {
        return pantallaCirugias;
    }

    public void setPantallaCirugias(PantallaGenerarExpedienteCirugias pantallaCirugias) {
        this.pantallaCirugias = pantallaCirugias;
    }

    public PantallaGenerarExpediente getPantallaDatosGenerales() {
        return pantallaDatosGenerales;
    }

    public void setPantallaDatosGenerales(PantallaGenerarExpediente pantallaDatosGenerales) {
        this.pantallaDatosGenerales = pantallaDatosGenerales;
    }
    
    public void mostrarAlergias(){
        pantallaAlergias.mostrar();
    }
    
    public void mostrarCirugias(){
        pantallaCirugias.mostrar();
    }
    
    public void mostrarDatosGenerales(){
          pantallaDatosGenerales.mostrar();
    }
    //mostrar la pantalla para generar un expediente
    public void mostrarIGenerarEx(String clues, String CURP, int opcion){

        PantallaGenerarExpediente PantallaGenerarExpediente = new PantallaGenerarExpediente();
        PantallaGenerarExpediente.setControladorRegistro(this);                
        PantallaGenerarExpediente.setOpcion(opcion);
        PantallaGenerarExpediente.setCURP(CURP);  
        PantallaGenerarExpediente.setClues(clues);
        PantallaGenerarExpediente.setVisible(true);
        this.setPantallaDatosGenerales(PantallaGenerarExpediente);

    }
    //mostrar la pantalla para moificar el expediente
    public void mostrarIModificarEx(String curp, int opcion){
        PantallaGenerarExpediente pantallaModificarExpediente = new PantallaGenerarExpediente();
        pantallaModificarExpediente.setControladorRegistro(this);
        pantallaModificarExpediente.setVisible(true);                
        pantallaModificarExpediente.setOpcion(opcion);
        pantallaModificarExpediente.setCURP(curp);
        this.setPantallaDatosGenerales(pantallaModificarExpediente);
        InicializarPantalla(pantallaModificarExpediente,curp);

    }
    //Consultar la pantalla expedientes
    public void mostrarIConsultarEx(String curp, int opcion){

        PantallaGenerarExpediente pantallaConsultarExpediente = new PantallaGenerarExpediente();
        pantallaConsultarExpediente.setControladorRegistro(this);
        pantallaConsultarExpediente.setVisible(true);
        pantallaConsultarExpediente.setOpcion(opcion);
        pantallaConsultarExpediente.setCURP(curp);
        this.setPantallaDatosGenerales(pantallaConsultarExpediente);
        InicializarPantalla(pantallaConsultarExpediente,curp);
    }
    //Llenar la pantalla de expediente para modificarla
    public void InicializarPantalla(PantallaGenerarExpediente pantallaInicializar, String curp){
        String sql="select * from expediente where CURP='"+curp+"'";
        agregarAccionBaseDatos("iniciar",sql);
        pantallaInicializar.IniciarPantalla(respuesta) ;
    }
   //agrega un expediente (datos generales)
    public boolean agregarExpediente(String clues, String curp, String nombre, int edad, char sexo, String tSangre, float peso, float estatura, String estadoCivil, String nacionalidad, String direccion, int CP, String noTel){
       // System.out.println("llega: "+clues+curp+nombre+edad+sexo+tSangre+peso+estatura+estadoCivil+nacionalidad+direccion+CP+noTel);
        if(validarCodigoPostal(CP+"") && validarNumeroTelefono(noTel) && validarNombre(nombre) && validarDireccion(direccion)){ 
            String sql="insert into expediente(CLUES,CURP,NOMBRE,EDAD,SEXO,ESTADO_CIVIL,NACIONALIDAD,DIRECCION,CODIGO_POSTAL,TELEFONO,PESO,ESTATURA,TIPO_SANGRE)"+"values('"+clues+"','"+curp+"','"+nombre+"',"+edad+",'"+sexo+"','"+estadoCivil+"','"+nacionalidad+"','"+direccion+"',"+CP+",'"+noTel+"',"+peso+","+estatura+",'"+tSangre+"')";
             agregarAccionBaseDatos("agregar",sql);
            return true;
        }else     
            return false;
    }
    //modifica espediente (datos generales)
    public boolean modificarExpediente(String clues, String curp, String nombre, int edad, char sexo, String tSangre, float peso, float estatura, String estadoCivil, String nacionalidad, String direccion, int CP, String noTel){
        
        if(validarCodigoPostal(CP+"") && validarNumeroTelefono(noTel) && validarNombre(nombre) && validarDireccion(direccion)){ 
            String sql="update  expediente set CLUES='"+clues+"',CURP='"+curp+"',NOMBRE='"+nombre+"',EDAD="+edad+",SEXO='"+sexo+"',ESTADO_CIVIL='"+estadoCivil+"',NACIONALIDAD='"+nacionalidad+"',DIRECCION='"+direccion+"',CODIGO_POSTAL="+CP+",TELEFONO='"+noTel+"',PESO="+peso+",ESTATURA="+estatura+",TIPO_SANGRE='"+tSangre+"' where CURP='"+curp+"'";
            agregarAccionBaseDatos("modificar",sql);     
            return true;
        }else     
            return false;
    }
  
    //muestra la pantalla de Alergias para crearla
    public void mostrarIGenerarExAlergias(String curp, int opcion){
        PantallaGenerarExpedienteAlergias pantallaExpedienteAlergias = new PantallaGenerarExpedienteAlergias();
        pantallaExpedienteAlergias.setControladorRegistro(this);
        this.setPantallaAlergias(pantallaExpedienteAlergias);
        pantallaExpedienteAlergias.setOpcion(opcion);
        pantallaExpedienteAlergias.setCurp(curp);
        pantallaExpedienteAlergias.setVisible(true);

    }
    //muestra la pantalla de Alergias para modificarla
    public void mostrarIModificarExAlergias(String curp, int opcion){
        
        PantallaGenerarExpedienteAlergias pantallaModificarAlergias = new PantallaGenerarExpedienteAlergias();
        pantallaModificarAlergias.setControladorRegistro(this);
        this.setPantallaAlergias(pantallaModificarAlergias);
        pantallaModificarAlergias.setOpcion(opcion);
        pantallaModificarAlergias.setCurp(curp);
         pantallaModificarAlergias.setVisible(true);
        InicializarPantallaAlergias(pantallaModificarAlergias, curp);
       
    }
    //consultar la pantalla alergias
    public void mostrarIConsultarExAlergias(String curp, int opcion){

        PantallaGenerarExpedienteAlergias pantallaConsultarAlergias = new PantallaGenerarExpedienteAlergias();
        pantallaConsultarAlergias.setControladorRegistro(this);
        this.setPantallaAlergias(pantallaConsultarAlergias);
        pantallaConsultarAlergias.setOpcion(opcion);
        pantallaConsultarAlergias.setCurp(curp);
        pantallaConsultarAlergias.setVisible(true);
        InicializarPantallaAlergias(pantallaConsultarAlergias, curp);
        
    }
    //Llenar la pantalla de Alergias para modificarla
    public void InicializarPantallaAlergias(PantallaGenerarExpedienteAlergias pantallaInicializar, String curp){
        String sql="select * from alergias where CURP='"+curp+"'";
        agregarAccionBaseDatos("iniciar",sql);
        pantallaInicializar.IniciarPantalla(respuesta);
    }
    //agrega un expediente (datos Alergias)
    public boolean agregarExpedienteAlergias(String alergia, String descripcion,String curp, int id){
        if(validarAlergia(alergia) && validarDescripcion(descripcion)){ 
            String sql="insert into alergias(Alergia,Descripcion,CURP,ID)"+"values('"+alergia+"','"+descripcion+"','"+curp+"',"+id+")";
            agregarAccionBaseDatos("agregar",sql);
            return true;
        }else     
            return false;
    }
    //modifica expediente (datos Alergias)
    public boolean modificarExpedienteAlergias(String alergia, String descripcion,String curp, int id){
        
        if(validarAlergia(alergia)&&validarDescripcion(descripcion)){ 
            String sql="update  alergias set Alergia='"+alergia+"',Descripcion='"+descripcion+"' where CURP='"+curp+"' and ID="+id+"";
            agregarAccionBaseDatos("modificar",sql);     
            return true;
        }else     
            return false;
    }
 
    //muestra la pantalla de Cirugias para crearla
    public void mostrarIGenerarExCirugias(String curp, int opcion){
            
        PantallaGenerarExpedienteCirugias pantallaExpedienteCirugias = new PantallaGenerarExpedienteCirugias();
        pantallaExpedienteCirugias.setControladorRegistro(this);
        this.setPantallaCirugias(pantallaExpedienteCirugias);
        pantallaExpedienteCirugias.setOpcion(opcion);
        pantallaExpedienteCirugias.setCurp(curp);
        pantallaExpedienteCirugias.setVisible(true);
    }
    //muestra la pantalla de Cirugias para modificarla
    public void mostrarIModificarExCirugias(String curp, int opcion){
        
        PantallaGenerarExpedienteCirugias pantallaModificarCirugias = new PantallaGenerarExpedienteCirugias();
        pantallaModificarCirugias.setControladorRegistro(this);
        this.setPantallaCirugias(pantallaModificarCirugias);
        pantallaModificarCirugias.setOpcion(opcion);
        pantallaModificarCirugias.setCurp(curp);
         pantallaModificarCirugias.setVisible(true);
        InicializarPantallaCirugias(pantallaModificarCirugias, curp);
       
    }
    //consultar la patalla Cirugias
    public void mostrarIConsultarExCirugias(String curp, int opcion){

        PantallaGenerarExpedienteCirugias pantallaConsultarCirugias = new PantallaGenerarExpedienteCirugias();
        pantallaConsultarCirugias.setControladorRegistro(this);
        this.setPantallaCirugias(pantallaConsultarCirugias);
        pantallaConsultarCirugias.setOpcion(opcion);
        pantallaConsultarCirugias.setCurp(curp);
        pantallaConsultarCirugias.setVisible(true);
        InicializarPantallaCirugias(pantallaConsultarCirugias, curp);
    }
    //Llenar la pantalla de Alergias para modificarla
    public void InicializarPantallaCirugias(PantallaGenerarExpedienteCirugias pantallaInicializar, String curp){
        String sql="select * from cirugias where CURP='"+curp+"'";
        agregarAccionBaseDatos("iniciar",sql);
        pantallaInicializar.IniciarPantalla(respuesta);
    }
    //agrega un expediente (datos Cirugias)
    public boolean agregarExpedienteCirugias(String fecha, String cirugia,String hospital, String curp, int id){
        String ID=curp+id;
        if(validarFecha(fecha) && validarDescripcion(cirugia) && validarHospital(hospital)){ 
            String sql="insert into cirugias(ID,CURP,FECHA,CIRUGIA,HOSPITAL)"+"values("+id+",'"+curp+"','"+fecha+"','"+cirugia+"','"+hospital+"')";
            agregarAccionBaseDatos("agregar",sql);
            return true;
        }else     
            return false;
    }
    //modifica espediente (datos Cirugias)
    public boolean modificarExpedienteCirugias(String fecha, String cirugia,String hospital, String curp, int id){
        
        if(validarFecha(fecha) && validarDescripcion(cirugia) && validarHospital(hospital)){ 
            String sql="update  cirugias set FECHA='"+fecha+"',CIRUGIA='"+cirugia+"',HOSPITAL='"+hospital+"' where CURP='"+curp+"' and ID="+id+"";
            agregarAccionBaseDatos("modificar",sql);     
            return true;
        }else     
            return false;
    }
   
    
    public void eliminarExpediente(String CURP){
        
            String sq, s, sql, st;
            st="delete from expediente where CURP='"+CURP+"'";
            agregarAccionBaseDatos("eliminar",st);
            if(controlBuscarEx.validarCURP(CURP, 1) != null){
                sq="delete from alergias where CURP='"+CURP+"'";      
                agregarAccionBaseDatos("eliminar",sq);
            }
            if(controlBuscarEx.validarCURP(CURP, 2) != null){
                s ="delete from cirugias where CURP='"+CURP+"'";
                agregarAccionBaseDatos("eliminar",s);
            }
            if(controlBuscarEx.validarCURP(CURP, 3) != null){
                sql="delete from perfil_f where CURP='"+CURP+"'";
                agregarAccionBaseDatos("eliminar",sql);
            }
            if(controlBuscarEx.validarCURP(CURP, 4) != null){
                sql="delete from medicametos where CURP='"+CURP+"'";
                agregarAccionBaseDatos("eliminar",sql);
            }
    }
 
    public void agregarAccionBaseDatos(String opcion,String sql){
        switch(opcion){
            case "agregar" :
                try {
                    conexion.conectar();
                    conexion.escribir(sql);
                    conexion.Off();
                }catch (SQLException ex) {
                    Logger.getLogger(ControlGenerarEx.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
               case "eliminar" :
                    try {
                           conexion.conectar();
                           conexion.Exe(sql);
                           conexion.Off();
                    } catch (SQLException ex) {
                            Logger.getLogger(ControlGenerarEx.class.getName()).log(Level.SEVERE, null, ex);
                    }
              break;
               case "iniciar" :
                    try {
                        conexion.conectar();
                        respuesta = conexion.obtenerDatos(sql);
                    } catch (SQLException ex) {
                        Logger.getLogger(ControlGenerarEx.class.getName()).log(Level.SEVERE, null, ex);
                    }
              break;
                case "modificar" :
                    try {
                        conexion.conectar();
                        conexion.actualizar(sql);
                        conexion.Off();
                    } catch (SQLException ex) {
                        Logger.getLogger(ControlGenerarEx.class.getName()).log(Level.SEVERE, null, ex);
                    }
              break;

        }
    }
    
    public boolean validarCodigoPostal(String codigoPostal){
        String numeros = "1234567890";
        if(codigoPostal.length() != 5)
            return false;
        else
            for( int i = 0; i < codigoPostal.length(); i++){
            char c = codigoPostal.charAt(i);
            if(!numeros.contains(c+"")){
                return false;
            }
        }
        return true;
    }
    
    public boolean validarNumeroTelefono(String telefono){
       String numeros = "1234567890";
        if(telefono.length() != 10)
            return false;
        else
            for( int i = 0; i < telefono.length(); i++){
            char c = telefono.charAt(i);
            if(!numeros.contains(c+"")){
                return false;
            }
        }
    
        return true;
    }
    
    
    public boolean validarNombre(String nombre){
        String CaracteresValidos = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZáéíóúÁÉÚÍÓ ";
        if (nombre.length() < 1)
            return false;
        else
            for(int i = 0; i< nombre.length(); i++){
                char c = nombre.charAt(i);
                if(!CaracteresValidos.contains(c+"")){
                    return false;
                }
            }
        return true;
    }
    
    public boolean validarDireccion(String direccion){
        String CaracteresValidos = "0123456789abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZáéíóúÁÉÚÍÓ #./";
        if(direccion.length() < 1)
            return false;
        else{
            for(int i = 0; i< direccion.length(); i++){
                char c = direccion.charAt(i);
                if(!CaracteresValidos.contains(c+""))
                    return false;
            }
        }
        return true;
    }
    
    public boolean validarCURP(String curp){
        String caracteresValidos = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String numeros = "1234567890";
        
        if(curp.length()!= 18)
            return false;
        else{
            for(int i = 0; i< curp.length(); i++){
                char c = curp.charAt(i);
                if(i == 0 || i == 1 || i == 2 || i == 3 || i == 10 || i ==11 || i == 12 || i == 13 || i ==14 || i == 15)
                    if(!caracteresValidos.contains(c+""))
                        return false;
                else
                        if(!numeros.contains(c+""))
                            return false;
            }
        }
        
        return true;
    }
    
    public boolean validarAlergia(String alergia){
        String CaracteresValidos = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZáéíóúÁÉÚÍÓ ";
        if(alergia.length() < 1)
            return false;
        else{
            for(int i = 0; i< alergia.length(); i++){
                char c = alergia.charAt(i);
                if(!CaracteresValidos.contains(c+"")){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean validarDescripcion(String descripcion){
        String CaracteresValidos = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZáéíóúÁÉÚÍÓ /.";
        if(descripcion.length() < 1)
            return false;
        else{
            for(int i = 0; i< descripcion.length(); i++){
                char c = descripcion.charAt(i);
                if(!CaracteresValidos.contains(c+"")){
                    return false;
                }
            }
        }
        return true;
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
    
    public boolean validarHospital(String descripcion){
            String CaracteresValidos = "1234567890abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZáéíóúÁÉÚÍÓ .";
            if(descripcion.length() < 1)
                return false;
            else{
                for(int i = 0; i< descripcion.length(); i++){
                    char c = descripcion.charAt(i);
                    if(!CaracteresValidos.contains(c+"")){
                        return false;
                    }
                }
            }
            return true;
        }
    
    public void cerrarConexio(){
        try {
                conexion.Off();
        } catch (SQLException ex) {
                Logger.getLogger(ControlGenerarPF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int validarDatosTabla(JTable tabla ,int i, int n){
          String aux=null;
          int cont=0;
           for( int iX=0; iX <n; iX++ ) {
                aux = (String)tabla.getModel().getValueAt(i, iX);
                if(aux == null)
                    cont++;       
            }
           return cont;
   }
}
