package br.pro.hashi.ensino.desagil.aps.view;

import br.pro.hashi.ensino.desagil.aps.model.Gate;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class View extends JPanel implements ActionListener {
    private final JComboBox<Gate> menu;
    private GateView gateView;

    public View(LinkedList<Gate> model) {
        menu = new JComboBox<>();
        for (Gate gate : model) {
            menu.addItem(gate);
        }
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(menu);
        addGateView(0);
        menu.addActionListener(this);
    }

    private void addGateView(int index) {

        // 1. Usar o índice para pegar a calculadora do menu.
        Gate gate = menu.getItemAt(index);

        // 2. Construir a representação gráfica a partir dela.
        gateView = new GateView(gate);

        // 3. Adicionar essa representação gráfica no JPanel.
        add(gateView);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        remove(gateView);
        int index = menu.getSelectedIndex();
        addGateView(index);
        ((JFrame) SwingUtilities.getRoot(this)).pack();
    }
}


