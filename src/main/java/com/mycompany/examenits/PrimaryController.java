package com.mycompany.examenits;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class PrimaryController {

    @FXML
    private Button boton;
    @FXML
    private TextArea txtMostrar;

    @FXML
    private void botonConsultar(ActionEvent event) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://24.152.40.30:3306/examenits","its","12345678");
            System.out.println("OK");
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("SELECT * FROM personas");
            ArrayList<String> datos = new ArrayList<String>();
         
            while(rs.next()){
                
                rs.getInt("idpersona");
                rs.getString("nombres");
                rs.getString("apellidos");
            
                datos.add(rs.getInt("idpersona")+"-"+rs.getString("nombres")+"-"+rs.getString("apellidos") + "\n");
                
                txtMostrar.setText(""+datos);
                
            }
            con.close();

        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex);
        }


    }
}
