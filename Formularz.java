package BL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Formularz extends JFrame{
    private JPanel RootPanel;
    private JTextField imie;
    private JTextField nazwisko;
    private JComboBox wylotZ;
    private JComboBox przylotDo;
    private JRadioButton takRadioButton;
    private JRadioButton nieRadioButton;
    private JCheckBox przystawkaCheckBox;
    private JCheckBox obiadCheckBox;
    private JCheckBox deserCheckBox;
    private JTextArea uwagi;
    private JButton dodajRezerwacjeButton;
    private JTable table1;
    private JLabel wylotDo;
    private JButton usuńRezerwacjeButton;
    private JButton button1;

    private ArrayList<Rezerwacja>listaRezerwacji=new ArrayList<>();
    private ArrayList<String> listaPosilkow = new ArrayList<>();
    private String selectedVip = "";

    public String pathListaRezerwacji= "C:\\Users\\Hores di En'Claws\\Desktop\\Projekty ALX\\src\\BL\\listaRezerwacji.txt";

    public Formularz () {
        add(RootPanel);
        setTitle("Formularz rezerwacji");
        setSize(700, 700);
        //zamkniecie okna aplikacji konczy proces
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultTableModel model = new DefaultTableModel();
        table1.setFillsViewportHeight(true);
        table1.setAutoCreateRowSorter(true);
        table1.setPreferredScrollableViewportSize(new Dimension(700, 700));
        model.addColumn("Imię");
        model.addColumn("Nazwisko");
        model.addColumn("Wylot Z");
        model.addColumn("Przylot Do");
        model.addColumn("VIP");
        model.addColumn("Posiłek");
        model.addColumn("Uwagi");
        table1.setModel(model);

        dodajRezerwacjeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (imie.getText().equals("") || imie.getText().equals("imie")) {
                    JOptionPane.showMessageDialog(rootPane, "Wpisz imię");
                } else if (nazwisko.getText().equals("") || nazwisko.getText().equals("nazwisko")) {
                    JOptionPane.showMessageDialog(rootPane, "Wpisz nazwisko");
                } else if (wylotZ.getSelectedItem() == ("")) {
                    JOptionPane.showMessageDialog(rootPane, "Proszę uzupełnić pole Wylot Z");
                } else if (przylotDo.getSelectedItem() == ("")) {
                    JOptionPane.showMessageDialog(rootPane, "Proszę uzupełnić pole Przylot Do");
                //} else if (selectedVip.equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Wybierz opcje VIP");
                } else if (listaPosilkow.size() == 0) {
                    JOptionPane.showMessageDialog(rootPane, "Proszę zaznaczyć posiłek");
                } else {
                    Rezerwacja rezerwacja = new Rezerwacja(imie.getText(), nazwisko.getText(), wylotZ.getSelectedItem().toString(), przylotDo.getSelectedItem().toString(), selectedVip, listaPosilkow, uwagi.getText());
                    listaRezerwacji.add(rezerwacja);

                    listaRezerwacji(model);

                    //czyszczenie formularza
                    imie.setText("");
                    nazwisko.setText("");
                    wylotZ.setSelectedIndex(0);
                    przylotDo.setSelectedIndex(0);
                    takRadioButton.setSelected(false);
                    nieRadioButton.setSelected(false);
                    przystawkaCheckBox.setSelected(false);
                    obiadCheckBox.setSelected(false);
                    deserCheckBox.setSelected(false);
                    listaPosilkow=new ArrayList<>();
                    uwagi.setText("");
                    selectedVip="";


                    try {
                        FileWriter fw = new FileWriter(pathListaRezerwacji, true);
                        fw.append(rezerwacja + "\n");
                        fw.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }


                }
            }
        });

        przystawkaCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (przystawkaCheckBox.isSelected()) {
                    listaPosilkow.add("przystawka");
                } else {
                    listaPosilkow.remove("przystawka");
                }
            }
        });
        obiadCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (obiadCheckBox.isSelected()) {
                    listaPosilkow.add("obiad");
                } else {
                    listaPosilkow.remove("obiad");
                }
            }
        });
        deserCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (deserCheckBox.isSelected()) {
                    listaPosilkow.add("deser");
                } else {
                    listaPosilkow.remove("deser");
                }
            }
        });
        usuńRezerwacjeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table1.getSelectedRow()==-1){
                    JOptionPane.showMessageDialog(rootPane,"Proszę zaznaczyć rezerwacje do usunięcia");
                }
                else{
                    listaRezerwacji.remove(table1.getSelectedRow());
                    listaRezerwacji(model); //odświeżamy
                    JOptionPane.showMessageDialog(rootPane,"Rezerwacja została usunięta");
                }
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //wpisywanie własnych instrukcji przed zamnkięcie programu
                System.exit(0);
            }
        });
        takRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public void listaRezerwacji(DefaultTableModel model) {
        int rowCount = model.getRowCount();
        for (int i=rowCount -1; i>=0;i--){
            model.removeRow(i);
        }

        for (Rezerwacja rezerwacja : listaRezerwacji) {
            model.addRow(new Object[] {
                rezerwacja.imie, rezerwacja.nazwisko, rezerwacja.wylotZ, rezerwacja.przylotDo, rezerwacja.selectedVIP, rezerwacja.selectedPosilek, rezerwacja.uwagi
            });
        }
    }

}
