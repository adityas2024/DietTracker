import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Screen extends JFrame {
    private JButton saveNewEntryButton;
    private JButton editEntryButton;
    private JButton printAllWeightsButton;
    private JTextField Date;
    private JTextField Weight;
    private JPanel PanelMain;
    private JPanel PanelLeft;
    private JPanel PanelRight;
    private JPanel PanelRightBottom;
    private JLabel labelDate;
    private JLabel labelWeight;
    private JPanel PanelRightTop;
    private JList listEntry;

    private ArrayList<Entry> Entries;
    private DefaultListModel listEntriesModel;

    Screen(){
        super( "Diet Tracker");
        this.setContentPane(this.PanelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        Entries = new ArrayList<Entry>();
        listEntriesModel = new DefaultListModel<>();
        listEntry.setModel(listEntriesModel);


        saveNewEntryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String D = Date.getText();
                String W = Weight.getText();
                Double We = Double.parseDouble(W);
                Entry a = new Entry(D,We);
                Entries.add(a);
                refreshEntrieslist();

            }
        });
        editEntryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int EntryNumber = listEntry.getSelectedIndex();
                String empty = "";
                if (EntryNumber >= 0) {
                    Entry b = Entries.get(EntryNumber);
                    b.setDate(Date.getText());
                    b.setWeight(Double.parseDouble(Weight.getText()));
                    refreshEntrieslist();
            }}
        });
        printAllWeightsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int EntryNumber = listEntry.getSelectedIndex();
                Entries.remove(EntryNumber);
                refreshEntrieslist();
            }
        });
    }
    public void refreshEntrieslist(){
        listEntriesModel.removeAllElements();
        System.out.println("Removing all entries from the list");
        for (Entry a: Entries ){
            System.out.println("Adding person to the list: " + getName());
            listEntriesModel.addElement(a.getDate() + " " + a.getWeight());
        }
    }
    public void addEntry(Entry a){
        Entries.add(a);
        refreshEntrieslist();
    }

}





