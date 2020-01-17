package dao;

import java.util.List;

import model.Annonce;

public interface DaoAnnonce extends DaoGeneric<Annonce,Integer> {

	public List<Annonce> selectAnnonceByProprio(Integer numC);
	public List<Annonce> afficherAnnoncesTerminees(Integer numC);
	public List<Annonce> selectAnnonceBySitter(Integer numC);
	public List<Annonce> SelectAllWithStatut0();
	
}
