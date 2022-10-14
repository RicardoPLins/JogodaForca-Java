import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class ForcaGrafico {

	private JFrame frame;
	private JButton button;
	private JTextField textField;
	private JLabel label;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton button_1;
	private JLabel label_1;
	String[] penalidades = {"perna1", "perna2", "braço1", "braço2", "tronco", "cabeça"};
	String letra;
	String[] letrasAdivinhadas; 	
	ArrayList<Integer> posicoes;
	public JogoDaForca jogo;
	private JTextField textField_4;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField textField_5;
	private JTextField textField_6;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForcaGrafico window = new ForcaGrafico();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ForcaGrafico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		button = new JButton("Iniciar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JogoDaForca jogo = new JogoDaForca("c:\\\\Users\\\\ricar\\\\Downloads\\\\palavras.csv");
					jogo.iniciar();
					letrasAdivinhadas = new String[jogo.getTamanho()];	
					Arrays.fill(letrasAdivinhadas, "");
					textField_1.setText(jogo.getDica());
					textField_2.setText(jogo.getTamanho()+"");
					textField_3.setText(jogo.getResultado());
					textField_4.setText(jogo.getPenalidade()+"");
					textField_5.setText(jogo.getAcertos()+"");
				}
				catch(Exception i) {
					System.out.println(i.getMessage());
				}


			}
		});
		button.setBounds(113, 11, 89, 23);
		frame.getContentPane().add(button);

		textField = new JTextField();
		textField.setBounds(168, 58, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		label = new JLabel("Digite uma letra:");
		label.setBounds(29, 61, 129, 14);
		frame.getContentPane().add(label);

		textField_1 = new JTextField();
		textField_1.setBounds(32, 140, 222, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(32, 171, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(132, 219, 191, 31);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		button_1 = new JButton("Enter");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_6.setText("");
				textField_5.setText("");
				textField_4.setText("");
				do {
					letra = textField.getText();
					textField.setText("");
					try {
						posicoes = jogo.getPosicoes(letra);
						if (posicoes.size()>0) {
							for(int i : posicoes)
								letrasAdivinhadas[i] = letra;
							textField_5.setText(jogo.getAcertos()+"");
							textField_6.setText(Arrays.toString(letrasAdivinhadas));
						} 
						else {
							textField_4.setText(jogo.getPenalidade()+"");
						}
					}
					catch(Exception e1) {
						System.out.println(e1.getMessage());
					}
					textField_1.setText(jogo.getDica());
					textField_2.setText(jogo.getTamanho()+"");
					textField_3.setText(jogo.getResultado());
				}
				while(!jogo.terminou());
			}

		});
		button_1.setBounds(168, 92, 89, 23);
		frame.getContentPane().add(button_1);

		label_1 = new JLabel("Situação");
		label_1.setBounds(32, 227, 86, 14);
		frame.getContentPane().add(label_1);

		textField_4 = new JTextField();
		textField_4.setBounds(116, 199, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		label_2 = new JLabel("Penalidade");
		label_2.setBounds(29, 202, 89, 14);
		frame.getContentPane().add(label_2);

		label_3 = new JLabel("Acertos");
		label_3.setBounds(329, 20, 46, 14);
		frame.getContentPane().add(label_3);

		textField_5 = new JTextField();
		textField_5.setBounds(315, 45, 86, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(300, 113, 124, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
	}
}
