package xl.book_store.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xl.book_store.service.ServiceBook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@Component
public class BookForm extends JFrame {
    ServiceBook serviceBook;
    private JPanel panel;
    private JTable bookTable;
    private DefaultTableModel bookTableModel;

    @Autowired
    public BookForm(ServiceBook serviceBook){
        this.serviceBook = serviceBook;
        startForm();

    }

    private void startForm(){
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900, 700);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - getWidth() / 2);
        int y = (screenSize.height - getHeight() / 2);
        setLocation(x, y);
    }


    private void createUIComponents() {
        this.bookTableModel = new DefaultTableModel(0, 5);
        String[] headers = {"id", "Book", "Author", "Price", "Existence"};
        this.bookTableModel.setColumnIdentifiers(headers);

        this.bookTable = new JTable(bookTableModel);
    }
}
