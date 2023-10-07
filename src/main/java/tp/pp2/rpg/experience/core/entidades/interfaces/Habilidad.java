package tp.pp2.rpg.experience.core.entidades.interfaces;

import tp.pp2.rpg.experience.core.entidades.Batalla;

public interface Habilidad {
	void realizar(Batalla batalla);
	String getNombre();
	String getDescripcion();
}
