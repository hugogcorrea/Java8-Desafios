package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;

import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	// TreeMap para times, pois nao eh necessario ordenar toda vez na busca
	private Map<Long, Time> mapTime = new TreeMap<>();
	// TreeMap para jogadores, pois nao eh necessario ordenar toda vez na busca
	private Map<Long, Jogador> mapJogador = new TreeMap<>();

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal,
			String corUniformeSecundario) {

		// buscar time pelo id para verificar se existe
		if (mapTime.containsKey(id) == true) {
			throw new IdentificadorUtilizadoException();
		}
		mapTime.put(id, new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade,
			BigDecimal salario) {

		// busca jogador pelo id para verificar se existe
		if (mapJogador.containsKey(id) == true) {
			throw new IdentificadorUtilizadoException();
		}
		// buscar time pelo id para verificar se existe
		verificarTimeExistente(idTime); // time nao existe

		mapJogador.put(id, new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario));

	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		// busca jogador pelo id para verificar se existe
		verificarJogadorExistente(idJogador);

		mapTime.get(mapJogador.get(idJogador).getIdTime()).setCapitao(idJogador);
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {

		// buscar time pelo id para verificar se existe
		verificarTimeExistente(idTime);

		Long idCapitao = mapTime.get(idTime).getCapitao();

		if (idCapitao == null) {// time nao tem capitao
			throw new CapitaoNaoInformadoException();
		}

		return idCapitao;
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {

		// busca jogador pelo id para verificar se existe
		verificarJogadorExistente(idJogador);

		return mapJogador.get(idJogador).getNome();

	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {

		// busca time pelo id para verificar se existe
		verificarTimeExistente(idTime);

		return mapTime.get(idTime).getNome();

	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {

		// busca time pelo id para verificar se existe
		verificarTimeExistente(idTime);

		// busca jogadores do time ordenado pelo id
		return mapJogador.values().stream()				
				.filter(x -> x.getIdTime().equals(idTime))
				.map(x -> x.getId()).collect(Collectors.toList());
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {

		// busca time pelo id para verificar se existe
		verificarTimeExistente(idTime);

		// busca jogadores do time ordenado pelo nivelHabilidade
		return mapJogador.values().stream()
				.filter(x -> x.getIdTime().equals(idTime))
				.max(Comparator.comparing(Jogador::getNivelHabilidade)).get().getId();
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		// busca time pelo id para verificar se existe
		verificarTimeExistente(idTime);

		// busca jogadores do time ordenado pelo dtNascimento mais antiga
		return mapJogador.values().stream()				
				.filter(x -> x.getIdTime().equals(idTime))
				.min(Comparator.comparing(Jogador::getdataNascimento)).get().getId();
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		return this.mapTime.keySet().stream().collect(Collectors.toList());
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		// busca time pelo id para verificar se existe
		verificarTimeExistente(idTime);

		// busca jogador ordenado pelo Salario
		return mapJogador.values().stream()				
				.filter(x -> x.getIdTime().equals(idTime))
				.max(Comparator.comparing(Jogador::getSalario)).get().getId();
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		verificarJogadorExistente(idJogador);

		// busca jogador pelo id
		return mapJogador.get(idJogador).getSalario();
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {

		// busca jogadores do time ordenado pelo nivelHabilidade
		return mapJogador.values().stream()
				.sorted(Comparator.comparingInt(Jogador::getNivelHabilidade).reversed())
				.map(x -> x.getId())
				.limit(top).collect(Collectors.toList());
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		if (!(mapTime.containsKey(timeDaCasa)) || !(mapTime.containsKey(timeDeFora))) {
			throw new TimeNaoEncontradoException();
		}
		Time timeCasa = mapTime.get(timeDaCasa);
		Time timeFora = mapTime.get(timeDeFora);

		if (timeCasa.getCorUniformePrincipal() == timeFora.getCorUniformePrincipal()) {
			return timeFora.getCorUniformeSecundario();
		} else {
			return timeFora.getCorUniformePrincipal();
		}
	}

	public void verificarJogadorExistente(Long idJogador) {
		if (!(mapJogador.containsKey(idJogador))) {
			throw new JogadorNaoEncontradoException();
		}
	}

	public void verificarTimeExistente(Long idTime) {
		if (!(mapTime.containsKey(idTime))) {
			throw new TimeNaoEncontradoException();
		}
	}

}
