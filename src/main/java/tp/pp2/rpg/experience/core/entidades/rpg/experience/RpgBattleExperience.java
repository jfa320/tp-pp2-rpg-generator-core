package tp.pp2.rpg.experience.core.entidades.rpg.experience;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.Personaje;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.extensible.HabilidadFinder;
import tp.pp2.rpg.experience.core.utils.ParserJSON;

public class RpgBattleExperience extends Observable {
	private Batalla batalla;
	private List<Habilidad> habilidades;
	private List<Personaje> personajes;
	private HabilidadFinder habilidadFinder;
	private Properties configProperties = new Properties();

	public RpgBattleExperience() {
	};

	public RpgBattleExperience(String pathConfigProperties) {
		try {
			configProperties.load(new FileInputStream(pathConfigProperties));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String datosBatalla = configProperties.getProperty("datos.batalla");
		this.personajes = ParserJSON.parsearPersonajesJSON(datosBatalla);
		this.batalla = ParserJSON.parsearBatallaJSON(datosBatalla); // la batalla ahora viene por JSON
		try {
			this.setHabilidades(configProperties.getProperty("path.habilidades"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void jugar(Habilidad habilidad) throws Exception {
		batalla.jugar(habilidad);
		setChanged();
		notifyObservers(batalla);
	}

	public void setHabilidades(String path) throws Exception {
		this.habilidadFinder = new HabilidadFinder();
		this.habilidades = habilidadFinder.findClasses(path);
	}

	public List<Habilidad> getHabilidades() {
		return habilidades;
	}

	public Batalla getBatalla() {
		return batalla;
	}

	public List<Personaje> getPersonajes() {
		return personajes;
	}

	public void setBatalla(Batalla batalla) {
		this.batalla = batalla;
	}

	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}

}
