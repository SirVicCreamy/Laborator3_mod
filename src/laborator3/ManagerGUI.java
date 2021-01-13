package laborator3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class ManagerGUI extends ManagerCursuri {

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
        DefaultTableModel modelCursuri = (DefaultTableModel) tabelCursuri.getModel();
        DefaultTableModel modelStudenti = (DefaultTableModel) tabelStudenti.getModel();
        DefaultTableModel modelProfi = (DefaultTableModel) tabelProfi.getModel();


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

                        modelCursuri.setColumnIdentifiers(columnsName);
                        Object[] lines = br.lines().toArray();

                        modelCursuri.setRowCount(0);

                        for (int i = 0; i < lines.length; i++) {
                            String[] row = lines[i].toString().split(",");
                            modelCursuri.addRow(row);
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

                        modelStudenti.setColumnIdentifiers(columnsName);
                        Object[] lines = br.lines().toArray();


                        modelStudenti.setRowCount(0);

                        for (int i = 0; i < lines.length; i++) {
                            String[] row = lines[i].toString().split(",");
                            modelStudenti.addRow(row);
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

                        modelProfi.setColumnIdentifiers(columnsName);
                        Object[] lines = br.lines().toArray();


                        modelProfi.setRowCount(0);

                        for (int i = 0; i < lines.length; i++) {
                            String[] row = lines[i].toString().split(",");
                            modelProfi.addRow(row);
                        }
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                index[0] = 2;
                panouTab.setSelectedIndex(index[0]);

            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    if (index[0] == 0) {

                        modelCursuri.addRow(new Object[]{"nume", "descriere"});
                    }
                    if (index[0] == 1) {
                        modelStudenti.addRow(new Object[]{"nume", "prenume", "grupa"});
                    }
                    if (index[0] == 2) {

                        modelProfi.addRow(new Object[]{"nume", "prenume"});
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }


            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (index[0] == 0) {

                        if (tabelCursuri.getSelectedRow() != -1) {

                            modelCursuri.removeRow(tabelCursuri.getSelectedRow());
                        }
                    }
                    if (index[0] == 1) {
                        if (tabelStudenti.getSelectedRow() != -1) {

                            modelStudenti.removeRow(tabelStudenti.getSelectedRow());
                        }
                    }
                    if (index[0] == 2) {
                        if (tabelProfi.getSelectedRow() != -1) {

                            modelProfi.removeRow(tabelProfi.getSelectedRow());
                        }
                    }

                } catch (Exception ex) {
                    System.out.println(ex);
                }


            }
        });


        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (index[0] == 0) {

                        PrintWriter writer = new PrintWriter("cursuri.csv");
                        writer.print("");
                        writer.close();
                        cursuri.clear();
                        for (int i = 0; i < tabelCursuri.getRowCount(); i++) {
                            Curs c = new Curs(tabelCursuri.getValueAt(i, 0).toString(), tabelCursuri.getValueAt(i, 1).toString());
                            cursuri.add(c);
                        }
                        for (Curs c : cursuri)
                            c.ScrieCSV("cursuri.csv");

                    }


                    if (index[0] == 1) {

                        PrintWriter writer = new PrintWriter("studenti.csv");
                        writer.print("");
                        writer.close();
                        studenti.clear();
                        for (int i = 0; i < tabelStudenti.getRowCount(); i++) {
                            Student s = new Student(tabelStudenti.getValueAt(i, 0).toString(), tabelStudenti.getValueAt(i, 1).toString(), Integer.parseInt(tabelStudenti.getValueAt(i, 2).toString()));
                            studenti.add(s);
                        }
                        for (Student s : studenti)
                            s.ScrieCSV("studenti.csv");

                    }
                    if (index[0] == 2) {


                        PrintWriter writer = new PrintWriter("profesori.csv");
                        writer.print("");
                        writer.close();
                        profesori.clear();
                        for (int i = 0; i < tabelProfi.getRowCount(); i++) {
                            Profesor p = new Profesor(tabelProfi.getValueAt(i, 0).toString(), tabelProfi.getValueAt(i, 1).toString());
                            profesori.add(p);
                        }
                        for (Profesor p : profesori)
                            p.ScrieCSV("profesori.csv");

                    }


                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }

        });


    }


}