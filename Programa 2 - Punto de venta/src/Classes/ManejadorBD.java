/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.AdministrarDatos;
import Interfaces.AdministrarPagos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ja-za
 */
public class ManejadorBD {

    private AdministrarDatos admin;
    private AdministrarPagos adminPagos;

    public ManejadorBD(Object admin) {
        this.admin = (AdministrarDatos)admin;
        if(admin instanceof AdministrarPagos){
            this.adminPagos = (AdministrarPagos)admin;
        }
    }

    public void consultarProductos() {
        try {
            Connection cn = Conexion.getConexion();
            String sql = "ConsultarProductos";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Producto p;
            while (rs.next()) {
                if(rs.getInt("Tipo") == 0){
                    p = new Producto(rs.getInt("Clave"), rs.getString("Descripcion"), 
                            rs.getDouble("Precio"), rs.getInt("Cantidad"), 
                            rs.getInt("Tipo"));
                }else{
                    p = new Paquete(rs.getInt("Clave"), rs.getString("Descripcion"), rs.getDouble("Precio"));
                }
                admin.insertar(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertarProducto(Producto nuevo) {
        Connection cn = Conexion.getConexion();
        String sql = "InsertarProducto ?,?,?,?,?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, nuevo.getClave());
            pst.setString(2, nuevo.getDescripcion());
            pst.setDouble(3, nuevo.getPrecio());
            pst.setInt(4, nuevo.getCantidad());
            pst.setInt(5, nuevo.getTipo());

            int result = pst.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Registro guardado exitosamente");

            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el registro");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarProducto(Producto nuevo) {
        Connection cn = Conexion.getConexion();
        String sql = "ModificarProducto ?,?,?,?,?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, nuevo.getClave());
            pst.setString(2, nuevo.getDescripcion());
            pst.setDouble(3, nuevo.getPrecio());
            pst.setInt(4, nuevo.getCantidad());
            pst.setInt(5, nuevo.getTipo());

            int result = pst.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente");

            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el registro");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarProducto(int clave) {
        Connection cn = Conexion.getConexion();
        String sql = "EliminarProducto ?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, clave);

            int result = pst.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente");

            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultarUsuarios() {
        try {
            Connection cn = Conexion.getConexion();
            String sql = "ConsultarUsuarios";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Usuario u;
            while (rs.next()) {
                u = new Usuario(rs.getInt("Clave"), rs.getString("Usuario"), rs.getString("ClaveUser"), rs.getDouble("Salario"), rs.getDouble("Comision"), rs.getInt("Rol"));
                admin.insertar(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertarUsuario(Usuario nuevo) {
        Connection cn = Conexion.getConexion();
        String sql = "InsertarUsuario ?,?,?,?,?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, nuevo.getNombre());
            pst.setString(2, nuevo.getContra());
            pst.setInt(3, nuevo.getRol());
            pst.setDouble(4, nuevo.getSalario());
            pst.setDouble(5, nuevo.getComision());

            int result = pst.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Registro guardado exitosamente");

            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el registro");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarUsuario(Usuario nuevo) {
        Connection cn = Conexion.getConexion();
        String sql = "ModificarUsuario ?,?,?,?,?,?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, nuevo.getClave());
            pst.setString(2, nuevo.getNombre());
            pst.setString(3, nuevo.getContra());
            pst.setInt(4, nuevo.getRol());
            pst.setDouble(5, nuevo.getSalario());
            pst.setDouble(6, nuevo.getComision());

            int result = pst.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Registro guardado exitosamente");

            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el registro");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarUsuario(Usuario nuevo) {
        Connection cn = Conexion.getConexion();
        String sql = "EliminarUsuario ?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, nuevo.getClave());

            int result = pst.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Registro guardado exitosamente");

            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el registro");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertarVenta(Venta nueva) {
        Connection cn = Conexion.getConexion();
        String sql = "InsertarVenta ?,?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, nueva.getFechaToStringSql());
            pst.setInt(2, nueva.getVendedor().getClave());
            pst.executeUpdate();

            sql = "SELECT TOP 1 * FROM Ventas ORDER BY Clave DESC;";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int clave = -1;
            while (rs.next()) {
                clave = rs.getInt("Clave");
                break;
            }

            if (clave >= 0) {
                for (DetalleVenta t : nueva.getDetalles()) {
                    insertarDetalleVenta(t, clave);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertarDetalleVenta(DetalleVenta nueva, int clave) {
        Connection cn = Conexion.getConexion();
        String sql = "InsertarDetalle ?,?,?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, nueva.getProducto().getClave());
            pst.setInt(2, clave);
            pst.setInt(3, nueva.getCantidad());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultarVentas(String fechaInicial, String fechaFinal) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Connection cn = Conexion.getConexion();
        String sql = "ConsultarVentas ?,?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, fechaInicial);
            pst.setString(2, fechaFinal);
            ResultSet rs = pst.executeQuery();
            Venta v = null;
            while (rs.next()) {
                try {
                    v = new Venta(rs.getInt("Clave"),
                            format.parse(rs.getString("Fecha")),
                            new Usuario(rs.getInt("idUsuario"), rs.getString("Usuario"),rs.getString("ClaveUser"), rs.getDouble("Salario"), rs.getDouble("Comision"), rs.getInt("Rol")),
                            null);
                } catch (ParseException ex) {
                    Logger.getLogger(ManejadorBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                sql = "ConsultarDetalle ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, rs.getInt("Clave"));
                ResultSet rs2 = pst.executeQuery();
                
                ArrayList<DetalleVenta> productos = new ArrayList<>();
                while (rs2.next()) {
                    productos.add(new DetalleVenta(rs2.getInt("Clave"), 
                                                   new Producto(rs2.getInt("idProducto"), 
                                                                rs2.getString("Descripcion"), 
                                                                rs2.getDouble("Precio"),
                                                                rs2.getInt("CantidadProducto"),
                                                                rs2.getInt("Tipo")), 
                                                    rs2.getInt("Cantidad")));
                }
                v.setDetalles(productos);
                admin.insertar(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultarVentasVendedor(String fechaInicial, String fechaFinal, Usuario vendedor) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Connection cn = Conexion.getConexion();
        String sql = "ConsultarVentasVendedor ?,?,?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, fechaInicial);
            pst.setString(2, fechaFinal);
            pst.setInt(3, vendedor.getClave());
            ResultSet rs = pst.executeQuery();
            Venta v = null;
            while (rs.next()) {
                try {
                    v = new Venta(rs.getInt("Clave"),
                            format.parse(rs.getString("Fecha")),
                            new Usuario(rs.getInt("idUsuario"), rs.getString("Usuario"),rs.getString("ClaveUser"), rs.getDouble("Salario"), rs.getDouble("Comision"), rs.getInt("Rol")),
                            null);
                } catch (ParseException ex) {
                    Logger.getLogger(ManejadorBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                sql = "ConsultarDetalle ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, rs.getInt("Clave"));
                ResultSet rs2 = pst.executeQuery();
                
                ArrayList<DetalleVenta> productos = new ArrayList<>();
                while (rs2.next()) {
                    productos.add(new DetalleVenta(rs2.getInt("Clave"), 
                                                   new Producto(rs2.getInt("idProducto"), 
                                                                rs2.getString("Descripcion"), 
                                                                rs2.getDouble("Precio"),
                                                                rs2.getInt("CantidadProducto"),
                                                                rs2.getInt("Tipo")), 
                                                    rs2.getInt("Cantidad")));
                }
                v.setDetalles(productos);
                adminPagos.insertarVenta(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void consultarVendedores(){
        try {
            Connection cn = Conexion.getConexion();
            String sql = "ConsultarVendedores";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Usuario u;
            while (rs.next()) {
                u = new Usuario(rs.getInt("Clave"), rs.getString("Usuario"), rs.getString("ClaveUser"), rs.getDouble("Salario"), rs.getDouble("Comision"), rs.getInt("Rol"));
                adminPagos.insertarVendedor(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertarPaquete(Paquete nuevo){
        insertarProducto(nuevo);
        for(DetallePaquete d : nuevo.getProductos()){
            insertarDetallePaquete(d);
        }
    }
    
    public void modificarPaquete(Paquete mod){
        modificarProducto(mod);
        for(DetallePaquete d : mod.getProductos()){
            modificarDetallePaquete(d);
        }
    }
    
    public void eliminarPaquete(int clave){
        eliminarDetallePaquete(clave);
        eliminarProducto(clave);
    }
    
    public void insertarDetallePaquete(DetallePaquete nueva) {
        Connection cn = Conexion.getConexion();
        String sql = "InsertarDetallePaquete ?,?,?,?";
        System.out.println(nueva.getClavePaquete()+", "+nueva.getProductoPaquete());

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, nueva.getClave());
            pst.setInt(2, nueva.getClavePaquete());
            pst.setInt(3, nueva.getProductoPaquete());
            pst.setInt(4, nueva.getCantidad());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificarDetallePaquete(DetallePaquete nueva) {
        Connection cn = Conexion.getConexion();
        String sql = "ModificarDetallePaquete ?,?,?,?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, nueva.getClave());
            pst.setInt(2, nueva.getClavePaquete());
            pst.setInt(3, nueva.getProductoPaquete());
            pst.setInt(4, nueva.getCantidad());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Paquete consultarDetallePaquete(int clavePaquete, Paquete paquete){
        Connection cn = Conexion.getConexion();
        String sql = "ConsultarDetallePaquete ?";
        paquete.vaciarLista();
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, clavePaquete);
            ResultSet rs = pst.executeQuery();
            DetallePaquete d;
            while (rs.next()) {
                d = new DetallePaquete(rs.getInt("Clave"), rs.getInt("ClavePaquete"), rs.getInt("ProductoPaquete"), rs.getInt("Cantidad"));
                paquete.agregarProducto(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paquete;
    }
    
    public void eliminarDetallePaquete(int clavePaquete) {
        Connection cn = Conexion.getConexion();
        String sql = "EliminarDetallesPaquete ?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, clavePaquete);

            int result = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarDetallePaquetePorId(int clave) {
        Connection cn = Conexion.getConexion();
        String sql = "EliminarDetallesPaquetePorId ?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, clave);

            int result = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void consultarPaquetes(){
        try {
            Connection cn = Conexion.getConexion();
            String sql = "ConsultarPaquetes";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Producto p;
            while (rs.next()) {
                p = new Paquete(rs.getInt("Clave"), rs.getString("Descripcion"), rs.getDouble("Precio"));
                admin.insertar(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario login(String usuario, String contra) {
        Connection cn = Conexion.getConexion();
        String sql = "IniciarSesion ?,?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, usuario);
            pst.setString(2, contra);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                return new Usuario(rs.getInt("Clave"), rs.getString("Usuario"), rs.getString("ClaveUser"), rs.getDouble("Salario"), rs.getDouble("Comision"), rs.getInt("Rol"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
