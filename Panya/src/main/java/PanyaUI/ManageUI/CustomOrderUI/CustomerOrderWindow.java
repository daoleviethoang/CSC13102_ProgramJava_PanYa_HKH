package PanyaUI.ManageUI.CustomOrderUI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.DefaultRowSorter;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.BigInteger;

import PanyaCore.CustomProduct;
import PanyaUI.ManageUI.HistoryUI.UpdateHistoryForm;

public class CustomerOrderWindow extends CustomerOrderWindowBase {

    /**
     *
     */
    private static final long serialVersionUID = 7588376371485028071L;

    String customProductFile = "Panya/src/main/resources/data/ManageData/CustomerProductFile.json";
    List<CustomProduct> customProducts;
    DefaultTableModel productModel;
    JFrame addFrame;
    JFrame updateFrame;
    AddCustomerOrderForm addForm;
    AddCustomerOrderForm updateForm;

    CustomerOrderWindow() {
        super();
        initComponents();
        this.customProducts = CustomProduct.readCustomProductList(this.customProductFile);
        initTable();
        initAction();
    }

    public CustomerOrderWindow(Color primary, Color light, Color dark) {
        super();
        initComponents();
        this.customProducts = CustomProduct.readCustomProductList(this.customProductFile);
        initTable();
        initAction();
        initTheme(primary, light, dark);
    }

    void initComponents() {
        this.addForm = new AddCustomerOrderForm();
        this.updateForm = new AddCustomerOrderForm();
        this.updateForm.addButton.setText("Update");

        this.addFrame = new JFrame();
        this.addFrame.setSize(428, 487);
        this.addFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.addFrame.add(this.addForm);

        this.updateFrame = new JFrame();
        this.updateFrame.setSize(428, 487);
        this.updateFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.updateFrame.add(this.updateForm);
        this.updateButon.setVisible(false);

    }

    void refreshTable() {
        while (this.productTable.getRowCount() > 0) {
            this.productModel.removeRow(0);
        }
        this.customProducts = CustomProduct.readCustomProductList(this.customProductFile);

        Collections.sort(this.customProducts, (o1, o2) -> {
            return o1.getId().compareTo(o2.getId());
        });

        var i = 0;
        if (this.customProducts != null) {
            for (var customProduct : customProducts) {

                var objects = new ArrayList<Object>();
                objects.add(++i);
                objects.add(customProduct.getName());
                objects.add(customProduct.getCustomerPhoneNumber());
                objects.add(customProduct.getCustomerAddress());
                objects.add(customProduct.getName());
                objects.add(customProduct.getQuantity());
                objects.add(customProduct.getSellOff().toString());
                objects.add(customProduct.getPrice().toString());
                this.productModel.addRow(objects.toArray());

            }
        }

    }

    void initTable() {
        this.productModel = (DefaultTableModel) this.productTable.getModel();
        refreshTable();
    }

    void initAction() {
        this.addButon.addActionListener(e -> {
            this.addFrame.setVisible(true);
            this.clearAddForm(this.addForm);
            this.addForm.id.setText(CustomProduct.nextId(customProducts));
        });

        this.addForm.addButton.addActionListener(e -> {
            actionPerformedAddButton();
        });

        this.productTable.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    showUpdateForm();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    showUpdateForm();
                }
            }
        });

        this.updateForm.addButton.addActionListener(e -> {
            actionPerformedUpdateButton();
        });

        this.deleteButon.addActionListener(e -> {
            var idx = this.productTable.getSelectedRow();
            if (idx == -1 ){
                return;
            }

            var option = JOptionPane.showConfirmDialog(this, "Do you really want to remove this item?", "Remove confirmation", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                this.customProducts.remove(idx);
                CustomProduct.saveCustomProductList(customProductFile, customProducts);
                refreshTable();
            }
        });

        this.searchTextField.getDocument().addDocumentListener(new DocumentListener(){
            public void changedUpdate(DocumentEvent e) {
                tableFilter();
            }

            public void insertUpdate(DocumentEvent e) {
                tableFilter();
            }

            public void removeUpdate(DocumentEvent e) {
                tableFilter();
            }
        });
    }

    void showUpdateForm() {
        this.clearAddForm(this.updateForm);
        this.updateFrame.setVisible(true);
        var idx = this.productTable.getSelectedRow();
        if (idx == -1) {
            return;
        }
        var product = this.customProducts.get(idx);
        updateForm.address.setText(product.getCustomerAddress());
        updateForm.name.setText(product.getCustomerName());
        updateForm.nameItem.setText(product.getName());
        updateForm.note.setText(product.getNote());
        updateForm.phone.setText(product.getCustomerPhoneNumber());
        updateForm.price.setText(product.getPriceString());
        updateForm.priceItem.setText(product.getCustomPriceString());
        updateForm.quantity.setText(Integer.valueOf(product.getQuantity()).toString());
        updateForm.sellOff.setText(product.getSellOffString());
        updateForm.id.setText(product.getId());
    }

    void actionPerformedUpdateButton() {
        var address = updateForm.address.getText();
        var name = updateForm.name.getText();
        var nameItem = updateForm.nameItem.getText();
        var note = updateForm.note.getText();
        var phone = updateForm.phone.getText();
        var price = BigDecimal.ZERO;
        var quantity = 1;
        var priceItem = BigDecimal.ZERO;
        var sellOff = BigDecimal.ZERO;
        try {
            if (!updateForm.price.getText().isEmpty()) {
                price = new BigDecimal(updateForm.price.getText());
            }
            if (!updateForm.priceItem.getText().isEmpty()) {
                priceItem = new BigDecimal(updateForm.priceItem.getText());
            }
            if (!updateForm.quantity.getText().isEmpty()) {
                quantity = Integer.valueOf(updateForm.quantity.getText());
            }
            if (!updateForm.sellOff.getText().isEmpty()) {
                sellOff = new BigDecimal(updateForm.sellOff.getText());
            }

            if (price.compareTo(BigDecimal.ZERO) == -1 || priceItem.compareTo(BigDecimal.ZERO) == -1 || quantity < 0
                    || sellOff.compareTo(BigDecimal.ZERO) == -1) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this.updateForm, "Invalid format number",
                    "Please input a valid number format", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this.updateForm, "Empty name", "Please input a name",
                    JOptionPane.ERROR_MESSAGE);
        }
        var id = updateForm.id.getText();

        var customProduct = new CustomProduct(id, nameItem, price, quantity, sellOff, note, priceItem, name, phone,
                address);

        // this.customProducts.add(customProduct);
        var idx = this.customProducts.indexOf(customProduct);
        if (idx == -1) {
            this.addFrame.setVisible(false);
            return;
        }
        this.customProducts.set(idx, customProduct);

        CustomProduct.saveCustomProductList(customProductFile, this.customProducts);
        refreshTable();
        this.updateFrame.setVisible(false);

    }

    void actionPerformedAddButton() {
        var address = addForm.address.getText();
        var name = addForm.name.getText();
        var nameItem = addForm.nameItem.getText();
        var note = addForm.note.getText();
        var phone = addForm.phone.getText();
        var price = BigDecimal.ZERO;
        var quantity = 1;
        var priceItem = BigDecimal.ZERO;
        var sellOff = BigDecimal.ZERO;

        try {
            if (!addForm.price.getText().isEmpty()) {
                price = new BigDecimal(addForm.price.getText());
            }
            if (!addForm.priceItem.getText().isEmpty()) {
                priceItem = new BigDecimal(addForm.priceItem.getText());
            }
            if (!addForm.quantity.getText().isEmpty()) {
                quantity = Integer.valueOf(addForm.quantity.getText());
            }
            if (!addForm.sellOff.getText().isEmpty()) {
                sellOff = new BigDecimal(addForm.sellOff.getText());
            }

            if (price.compareTo(BigDecimal.ZERO) == -1 || priceItem.compareTo(BigDecimal.ZERO) == -1 || quantity < 0
                    || sellOff.compareTo(BigDecimal.ZERO) == -1) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this.addForm, "Invalid format number", "Please input a valid number format",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this.addForm, "Empty name", "Please input a name", JOptionPane.ERROR_MESSAGE);
        }
        var id = addForm.id.getText();
        var customProduct = new CustomProduct(id, nameItem, price, quantity, sellOff, note, priceItem, name, phone,
                address);

        this.customProducts.add(customProduct);
        Collections.sort(this.customProducts, (o1, o2) -> {
            return o1.getId().compareTo(o2.getId());
        });
        CustomProduct.saveCustomProductList(customProductFile, this.customProducts);
        refreshTable();
        this.addFrame.setVisible(false);
    }

    void clearAddForm(AddCustomerOrderForm addForm) {
        addForm.address.setText("");
        addForm.name.setText("");
        addForm.nameItem.setText("");
        addForm.note.setText("");
        addForm.phone.setText("");
        addForm.price.setText("");
        addForm.priceItem.setText("");
        addForm.quantity.setText("");
        addForm.sellOff.setText("");
        addForm.id.setText("");
    }

    private void tableFilter() {
        RowFilter<DefaultTableModel, Object> rf = null;
        // If current expression doesn't parse, don't update.
        try {
            rf = RowFilter.regexFilter("(?i)" + this.searchTextField.getText());
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        ((DefaultRowSorter) this.productTable.getRowSorter()).setRowFilter(rf);
    }

}
