/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.Carro;
import modelos.ConexionBD;

/**
 *
 * @author Manuela Gomez
 */
public class ControladorCarro {
    private final ConexionBD conn;
    private final Connection con;

    public ControladorCarro() {
        conn = new ConexionBD();
        con = conn.getConexion();
    }

    public ResultSet buscarCarro(String matricula) {
        String where = "";

        if (!"".equals(matricula)) {
            where = "WHERE matricula = '" + matricula + "'";
        }

        try {
            PreparedStatement ps;
            ResultSet rs;

            String sql = "SELECT * FROM carros " + where;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            return rs;

        } catch (SQLException e) {
            System.err.println(e);

        }
        return null;

    }

    public ResultSet listarCarros() {

        try {
            PreparedStatement ps;
            ResultSet rs;

            String sql = "SELECT * FROM carros ";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            return rs;

        } catch (SQLException e) {
            System.err.println(e);

        }
        return null;

    }

    public void guardarCarros(Carro carro) throws SQLException {

        try {

            PreparedStatement ps;

            String query = "INSERT INTO carros (matricula, modelo, marca, precio, color, seguro, ciudad ) VALUES (?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);

            ps.setString(1, carro.getMatricula());
            ps.setString(2, carro.getModelo());
            ps.setString(3, carro.getMarca());
            ps.setDouble(4, carro.getPrecio());
            ps.setString(5, carro.getColor());
            ps.setString(6, carro.getSeguro());
            ps.setString(7, carro.getCiudad());
            
            ps.execute();

        } catch (SQLException ex) {
            System.err.println(ex);
            throw new SQLException();
        }
    }

    public void updateCarros(Carro carro) {

        try {
            PreparedStatement ps;

            String query = ("UPDATE carros SET precio=?, color=?, seguro=?, ciudad=? WHERE matricula=?");
            ps = con.prepareStatement(query);

            ps.setDouble(1, carro.getPrecio());
            ps.setString(2, carro.getColor());
            ps.setString(3, carro.getSeguro());
            ps.setString(4, carro.getCiudad());
            ps.setString(5, carro.getMatricula());

            ps.execute();

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public void deleteCarro(String matricula) {
        try {
            PreparedStatement ps;

            String query = "DELETE FROM carros WHERE matricula = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, matricula);
            
            ps.execute();

        } catch (SQLException ex) {
            System.err.println(ex);
        }

    }

    
}
