package com.srit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.srit.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>{

	@Query("select a from Article a where a.type like 'piece' and   a.fournisseur.id like :idf")
	public List<Article> findPiecesByFournisseur(@Param("idf")Long idf);
	
	@Query("select a from Article a where a.type like 'produit' and  a.fournisseur.id like :idf")
	public List<Article> findProduitsByFournisseur(@Param("idf")Long idf);
	
	@Query("select a from Article a where a.codeArticle like :x")
	public Article findArticleByCode(@Param("x")String codeArticle);
	
	@Query("select a from Article a where a.type like 'Pièce'")
	public List<Article> getPieces();
	
	@Query("select a from Article a where a.type like 'Produit'")
	public List<Article> getProduits();
	
	


	
	
}
