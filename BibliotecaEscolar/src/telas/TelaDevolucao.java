package telas;

import javax.swing.*;
import controle.*;

public class TelaDevolucao extends JFrame {

	public TelaDevolucao() {
		setTitle("Devolução de Obra");
		setSize(300, 200);
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		JLabel lblMatricula = new JLabel("Matrícula:");
		lblMatricula.setBounds(20, 20, 80, 25);
		add(lblMatricula);

		JTextField campoMatricula = new JTextField();
		campoMatricula.setBounds(100, 20, 150, 25);
		add(campoMatricula);

		JLabel lblCodigo = new JLabel("Código da Obra:");
		lblCodigo.setBounds(20, 60, 100, 25);
		add(lblCodigo);

		JTextField campoCodigo = new JTextField();
		campoCodigo.setBounds(130, 60, 120, 25);
		add(campoCodigo);

		JButton botaoDevolver = new JButton("Devolver");
		botaoDevolver.setBounds(90, 110, 100, 30);
		add(botaoDevolver);

		botaoDevolver.addActionListener(e -> {
			String matricula = campoMatricula.getText().trim();
			String codigo = campoCodigo.getText().trim();

			if (matricula.isEmpty() || codigo.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
				return;
			}

			boolean sucesso = EmprestimoControle.registrarDevolucao(matricula, codigo);

			if (sucesso) {
				JOptionPane.showMessageDialog(this, "Devolução registrada com sucesso!");
				dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Empréstimo não encontrado ou já devolvido.");
			}
		});

		setVisible(true);
	}
}