package lopatin.behavioral.state.ui;

import javax.swing.*;
import java.awt.*;

public class Ui {
    private Hero hero;
    private static JTextField textField = new JTextField();

    public Ui(Hero hero) {
        this.hero = hero;
    }

    public void init() {
        JFrame frame = new JFrame("Text RPG");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel context = new JPanel();
        context.setLayout(new BoxLayout(context, BoxLayout.Y_AXIS));
        frame.getContentPane().add(context);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        context.add(textField);
        context.add(buttons);
        JButton play = new JButton("Move");
        play.addActionListener(e -> textField.setText(hero.getState().onMove()));
        JButton stop = new JButton("Stop");
        stop.addActionListener(e -> textField.setText(hero.getState().onStop()));
        JButton next = new JButton("Attack");
        next.addActionListener(e -> textField.setText(hero.getState().onAttack()));
        JButton prev = new JButton("Block");
        prev.addActionListener(e -> textField.setText(hero.getState().onBlock()));
        frame.setVisible(true);
        frame.setSize(300, 100);
        buttons.add(play);
        buttons.add(stop);
        buttons.add(next);
        buttons.add(prev);
    }
}
