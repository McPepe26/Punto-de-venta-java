/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Classes.DetalleVenta;
import Classes.ManejadorBD;
import Classes.Producto;
import Classes.Usuario;
import Classes.Venta;
import Interfaces.AdministrarDatos;
import Interfaces.ManageAyuda;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ja-za
 */
public class Principal extends javax.swing.JFrame implements ManageAyuda, AdministrarDatos {

    private DefaultTableModel model;
    private ArrayList<Producto> productos;
    private Venta venta;
    private Usuario vendedor;
    private ManejadorBD manejador;

    /**
     * Creates new form Principal
     *
     * @param currentUser
     */
    public Principal(Usuario currentUser) {
        model = new DefaultTableModel(new Object[]{"Clave", "Descripción", "Precio unitario", "Cantidad", "Total"}, 0);
        initComponents();
        
        productos = new ArrayList<>();

        vendedor = currentUser;
        venta = new Venta(new Date(), vendedor, new ArrayList<>());
        btnVender.setEnabled(false);

        lblVendedor.setText("Vendedor: " + vendedor.getNombre());
        manejador = new ManejadorBD(this);

        manejador.consultarProductos();

        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtClave = new javax.swing.JTextField();
        lblVendedor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVenta = new javax.swing.JTable();
        lblTotal = new javax.swing.JLabel();
        btnVender = new javax.swing.JButton();
        btnAdministrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Venta");

        txtClave.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });

        lblVendedor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblVendedor.setText("Vendedor");

        tblVenta.setModel(model);
        jScrollPane1.setViewportView(tblVenta);

        lblTotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTotal.setText("Total: $0.0");

        btnVender.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnVender.setText("Vender");
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });

        btnAdministrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAdministrar.setText("Administrar");
        btnAdministrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAdministrar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnVender, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClave, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdministrar, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addComponent(btnVender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        String texto = txtClave.getText();
        int cantidad;
        txtClave.setText("");
        if (texto.replace(" ", "").length() == 1) {
            if (texto.equals("?")) {
                //Desplegar ayuda
                new Ayuda(this, productos).setVisible(true);
            } else if (!venta.estaVacia()) {
                model.removeRow(model.getRowCount() - 1);
                if (texto.equals("-")) {
                    cantidad = venta.getDetalles().size();
                    if (venta.quitarItemUltimo() == cantidad) {
                        DetalleVenta detalle = venta.getUltimo();
                        Producto p = detalle.getProducto();
                        model.addRow(new Object[]{p.getClave(), p.getDescripcion(), p.getPrecio(), detalle.getCantidad(), venta.calcularTotalUltimo()});
                    }
                } else if (texto.equals("+")) {
                    if (venta.getUltimo().getProducto().getCantidad() > 0) {
                        venta.agregarItemUltimo();
                        DetalleVenta detalle = venta.getUltimo();
                        Producto p = detalle.getProducto();
                        model.addRow(new Object[]{p.getClave(), p.getDescripcion(), p.getPrecio(), detalle.getCantidad(), venta.calcularTotalUltimo()});
                        venta.getUltimo().getProducto().setCantidad(venta.getUltimo().getProducto().getCantidad()-1);
                    } else {
                        DetalleVenta detalle = venta.getUltimo();
                        Producto p = detalle.getProducto();
                        model.addRow(new Object[]{p.getClave(), p.getDescripcion(), p.getPrecio(), detalle.getCantidad(), venta.calcularTotalUltimo()});
                        JOptionPane.showMessageDialog(this, "Ya no hay productos en inventario");
                    }
                }
            }
        } else if (texto.length() > 1) {
            for (int i = 0; i < model.getRowCount(); i++) {
                try {
                    if (((Integer) model.getValueAt(i, 0)) == Integer.parseInt(texto)) {
                        JOptionPane.showMessageDialog(this, "Ya existe ese articulo en la lista");
                        return;
                    }
                } catch (NumberFormatException ex) {

                }
            }
            productos.forEach((p) -> {
                try {
                    if (p.getClave() == Integer.parseInt(texto)) {
                        if (p.getCantidad() > 0) {
                            venta.agregarItem(p, 1);
                            model.addRow(new Object[]{p.getClave(), p.getDescripcion(), p.getPrecio(), "1", venta.calcularTotalUltimo()});
                            venta.getUltimo().getProducto().setCantidad(venta.getUltimo().getProducto().getCantidad()-1);
                        } else {
                            JOptionPane.showMessageDialog(this, "Ya no hay productos en inventario");
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Ingresa una clave de producto valida");
                }
            });
        }

        btnVender.setEnabled(!venta.estaVacia());

        lblTotal.setText("Total: $" + venta.calcularTotal());
    }//GEN-LAST:event_txtClaveActionPerformed

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        lblTotal.setText("Total: $0.0");
        //Se registra una venta
        manejador.insertarVenta(venta);
        venta = new Venta(new Date(), vendedor, new ArrayList<>());
        JOptionPane.showMessageDialog(this, "Venta registrada");
    }//GEN-LAST:event_btnVenderActionPerformed

    private void btnAdministrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarActionPerformed
        new Administracion(vendedor).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnAdministrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdministrar;
    private javax.swing.JButton btnVender;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblVendedor;
    private javax.swing.JTable tblVenta;
    private javax.swing.JTextField txtClave;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setProducto(int p) {
        txtClave.setText("" + productos.get(p).getClave());
        txtClaveActionPerformed(null);
    }

    @Override
    public void insertar(Object p) {
        productos.add((Producto) p);
    }

}