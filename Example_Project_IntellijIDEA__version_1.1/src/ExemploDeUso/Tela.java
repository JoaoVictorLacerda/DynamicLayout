package ExemploDeUso;

import DynamicLayout.DynamicLayout;

import javax.swing.*;
import java.awt.*;

public class Tela  {
    private final JFrame FRAME = new JFrame();

    public Tela(String titulo) {
        this.configuracaoJanela(titulo);

    }

    private void configuracaoJanela(String titulo){
        Container div = this.FRAME.getContentPane();
        div.setBackground(new Color(179, 179, 179));
        this.FRAME.setSize(700,400);
        this.FRAME.setTitle("Livraria Digital - "+titulo);
        this.FRAME.setResizable(true);
        this.FRAME.setMinimumSize(new Dimension(650,350));
        this.FRAME.setLocationRelativeTo(null);
        this.FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.FRAME.setLayout(new DynamicLayout(700,400));
        this.addPainel();
        this.addImagemUser();
        this.addFormLabel();
        this.addInputs();
        this.addButtons();
        this.addBackground();
        this.FRAME.setVisible(true);

    }
    private class BackgroundTela extends JPanel {

            private ImageIcon img;

            public BackgroundTela(){
                img = new ImageIcon("img/livros.png");
            }

            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);

                g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);

            }

            public void setImg(ImageIcon img){
                this.img = img;
            }

            public ImageIcon getImg(){
                return this.img;
            }
        }

        private void addBackground(){

            JPanel painel = new BackgroundTela();
            int width = this.FRAME.getWidth();
            int height = this.FRAME.getHeight();

            painel.setBounds(0,0,width,height);
            this.FRAME.add(painel);
        }


    private final JPanel JP_PAINEL =  new JPanel();
    private JTextField email;

    private JPasswordField senha;



    private void addPainel() {
        this.JP_PAINEL.setBounds(200, 15, 300, 340);
        this.JP_PAINEL.setBackground(Color.DARK_GRAY);
        this.JP_PAINEL.setLayout(new DynamicLayout(300,340));
        this.FRAME.add(JP_PAINEL);
    }

    private void addImagemUser() {
        ImageIcon imagemUser = new ImageIcon("img/userADM.png");
        JLabel boasVindas = new JLabel();
        boasVindas.setBounds(0, 2, 300, 100);
        boasVindas.setHorizontalAlignment(JLabel.CENTER);
        boasVindas.setIcon(imagemUser);
        this.JP_PAINEL.add(boasVindas);
    }

    private void addFormLabel() {
        JLabel login = new JLabel("Login do Livreiro",JLabel.CENTER);
        JLabel email = new JLabel("E-mail:",JLabel.RIGHT);
        JLabel senha = new JLabel("Senha:",JLabel.RIGHT);
        Font font = new Font("Arial",Font.BOLD,13);

        login.setBounds(0, 105, 300, 30);
        login.setFont(new Font("Arial",Font.BOLD,13));
        login.setForeground(Color.WHITE);
        this.JP_PAINEL.add(login);

        email.setBounds(0, 145, 80, 40);
        //email.setOpaque(true);
        //email.setBackground(Color.WHITE);
        email.setFont(font);
        this.JP_PAINEL.add(email);

        senha.setBounds(0, 185, 80, 40);
        senha.setFont(font);
        this.JP_PAINEL.add(senha);


    }
    private void addInputs() {
        this.email = new JTextField();
        this.senha = new JPasswordField();

        Font font = new Font("Arial",Font.BOLD,12);

        JSeparator emailSeparador = new JSeparator();
        JSeparator senhaSeparador = new JSeparator();

        email.setBounds(90, 142, 175, 25);
        email.setFont(font);
        email.setForeground(new Color(128, 196, 255));
        email.setBorder(null);
        this.JP_PAINEL.add(email);

        senha.setBounds(90, 182, 175, 25);
        senha.setFont(font);
        senha.setForeground(new Color(128, 196, 255));
        senha.setBorder(null);
        this.JP_PAINEL.add(senha);

        emailSeparador.setBounds(90,167,170,10);
        emailSeparador.setOrientation(JSeparator.HORIZONTAL);
        emailSeparador.setBackground(Color.WHITE);
        this.JP_PAINEL.add(emailSeparador);

        senhaSeparador.setBounds(90,207,170,10);
        senhaSeparador.setOrientation(JSeparator.HORIZONTAL);
        senhaSeparador.setBackground(Color.WHITE);
        this.JP_PAINEL.add(senhaSeparador);



    }


    private void addButtons(){
        JButton entrar = new JButton("Entrar");
        Font font = new Font("Arial",Font.BOLD,12);



        entrar.setBounds(123, 220, 60, 25);
        entrar.setBackground(new Color(102, 102, 102));
        entrar.setFont(font);
        entrar.setBorder(null);
        this.JP_PAINEL.add(entrar);

        JLabel esqueceu = new JLabel("Esqueceu a senha?",JLabel.CENTER);
        esqueceu.setBounds(0, 257, 300, 30);
        esqueceu.setFont(font);
        this.JP_PAINEL.add(esqueceu);


        JButton soucliente = new JButton("Sou Cliente");
        soucliente.setBounds(100, 300, 100, 25);
        soucliente.setBackground(new Color(102, 102, 102));
        soucliente.setFont(font);
        soucliente.setBorder(null);



        this.JP_PAINEL.add(soucliente);

    }
}
