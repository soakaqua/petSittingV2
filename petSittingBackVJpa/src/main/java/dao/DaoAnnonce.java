package dao;

import java.util.List;

import model.Annonce;
import model.Compte;
import model.Sitter;

public interface DaoAnnonce extends DaoGeneric<Annonce,Integer> {

	public List<Annonce> selectAnnonceByProprio(Integer numC);
	public List<Annonce> afficherAnnoncesTerminees(Integer numC);
	public List<Annonce> selectAnnonceBySitter(Integer numC);
	public List<Sitter> selectSittersByReponseValidee(Annonce a);
	public List<Integer> selectNoteSitter(Compte c);
	public List<Annonce> SelectAllWithStatut0();
}
