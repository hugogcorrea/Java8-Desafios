package challenge;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CriptografiaCesariana implements Criptografia {

	@Override
	public String criptografar(String texto) {
		isEmptyOrNull(texto);
		
		Stream<Object> characterStream = 
				texto.chars().mapToObj(c -> {
					if (Character.isLetter((char) c)) { // caso for letra retorna valor da letra
						return (String.valueOf((char) ((int) c + 3))).toLowerCase();
					} else
						return (char) c;
				});

		return characterStream.map(c -> c.toString())
				.collect(Collectors.joining(""));
	}

	@Override
	public String descriptografar(String texto) {
		isEmptyOrNull(texto);

		Stream<Object> characterStream = 
				texto.chars().mapToObj(c -> {
					if (Character.isLetter((char) c)) { // caso for letra retorna valor da letra
						return (String.valueOf((char) ((int) c - 3))).toLowerCase();
					} else
						return (char) c;
				});

		return characterStream.map(c -> c.toString())
				.collect(Collectors.joining(""));
	}

	private void isEmptyOrNull(String texto) {	
		if (texto == null)
			throw new NullPointerException();
		if (texto.isEmpty())
			throw new IllegalArgumentException();
	}

}
