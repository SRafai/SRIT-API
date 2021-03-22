package com.srit.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
import com.srit.entities.AppUser;
import com.srit.entities.Vehicule;
import com.srit.imetier.GestionVehiculeMetier;
@CrossOrigin
@RestController("/rest")
@RequestMapping("/api")
public class GestionVehiculesRestService {
	
	@Autowired
	GestionVehiculeMetier gvMetier;

	@RequestMapping(value = "/articles", method = RequestMethod.POST)
	public Article addArticle(@RequestBody Article article) {
		return gvMetier.addArticle(article);
	}
	@RequestMapping(value = "/articles/{id}", method = RequestMethod.PUT)
	public Article updateArticle(@PathVariable("id") Long id, @RequestBody Article article) {
		return gvMetier.updateArticle(id, article);
	}
	@RequestMapping(value = "/articles/{id}", method = RequestMethod.DELETE)
	public void deleteArticle(@PathVariable("id")Long id) {
		gvMetier.deleteArticle(id);
	}

	@RequestMapping(value = "/pieces", params = "idf", method = RequestMethod.GET)
	public List<Article> findPiecesByFournisseur(@RequestParam("idf")Long idf) {
		return gvMetier.findPiecesByFournisseur(idf);
	}
	@RequestMapping(value = "/pieces", method = RequestMethod.GET)
	public List<Article> getPieces() {
		return gvMetier.getPieces();
	}
	@RequestMapping(value = "/produits", method = RequestMethod.GET)
	public List<Article> getProduits() {
		return gvMetier.getProduits();
	}
	
	@RequestMapping(value = "/produits", params="idf", method = RequestMethod.GET)
	public List<Article> findProduitsByFournisseur(@RequestParam("idf")Long idf) {
		return gvMetier.findProduitsByFournisseur(idf);
	}
	
	@RequestMapping(value = "/articles", params = "code",method = RequestMethod.GET)
	public Article findArticleByCode(@RequestParam("code")String codeArticle) {
		return gvMetier.findArticleByCode(codeArticle);
	}

	@RequestMapping(value = "/articles/{id}", method = RequestMethod.GET)
	public Article getArticleById(@PathVariable("id") Long id) {
		return gvMetier.getArticleById(id);
	}
    //Articles All Good
	
/************************BCs OK*****************************/

	@RequestMapping(value = "/bcs", method = RequestMethod.POST)
	public BC addBC(@RequestBody BC bc) {
		return gvMetier.addBC(bc);
	}

	@RequestMapping(value = "/bcs/{id}", method = RequestMethod.PUT)
	public BC updateBC(@PathVariable("id")Long id, @RequestBody BC bc) {
		return gvMetier.updateBC(id, bc);
	}
	
	@RequestMapping(value = "/bcs/validate/{id}", method = RequestMethod.GET)
	public BC validateBC(@PathVariable("id")Long id) {
		return gvMetier.validateBC(id);
	}

	@RequestMapping(value = "/bcs/refuse/{id}", method = RequestMethod.GET)
	public BC refuseBC(@PathVariable("id")Long id) {
		return gvMetier.refuseBC(id);
	}
	@RequestMapping(value = "/bcs/{id}", method = RequestMethod.DELETE)
	public void deleteBC(@PathVariable("id")Long id) {
		gvMetier.deleteBC(id);
	}
	@RequestMapping(value = "/bcs", params = {"dateStart","dateEnd"}, method = RequestMethod.GET)
	public List<BC> findBCsByDate(@RequestParam("dateStart")@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")Date dateStart, @RequestParam("dateEnd") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")Date dateEnd) {
		//use this date pattern in url exp : 2017-01-24T06:00:00.000Z
		return gvMetier.findBCsByDate(dateStart, dateEnd);
	}

	@RequestMapping(value = "/bcs", params="imm", method = RequestMethod.GET)
	public List<BC> findBCsByImm(@RequestParam(name="imm")String imm) {
		return gvMetier.findBCsByImm(imm);
	}

	@RequestMapping(value = "/bcs/{id}", method = RequestMethod.GET)
	public BC findBCById(@PathVariable("id")Long id) {
		return gvMetier.findBCById(id);
	}

	@RequestMapping(value = "/bcs", method = RequestMethod.GET)
	public List<BC> findAllBC() {
		return gvMetier.findAllBC();
	}
	
	@RequestMapping(value = "/bcs/notValidated", method = RequestMethod.GET)
	public List<BC> findAllBCNotValidated() {
		return gvMetier.findAllBCNotValidated();
	}

/***************************BLs OK*****************************/

	@RequestMapping(value = "/bls", method = RequestMethod.POST)
	public BL addBL(@RequestBody BL bl) {
		return gvMetier.addBL(bl);
	}

	@RequestMapping(value = "/bls/{id}", method = RequestMethod.PUT)
	public BL updateBL(@PathVariable("id")Long id, @RequestBody BL bl) {
		return gvMetier.updateBL(id, bl);
	}

	@RequestMapping(value = "/bls", params = {"dateStart","dateEnd"}, method = RequestMethod.GET)
	public List<BL> findBLsByDate(@RequestParam("dateStart")@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")Date dateStart, @RequestParam("dateEnd") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")Date dateEnd) {
		//use this date pattern in url exp : 2017-01-24T06:00:00.000Z
		
		return gvMetier.findBLsByDate(dateStart, dateEnd);
	}

	@RequestMapping(value = "/bls", params="imm", method = RequestMethod.GET)
	public List<BL> findBLsByImm(@RequestParam("imm") String imm) {
		return gvMetier.findBLsByImm(imm);
	}

	@RequestMapping(value = "/bls", params="plId", method = RequestMethod.GET)
	public BL findBLByPlanning(@RequestParam Long plId) {
		return gvMetier.findBLByPlanning(plId);
	}

	@RequestMapping(value = "/bls/{id}", method = RequestMethod.GET)
	public BL findBLById(@PathVariable("id") Long id) {
		return gvMetier.findBLById(id);
	}
	@RequestMapping(value = "/bls/{id}", method = RequestMethod.DELETE)
	public void deleteBLById(@PathVariable("id") Long id) {
		 gvMetier.deleteBL(id);
	}

	@RequestMapping(value = "/bls", method = RequestMethod.GET)
	public List<BL> findAllBL() {
		return gvMetier.findAllBL();
	}

/***************************Clients OK********************************/

	@RequestMapping(value = "/clients", method = RequestMethod.POST)
	public Client addClient(@RequestBody Client client) {
		return gvMetier.addClient(client);
	}
	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public List<Client> findAllClients() {
		return gvMetier.findAllClients();
	}
	@RequestMapping(value = "/clients/{id}", method = RequestMethod.PUT)
	public Client updateClient(@PathVariable("id") Long id, @RequestBody Client client) {
		return gvMetier.updateClient(id, client);
	}
	@RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
	public void deleteClient(@PathVariable("id") Long id) {
		gvMetier.deleteClient(id);
	}

	@RequestMapping(value = "/clients", params = "siren", method = RequestMethod.GET)
	public Client findClientBySiren(@RequestParam("siren")Integer siren) {
		return gvMetier.findClientBySiren(siren);
	}
	
	@RequestMapping(value = "/clients", params="rs", method = RequestMethod.GET)
	public Client findClientByRS(@RequestParam("rs") String rs) {
		return gvMetier.findClientByRS(rs);
	}

	@RequestMapping(value = "/clients/{id}", method = RequestMethod.GET)
	public Client findClientById(@PathVariable("id")Long id) {
		return gvMetier.findClientById(id);
	}

/********************Commande OK********************/

	@RequestMapping(value = "/commandes", method = RequestMethod.POST)
	public Commande addCommande(@RequestBody Commande cde) {
		return gvMetier.addCommande(cde);
	}
	
	@RequestMapping(value = "/commandes/{id}", method = RequestMethod.PUT)
	public Commande updateCommande(@PathVariable("id") Long id, @RequestBody Commande cde) {
		return gvMetier.updateCommande(id, cde);
	}

	@RequestMapping(value = "/commandes/{id}", method = RequestMethod.DELETE)
	public void deleteCommande(@PathVariable("id") Long id) {
		gvMetier.deleteCommande(id);
	}

	@RequestMapping(value = "/commandes",params="idBc", method = RequestMethod.GET)
	public List<Commande> findCommandesByBC(@RequestParam("idBc") Long idBC) {
		return gvMetier.findCommandesByBC(idBC);
	}

	@RequestMapping(value = "/commandes/{id}", method = RequestMethod.GET)
	public Commande findCommandeById(@PathVariable("id") Long id) {
		return gvMetier.findCommandeById(id);
	}
	
/************************Fournisseur OK******************************/


	@RequestMapping(value = "/fournisseurs", method = RequestMethod.POST)
	public Fournisseur addFournisseur(@RequestBody Fournisseur fournisseur) {
		return gvMetier.addFournisseur(fournisseur);
	}

	@RequestMapping(value = "/fournisseurs", method = RequestMethod.GET)
	public List<Fournisseur> findAllFournisseurs() {
		return gvMetier.findAllFournisseurs();
	}
	
	@RequestMapping(value = "/fournisseurs/{id}", method = RequestMethod.PUT)
	public Fournisseur updateFournisseur(@PathVariable("id")Long id, @RequestBody Fournisseur fournisseur) {
		return gvMetier.updateFournisseur(id, fournisseur);
	}

	@RequestMapping(value = "/fournisseurs/{id}", method = RequestMethod.DELETE)
	public void deleteFournisseur(@PathVariable("id")Long id) {
		gvMetier.deleteFournisseur(id);
	}

	@RequestMapping(value = "/fournisseurs", params = "siren", method = RequestMethod.GET)
	public Fournisseur findFournisseurBySiren(@RequestParam("siren")Integer siren) {
		return gvMetier.findFournisseurBySiren(siren);
	}

	@RequestMapping(value = "/fournisseurs",params = "rs", method = RequestMethod.GET)
	public Fournisseur findFournisseurByRS(@RequestParam("rs")String rs) {
		return gvMetier.findFournisseurByRS(rs);
	}

	@RequestMapping(value = "/fournisseurs", params = "type", method = RequestMethod.GET)
	public List<Fournisseur> findFournisseursByType(@RequestParam("type")String type) {
		return gvMetier.findFournisseursByType(type);
	}

	@RequestMapping(value = "/fournisseurs/{id}", method = RequestMethod.GET)
	public Fournisseur findFournisseurById(@PathVariable("id") Long id) {
		return gvMetier.findFournisseurById(id);
	}

/***************************QPSRowDatas ********************************/

	@RequestMapping(value = "/gpsrowdatas", method = RequestMethod.POST)
	public GpsRowData addGpsRowData(@RequestBody GpsRowData gprd) {
		return gvMetier.addGpsRowData(gprd);
	}

	@RequestMapping(value = "/gpsrowdatas/{id}", method = RequestMethod.PUT)
	public GpsRowData updateGpsRowData(@PathVariable("id") Long id, @RequestBody GpsRowData gprd) {
		return gvMetier.updateGpsRowData(id, gprd);
	}

	@RequestMapping(value = "/gpsrowdatas/{id}", method = RequestMethod.DELETE)
	public void deleteGpsRowData(@PathVariable("id")Long id) {
		gvMetier.deleteGpsRowData(id);
	}

	@RequestMapping(value = "/gpsrowdatas",params= {"imm","dateStart","dateEnd"}, method = RequestMethod.GET)
	public List<GpsRowData> findGpsRowsDataByImmandDate(@RequestParam("imm")String imm, @RequestParam("dateStart") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")Date dateD, @RequestParam("dateEnd")@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX") Date dateF){
		return gvMetier.findGpsRowsDataByImmandDate(imm, dateD, dateF);
	}

	@RequestMapping(value = "/gpsrowdatas/{id}", method = RequestMethod.GET)
	public GpsRowData findGpsRowDataById(@PathVariable("id")Long id) {
		return gvMetier.findGpsRowDataById(id);
	}

/************************Planning OK**************************/

	@RequestMapping(value = "/plannings", method = RequestMethod.POST)
	public Planning addPlanning(@RequestBody Planning pl) {
		return gvMetier.addPlanning(pl);
	}

	@RequestMapping(value = "/plannings/{id}", method = RequestMethod.PUT)
	public Planning updatePlanning(@PathVariable("id") Long id, @RequestBody Planning pl) {
		return gvMetier.updatePlanning(id, pl);
	}

	@RequestMapping(value = "/plannings/{id}", method = RequestMethod.DELETE)
	public void deletePlanning(@PathVariable("id")Long id) {
		gvMetier.deletePlanning(id);
	}

	@RequestMapping(value = "/plannings",params = "imm", method = RequestMethod.GET)
	public List<Planning> findPlanningsByImm(@RequestParam("imm")String imm) {
		return gvMetier.findPlanningsByImm(imm);
	}

	@RequestMapping(value = "/plannings",params= {"imm","dated","datef"}, method = RequestMethod.GET)
	public List<Planning> findPlanningsByImmandDate(@RequestParam("imm")String imm, @RequestParam("dated") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")Date dateD, @RequestParam("datef")@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX") Date dateF) {
		return gvMetier.findPlanningsByImmandDate(imm, dateD, dateF);
	}

	
/***************************Rappels OK***********************************/

	@RequestMapping(value = "/rappels", method = RequestMethod.POST)
	public Rappel sendRappel(@RequestBody Rappel r) {
		return gvMetier.sendRappel(r);
	}
	
	@RequestMapping(value = "/rappels/receiver/{id}", method = RequestMethod.GET)
	public List<Rappel> findRappelsForReceiver(@PathVariable("id")Long id) {
		return gvMetier.findRappelsForReceiver(id);
	}

	@RequestMapping(value = "/rappels/seen/{id}", method = RequestMethod.PUT)
	public Rappel rappelSeen(@PathVariable("id") Long id) {
		return gvMetier.rappelSeen(id);
	}

	@RequestMapping(value = "/rappels/{id}", method = RequestMethod.PUT)
	public Rappel updateRappel(@PathVariable("id") Long id, @RequestBody Rappel r) {
		return gvMetier.updateRappel(id, r);
	}

	@RequestMapping(value = "/rappels/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		gvMetier.delete(id);
	}
    
/**************************RD OK******************************/

	@RequestMapping(value = "/rds", method = RequestMethod.POST)
	public RevenuDepense addRevenuDepense(@RequestBody RevenuDepense rd) {
		return gvMetier.addRevenuDepense(rd);
	}

	@RequestMapping(value = "/rds/{id}", method = RequestMethod.PUT)
	public RevenuDepense updateRevenuDepense(@PathVariable("id")Long id, @RequestBody RevenuDepense rd) {
		return gvMetier.updateRevenuDepense(id, rd);
	}

	@RequestMapping(value = "/rds/{id}", method = RequestMethod.DELETE)
	public void deleteRevenuDepense(@PathVariable("id")Long id) {
		gvMetier.deleteRevenuDepense(id);
	}

	@RequestMapping(value = "/rds/revenus", method = RequestMethod.GET)
	public List<RevenuDepense> findAllRevenus() {
		return gvMetier.findAllRevenus();
	}

	@RequestMapping(value = "/rds/depenses", method = RequestMethod.GET)
	public List<RevenuDepense> findAllDepenses() {
		return gvMetier.findAllDepenses();
	}

	@RequestMapping(value = "/rds/{id}", method = RequestMethod.GET)
	public RevenuDepense findRevenuDepenseById(@PathVariable("id")Long id) {
		return gvMetier.findRevenuDepenseById(id);
	}
	
/*********************Users OK***************************/

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public AppUser addUser(@RequestBody AppUser u) {
		return gvMetier.addUser(u);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	public AppUser updateUser(@PathVariable("id")Long id, @RequestBody AppUser u) {
		return gvMetier.updateUser(id, u);
	}
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") Long id) {
		gvMetier.deleteUser(id);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public AppUser findUserById(@PathVariable("id")Long id) {
		return gvMetier.findUserById(id);
	}

	@RequestMapping(value = "/users/others", method = RequestMethod.GET)
	public List<AppUser> findOtherUsers() {
		return gvMetier.findOtherUsers();
	}

	
	@RequestMapping(value = "/users", params = "email", method = RequestMethod.GET)
	public AppUser findUserByEmail(@RequestParam("email")String email) {
		return gvMetier.findAppUserByEmail(email);
	}


	@RequestMapping(value = "/users",params = "role", method = RequestMethod.GET)
	public AppUser findUserByRole(@RequestParam("role")String role) {
		return gvMetier.findUserByRole(role);
	}

	@RequestMapping(value = "/users/login",params= {"email","password"}, method = RequestMethod.GET)
	public AppUser login(@RequestParam("email")String email, @RequestParam("password")String password) {
		return gvMetier.login(email, password);
	}

	//Vehicules OK
	@RequestMapping(value = "/vehicules", method = RequestMethod.POST)
	public Vehicule addVehicule(@RequestBody Vehicule v) {
		return gvMetier.addVehicule(v);
	}

	@RequestMapping(value = "/vehicules/{id}", method = RequestMethod.PUT)
	public Vehicule updateVehicule(@PathVariable("id") Long id, @RequestBody Vehicule v) {
		return gvMetier.updateVehicule(id, v);
	}

	@RequestMapping(value = "/vehicules/{id}", method = RequestMethod.DELETE)
	public void deleteVehicule(@PathVariable("id")Long id) {
		gvMetier.deleteVehicule(id);
	}

	@RequestMapping(value = "/vehicules", params = "imm", method = RequestMethod.GET)
	public Vehicule findVehiculeByImmatriculation(@RequestParam("imm")String imm) {
		return gvMetier.findVehiculeByImmatriculation(imm);
	}
	
	@RequestMapping(value = "/vehicules", method = RequestMethod.GET)
	public List<Vehicule> findAll() {
		return gvMetier.findAll();
	}

	@RequestMapping(value = "/vehicules/{id}", method = RequestMethod.GET)
	public Vehicule findVehiculeById(@PathVariable("id")Long id) {
		return gvMetier.findVehiculeById(id);
	}
	
	

}

