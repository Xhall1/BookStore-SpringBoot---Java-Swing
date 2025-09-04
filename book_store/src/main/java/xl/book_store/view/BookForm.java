package xl.book_store.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xl.book_store.model.Book;
import xl.book_store.service.ServiceBook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class BookForm extends JFrame {
    ServiceBook serviceBook;
    private JPanel panel;
    private JTable bookTable;
    private JTextField idText;
    private JTextField bookText;
    private JTextField authorText;
    private JTextField priceText;
    private JTextField existenceText;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private DefaultTableModel bookTableModel;

    @Autowired
    public BookForm(ServiceBook serviceBook){
        this.serviceBook = serviceBook;
        startForm();

        addButton.addActionListener(e -> addBook());
        bookTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                loadBook();
            }
        });
        editButton.addActionListener(e -> {
            editBook();
        });
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

    private void addBook() {
        if(bookText.getText().equals("")){
            showMessage("Add a name");
            bookText.requestFocusInWindow();
            return;
        }

        var bookName = bookText.getText();
        var author = authorText.getText();
        var price = Double.parseDouble(priceText.getText());
        var existence = Integer.parseInt(existenceText.getText());

        var book = new Book(null, bookName, author, price, existence);
        book.setBookName(bookName);
        book.setAuthor(author);
        book.setPrice(price);
        book.setExistence(existence);
        this.serviceBook.saveBook(book);
        showMessage("Book added");
        clearForm();
    }

    private void loadBook(){
        var line = bookTable.getSelectedRow();
        if(line != -1){
            String idBook =
                    bookTable.getModel().getValueAt(line, 0).toString();
            idText.setText(idBook);
            String bookName =
                    bookTable.getModel().getValueAt(line, 1).toString();
            bookText.setText(bookName);
            String author =
                    bookTable.getModel().getValueAt(line, 2).toString();
            authorText.setText(author);
            String price =
                    bookTable.getModel().getValueAt(line, 3).toString();
            priceText.setText(price);
            String existence =
                    bookTable.getModel().getValueAt(line, 4).toString();
            existenceText.setText(existence);
        }
    }

    private void editBook(){
        if(this.idText.getText().equals("")){
            showMessage("You must select a record");
        } else {
            if(bookText.getText().equals("")){
                showMessage("Give a name to the book");
                bookText.requestFocusInWindow();
                return;
            }

            int idBook = Integer.parseInt(idText.getText());
            var bookName = bookText.getText();
            var author = authorText.getText();
            var price = Double.parseDouble(priceText.getText());
            var existence = Integer.parseInt(existenceText.getText());
            var book =
                    new Book(idBook, bookName, author, price, existence);
            serviceBook.saveBook(book);
            showMessage("The book was modified");
            clearForm();
            listBooks();
        }
    }

    private void clearForm() {
        bookText.setText("");
        authorText.setText("");
        priceText.setText("");
        existenceText.setText("");
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    private void createUIComponents() {

        idText = new JTextField("");
        idText.setVisible(false);

        this.bookTableModel = new DefaultTableModel(0, 5);
        String[] headers = {"id", "Book", "Author", "Price", "Existence"};
        this.bookTableModel.setColumnIdentifiers(headers);

        this.bookTable = new JTable(bookTableModel);

        listBooks();
    }

    private void listBooks(){
        bookTableModel.setRowCount(0);

        var books = serviceBook.listBooks();
        books.forEach((book)-> {
           Object[] lineBook = {
                book.getIdBook(),
                book.getBookName(),
                book.getAuthor(),
                book.getPrice(),
                book.getExistence()
           };
           this.bookTableModel.addRow(lineBook);
        });
    }
}
