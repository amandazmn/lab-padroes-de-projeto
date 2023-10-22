package dio.strategy;

public class Robo {
	
	private Comportamento comportamento;

	public Comportamento getComportamneto() {
		return comportamento;
	}

	public void setComportamneto(Comportamento comportamneto) {
		this.comportamento = comportamneto;
	}
	
	public void mover() {
		comportamento.mover();
	}

}
