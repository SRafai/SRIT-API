package com.srit.imetier;

import java.util.Date;
import java.util.List;

//import org.springframework.security.core.userdetails.UserDetails;

import com.srit.entities.AppUser;
import com.srit.entities.Article;
import com.srit.entities.BC;
import com.srit.entities.BL;
import com.srit.entities.Client;
import com.srit.entities.Commande;
import com.srit.entities.Fournisseur;
import com.srit.entities.GpsRowData;
import com.srit.entities.Planning;
import com.srit.entities.Rappel;
import com.srit.entities.RevenuDepense;
import com.srit.entities.Role;
import com.srit.entities.Vehicule;

public interface GestionVehiculeMetier {
	
	/******* Article ********/
	
	public Article addArticle(Article article);
	public Article updateArticle(Long id, Article article);
	public void deleteArticle(Long articleId);
	public List<Article> findPiecesByFournisseur(Long idf);
	public List<Article> findProduitsByFournisseur(Long idf);
	public Article findArticleByCode(String codeArticle);
	public Article getArticleById(Long id);
	public List<Article> getPieces();
	public List<Article> getProduits();
	
	/******* BC ********/
	
	public BC addBC(BC bc);
	public BC updateBC(Long id, BC bc);
	public BC validateBC(Long id);
	public BC refuseBC(Long id);
	public void deleteBC(Long id);
	public List<BC> findBCsByDate(Date dateStart, Date dateEnd);
	public List<BC> findBCsByImm(String imm);
	public BC findBCById(Long id);
	public List<BC> findAllBC();
	//For rappel list bc à approuver
	public List<BC> findAllBCNotValidated();
	
	/******* BL ********/
	
	public BL addBL(BL bl);
	public BL updateBL(Long id, BL bl);
	public List<BL> findBLsByDate(Date dateStart, Date dateEnd);
	public List<BL> findBLsByImm(String imm);
	public BL findBLByPlanning(Long plId);
	public BL findBLById(Long id);
	public List<BL> findAllBL();
	public void deleteBL(Long id);
	
	/******* Client ********/
	
	public Client addClient(Client client);
	public List<Client> findAllClients();
	public Client updateClient(Long id, Client client);
	public void deleteClient(Long id);
	public Client findClientBySiren(int siren);
	public Client findClientByRS(String rs);
	public Client findClientById(Long id);
	
	/******* Commande ********/
	
	public Commande addCommande(Commande cde);
	public Commande updateCommande(Long id, Commande cde);
	public void deleteCommande(Long id);
	public List<Commande> findCommandesByBC(Long idBC);
	public Commande findCommandeById(Long id);
	
	/******* Fournisseur ********/
	
	public Fournisseur addFournisseur(Fournisseur fournisseur);
	public List<Fournisseur> findAllFournisseurs();
	public Fournisseur updateFournisseur(Long id, Fournisseur fournisseur);
	public void deleteFournisseur(Long id);
	public Fournisseur findFournisseurBySiren(int siren);
	public Fournisseur findFournisseurByRS(String rs);
	public List<Fournisseur> findFournisseursByType(String type);
	public Fournisseur findFournisseurById(Long id);
	
	/******* GpsRowData ********/
	
	public GpsRowData addGpsRowData(GpsRowData gprd);
	public GpsRowData updateGpsRowData(Long id, GpsRowData gprd);
	public void deleteGpsRowData(Long id);
	public List<GpsRowData> findGpsRowsDataByImmandDate(String imm, Date dateDebut, Date datefin);
	public GpsRowData findGpsRowDataById(Long id);
	
	/******* Planning ********/
	
	public Planning addPlanning(Planning pl);
	public Planning updatePlanning(Long id, Planning pl);
	public void deletePlanning(Long id);
	public List<Planning> findPlanningsByImm(String imm);
	public List<Planning> findPlanningsByImmandDate(String imm, Date dateD, Date dateF);

	/******* Rappel ********/
	
	public Rappel sendRappel(Rappel r);
	public List<Rappel> findRappelsForReceiver(Long id);
	public Rappel rappelSeen(Long id);
	public Rappel updateRappel(Long id, Rappel r);
	public void delete(Long id);
	
	/******* RevenuDepense ********/
	
	public RevenuDepense addRevenuDepense(RevenuDepense rd);
	public RevenuDepense updateRevenuDepense(Long id, RevenuDepense rd);
	public void deleteRevenuDepense(Long id);
	public List<RevenuDepense> findAllRevenus();
	public List<RevenuDepense> findAllDepenses();
	public RevenuDepense findRevenuDepenseById(Long id);
	
	/******* User ********/
	
	public AppUser addUser(AppUser u);
	public AppUser updateUser(Long id, AppUser u);
	public void deleteUser(Long id);
	public AppUser findUserById(Long id);
	public List<AppUser> findOtherUsers();
	//public UserDetails findUserByEmail(String email);
	public AppUser findAppUserByEmail(String email);
	public AppUser findUserByRole(String role);
	public AppUser login(String email, String password);
	
	/********** Role ***********/
	public Role addRole(Role r);
	public Role updateRole(Long id, Role r);
	public void deleteRole(Long id);
	public List<Role> getRoles();
	public Role getRoleById(Long id);
	
	/******* Vehicule ********/
	
	public Vehicule addVehicule(Vehicule v);
	public Vehicule updateVehicule(Long id, Vehicule v);
	public void deleteVehicule(Long id);
	public Vehicule findVehiculeByImmatriculation(String imm);
	public List<Vehicule> findAll();
	public Vehicule findVehiculeById(Long id);

}
