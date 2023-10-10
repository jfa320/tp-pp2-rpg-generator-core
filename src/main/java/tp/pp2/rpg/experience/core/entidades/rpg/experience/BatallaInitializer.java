package tp.pp2.rpg.experience.core.entidades.rpg.experience;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.extensible.HabilidadFinder;

public class BatallaInitializer {

    public Batalla generarBatalla(String pathConfigProperties) throws Exception{

		PersonajeBuilder personajesBuilder = new PersonajeBuilder(pathConfigProperties);
		Map<String,Properties> personajes = personajesBuilder.buildAllPersonajes();
		HabilidadFinder habilidadFinder = new HabilidadFinder(pathConfigProperties);
		List<Habilidad> habilidades = habilidadFinder.findClasses("");

		Batalla batalla = BatallaBuilder.build(habilidades,personajes);			
        return batalla;
    }

}