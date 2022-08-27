package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import negocio.Cargo;
import negocio.Colaborador;

public class ControladorGravarColaborador implements ActionListener {
	// Propriedades da classe
	private JComboBox<String> cboCargo = null;
	private JTextField txtNome = null;
	
	// M�todo construtor cheio da classe
	public ControladorGravarColaborador(JComboBox<String> cboCargo, JTextField txtNome) {
		super();
		this.cboCargo = cboCargo;
		this.txtNome = txtNome;
	}

	// M�todo sobrescrito da interface
	public void actionPerformed(ActionEvent e) {
		// Cr�ticas de dados
		if (cboCargo.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Campo cargo obrigat�rio !");
			return;
		}
		if (txtNome.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo nome obrigat�rio !");
			return;
		}
		
		// Composi��o do objeto
		Colaborador objColaborador = new Colaborador();
		objColaborador.setObjCargo(new Cargo(cboCargo.getSelectedIndex(), "", 0));
		objColaborador.setNome(txtNome.getText());
		
		try {
			objColaborador.persistir();
			JOptionPane.showMessageDialog(null, "Grava��o realizada com sucesso !");
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
	}
}