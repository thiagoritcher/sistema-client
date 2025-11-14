package br.com.ritcher.ui;

public class OperationLabelImpl implements OperationLabel {

	@Override
	public String getLabel(Operation operation) {
		switch (operation) {
		case EQUALS:
			return "Igual";
		case BETWEN:
			return "Entre";
		case BIGGER:
			return "Maior que";
		case SMALLER:
			return "Menor que";
		case ENDWITH:
			return "Termina com";
		case STARTWITH:
			return "Começa com";
		case ISEMPTY:
			return "Vazio";
		case CONTAINS:
			return "Contem";
		default:
			throw new IllegalArgumentException("Unknow " +  operation.toString());
		}
	}

}
