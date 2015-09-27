package obra;

public enum ObraStatus {

	REGISTRADA(1), 
	EM_ANDAMENTO(2), 
	FINALIZADA(3), 
	CANCELADA(4),
	INATIVA(5);
	
	private final int valor;

	ObraStatus(int valorOpcao) {
		valor = valorOpcao;
	}

	public int getValor() {
		return valor;
	}

}
