package dao;

import java.util.Collection;

import metier.Cachette;

public interface CachetteDao extends Dao<Cachette> {
public Collection<Cachette>findAllActives();

}
