package com.o18.restaurant;

import com.o18.restaurant.model.Category;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 1 on 27.12.2016.
 */
public class MenuViewScreen extends JFrame {
    private static final String TITLE = "Работа с меню";
    private static final String OPEN = "Открыть";
    private static final String ADD = "+";
    private static final String REMOVE = "-";
    private static final String EDIT = "Изменить";
    private JButton backToSelectionMenuButton;
    private JComboBox<Category> selectionCategoryBox;
    private JButton addCategoryButton;
    private JButton removeCategoryButton;
    private JButton editCategoryButton;
    private JTextField addAndEditNameCategory;


    public MenuViewScreen() {
        super(TITLE);
        backToSelectionMenuButton = getBackToSelectionMenuButton();
        addCategoryButton = getAddCategoryButton();
        removeCategoryButton = getRemoveCategoryButton();
        editCategoryButton = getEditCategoryButton();
        selectionCategoryBox = getSelectionCategoryBox();
        addAndEditNameCategory = getAddAndEditNameCategory();
        MenuSelectionScreen mss = new MenuSelectionScreen();
        this.setSize(700, 400);
        JPanel panel = new JPanel();
        this.add(panel);
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setLayout(gbl);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.anchor = gbc.NORTHWEST;
        panel.add(backToSelectionMenuButton, gbc);
        gbc.gridy = 3;
        gbc.gridx = 5;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(10, 10, 0, 0);
        panel.add(selectionCategoryBox, gbc);
        gbc.gridwidth = 1;
        gbc.gridx = GridBagConstraints.RELATIVE;
        panel.add(addCategoryButton, gbc);
        panel.add(removeCategoryButton, gbc);
        panel.add(editCategoryButton, gbc);
        gbc.gridy = 4;
        gbc.gridx = 5;
        gbc.gridwidth = 3;
        panel.add(addAndEditNameCategory, gbc);
        this.backToSelectionAction();
        this.visibleTextFieldAction(addAndEditNameCategory);
    }

    private JButton getBackToSelectionMenuButton() {
        if (backToSelectionMenuButton == null) {
            backToSelectionMenuButton = new JButton(OPEN);
            backToSelectionMenuButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        }
        return backToSelectionMenuButton;
    }

    private JComboBox<Category> getSelectionCategoryBox() {
        if (selectionCategoryBox == null) {
            Category[] arr = new Category[]{new Category("Мясо"), new Category("Рыба"), new Category("Птица")};
            selectionCategoryBox = new JComboBox<>(arr);
            selectionCategoryBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        }
        return selectionCategoryBox;
    }

    private JButton getAddCategoryButton() {
        if (addCategoryButton == null) {
            addCategoryButton = new JButton(ADD);
            addCategoryButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
        }
        return addCategoryButton;
    }

    private JButton getRemoveCategoryButton() {
        if (removeCategoryButton == null) {
            removeCategoryButton = new JButton(REMOVE);
            removeCategoryButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
        }
        return removeCategoryButton;
    }

    private JButton getEditCategoryButton() {
        if (editCategoryButton == null) {
            editCategoryButton = new JButton(EDIT);
            editCategoryButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        }
        return editCategoryButton;
    }

    private JTextField getAddAndEditNameCategory() {
        if (addAndEditNameCategory == null) {
            addAndEditNameCategory = new JTextField(20);
            addAndEditNameCategory.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
            addAndEditNameCategory.setVisible(false);
        }
        return addAndEditNameCategory;
    }

    private class BackToSelectionScreenAction implements ActionListener {
        private JFrame oldFrame;

        public BackToSelectionScreenAction(JFrame oldFrame) {
            this.oldFrame = oldFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            oldFrame.setVisible(false);
            MenuSelectionScreen.main(new String[]{});
        }
    }

    private void backToSelectionAction() {
        MenuViewScreen.BackToSelectionScreenAction backToSelectionAction = new MenuViewScreen.BackToSelectionScreenAction(this);
        backToSelectionMenuButton.addActionListener(backToSelectionAction);
    }

    private class VisibleTextFieldAction implements ActionListener {
        private JTextField field;

        public VisibleTextFieldAction(JTextField field) {
            this.field = field;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            field.setVisible(true);
        }
    }

    private void visibleTextFieldAction(JTextField field) {
        MenuViewScreen.VisibleTextFieldAction visibleTextFieldAction = new MenuViewScreen.VisibleTextFieldAction(field);
        addCategoryButton.addActionListener(visibleTextFieldAction);
        editCategoryButton.addActionListener(visibleTextFieldAction);
    }
}
