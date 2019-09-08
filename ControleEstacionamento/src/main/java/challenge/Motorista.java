package challenge;

public class Motorista {

	private String nome;
	private int idade;
	private String cnh;
	private int ptsCnh;

	private final int MAIOR_IDADE = 18;
	private final int MIN_PONTOS_PERMITIDOS = 0;
	private final int MAX_PONTOS_PERMITIDOS = 20;
	public static Motorista builder() {
		return new Motorista();
	}

	public Motorista build() {
		if (cnh == null || nome == null) {
			throw new NullPointerException();
		}		
		if (idade < MAIOR_IDADE) {
			throw new EstacionamentoException("Motorista nao deve ser menor de idade");
		}

		return this;
	}

	public Motorista withNome(String nome) {
		this.nome = nome;
		return this;
	}

	public Motorista withIdade(int idade) {
		if (idade < 0) {
			throw new IllegalArgumentException();
		}
		this.idade = idade;
		return this;
	}

	public Motorista withPontos(int pontos) {
		if (pontos < MIN_PONTOS_PERMITIDOS) {
			throw new IllegalArgumentException();
		}
		if (pontos > MAX_PONTOS_PERMITIDOS) {
			throw new EstacionamentoException("Nao deve estacionar, motorista excedeu pontuacao");
		}
		this.ptsCnh = pontos;
		return this;
	}

	public Motorista withHabilitacao(String cnh) {
		this.cnh = cnh;
		return this;
	}

	public String getNome() {
		return this.nome;
	}

	public int getIdade() {
		return this.idade;
	}

}
