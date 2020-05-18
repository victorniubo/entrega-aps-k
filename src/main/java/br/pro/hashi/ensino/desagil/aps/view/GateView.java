package br.pro.hashi.ensino.desagil.aps.view;

import br.pro.hashi.ensino.desagil.aps.model.Gate;
import br.pro.hashi.ensino.desagil.aps.model.Light;
import br.pro.hashi.ensino.desagil.aps.model.Switch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

public class GateView extends FixedPanel implements ActionListener, MouseListener {
    private final Light luz;

    private final Switch switch0;
    private final Switch switch1;
    private final Switch switch2;

    private final JCheckBox in0;
    private final JCheckBox in1;
    private final JCheckBox in2;
    //private final JCheckBox out;
    private final Image image;
    private Color color;

    public GateView(Gate gate) {
        super(300, 150);


        luz = new Light(250, 0, 0);
        color = luz.getColor();

        switch0 = new Switch();
        switch1 = new Switch();
        switch2 = new Switch();

        in0 = new JCheckBox();
        in1 = new JCheckBox();
        in2 = new JCheckBox();
        //out = new JCheckBox();

        JLabel in0Label = new JLabel("Ent. 1");
        JLabel in1Label = new JLabel("Ent. 2");
        JLabel in2Label = new JLabel("Ent. 3");
        //JLabel outLabel = new JLabel("Saida");

        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        gate.connect(0, switch0);
        add(in0Label, 4, 57, 75, 25);
        add(in0, 45, 61, 20, 20);
        if (gate.getInputSize() == 2) {
            gate.connect(1, switch1);
            add(in0Label, 4, 40, 75, 25);
            add(in0, 45, 42, 20, 20);

            add(in1Label, 4, 76, 75, 25);
            add(in1, 45, 78, 20, 20);
            in1.addActionListener(this);
        } else if (gate.getInputSize() == 3) {
            gate.connect(1, switch1);
            gate.connect(2, switch2);
            add(in0Label, 4, 40, 75, 25);
            add(in0, 45, 42, 20, 20);

            add(in1Label, 4, 56, 75, 25);
            add(in1, 45, 58, 20, 20);
            in1.addActionListener(this);

            add(in2Label, 4, 72, 75, 25);
            add(in2, 45, 74, 20, 20);
            in2.addActionListener(this);
        }
//        add(outLabel, 248, 57, 75, 25);
//        add(out, 225, 61, 17, 17);

        color = Color.BLACK;

        // Usamos esse carregamento nos Desafios, vocês lembram?
        String name = gate.toString() + ".png";
        URL url = getClass().getClassLoader().getResource(name);
        image = getToolkit().getImage(url);


        in0.addActionListener(this);
        in1.addActionListener(this);
        //out.setEnabled(false);

        addMouseListener(this);
        luz.connect(0, gate);
        update();

    }

    private void update() {


        if (in0.isSelected()) {
            switch0.turnOn();
        } else {
            switch0.turnOff();
        }

        if (in1.isSelected()) {
            switch1.turnOn();
        } else {
            switch1.turnOff();
        }

        if (in2.isSelected()) {
            switch2.turnOn();
        } else {
            switch2.turnOff();
        }

        color = luz.getColor();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        update();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        //Descobre em qual posição o clique ocorreu.
        int x = mouseEvent.getX();
        int y = mouseEvent.getY();

        // Se o clique foi dentro do quadrado colorido...
        if (Math.sqrt(x - 225) + Math.sqrt(y - 61) <= 400) {

            // ...então abrimos a janela seletora de cor...
            color = JColorChooser.showDialog(this, null, color);
            luz.setColor(color);
            update();
        }

    }


    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void paintComponent(Graphics g) {


        // Não podemos esquecer desta linha, pois não somos os
        // únicos responsáveis por desenhar o painel, como era
        // o caso nos Desafios. Agora é preciso desenhar também
        // componentes internas, e isso é feito pela superclasse.

        super.paintComponent(g);


        // Desenha a imagem, passando sua posição e seu tamanho.
        g.drawImage(image, 65, 30, 160, 80, this);

        // Desenha um quadrado cheio.
        g.setColor(color);
        g.fillOval(225, 61, 20, 20);

        // Linha necessária para evitar atrasos
        // de renderização em sistemas Linux.
        getToolkit().sync();
    }
}
