package br.com.ritcher.ui;

public enum Operation {
	EQUALS(1, ol()), CONTAINS(1, ol()), ENDWITH(1, ol()), STARTWITH(1, ol()), BETWEN(2, ol()), BIGGER(1, ol()),
	SMALLER(1, ol()), ISEMPTY(0, ol());

	Operation(int i, OperationLabel label) {
		this.inputCount = i;
		this.operLabel = label;
	}

	private OperationLabel operLabel;

	private int inputCount;

	public int getInputCount() {
		return inputCount;
	}

	private static OperationLabel ol() {
		return new OperationLabelImpl();
	}

	String getLabel() {
		return operLabel.getLabel(this);
	}
}
