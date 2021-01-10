package laborator3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

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
                String[] nullstring={"",""};

                try{
                    if(index[0]==0) {

                        modelCursuri.addRow(nullstring);
                    }
                        if(index[0]==1) {
                            modelStudenti.addRow(nullstring);
                        }
                    if(index[0]==2)
                        modelProfi.addRow(nullstring);

                }
                catch(Exception ex) {System.out.println(ex);}


            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    if(index[0]==0) {

                        if(tabelCursuri.getSelectedRow()!=-1)
                        modelCursuri.removeRow(tabelCursuri.getSelectedRow());
                    }
                    if(index[0]==1) {
                        if(tabelStudenti.getSelectedRow()!=-1)
                        modelStudenti.removeRow(tabelStudenti.getSelectedRow());
                    }
                    if(index[0]==2)
                        if(tabelProfi.getSelectedRow()!=-1)
                        modelProfi.removeRow(tabelProfi.getSelectedRow());

                }
                catch(Exception ex) {System.out.println(ex);}


            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    if(index[0]==0) {

                        File file = new File("cursuri.csv");
                        try {

                            FileWriter fw = new FileWriter(file);
                            FileReader fr = new FileReader(file);
                            BufferedWriter bw = new BufferedWriter(fw);
                            BufferedReader br = new BufferedReader(fr);
                            String line = br.readLine();
                            if (line == null)
                                bw.write("nume, descriere\r\n"); //se scrie antetul

                            for(int i = 0; i < modelCursuri.getRowCount(); i++){//rows
                                for(int j = 0; j < modelCursuri.getColumnCount(); j++){//columns
                                    bw.write(modelCursuri.getValueAt(i, j).toString()+",");

                                }
                                bw.newLine();
                            }

                            bw.close();
                            br.close();
                            fw.close();
                            fr.close();

                        } catch (IOException ex) {
                            System.out.println(ex);
                        }

                    }






                    if(index[0]==1) {
                        if(tabelStudenti.getSelectedRow()!=-1)
                            modelStudenti.removeRow(tabelStudenti.getSelectedRow());
                    }
                    if(index[0]==2)
                        if(tabelProfi.getSelectedRow()!=-1)
                            modelProfi.removeRow(tabelProfi.getSelectedRow());

                }
                catch(Exception ex) {System.out.println(ex);}


            }
        });
    }


}