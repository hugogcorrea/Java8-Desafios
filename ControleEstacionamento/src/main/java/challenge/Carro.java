package challenge;

public class Carro {

	private String placa;
	private String cor;
	private Motorista motorista;

	public static Carro builder() {
		return new Carro();
	}

	public Carro withCor(Cor color) {
		this.cor = color.toString();
		return this;
	}

	public Carro build() {
		if (placa == null || cor == null) {
			throw new NullPointerException();
		}	
		if (motorista == null) {
			throw new EstacionamentoException("Nao deve ter carro autonomo");
		}
		return this;
	}

	public Carro withPlaca(String placa) {
		this.placa = placa;
		return this;
	}

	public Carro withMotorista(Motorista motorista) {
		this.motorista = motorista;
		return this;
	}

	public Motorista getMotorista() {
		return this.motorista;

	}

}
