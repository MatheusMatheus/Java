package socket01_C_HW;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Principal extends JDialog {
	private static final long serialVersionUID = 1L;
	private Cliente cliente;
	private boolean conectado;
	private JLabel lblHost = new JLabel("Servidor");
	private JTextField edtHost = new JTextField("localhost");
	private JLabel lblNome = new JLabel("Nome");
	private JTextField edtNome = new JTextField();
	private JButton btnConectar = new JButton("Conectar");
	private JTextArea taMensagens = new JTextArea();
	private JScrollPane sbMensagens = new JScrollPane(this.taMensagens, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private JLabel lblMensagem = new JLabel("Mensagem");
	private JTextField edtMensagem = new JTextField();
	private JButton btnEnviar = new JButton("Enviar");
	
	@SuppressWarnings("deprecation")
	public Principal(Cliente cliente) {
		this.cliente = cliente;
		this.conectado = false;
		this.mostrar();
		this.show();
	}
	
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		new Principal(cliente);
	}

	public void mostrar() {
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(new Color(238, 238, 238));
		this.setSize(538, 355);
		this.setLocation(217, 172);
		this.setTitle("Chat - Cliente");
		this.setResizable(false);
		this.setModal(true);
		this.lblHost.setBounds(new Rectangle(10, 13, 57, 13));
		this.getContentPane().add(lblHost, null);
		this.edtHost.setBounds(new Rectangle(62, 10, 140, 22));
		this.getContentPane().add(edtHost, null);
		this.lblNome.setBounds(new Rectangle(213, 13, 57, 13));
		this.getContentPane().add(lblNome, null);
		this.edtNome.setBounds(new Rectangle(250, 10, 140, 22));
		this.getContentPane().add(edtNome, null);
		this.btnConectar.setBounds(new Rectangle(400, 10, 110, 22));
		this.getContentPane().add(btnConectar, null);
		this.taMensagens.setEditable(false);
		this.sbMensagens.setBounds(new Rectangle(10, 40, 500, 235));
		this.getContentPane().add(this.sbMensagens, null);
		this.lblMensagem.setBounds(new Rectangle(10, 287, 75, 14));
		this.getContentPane().add(lblMensagem, null);
		this.edtMensagem.setBounds(new Rectangle(80, 285, 350, 22));
		this.edtMensagem.setEnabled(false);
		this.getContentPane().add(edtMensagem, null);
		this.btnEnviar.setBounds(new Rectangle(440, 285, 70, 22));
		this.btnEnviar.setEnabled(false);
		this.getContentPane().add(btnEnviar, null);
		this.btnConectar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				conectar();
			}});
		this.btnEnviar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				enviarMensagem();
			}});
		
		this.edtMensagem.addActionListener (new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
				enviarMensagem();
	      }});		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				fechar();
			}
		});
	}
	
	private void conectar() {
		if (this.conectado) {
			this.cliente.desconectar();
			this.conectado = false;
		}
		else
			if (this.edtNome.getText().length() == 0) {
				this.taMensagens.insert("Informe o nome\n", 0);
				this.edtNome.requestFocus();
			}
			else {
				this.conectado = this.cliente.conectar(this.edtHost.getText(), this.edtNome.getText(), this.taMensagens);
				if (!this.conectado)
					this.taMensagens.insert("Erro de conexão\n", 0);
			}
		this.habilitar();
	}
	
	private void enviarMensagem() {
		this.cliente.enviarMensagem(this.edtMensagem.getText());
		this.edtMensagem.setText("");
		this.edtMensagem.requestFocus();
	}

	private void fechar() {
		if (this.conectado)
			this.cliente.desconectar();
		System.exit(0);
	}
	
	private void habilitar() {
		if (this.conectado)
			this.btnConectar.setText("Desconectar");
		else
			this.btnConectar.setText("Conectar");
		this.edtHost.setEnabled(!this.conectado);
		this.edtNome.setEnabled(!this.conectado);
		this.edtMensagem.setEnabled(this.conectado);
		this.btnEnviar.setEnabled(this.conectado);
	}

}