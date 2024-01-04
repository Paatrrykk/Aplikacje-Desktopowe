import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SchoolApp extends JFrame {

    private DefaultTableModel model;

    public SchoolApp() {
        super("School App");

        model = new DefaultTableModel();
        model.addColumn("Klasa");
        model.addColumn("Przedmiot");
        model.addColumn("Zadanie");
        model.addColumn("Checkbox");

        JTable table = new JTable(model);
        table.getColumnModel().getColumn(3).setCellRenderer(new CheckBoxRenderer());
        table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(new JCheckBox()));

        JScrollPane scrollPane = new JScrollPane(table);

        JButton addButton = new JButton("Dodaj");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRow();
            }
        });

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(addButton, BorderLayout.SOUTH);

        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addRow() {
        String klasa = JOptionPane.showInputDialog("Podaj klasę:");
        String przedmiot = JOptionPane.showInputDialog("Podaj przedmiot:");
        String zadanie = JOptionPane.showInputDialog("Podaj zadanie:");

        if (klasa != null && przedmiot != null && zadanie != null) {
            model.addRow(new Object[]{klasa, przedmiot, zadanie, false});
        }
    }

    private class CheckBoxRenderer extends JCheckBox implements TableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setSelected(value != null && (boolean) value);
            return this;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SchoolApp();
            }
        });
    }
}
