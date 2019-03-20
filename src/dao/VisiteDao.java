package dao;

import java.util.Collection;

import metier.Visite;

public interface VisiteDao extends Dao<Visite> {
public Collection<Visite>findAllActives();

}

