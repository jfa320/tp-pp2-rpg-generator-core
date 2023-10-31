package tp.pp2.rpg.experience.core.entidades.rpg.experience;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.extensible.HabilidadFinder;

public class BatallaInitializer {

    public Batalla generarBatalla(String pathConfigProperties){
		PersonajeBuilder personajesBuilder = new PersonajeBuilder(pathConfigProperties.replace("\\", File.separator));
		Map<String,Properties> personajes = personajesBuilder.buildAllPersonajes();
		HabilidadFinder habilidadFinder = new HabilidadFinder(pathConfigProperties.replace("\\", File.separator));
		List<Habilidad> habilidades = null;
		try {
			habilidades = habilidadFinder.findClasses("");
		} catch (Exception e) {
			e.printStackTrace();
		}

		Batalla batalla = BatallaBuilder.build(habilidades,personajes);			
        return batalla;
    }

}
