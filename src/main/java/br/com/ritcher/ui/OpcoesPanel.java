package br.com.ritcher.ui;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import br.com.ritcher.model.Form;
import br.com.ritcher.model.Input;

public class OpcoesPanel  implements ActionListener {

	private final JPanel opcoesPanel;
	private final Form form;
	private final JSeparator jSeparator1;
	private final JButton opcoesButton;
	
	private boolean opcoesVisible;
	
	private final List<Line> lines = new ArrayList<OpcoesPanel.Line>();
	private final List<Input> inputs;


	public OpcoesPanel(Form form, JButton opcoes) {
		super();
		this.opcoesButton = opcoes;
		this.form = form;
		inputs = findInput.find(form);

        opcoesPanel = new javax.swing.JPanel();
        opcoesPanel.setVisible(opcoesVisible);
        jSeparator1 = new javax.swing.JSeparator();

        setupOpcoesPanel();
        lines.add(addLine());
	}

	private void setupOpcoesPanel() {
		opcoesPanel.setLayout(new GridLayout(0, 1));
	}

	class Line {
		public JComboBox<String> opcoes;
		public JComboBox<String> operacoes;
		public JFormattedTextField text1;
		public JFormattedTextField text2;
		public JButton remove;
		public JButton add;
		public JPanel container;
		
	}
	
	private Line addLine(){
		Line line = new Line();
		line.container = new JPanel();
		line.container.setLayout(new java.awt.GridBagLayout());
		GridBagConstraints gridBagConstraints;
        
		
		line.opcoes = new JComboBox<String>();
		line.opcoes.setModel(opcoesModel(form));
		line.opcoes.addActionListener(this);

        gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 1);
		line.container.add(line.opcoes, gridBagConstraints);
		
		line.operacoes = new JComboBox<String>();
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 1);
		line.operacoes.addActionListener(this);
		line.container.add(line.operacoes, gridBagConstraints);

        line.text1 = new javax.swing.JFormattedTextField();

        line.text2 = new javax.swing.JFormattedTextField();

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 1, 5, 1);
        line.container.add(line.text1, gridBagConstraints);
        
        line.remove = new javax.swing.JButton();
        line.add = new javax.swing.JButton();

        line.remove.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 1, 5, 1);
        line.container.add(line.remove, gridBagConstraints);
        line.remove.addActionListener(this);

        line.add.setText("+");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 1, 5, 5);
        line.container.add(line.add, gridBagConstraints);
        line.add.addActionListener(this);

        
        opcoesPanel.add(line.container);
        updateOperacoesModel(line.opcoes);

        
        if(opcoesPanel.getParent() != null) {
			opcoesPanel.getParent().revalidate();
			opcoesPanel.getParent().repaint();
        }


        return line;
	}
	
	private void removeLine(Line l) {
		opcoesPanel.remove(l.container);
        if(opcoesPanel.getParent() != null) {
			opcoesPanel.getParent().revalidate();
			opcoesPanel.getParent().repaint();
        }
	}
	
	FindInput findInput = new FindInput();
	OperationList operationList = new OperationList();

	private DefaultComboBoxModel<String> opcoesModel(Form form) {
		List<Input> inputs = findInput.find(form);
		DefaultComboBoxModel<String> model = new javax.swing.DefaultComboBoxModel<String>();
		inputs.stream()
			.map(i -> i.getLabel())
			.forEach(l -> model.addElement(l));
	
		return model;
	}
	
	private DefaultComboBoxModel<String> operacoesModel(Input selected) {
		List<Operation> list = operationList.getOperations(selected);

		DefaultComboBoxModel<String> model = new javax.swing.DefaultComboBoxModel<String>();
		list.stream()
			.map(i -> i.getLabel())
			.forEach(l -> model.addElement(l));
		
		return model;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			if(e.getSource() == opcoesButton) {
				switchOpcoesPanel();
				return;
			}
			addOrRemoveLine(e);
		}
	
		
		if(e.getSource() instanceof JComboBox) {
			updateOperacoesModel(e.getSource());
		}
	}

	private void updateOperacoesModel(Object source) {
		for (Line line : lines) {
			if(line.opcoes == source) {
				Input selected = inputs.get(line.opcoes.getSelectedIndex());
				line.operacoes.setModel(operacoesModel(selected));
				line.operacoes.getParent().invalidate();
				line.operacoes.getParent().repaint();
				
				return;
			}
		}
	}

	private void addOrRemoveLine(ActionEvent e) {
		Line added = null, removed = null;
		for (Line line : lines) {
			if(line.add == e.getSource()) {
				added = this.addLine();
				System.out.println("Added");
			}
			if(line.remove == e.getSource()) {
				this.removeLine(line);
				removed = line;
			}
		}

		if(added != null) {
			lines.add(added);
		}
		
		if(removed != null) {
			lines.remove(removed);
		}

	}

	private void switchOpcoesPanel() {
		opcoesVisible = !opcoesVisible;
		opcoesPanel.setVisible(opcoesVisible);
		opcoesPanel.getParent().revalidate();
		opcoesPanel.getParent().repaint();
	}

	public Component getOpcoesPanel() {
		return opcoesPanel;
	}
}
