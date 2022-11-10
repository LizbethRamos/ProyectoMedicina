
package Controlador;
import BaseDatos.Conexion;
import Pantalla.PantallaInicio;
public class ControlInicio {
    PantallaInicio PantallaInicio;
    
       ControlBuscarEx controlBuscarEx;
       ControlBuscarPF controlBuscarPF;
       ControlLoggin controlLogin;
       ControlGenerarEx controlRegistro;
       ControlGenerarPF controlGenerarPF;
       Conexion conexion;

        public Conexion getConexion() {
                return conexion;
        }

        public void setConexion(Conexion conexion) {
                this.conexion = conexion;
        }
       
        public PantallaInicio getPantallaInicio() {
                return PantallaInicio;
        }

        public void setPantallaInicio(PantallaInicio PantallaInicio) {
                this.PantallaInicio = PantallaInicio;
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
        
        public void mostrarInicio(){
                PantallaInicio pantallaInicio = new PantallaInicio();
                pantallaInicio.setInicio(this);
                pantallaInicio.setVisible(true);
        }
}
