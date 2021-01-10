package PanyaUI.ManageUI.HistoryUI;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultRowSorter;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import PanyaCore.History;
import PanyaCore.Product;

public class HistoryWindow extends HistoryWindowBase {
    
    /**
     *
     */
    private static final long serialVersionUID = 2609214394896659859L;

    String historyFile = "Panya/src/main/resources/data/ManageData/HistoryFile.json";
    List<History> histories;
    DefaultTableModel historyModel;

    List<List<Object>> tableRows = new ArrayList<>();
    public HistoryWindow() {
        super();
        initComponents();
        this.histories = History.readHistoryList(historyFile);
        initTable();
    }

    public HistoryWindow(Color primary, Color light, Color dark) {
        super();
        initComponents();
        initTable();
        initTheme(primary, light, dark);
    }

    private void initComponents() {
        this.statisticButton.setVisible(false);

        this.deleteButton.addActionListener(e->{
            var idx = this.historyTable.getSelectedRow();
            if (idx == -1) {
                return;
            }
            var row = this.tableRows.get(idx);
    
            var product = (Product) row.get(5);
            var history = (History) row.get(6);
            history.getProducts().remove(product);
            
            if (history.getProducts().isEmpty()){
                this.histories.remove(history);
            }
            this.tableRows.remove(idx);
            this.historyModel.removeRow(idx);
            History.saveHistoryList(historyFile, this.histories);
        });

        this.searchTextField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                historyTableFilter();
            }

            public void insertUpdate(DocumentEvent e) {
                historyTableFilter();
            }

            public void removeUpdate(DocumentEvent e) {
                historyTableFilter();
            }
        });
    }

    void refreshTable() {
        this.histories = History.readHistoryList(historyFile);
        if (this.histories != null) {

            for (var history : histories) {    
                for (var product : history.getProducts()){
                    var objects = new ArrayList<Object>();
                    
                    objects.add(history.getDate().toString());
                    objects.add(product.getName());
                    objects.add(product.getQuantity());
                    objects.add(product.getSellOff().toString());
                    objects.add(product.getPrice().toString());
                    this.historyModel.addRow(objects.toArray());
                    
                    objects.add(product);
                    objects.add(history);
                    this.tableRows.add(objects);
                }
                
            }
        }
    }

    /**
     * Update the row filter regular expression from the expression in the text box.
     */
    private void historyTableFilter() {
        RowFilter<DefaultTableModel, Object> rf = null;
        // If current expression doesn't parse, don't update.
        try {
            rf = RowFilter.regexFilter("(?i)" + this.searchTextField.getText());
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        ((DefaultRowSorter) this.historyTable.getRowSorter()).setRowFilter(rf);
    }

    public void initTable() {
        
        this.historyModel = (DefaultTableModel) this.historyTable.getModel();
        refreshTable();
    }

    public void initButton() {
        
    }
}
