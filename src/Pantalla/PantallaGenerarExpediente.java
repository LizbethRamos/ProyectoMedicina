package Pantalla;
import Controlador.ControlGenerarEx;
import com.placeholder.PlaceHolder;
import javax.swing.ButtonGroup;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class PantallaGenerarExpediente extends JFrame{
    private JPanel jPanelBase;
    private JTextField jTextCLUES, jTextCURP, jTextNombre, 
            jTextDireccion, jTextCP, jTextNumeroTelefono, jTextPeso, jTextTalla;
    private ButtonGroup sexo;//Agregue este
    private JComboBox jComboEdad, jComboNacionalidad;
    private JRadioButton jCheckFemenino, jCheckMasculino;
    private JLabel jLabelNacionalidad, jLabelCLUES, jLabelCURP, jLabelNombre, jLabelEdad, jLabelDireccion, jLabelCP, 
            jLabelNumeroTelefono, jLabelSexo, jLabelFemenino, jLabelMasculino, jLabelEstadoCivil, jLabelTipoSangre, jLabelPeso, jLabelEstatura;
    private JComboBox jComboEstadoCivil, jComboTipoSangre;
    private JButton jButtonAlergias, jButtonCirugias, jButtonGuardar, jButtonCancelar;
    
    private PantallaGenerarExpedienteAlergias pantallaAlergias;
    private PantallaGenerarExpedienteCirugias pantallaCirugias;
    private ControlGenerarEx controladorRegistro;
    private String clues="VACIO";
    private String CURP="VACIO";
    private int opcion;
    
    public PantallaGenerarExpediente(){
        this.setSize(620, 500);
        this.setTitle("Datos Personales");
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(false);
       
        init();
    }
    
    public String getClues() {
        return clues;
    }

    public void setClues(String clues) {
        this.clues = clues;
        jTextCLUES.setText(clues);
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String Curp) {
        this.CURP = Curp;
        jTextCURP.setText(Curp);
    }

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }
    
    public PantallaGenerarExpedienteCirugias getPantallaCirugias() {
        return pantallaCirugias;
    }

    public void setPantallaAlergias(PantallaGenerarExpedienteCirugias pantallaCirugias) {
        this.pantallaCirugias = pantallaCirugias;
    }
    
    public PantallaGenerarExpedienteAlergias getPantallaAlergias() {
        return pantallaAlergias;
    }

    public void setPantallaAlergias(PantallaGenerarExpedienteAlergias pantallaAlergias) {
        this.pantallaAlergias = pantallaAlergias;
    }

    public ControlGenerarEx getControladorRegistro() {
        return controladorRegistro;
    }

    public void setControladorRegistro(ControlGenerarEx controladorRegistro) {
        this.controladorRegistro = controladorRegistro;
    }
    
    private void init(){
        Consultar(getOpcion());
        Color blanco = new Color(255, 255, 255);
        Color gris = new Color(40, 55, 71 );
        Color rosa = new Color(235, 222, 240);
        Color azulFuerte = new Color(51, 51, 153);
        Color azulMasFuerte = new Color(0, 0, 51);
        
        

        //Botones
        jButtonAlergias = new JButton("Alergias");
        jButtonAlergias.setFont(new Font("Nunito Sans",0,12));
        jButtonAlergias.setEnabled(true);
        jButtonAlergias.setBackground(Color.WHITE);
        jButtonAlergias.setBounds(30,420,120, 30);//x, y, largo, alto
      //  jButtonAlergias.setBorderPainted(false);

        jButtonCirugias = new JButton("Cirugias");
        jButtonCirugias.setFont(new Font("Nunito Sans",0,12));
        jButtonCirugias.setEnabled(true);
        jButtonCirugias.setBackground(Color.WHITE);
        jButtonCirugias.setBounds(180,420,120, 30);//
      //  jButtonCirugias.setBorderPainted(false);
        
        jButtonGuardar = new JButton("Guardar");
        jButtonGuardar.setFont(new Font("Nunito Sans",0,12));
        jButtonGuardar.setEnabled(true);
        jButtonGuardar.setBackground(Color.WHITE);
        jButtonGuardar.setBounds(320,420,120, 30);//
      //  jButtonGuardar.setBorderPainted(false);
        
        jButtonCancelar = new JButton("Cancelar");
        jButtonCancelar.setFont(new Font("Nunito Sans",0,12));
        jButtonCancelar.setEnabled(true);
        jButtonCancelar.setBackground(Color.WHITE);
        jButtonCancelar.setBounds(460,420,120, 30);//
     //   jButtonCancelar.setBorderPainted(false);
        //Campos de texto______________________________________________________________________
        jTextCLUES = new JTextField("-------CLUES-------");
        jTextCLUES.setFont(new Font("Nunito Sans",0,12));
        jTextCLUES.setBounds(70, 12 ,100, 20);
        jTextCLUES.setBackground(blanco);
        jTextCLUES.setEnabled(false);
        jTextCLUES.setBorder(BorderFactory.createLineBorder(blanco, 1));
        
        jTextCURP = new JTextField(30);
        jTextCURP.setBounds(270, 12 ,300, 20);
        jTextCURP.setFont(new Font("Nunito Sans",0,12));
        jTextCURP.setBackground(blanco);
        jTextCURP.setEnabled(false);
        jTextCURP.setBorder(BorderFactory.createLineBorder(blanco, 1));
        PlaceHolder holder4 = new PlaceHolder(jTextCURP, "Ejem: GACR981018HPLRRC04");
        
        jTextNombre = new JTextField(12); 
        jTextNombre.setBounds(70, 50,500, 25);
        jTextNombre.setFont(new Font("Nunito Sans",0,12));
        jTextNombre.setBackground(blanco);
        jTextNombre.setBorder(BorderFactory.createLineBorder(blanco, 1));
        PlaceHolder holder = new PlaceHolder(jTextNombre, "Ejem: Ricardo Emmanuel García Cruz");
        
        jComboEdad = new JComboBox();
        jComboEdad.setBounds(50, 105, 150, 25);
        jComboEdad.setBackground(blanco);
        jComboEdad.setBorder(BorderFactory.createLineBorder(blanco, 1));
        jComboEdad.addItem("Seleccionar Edad");
        jComboEdad.setFont(new Font("Nunito Sans",0,12));
        for(int i = 1; i<100; i++){
            jComboEdad.addItem(""+i);
        }
        sexo = new ButtonGroup(); 
        
        jComboTipoSangre = new JComboBox();
        jComboTipoSangre.addItem("Seleccionar");
        jComboTipoSangre.addItem("O+");
        jComboTipoSangre.addItem("O-");        
        jComboTipoSangre.addItem("A+");
        jComboTipoSangre.addItem("A-");
        jComboTipoSangre.addItem("B+");
        jComboTipoSangre.addItem("B-");
        jComboTipoSangre.addItem("AB+");        
        jComboTipoSangre.addItem("AB-");
        jComboTipoSangre.setBounds(480, 100,100, 25);
        jComboTipoSangre.setBackground(blanco);
        jComboTipoSangre.setFont(new Font("Nunito Sans",0,12));
        jComboTipoSangre.setBorder(BorderFactory.createLineBorder(blanco, 1));
        
        jTextPeso = new JTextField();
        jTextPeso.setBounds(130, 150,100, 25);
        jTextPeso.setFont(new Font("Nunito Sans",0,12));
        jTextPeso.setBackground(blanco);
        jTextPeso.setBorder(BorderFactory.createLineBorder(blanco, 1));
        PlaceHolder holder6 = new PlaceHolder(jTextPeso, "Ejem: 71.5");
        jTextPeso.setToolTipText("Peso en Kilogramos");
        
        jTextTalla = new JTextField();
        jTextTalla.setBounds(370, 150,120, 25);
        jTextTalla.setFont(new Font("Nunito Sans",0,12));
        jTextTalla.setBackground(blanco);
        jTextTalla.setBorder(BorderFactory.createLineBorder(blanco, 1));
        PlaceHolder holder7 = new PlaceHolder(jTextTalla, "Ejem: 1.75");
        jTextTalla.setToolTipText("Talla en Metros");
        
        jComboEstadoCivil = new JComboBox();
        jComboEstadoCivil.setBackground(blanco);
        jComboEstadoCivil.setFont(new Font("Nunito Sans",0,12));
        jComboEstadoCivil.addItem("Seleccione una opcion");
        jComboEstadoCivil.addItem("Soltero");
        jComboEstadoCivil.addItem("Casado");
        jComboEstadoCivil.addItem("Viudo");
        jComboEstadoCivil.addItem("Divorciado");
        jComboEstadoCivil.setBounds(90, 190,200, 25);
        jComboEstadoCivil.setBorder(BorderFactory.createLineBorder(blanco, 1));
        
        jComboNacionalidad = new JComboBox();
        jComboNacionalidad.setBounds(400, 190, 180, 25);
        jComboNacionalidad.setBackground(blanco);
        jComboNacionalidad.setFont(new Font("Nunito Sans",0,12));
        jComboNacionalidad.addItem("Seleccione Nacionalidad");
        jComboNacionalidad.addItem("Mexicana");
        jComboNacionalidad.addItem("Argentino/a");
        jComboNacionalidad.addItem("Boliviano /a");
        jComboNacionalidad.addItem("Chileno /a");
        jComboNacionalidad.addItem("Colombiano /a");
        jComboNacionalidad.addItem("Costarricense");
        jComboNacionalidad.addItem("Estadounidense");
        jComboNacionalidad.setBorder(BorderFactory.createLineBorder(blanco, 1));
        
        
        jTextDireccion = new JTextField(45);
        jTextDireccion.setBounds(80, 250,500, 25);
        jTextDireccion.setFont(new Font("Nunito Sans",0,12));
        jTextDireccion.setBackground(blanco);
        jTextDireccion.setBorder(BorderFactory.createLineBorder(blanco, 1));
        PlaceHolder holder1 = new PlaceHolder(jTextDireccion, "Ejem: Privada Rosales S/N. Puebla");
        
        jTextCP = new JTextField(10);
        jTextCP.setBounds(105, 345,130, 25);
        jTextCP.setFont(new Font("Nunito Sans",0,12));
        jTextCP.setBackground(blanco);
        jTextCP.setBorder(BorderFactory.createLineBorder(blanco, 1));
        PlaceHolder holder3 = new PlaceHolder(jTextCP, "Ejem:72980");
        
        jTextNumeroTelefono = new JTextField(20);
        jTextNumeroTelefono.setBounds(400, 345,180, 25);
        jTextNumeroTelefono.setFont(new Font("Nunito Sans",0,12));
        jTextNumeroTelefono.setBackground(blanco);
        jTextNumeroTelefono.setBorder(BorderFactory.createLineBorder(blanco, 1));
        PlaceHolder holder5 = new PlaceHolder(jTextNumeroTelefono, "Ejem: 2229122496");
        
        //CheckBox
        jCheckFemenino = new JRadioButton();
        jCheckFemenino.setBackground(rosa);
        jCheckFemenino.setBounds(290, 105, 20, 20);
        
        jCheckMasculino = new JRadioButton();
        jCheckMasculino.setBackground(rosa);
        jCheckMasculino.setBounds(330, 105, 20, 20);
        
        sexo.add(jCheckFemenino);
        sexo.add(jCheckMasculino);
        
        //JLabel
        jLabelCLUES = new JLabel("CLUES");
        jLabelCLUES.setBounds(10,15,80,15);
        jLabelCLUES.setBackground(azulFuerte);
        jLabelCLUES.setFont(new Font("Nunito Sans",0,15));
        
        jLabelCURP = new JLabel("CURP");
        jLabelCURP.setBounds(220,15,80,15);
        jLabelCURP.setBackground(azulFuerte);
        jLabelCURP.setFont(new Font("Nunito Sans",0,15));
        
        jLabelNombre = new JLabel("Nombre");
        jLabelNombre.setBounds(10,55,80,15);
        jLabelNombre.setBackground(azulFuerte);
        jLabelNombre.setFont(new Font("Nunito Sans",0,15));
        
        jLabelEdad = new JLabel("Edad");
        jLabelEdad.setBounds(10,110,80,15);
        jLabelEdad.setBackground(azulFuerte);
        jLabelEdad.setFont(new Font("Nunito Sans",0,15));
        
        jLabelSexo = new JLabel("Sexo");
        jLabelSexo.setBounds(240,105,80,15);
        jLabelSexo.setBackground(azulFuerte);
        jLabelSexo.setFont(new Font("Nunito Sans",0,15));
        
        jLabelFemenino = new JLabel("F");
        jLabelFemenino.setBounds(283,105,30,15);
        jLabelFemenino.setBackground(azulFuerte);
        jLabelFemenino.setFont(new Font("Nunito Sans",0,15));
        
        jLabelMasculino = new JLabel("M");
        jLabelMasculino.setBounds(318,105,30,15);
        jLabelMasculino.setBackground(azulFuerte);
        jLabelMasculino.setFont(new Font("Nunito Sans",0,15));
        
        jLabelTipoSangre = new JLabel("Tipo de Sangre");
        jLabelTipoSangre.setBounds(370,105,150,15);
        jLabelTipoSangre.setBackground(azulFuerte);
        jLabelTipoSangre.setFont(new Font("Nunito Sans",0,15));
        
        jLabelPeso = new JLabel("Peso");
        jLabelPeso.setBounds(90,155,50,15);
        jLabelPeso.setBackground(azulFuerte);
        jLabelPeso.setFont(new Font("Nunito Sans",0,15));
        
        jLabelEstatura = new JLabel("Estatura");
        jLabelEstatura.setBounds(325,155,50,15);
        jLabelEstatura.setBackground(azulFuerte);
        jLabelEstatura.setFont(new Font("Nunito Sans",0,15));
        
        
        jLabelEstadoCivil = new JLabel("Estado Civil");
        jLabelEstadoCivil.setBounds(10,195,100,15);
        jLabelEstadoCivil.setBackground(azulFuerte);
        jLabelEstadoCivil.setFont(new Font("Nunito Sans",0,15));
        
        
        jLabelNacionalidad = new JLabel("Nacionalidad");
        jLabelNacionalidad.setBounds(310,195,100,15);
        jLabelNacionalidad.setBackground(azulFuerte);
        jLabelNacionalidad.setFont(new Font("Nunito Sans",0,15));
        
        jLabelDireccion = new JLabel("Dirección");
        jLabelDireccion.setBounds(10,253,100,15);
        jLabelDireccion.setBackground(azulFuerte);
        jLabelDireccion.setFont(new Font("Nunito Sans",0,15));
        
        jLabelCP = new JLabel("Código Postal");
        jLabelCP.setBounds(10,350,100,15);
        jLabelCP.setBackground(azulFuerte);
        jLabelCP.setFont(new Font("Nunito Sans",0,15));
        
        jLabelNumeroTelefono = new JLabel("Numero Telefonico");
        jLabelNumeroTelefono.setBounds(270,350,150,15);
        jLabelNumeroTelefono.setBackground(azulFuerte);
        jLabelNumeroTelefono.setFont(new Font("Nunito Sans",0,15));
        
        //Paneles
        jPanelBase = new JPanel();
        jPanelBase.setLayout(null);
        jPanelBase.setBackground(rosa);

        jPanelBase.add(jButtonAlergias);
        jPanelBase.add(jButtonCirugias);
        jPanelBase.add(jButtonGuardar);
        jPanelBase.add(jButtonCancelar);
        jPanelBase.add(jLabelCLUES);
        jPanelBase.add(jTextCLUES);
        jPanelBase.add(jLabelCURP);
        jPanelBase.add(jTextCURP);
        jPanelBase.add(jLabelNombre);
        jPanelBase.add(jTextNombre);
        jPanelBase.add(jLabelEdad);
        jPanelBase.add(jComboEdad);
        jPanelBase.add(jLabelSexo);
        jPanelBase.add(jLabelFemenino);
        jPanelBase.add(jCheckFemenino);
        jPanelBase.add(jLabelMasculino);
        jPanelBase.add(jCheckMasculino);
        jPanelBase.add(jLabelTipoSangre);
        jPanelBase.add(jComboTipoSangre);
        jPanelBase.add(jLabelPeso);
        jPanelBase.add(jTextPeso);
        jPanelBase.add(jLabelEstatura);
        jPanelBase.add(jTextTalla);
        jPanelBase.add(jLabelEstadoCivil);
        jPanelBase.add(jComboEstadoCivil);
        jPanelBase.add(jLabelNacionalidad);
        jPanelBase.add(jComboNacionalidad);
        jPanelBase.add(jLabelDireccion);
        jPanelBase.add(jTextDireccion);
        jPanelBase.add(jLabelCP);
        jPanelBase.add(jTextCP);
        jPanelBase.add(jLabelNumeroTelefono);
        jPanelBase.add(jTextNumeroTelefono);
        this.getContentPane().add(jPanelBase);
        
        jButtonAlergias.addActionListener((ActionEvent e) -> {
            switch(getOpcion()){
                case 0://agregar
                    controladorRegistro.mostrarIGenerarExAlergias(getCURP(), getOpcion());
                    this.dispose();
                    break;
                case 1://modificar
                        controladorRegistro.mostrarIModificarExAlergias(getCURP(), getOpcion());
                        this.dispose();
                    break;
                case 2://consultar
                    controladorRegistro.mostrarIConsultarExAlergias(getCURP(), getOpcion());
                    this.dispose();
                    break;
            }
        });
        
        jButtonCirugias.addActionListener((ActionEvent e) -> {
            switch(getOpcion()){
                case 0://agregar
                    controladorRegistro.mostrarIGenerarExCirugias(getCURP(), getOpcion());
                    this.dispose();
                    break;
                case 1://modificar
                    controladorRegistro.mostrarIModificarExCirugias(getCURP(), getOpcion());
                    this.dispose();
                    break;
                case 2://consultar
                    controladorRegistro.mostrarIConsultarExCirugias(getCURP(), getOpcion());
                    this.dispose();
                    break;
            }
        });
        
        jButtonGuardar.addActionListener((ActionEvent e) -> {
            char sexo = ' ';
            switch(getOpcion()){
                case 0://agregar
                    if(jCheckFemenino.isSelected())
                        sexo = 'F';
                    else
                        sexo = 'M';
                    if(controladorRegistro.agregarExpediente(jTextCLUES.getText(), jTextCURP.getText(), jTextNombre.getText(), Integer.parseInt(jComboEdad.getSelectedItem().toString()), sexo, jComboTipoSangre.getSelectedItem().toString(), Float.parseFloat(jTextPeso.getText()), Float.parseFloat(jTextTalla.getText()), jComboEstadoCivil.getSelectedItem().toString(), jComboNacionalidad.getSelectedItem().toString(), jTextDireccion.getText(), Integer.parseInt(jTextCP.getText()), jTextNumeroTelefono.getText()))
                        cerrar(2);
                    else
                        JOptionPane.showMessageDialog(null, "Verifique la información ingresada");
                    break;
                case 1://modificar
                    if(jCheckFemenino.isSelected())
                        sexo = 'F';
                    else
                        sexo = 'M';
                    if(controladorRegistro.modificarExpediente(jTextCLUES.getText(), jTextCURP.getText(), jTextNombre.getText(), Integer.parseInt(jComboEdad.getSelectedItem().toString()), sexo, jComboTipoSangre.getSelectedItem().toString(), Float.parseFloat(jTextPeso.getText()), Float.parseFloat(jTextTalla.getText()), jComboEstadoCivil.getSelectedItem().toString(), jComboNacionalidad.getSelectedItem().toString(), jTextDireccion.getText(), Integer.parseInt(jTextCP.getText()), jTextNumeroTelefono.getText()))
                        cerrar(2);
                    else
                        JOptionPane.showMessageDialog(null, "Verifique la información ingresada");
                    break;
                case 2://consultar
                    cerrar(0);
                    break;
            }
        });
           
        jButtonCancelar.addActionListener((ActionEvent e) -> {
            switch(getOpcion()){
                case 0://agregar
                    controladorRegistro.eliminarExpediente(jTextCURP.getText());
                    cerrar(0);
                    break;
                case 1://modificar
                    cerrar(3);
                    break;
                case 2://consultar
                    
                    cerrar(0);
                    break;      
            }
        });        
    }
    
    public void IniciarPantalla(ResultSet respuesta){
              Consultar(getOpcion());
    try {
        while(respuesta.next()){
            String sexo;
            jTextCLUES.setText(respuesta.getString("CLUES"));
            jTextCURP.setText(respuesta.getString("CURP"));
            jTextNombre.setText(respuesta.getString("NOMBRE"));
            jComboEdad.setSelectedItem(respuesta.getString("EDAD"));
            jComboNacionalidad.setSelectedItem(respuesta.getString("NACIONALIDAD"));
            sexo = respuesta.getString("SEXO");
            if(sexo == "M")
                jCheckMasculino.setSelected(true);
            else
                jCheckFemenino.setSelected(true);
            jComboEstadoCivil.setSelectedItem(respuesta.getString("ESTADO_CIVIL"));
            jTextDireccion.setText(respuesta.getString("DIRECCION"));
            jTextCP.setText(respuesta.getString("CODIGO_POSTAL"));
            jTextNumeroTelefono.setText(respuesta.getString("TELEFONO"));
            jTextPeso.setText(respuesta.getString("PESO"));
            jTextTalla.setText(respuesta.getString("ESTATURA"));
            jComboTipoSangre.setSelectedItem(respuesta.getString("TIPO_SANGRE"));
        }
        controladorRegistro.cerrarConexio();
    } catch (SQLException ex) {
        Logger.getLogger(ControlGenerarEx.class.getName()).log(Level.SEVERE, null, ex);
    }
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
    
    public void cerrar(int opcion){
        switch(opcion){
            case 0:
                controladorRegistro.getControlBuscarEx().mostrarIBuscarEx();
                this.dispose();
                break;
            case 2:
                this.dispose();
                controladorRegistro.getControlBuscarEx().mostrarIBuscarEx();
                JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
                break;
            case 3:
                //Cancela y muestra pantalla expedientes
                int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro?", "confirmación cancelar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if(respuesta != 1){
                    controladorRegistro.getControlBuscarEx().mostrarIBuscarEx();
                    this.dispose();
                }
                break;
        }

    }
}