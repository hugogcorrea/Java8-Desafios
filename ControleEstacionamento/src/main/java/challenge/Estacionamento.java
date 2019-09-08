package challenge;

import java.util.ArrayList;
import java.util.List;
import challenge.EstacionamentoException;

public class Estacionamento {

	private List<Carro> carrosEstacionados = new ArrayList<Carro>();

	private final int MELHORIDADE = 55;
	private final int CAPACIDADE_MAXIMA_ESTACIONADOS = 10;

	public void estacionar(Carro novoCarro) {

		if (carrosEstacionados() == CAPACIDADE_MAXIMA_ESTACIONADOS) {// caso estiver cheio
			Carro carro = carrosEstacionados.stream()
					.filter(p -> p.getMotorista().getIdade() < MELHORIDADE).findFirst()
					.orElseThrow(() -> new EstacionamentoException("Nao ha vagas."));
			
			carrosEstacionados.remove(carro);
		}
		carrosEstacionados.add(novoCarro);
	}

	public int carrosEstacionados() {
		return carrosEstacionados.size();
	}

	public boolean carroEstacionado(Carro carroLocalizar) {
		return carrosEstacionados.contains(carroLocalizar);
	}

}
