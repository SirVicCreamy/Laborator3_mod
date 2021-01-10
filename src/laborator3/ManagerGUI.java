package laborator3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ManagerGUI {

    protected JPanel panel;
    private JLabel antet;
    private JButton profiButton;
    private JButton cursuriButton;
    private JButton studentiButton;
    private JTabbedPane panouTab;
    private JTable tabelStudenti;
    private JScrollPane profiPanel;
    private JScrollPane studentiPanel;
    private JScrollPane cursuriPanel;
    private JTable tabelCursuri;
    private JTable tabelProfi;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton addButton;


    public ManagerGUI() {

        final int[] index = {0};
        cursuriButton.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {

                File file = new File("cursuri.csv");
                try {
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    String firstLine = br.readLine();
                    if (firstLine != null) {
                        String[] columnsName = firstLine.split(",");
                        DefaultTableModel model = (DefaultTableModel) tabelCursuri.getModel();
                        model.setColumnIdentifiers(columnsName);
                        Object[] lines = br.lines().toArray();

                        for (int i = 0; i < lines.length; i++) {
                            String[] row = lines[i].toString().split(",");
                            model.addRow(row);
                        }
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                index[0] = 0;
                panouTab.setSelectedIndex(index[0]);

            }
        });
        studentiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                File file = new File("studenti.csv");
                try {
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    String firstLine = br.readLine();
                    if (firstLine != null) {
                        String[] columnsName = firstLine.split(",");
                        DefaultTableModel model = (DefaultTableModel) tabelStudenti.getModel();
                        model.setColumnIdentifiers(columnsName);
                        Object[] lines = br.lines().toArray();

                        for (int i = 0; i < lines.length; i++) {
                            String[] row = lines[i].toString().split(",");
                            model.addRow(row);
                        }
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }

                index[0] = 1;
                panouTab.setSelectedIndex(index[0]);

            }
        });
        profiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                File file = new File("profesori.csv");
                try {
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    String firstLine = br.readLine();
                    if (firstLine != null) {
                        String[] columnsName = firstLine.split(",");
                        DefaultTableModel model = (DefaultTableModel) tabelProfi.getModel();
                        model.setColumnIdentifiers(columnsName);
                        Object[] lines = br.lines().toArray();

                        for (int i = 0; i < lines.length; i++) {
                            String[] row = lines[i].toString().split(",");
                            model.addRow(row);
                        }
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                index[0] = 2;
                panouTab.setSelectedIndex(index[0]);

            }
        });
    }


}