package br.com.ritcher.ui.opcoes;

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
import br.com.ritcher.model.input.DateInput;
import br.com.ritcher.model.input.IntegerInput;
import br.com.ritcher.model.input.SearchItem;
import br.com.ritcher.model.input.SelectItem;
import br.com.ritcher.model.input.Switch;
import br.com.ritcher.model.input.TextLine;
import br.com.ritcher.ui.FindInput;
import br.com.ritcher.ui.search.SearchInput;
import br.com.ritcher.ui.search.SearchProvider;

public class OpcoesPanel  implements ActionListener {

	private final JPanel opcoesPanel;
	private final Form form;
	private final JSeparator jSeparator1;
	private final JButton opcoesButton;
	
	private boolean opcoesVisible;
	
	private final List<Line> lines = new ArrayList<OpcoesPanel.Line>();
	private final List<Input> inputs;
	private SearchProvider provider;


	public OpcoesPanel(Form form, JButton opcoes, SearchProvider provider) {
		super();
		this.opcoesButton = opcoes;
		this.form = form;
		this.provider = provider;
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
		public JComboBox<Operation> operacoes;
		public JFormattedTextField text1;
		public JFormattedTextField text2;
		public JButton remove;
		public JButton add;
		public JPanel container;
		public JCheckBox inputSwitch;
		public JComboBox<Object> selectItem;
		public SearchInput searchItem;
		
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
		
		line.operacoes = new JComboBox<Operation>();
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 1);

		line.operacoes.setModel(operacoesModel(inputs.get(0)));
		line.operacoes.addActionListener(this);
		line.container.add(line.operacoes, gridBagConstraints);

        line.text1 = new javax.swing.JFormattedTextField();


        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 1, 5, 1);
        line.container.add(line.text1, gridBagConstraints);


        line.text2 = new javax.swing.JFormattedTextField();
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 1, 5, 1);
        line.container.add(line.text2, gridBagConstraints);
        line.text2.setVisible(false);

        line.selectItem = new javax.swing.JComboBox<Object>();
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 1, 5, 1);
        line.container.add(line.selectItem, gridBagConstraints);
        line.selectItem.setVisible(false);
        
        line.searchItem = new SearchInput(null, provider);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 1, 5, 1);
        line.container.add(line.searchItem, gridBagConstraints);
        line.searchItem.setVisible(false);
        
        line.inputSwitch = new javax.swing.JCheckBox();
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 1, 5, 1);
        line.container.add(line.inputSwitch, gridBagConstraints);
        line.inputSwitch.setVisible(false);

        
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
        updateOpcoes(line.opcoes);

        
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
	
	private DefaultComboBoxModel<Operation> operacoesModel(Input selected) {
		List<Operation> list = operationList.getOperations(selected);

		DefaultComboBoxModel<Operation> model = new javax.swing.DefaultComboBoxModel<Operation>();
		list.stream()
			.forEach(l -> model.addElement(l));
		
		return model;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src instanceof JButton) {
			if(opcoesButton == src) {
				switchOpcoesPanel();
				return;
			}
			addOrRemoveLine(e);
		}
	
		
		if(src instanceof JComboBox) {
			if(updateOpcoes(src)) {
				return;
			}
			if(updateOperacao(src)) {
				return;
			}
		}
	}

	private boolean updateOperacao(Object source) {
		for (Line line : lines) {
			if(line.operacoes == source) {
				Input selected = inputs.get(line.opcoes.getSelectedIndex());
				Operation oper = (Operation) line.operacoes.getSelectedItem();

				line.text1.setVisible(true);
				line.text2.setVisible(false);
				line.inputSwitch.setVisible(false);
				line.selectItem.setVisible(false);
				line.searchItem.setVisible(false);

				if(selected instanceof DateInput) {
					if(oper.getInputCount() > 1) {
						line.text2.setVisible(true);
					}
				}
				else if(selected instanceof IntegerInput) {
					if(oper.getInputCount() > 1) {
						line.text2.setVisible(true);
					}
				}
				else if(selected instanceof Switch) {
					line.text1.setVisible(false);
					line.inputSwitch.setVisible(true);
				}
				else if(selected instanceof SelectItem) {
					line.text1.setVisible(false);
					line.selectItem.setVisible(true);
				}
				else if(selected instanceof SearchItem) {
					line.text1.setVisible(false);
					line.searchItem.setVisible(true);
					line.searchItem.setInput((SearchItem) selected);
				}
				//line.operacoes.setModel(operacoesModel(selected));
				line.operacoes.getParent().invalidate();
				line.operacoes.getParent().repaint();
			
				return true;
			}
		}
		return false;
	}

	private boolean updateOpcoes(Object source) {
		for (Line line : lines) {
			if(line.opcoes == source) {
				Input selected = inputs.get(line.opcoes.getSelectedIndex());
				line.operacoes.setModel(operacoesModel(selected));
				line.operacoes.getParent().invalidate();
				line.operacoes.getParent().repaint();
				updateOperacao(line.operacoes);
			
				return true;
			}
		}
		return false;
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
