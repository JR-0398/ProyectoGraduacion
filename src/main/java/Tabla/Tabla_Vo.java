/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tabla;

import com.dao.ControlRegis_Hist;
import com.modelo.registro_historico;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JUANJO
 */
public class Tabla_Vo {
    ControlRegis_Hist dao = null;

    public void visualizar_PdfVO(JTable tabla) {
        tabla.setDefaultRenderer(Object.class, new imgTabla());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("id_pdf");
        dt.addColumn("nombre_pdf");
        dt.addColumn("archivo_pdf");

        ImageIcon icono = null;
        if (get_Image("/images/32pdf.png") != null) {
            icono = new ImageIcon(get_Image("/images/32pdf.png"));
        }

        dao = new ControlRegis_Hist();
        registro_historico vo = new registro_historico();
        ArrayList<registro_historico> list = dao.Listar_Pdf();

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[3];
                vo = list.get(i);
                fila[0] = vo.getId_pdf();
                fila[1] = vo.getNombre_pdf();
                if (vo.getArchivo_pdf()!= null) {
                    fila[2] = new JButton(icono);
                } else {
                    fila[2] = new JButton("Vacio");
                }

                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(32);
        }
    }

    public Image get_Image(String ruta) {
        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(ruta));
            Image mainIcon = imageIcon.getImage();
            return mainIcon;
        } catch (Exception e) {
        }
        return null;
    }
}
