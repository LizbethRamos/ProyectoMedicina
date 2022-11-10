package Principal;

import BaseDatos.Conexion;
import Controlador.*;
import Pantalla.PantallaLogin;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

public class MainProyecto {
         public static void main(String args[]){
                 Conexion conexion=new Conexion();
                 ControlBuscarEx controlBuscarEx=new ControlBuscarEx();
                 ControlBuscarPF controlBuscarPf= new ControlBuscarPF();
                 ControlGenerarPF controlGenerarPF =new ControlGenerarPF();
                 ControlGenerarEx controlGenerarEx = new ControlGenerarEx();
                 ControlInicio controlInicio=new ControlInicio();
                 ControlLoggin  controlLoggin=new ControlLoggin();
                 
                 controlBuscarEx.setControlGenerarPF(controlGenerarPF);
                 controlBuscarEx.setControlBuscarPF(controlBuscarPf);
                 controlBuscarEx.setControlInicio(controlInicio);
                 controlBuscarEx.setControlLogin(controlLoggin);
                 controlBuscarEx.setControlRegistro(controlGenerarEx);
                 controlBuscarEx.setConexion(conexion);
                 
                 controlBuscarPf.setControlBuscarEx(controlBuscarEx);
                 controlBuscarPf.setControlGenerarPF(controlGenerarPF);
                 controlBuscarPf.setControlLogin(controlLoggin);
                 controlBuscarPf.setControlRegistro(controlGenerarEx);
                 controlBuscarPf.setControlInicio(controlInicio);
                 controlBuscarPf.setConexion(conexion);
            
                 
                 controlGenerarPF.setControlBuscarEx(controlBuscarEx);
                 controlGenerarPF.setControlBuscarPF(controlBuscarPf);
                 controlGenerarPF.setControlInicio(controlInicio);
                 controlGenerarPF.setControlRegistro(controlGenerarEx);
                 controlGenerarPF.setControlLogin(controlLoggin);
                 controlGenerarPF.setConexion(conexion);
                 
                 controlGenerarEx.setControlInicio(controlInicio);
                 controlGenerarEx.setControlLoggin(controlLoggin);
                 controlGenerarEx.setControlBuscarEx(controlBuscarEx);
                 controlGenerarEx.setControlBuscarPF(controlBuscarPf);
                 controlGenerarEx.setControlGenerarPF(controlGenerarPF);
                 controlGenerarEx.setConexion(conexion);
                 
                 controlInicio.setControlBuscarEx(controlBuscarEx);
                 controlInicio.setControlBuscarPF(controlBuscarPf);
                 controlInicio.setControlGenerarPF(controlGenerarPF);
                 controlInicio.setControlLogin(controlLoggin);
                 controlInicio.setControlRegistro(controlGenerarEx);
                 controlInicio.setConexion(conexion);
                 
                 controlLoggin.setControlBuscarEx(controlBuscarEx);
                 controlLoggin.setControlBuscarPF(controlBuscarPf);
                 controlLoggin.setControlGenerarPF(controlGenerarPF);
                 controlLoggin.setControlInicio(controlInicio);
                 controlLoggin.setControlRegistro(controlGenerarEx);
                 controlLoggin.setConexion(conexion);
                 
                 PantallaLogin pantallaLoggin = new PantallaLogin();
                 pantallaLoggin.setControlLoggin(controlLoggin);
                 pantallaLoggin.setVisible(true);
                 pantallaLoggin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         }
}
