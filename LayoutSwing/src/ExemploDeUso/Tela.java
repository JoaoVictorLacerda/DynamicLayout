package ExemploDeUso;

import DynamicLayout.DynamicLayout;

import javax.swing.*;
import java.awt.*;

public class Tela extends JFrame {
    private final JPanel PAINEL = new JPanel();
    public Tela(){
        Container div = this.getContentPane();
        div.setBackground(new Color(179, 179, 179));
        this.setSize(700,400);
        this.setLayout(new DynamicLayout(700,400));
        this.configuraPainel();
        this.setResizable(true);
        this.setMinimumSize(new Dimension(630,350));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addLabels();
        this.addJButton();
        this.addJTextFields();
        this.setVisible(true);
    }
    public void addJButton(){
        JButton button = new JButton("click me");
        button.setBounds(95,150,110,30);

        this.PAINEL.add(button);
    }
    public void addJTextFields(){
        JTextField senha = new JTextField();
        JTextField email = new JTextField();
        senha.setBounds(175,32,120,35);
        email.setBounds(175,102,120,35);
        this.PAINEL.add(senha);
        this.PAINEL.add(email);
    }
    public void addLabels(){
        JLabel senha = new JLabel("Digite sua senha: ",JLabel.CENTER);
        JLabel email = new JLabel("Digite seu email: ",JLabel.CENTER);
        senha.setOpaque(true);
        senha.setBackground(Color.BLUE);
        senha.setBounds(20,30,150,40);

        email.setOpaque(true);
        email.setBackground(Color.GRAY);
        email.setBounds(20,100,150,40);


        this.PAINEL.add(senha);
        this.PAINEL.add(email);

    }
    public void configuraPainel(){
        this.PAINEL.setBackground(Color.DARK_GRAY);
        this.PAINEL.setLayout(new DynamicLayout(300,260));
        this.PAINEL.setBounds(200,70,300,260);
        this.add(PAINEL);
    }

}
