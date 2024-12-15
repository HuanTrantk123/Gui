package com.mycompany.person;

import javax.swing.*;
import java.awt.*;

public class PersonGUI extends JFrame {
    private PersonList personList;
    private JTextArea displayArea;

    // Trường nhập liệu chung
    private JTextField idField, nameField, specificField1, specificField2;
    private JLabel specificLabel1, specificLabel2;

    public PersonGUI() {
        personList = new PersonList();
        displayArea = new JTextArea(20, 50);
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Arial", Font.PLAIN, 14));

        setTitle("Quản lý Sinh viên và Giáo viên");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Khu vực hiển thị danh sách
        JPanel displayPanel = new JPanel(new BorderLayout());
        displayPanel.setBorder(BorderFactory.createTitledBorder("Khu vực hiển thị"));
        displayPanel.add(new JScrollPane(displayArea), BorderLayout.CENTER);
        add(displayPanel, BorderLayout.CENTER);

        // Khu vực nút chức năng
        JPanel buttonPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Chức năng"));

        JButton addStudentButton = new JButton("Thêm Sinh viên");
        JButton addTeacherButton = new JButton("Thêm Giáo viên");
        JButton updateButton = new JButton("Cập nhật");
        JButton deleteButton = new JButton("Xóa");
        JButton findButton = new JButton("Tìm kiếm");
        JButton displayButton = new JButton("Hiển thị tất cả");
        JButton topStudentsButton = new JButton("Top 3 Sinh viên");
        JButton highestIncomeTeacherButton = new JButton("Giáo viên thu nhập cao nhất");

        buttonPanel.add(addStudentButton);
        buttonPanel.add(addTeacherButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(findButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(topStudentsButton);
        buttonPanel.add(highestIncomeTeacherButton);

        add(buttonPanel, BorderLayout.EAST);

        // Khu vực nhập liệu
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Thông tin chi tiết"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        idField = new JTextField(15);
        nameField = new JTextField(15);
        specificField1 = new JTextField(15);
        specificField2 = new JTextField(15);

        specificLabel1 = new JLabel();
        specificLabel2 = new JLabel();

        addInputField(inputPanel, gbc, "ID:", idField, 0);
        addInputField(inputPanel, gbc, "Name:", nameField, 1);
        addInputField(inputPanel, gbc, specificLabel1, specificField1, 2);
        addInputField(inputPanel, gbc, specificLabel2, specificField2, 3);

        add(inputPanel, BorderLayout.WEST);

        // Sự kiện nút chức năng
        addStudentButton.addActionListener(e -> setInputFieldsForStudent());
        addTeacherButton.addActionListener(e -> setInputFieldsForTeacher());
        addStudentButton.addActionListener(e -> addStudent());
        addTeacherButton.addActionListener(e -> addTeacher());
        updateButton.addActionListener(e -> updatePerson());
        deleteButton.addActionListener(e -> deletePerson());

        setVisible(true);
    }

    private void addInputField(JPanel panel, GridBagConstraints gbc, String label, JTextField textField, int row) {
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel(label), gbc);

        gbc.gridx = 1;
        panel.add(textField, gbc);
    }

    private void setInputFieldsForStudent() {
        specificLabel1.setText("GPA:");
        specificLabel2.setText("Tuition Fee:");
        clearInputFields();
    }

    private void setInputFieldsForTeacher() {
        specificLabel1.setText("Classes:");
        specificLabel2.setText("Salary:");
        clearInputFields();
    }

    private void addStudent() {
        try {
            Student student = new Student();
            student.setId(idField.getText());
            student.setName(nameField.getText());
            student.setGpa(Double.parseDouble(specificField1.getText()));
            student.setTuiitionFee(Double.parseDouble(specificField2.getText()));

            personList.addPerson(student);
            displayArea.append("Đã thêm sinh viên: " + student.getName() + "\n");
            clearInputFields();
        } catch (NumberFormatException ex) {
            displayArea.append("Vui lòng nhập số hợp lệ cho GPA và Tuition Fee.\n");
        }
    }

    private void addTeacher() {
        try {
            Teacher teacher = new Teacher();
            teacher.setId(idField.getText());
            teacher.setName(nameField.getText());
            teacher.setNumberOfClasses(Integer.parseInt(specificField1.getText()));
            teacher.setBaseSalary(Double.parseDouble(specificField2.getText()));

            personList.addPerson(teacher);
            displayArea.append("Đã thêm giáo viên: " + teacher.getName() + "\n");
            clearInputFields();
        } catch (NumberFormatException ex) {
            displayArea.append("Vui lòng nhập số hợp lệ cho Classes và Salary.\n");
        }
    }

    private void updatePerson() {
        String id = idField.getText();
        if (personList.updatePersonById(id)) {
            displayArea.append("Đã cập nhật thông tin cho ID: " + id + "\n");
        } else {
            displayArea.append("Không tìm thấy ID: " + id + "\n");
        }
        clearInputFields();
    }

    private void deletePerson() {
        String id = idField.getText();
        if (personList.deleteById(id)) {
            displayArea.append("Đã xóa ID: " + id + "\n");
        } else {
            displayArea.append("Không tìm thấy ID: " + id + "\n");
        }
        clearInputFields();
    }

    private void clearInputFields() {
        idField.setText("");
        nameField.setText("");
        specificField1.setText("");
        specificField2.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PersonGUI::new);
    }
}
