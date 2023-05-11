package Ventas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class subscripciones {

	JFrame frame;
	private JTextField txtSuTarjeta;
	static final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextField txtFechaCaducidad;
	private JPasswordField passwordField;
	private JTextField txtEscribeAqui;
	private JTextField txtRepitelaAqui;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					subscripciones window = new subscripciones();
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
	public subscripciones() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(255, 248, 220));
		frame.getContentPane().setLayout(null);
		tabbedPane.setBounds(-11, -47, 763, 521);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 248, 220));
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		 JLabel pago = new JLabel("Realizacion de pago");
		pago.setBounds(237, 83, 299, 37);
		panel.add(pago);
		pago.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		txtSuTarjeta = new JTextField();
		txtSuTarjeta.setBounds(192, 201, 403, 55);
		panel.add(txtSuTarjeta);
		txtSuTarjeta.setText("\r\n");
		txtSuTarjeta.setColumns(10);
		
		JButton btnNewButton = new JButton("Pagar");
		
		btnNewButton.setBackground(new Color(244, 164, 96));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(276, 345, 228, 83);
		panel.add(btnNewButton);
		
		txtFechaCaducidad = new JTextField();
		txtFechaCaducidad.setHorizontalAlignment(SwingConstants.CENTER);
		txtFechaCaducidad.setColumns(10);
		txtFechaCaducidad.setBounds(444, 284, 151, 50);
		panel.add(txtFechaCaducidad);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("");
		passwordField.setBounds(192, 284, 132, 50);
		panel.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("CVV");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(104, 284, 62, 50);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Su tarjeta");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(104, 203, 62, 50);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Fecha caducidad");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(334, 284, 99, 50);
		panel.add(lblNewLabel_1_2);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setVisible(false);
		progressBar.setIndeterminate(true);
		progressBar.setBackground(new Color(255, 250, 250));
		progressBar.setBounds(203, 444, 368, 25);
		panel.add(progressBar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 248, 220));
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cambio de contraseña");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(242, 114, 308, 61);
		panel_1.add(lblNewLabel);
		
		txtEscribeAqui = new JTextField();
		txtEscribeAqui.setHorizontalAlignment(SwingConstants.CENTER);
		txtEscribeAqui.setText("Escribe aqui");
		txtEscribeAqui.setBounds(176, 214, 406, 44);
		panel_1.add(txtEscribeAqui);
		txtEscribeAqui.setColumns(10);
		
		txtRepitelaAqui = new JTextField();
		txtRepitelaAqui.setText("Repitela aqui");
		txtRepitelaAqui.setHorizontalAlignment(SwingConstants.CENTER);
		txtRepitelaAqui.setColumns(10);
		txtRepitelaAqui.setBounds(176, 269, 406, 44);
		panel_1.add(txtRepitelaAqui);
		
		JButton btnNewButton_1 = new JButton("Realizar cambios");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtEscribeAqui.getText().compareToIgnoreCase(txtRepitelaAqui.getText())==0) {
					JOptionPane.showMessageDialog(null,"contraseña cambiada");
					try {
						Conexion.actualizarUsuario(Inicio.usuario.getText(),txtRepitelaAqui.getText());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden, intentalo de nuevo");
				}
			}
		});
		btnNewButton_1.setBackground(new Color(255, 160, 122));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(258, 349, 254, 61);
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Gracias por su compra");
		lblNewLabel_2.setFont(new Font("Vivaldi", Font.PLAIN, 45));
		lblNewLabel_2.setBounds(196, 133, 493, 214);
		panel_2.add(lblNewLabel_2);
		frame.setBounds(450, 200, 750, 500);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(txtRepitelaAqui.getText().length() ==20 && passwordField.getText().length()==3) {
				progressBar.setVisible(true);
				Timer timer=new Timer(5000,new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(tabbedPane.getSelectedIndex()!=1) {
							progressBar.setVisible(false);
							tabbedPane.setSelectedIndex(2);
						}
						
						
					}
				});
				timer.start();
				
			}else {
				JOptionPane.showInternalMessageDialog(null, "Tarjeta vacia");
			}
			}
				
				
				
		});
		
	}
}
