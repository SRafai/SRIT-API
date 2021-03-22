package com.srit.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;*/
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.srit.imetier.GestionVehiculeMetier;
import com.srit.repositories.AppUserRepository;
import com.srit.repositories.ArticleRepository;
import com.srit.repositories.BCRepository;
import com.srit.repositories.BLRepository;
import com.srit.repositories.ClientRepository;
import com.srit.repositories.CommandeRepository;
import com.srit.repositories.FournisseurRepository;
import com.srit.repositories.GpsRowDataRepository;
import com.srit.repositories.PlanningRepository;
import com.srit.repositories.RappelRepository;
import com.srit.repositories.RevenuDepenseRepository;
import com.srit.repositories.RoleRepository;
import com.srit.repositories.VehiculeRepository;

@Service("/metier")
@Transactional
public class GestionVehiculeMetierImpl implements GestionVehiculeMetier {

	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private BCRepository bcRepository;
	@Autowired
	private BLRepository blRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private FournisseurRepository fournisseurRepository;
	@Autowired
	private GpsRowDataRepository gpsRowDataRepository;
	@Autowired
	private PlanningRepository planningRepository;
	@Autowired
	private RappelRepository rappelRepository;
	@Autowired
	private RevenuDepenseRepository revenuDepenseRepository;
	@Autowired
	private AppUserRepository userRepo;
	@Autowired
	private VehiculeRepository vehiculeRepository;
	@Autowired
	private RoleRepository roleRepo;
	/*@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;*/
	
	/*********** Article ************/

	@Override
	public List<Article> getPieces() {
		// TODO Auto-generated method stub
		return articleRepository.getPieces();
	}

	@Override
	public List<Article> getProduits() {
		// TODO Auto-generated method stub
		return articleRepository.getProduits();
	}
	@Override
	public Article addArticle(Article article) {
		// TODO Auto-generated method stub
		if(article != null)
		{
			return articleRepository.save(article);
		}
		return null;
	}

	@Override
	public Article updateArticle(Long id, Article article) {
		// TODO Auto-generated method stub
		// Valideeeeeee !!
		if(id != null && article != null)
		{
			Optional<Article> aOpt = articleRepository.findById(id);
			
			if(aOpt != null)
			{
				Article a = aOpt.get();
				
				if (article.getCodeArticle() != null) {
					a.setCodeArticle(article.getCodeArticle());
				}
				if (article.getCodeFamille() != null) {
					a.setCodeFamille(article.getCodeFamille());
				}
				if (article.getDesignation() != null) {
					a.setDesignation(article.getDesignation());
				}
				if (article.getFournisseur() != null) {
					Optional<Fournisseur> fOpt = fournisseurRepository.findById(article.getFournisseur().getId());
					Fournisseur f = fOpt.get();
					article.setFournisseur(f);
					a.setFournisseur(article.getFournisseur());
				}
				if (article.getPrix() != null) {
					a.setPrix(article.getPrix());
				}
				if (article.getType() != null) {
					a.setType(article.getType());
				}

				return articleRepository.save(a);
			}
		}
		return null;
	}

	@Override
	public void deleteArticle(Long articleId) {
		// TODO Auto-generated method stub
		if(articleId != null)
		{
			articleRepository.deleteById(articleId);
		}
	}

	@Override
	public List<Article> findPiecesByFournisseur(Long idf) {
		// TODO Auto-generated method stub
		if(idf != null)
		{
			return articleRepository.findPiecesByFournisseur(idf);
		}
		return null;
	}

	@Override
	public List<Article> findProduitsByFournisseur(Long idf) {
		// TODO Auto-generated method stub
		if(idf != null)
		{
			return articleRepository.findProduitsByFournisseur(idf);
		}
		return null;
	}

	@Override
	public Article findArticleByCode(String codeArticle) {
		// TODO Auto-generated method stub
		if(codeArticle != null)
		{
			return articleRepository.findArticleByCode(codeArticle);
		}
		return null;
	}

	@Override
	public Article getArticleById(Long id) {
		// TODO Auto-generated method stub
		if(id != null)
		{
			return articleRepository.findById(id).get();
		}
		return null;
	}

	/*********** BC ************/

	@Override
	public BC addBC(BC bc) {
		// TODO Auto-generated method stub
		if(bc != null)
		{
			bc.setDate(new Date());
			bc.setIsValid(false);
			return bcRepository.save(bc);
		}
		return null;
	}

	@Override
	public BC updateBC(Long id, BC bc) {
		// TODO Auto-generated method stub
		// Verifieeeeeeeeeeeeee
		if(id != null && bc != null)
		{
			Optional<BC> bcOpt = bcRepository.findById(id);
			
			if(bcOpt != null)
			{
				BC bcOld = bcOpt.get();
				
				if (bc.getIsValid() != null) {
					bcOld.setIsValid(bc.getIsValid());
				}
				if (bc.getImage_path() != null) {
					bcOld.setImage_path(bc.getImage_path());
				}
				if (bc.getTitle() != null) {
					bcOld.setTitle(bc.getTitle());
				}
				if (bc.getVehicule() != null) {
					Optional<Vehicule> vOpt = vehiculeRepository.findById(bc.getVehicule().getIdVeh());
					if(vOpt != null)
					{
						Vehicule v = vOpt.get();
						bcOld.setVehicule(v);	
					}
				}
				return bcRepository.save(bcOld);
			}
		}
		return null;
	}

	@Override
	public BC validateBC(Long id) {
		// TODO Auto-generated method stub
		if(id != null)
		{
			Optional<BC> bcOpt = bcRepository.findById(id);
			if(bcOpt != null)
			{
				BC bc = bcOpt.get();
				bc.setIsValid(true);
				return bcRepository.save(bc);
			}
		}
		return null;
	}

	@Override
	public BC refuseBC(Long id) {
		// TODO Auto-generated method stub
		if(id != null)
		{
			Optional<BC> bcOpt = bcRepository.findById(id);
			if(bcOpt != null)
			{
				BC bc = bcOpt.get();
				bc.setIsValid(false);
				return bcRepository.save(bc);
			}
		}
		return null;
	}

	@Override
	public void deleteBC(Long id) {
		// TODO Auto-generated method stub
		if(id != null)
		{
			bcRepository.deleteById(id);
		}
	}

	@Override
	public List<BC> findBCsByDate(Date dateStart, Date dateEnd) {
		// TODO Auto-generated method stub
		if(dateStart != null && dateEnd != null)
		{
			return bcRepository.findBCsByDate(dateStart, dateEnd);
		}
		return null;
	}

	@Override
	public List<BC> findBCsByImm(String imm) {
		// TODO Auto-generated method stub
		if(imm != null)
		{
			return bcRepository.findBCsByImm(imm);
		}
		return null;
	}

	@Override
	public BC findBCById(Long id) {
		// TODO Auto-generated method stub
		if(id != null)
		{
			return bcRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public List<BC> findAllBC() {
		// TODO Auto-generated method stub
		return bcRepository.findAll(Sort.by(Sort.Direction.DESC, "date"));
	}

	@Override
	public List<BC> findAllBCNotValidated() {
		// TODO Auto-generated method stub
		return bcRepository.findAllBCNotValidated(Sort.by(Sort.Direction.DESC, "date"));
	}

	/*********** BL ************/

	@Override
	public BL addBL(BL bl) {
		// TODO Auto-generated method stub
		if(bl != null)
		{
			bl.setDate(new Date());
			return blRepository.save(bl);
		}
		return null;
	}

	@Override
	public BL updateBL(Long id, BL bl) {
		// TODO Auto-generated method stub
		if(id != null && bl != null)
		{
			Optional<BL> blOpt = blRepository.findById(id);
			
			if(blOpt != null)
			{
				BL blOld = blOpt.get();
				
				if (bl.getImage_path() != null) {
					blOld.setImage_path(bl.getImage_path());
				}
				if (bl.getVehicule() != null) {
					Optional<Vehicule> vOpt = vehiculeRepository.findById(bl.getVehicule().getIdVeh());
					if(vOpt != null)
					{
						Vehicule v = vOpt.get();
						blOld.setVehicule(v);
					}
				}
				if (bl.getPlanning() != null) {
					Optional<Planning> pOpt = planningRepository.findById(bl.getPlanning().getId());
					if(pOpt != null)
					{
						Planning p = pOpt.get();
						blOld.setPlanning(p);
					}
				}
				return blRepository.save(blOld);
			}
		}
		return null;
	}

	@Override
	public void deleteBL(Long id) {
		// TODO Auto-generated method stub
		if(id != null)
		{
			blRepository.deleteById(id);	
		}
	}

	@Override
	public List<BL> findBLsByDate(Date dateStart, Date dateEnd) {
		// TODO Auto-generated method stub
		if(dateStart != null && dateEnd != null)
		{
			return blRepository.findBLsByDate(dateStart, dateEnd);
		}
		return null;
	}

	@Override
	public List<BL> findBLsByImm(String imm) {
		// TODO Auto-generated method stub
		if(imm != null)
		{
			return blRepository.findBLsByImm(imm);
		}
		return null;
	}

	@Override
	public BL findBLById(Long id) {
		// TODO Auto-generated method stub
		if(id != null)
		{
			return blRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public List<BL> findAllBL() {
		// TODO Auto-generated method stub
		return blRepository.findAll(Sort.by(Sort.Direction.DESC, "date"));
	}

	@Override
	public BL findBLByPlanning(Long plId) {
		// TODO Auto-generated method stub
		if(plId != null)
		{
			return blRepository.findBLByPlanning(plId);
		}
		return null;
	}

	/*********** Client ************/

	@Override
	public Client addClient(Client client) {

		if(client != null)
		{
			return clientRepository.save(client);
		}
		return null;
	}

	@Override
	public List<Client> findAllClients() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public Client updateClient(Long id, Client c) {
		// TODO Auto-generated method stub
		if(id != null && c != null)
		{
			Optional<Client> cOpt = clientRepository.findById(id);
			
			
			if(cOpt != null)
			{
				Client cOld = cOpt.get();
				
				if (c.getCodeClient() != null) {
					cOld.setCodeClient(c.getCodeClient());
				}
				if (c.getLatitude() != null) {
					cOld.setLatitude(c.getLatitude());
				}
				if (c.getLongitude() != null) {
					cOld.setLongitude(c.getLongitude());
				}
				if (c.getRs() != null) {
					cOld.setRs(c.getRs());
				}
				if (c.getSiren() != 0) {
					cOld.setSiren(c.getSiren());
				}

				return clientRepository.save(cOld);
			}
		}
		
		return null;
	}

	@Override
	public void deleteClient(Long id) {
		// TODO Auto-generated method stub
		if(id != null)
		{
			clientRepository.deleteById(id);
		}
	}

	@Override
	public Client findClientBySiren(int siren) {
		// TODO Auto-generated method stub
		if(siren > 0)
		{
			return clientRepository.findClientBySiren(siren);
		}
		return null;
	}

	@Override
	public Client findClientByRS(String rs) {
		// TODO Auto-generated method stub
		if(rs != null)
		{
			return clientRepository.findClientByRS(rs);
		}
		return null;
	}

	@Override
	public Client findClientById(Long id) {
		// TODO Auto-generated method stub
		if (id != null) {
			return clientRepository.findById(id).get();
		}
		return null;
	}

	/*********** Commande ************/

	@Override
	public Commande addCommande(Commande cde) {
		// TODO Auto-generated method stub
		if (cde != null) {
			return commandeRepository.save(cde);
		}

		return null;
	}

	@Override
	public Commande updateCommande(Long id, Commande cde) {
		// TODO Auto-generated method stub
		if (id != null && cde != null) {
			Optional<Commande> cdeOpt = commandeRepository.findById(id);

			if (cdeOpt != null) {
				Commande cdeOld = cdeOpt.get();
				if (cde.getArticle() != null) {
					Optional<Article> aOpt = articleRepository.findById(cde.getArticle().getId());
					if(aOpt != null)
					{
						Article a = aOpt.get();
						cdeOld.setArticle(a);
					}
				}
				if (cde.getBc() != null) {
					Optional<BC> bcOpt = bcRepository.findById(cde.getBc().getId());
					if(bcOpt != null)
					{
						BC bc = bcOpt.get();
						cdeOld.setBc(bc);
					}
					
				}
				if (cde.getQuantite() != 0) {
					cdeOld.setQuantite(cde.getQuantite());
				}
				return commandeRepository.save(cdeOld);
			}
		}

		return null;

	}

	@Override
	public void deleteCommande(Long id) {
		// TODO Auto-generated method stub
		if (id != null) {
			commandeRepository.deleteById(id);
		}
	}

	@Override
	public List<Commande> findCommandesByBC(Long idBC) {
		// TODO Auto-generated method stub
		if (idBC != null) {
			return commandeRepository.findCommandesByBC(idBC);
		}
		return null;
	}

	@Override
	public Commande findCommandeById(Long id) {
		// TODO Auto-generated method stub
		if (id != null) {
			return commandeRepository.findById(id).get();
		}
		return null;
	}

	/*********** Fournisseur ************/

	@Override
	public Fournisseur addFournisseur(Fournisseur fournisseur) {
		// TODO Auto-generated method stub
		if (fournisseur != null) {
			return fournisseurRepository.saveAndFlush(fournisseur);
		}
		return null;
	}

	@Override
	public List<Fournisseur> findAllFournisseurs() {
		// TODO Auto-generated method stub
		return fournisseurRepository.findAll();
	}

	@Override
	public Fournisseur updateFournisseur(Long id, Fournisseur f) {
		// TODO Auto-generated method stub
		if (id != null && f != null) {
			
			Optional<Fournisseur> fOpt = fournisseurRepository.findById(id);

			if (fOpt != null) {
				Fournisseur fOld = fOpt.get();
				if (f.getCodeFournisseur() != null) {
					fOld.setCodeFournisseur(f.getCodeFournisseur());
				}
				if (f.getLatitude() != null) {
					fOld.setLatitude(f.getLatitude());
				}
				if (f.getLongitude() != null) {
					fOld.setLongitude(f.getLongitude());
				}
				if (f.getRs() != null) {
					fOld.setRs(f.getRs());
				}
				if (f.getSiren() != 0) {
					fOld.setSiren(f.getSiren());
				}
				if (f.getType() != null) {
					fOld.setType(f.getType());
				}

				return fournisseurRepository.save(fOld);
			}
		}

		return null;
	}

	@Override
	public void deleteFournisseur(Long id) {
		// TODO Auto-generated method stub
		if(id != null)
		{
			fournisseurRepository.deleteById(id);
		}
	}

	@Override
	public Fournisseur findFournisseurBySiren(int siren) {
		// TODO Auto-generated method stub
		if(siren > 0)
		{
			return fournisseurRepository.findFournisseurBySiren(siren);
		}
		return null;
	}

	@Override
	public Fournisseur findFournisseurByRS(String rs) {
		// TODO Auto-generated method stub
		if(rs != null)
		{
			return fournisseurRepository.findFournisseurByRS(rs);
		}
		return null;
	}

	@Override
	public List<Fournisseur> findFournisseursByType(String type) {
		// TODO Auto-generated method stub
		if(type != null)
		{
			return fournisseurRepository.findFournisseursByType(type);
		}
		return null;
	}

	@Override
	public Fournisseur findFournisseurById(Long id) {
		// TODO Auto-generated method stub
		if(id != null)
		{
			return fournisseurRepository.findById(id).get();
		}
		return null;
	}

	/*********** GpsRowData ************/

	@Override
	public GpsRowData addGpsRowData(GpsRowData gprd) {
		// TODO Auto-generated method stub
		if (gprd != null) {
			gprd.setDate(new Date());
			return gpsRowDataRepository.save(gprd);
		} 
		
		return null;
	}

	@Override
	public GpsRowData updateGpsRowData(Long id, GpsRowData gprd) {
		// TODO Auto-generated method stub
		// Verifieeeeeeeeeeeeeeeeeeeeeee
		if (id != null && gprd != null) {
			Optional<GpsRowData> gprdOpt = gpsRowDataRepository.findById(id);
			
			if (gprdOpt != null) {
				GpsRowData gprdOld = gprdOpt.get();
				if (gprd.getClient() != null) {
					Long idC = gprd.getClient().getId();
					Optional<Client> cOpt = clientRepository.findById(idC);
					Client c = cOpt.get();
					gprdOld.setClient(c);
				}
				if (gprd.getFournisseur() != null) {
					Optional<Fournisseur> fOpt = fournisseurRepository.findById(gprd.getFournisseur().getId());
					if(fOpt != null)
					{
						Fournisseur f = fOpt.get();
						gprdOld.setFournisseur(f);
					}
				}
				if (gprd.getLatitude() != null) {
					gprdOld.setLatitude(gprd.getLatitude());
				}
				if (gprd.getLongitude() != null) {
					gprdOld.setLongitude(gprd.getLongitude());
				}
				if (gprd.getVehicule() != null) {
					Optional<Vehicule> vOpt = vehiculeRepository.findById(gprd.getVehicule().getIdVeh());
					if(vOpt != null)
					{
						Vehicule v = vOpt.get();
						gprdOld.setVehicule(v);	
					}
				}

				return gpsRowDataRepository.save(gprdOld);
			} 
		} 
			return null;
	}

	@Override
	public void deleteGpsRowData(Long id) {
		// TODO Auto-generated method stub
		if (id != null) {
			gpsRowDataRepository.deleteById(id);
		}
	}

	@Override
	public List<GpsRowData> findGpsRowsDataByImmandDate(String imm, Date dateDebut, Date dateFin) {
		// TODO Auto-generated method stub
		if(imm != null && dateDebut != null && dateFin != null)
		{
			return gpsRowDataRepository.findGpsRowsDataByImmandDate(imm, dateDebut, dateFin);
		}
		return null;
	}

	@Override
	public GpsRowData findGpsRowDataById(Long id) {
		// TODO Auto-generated method stub
		if(id != null)
		{
			return gpsRowDataRepository.findById(id).get();
		}
		return null;
	}

	/*********** Planning ************/

	@Override
	public Planning addPlanning(Planning pl) {
		if (pl != null) {
			// TODO Auto-generated method stub
			pl.setDate(new Date());
			pl.setIsValidC(false);
			pl.setIsValidF(false);
			return planningRepository.save(pl);
		} 
		return null;
	}

	@Override
	public Planning updatePlanning(Long id, Planning pl) {
		// TODO Auto-generated method stub
		// Verifiiiiieeeeeeeeeeeee

		if (id != null && pl != null) {
			Optional<Planning> plOpt = planningRepository.findById(id);
			
			if (plOpt != null) {
				
				Planning plOld = plOpt.get();
				
				if (pl.getIsValidC() != null) {
					plOld.setIsValidC(pl.getIsValidC());
				}
				if (pl.getIsValidF() != null) {
					plOld.setIsValidF(pl.getIsValidF());
				}
				if (pl.getBl() != null) {
					Optional<BL> blOpt = blRepository.findById(pl.getBl().getId());
					if(blOpt != null)
					{
						BL bl = blOpt.get();
						plOld.setBl(bl);
					}
					
				}
				if (pl.getClient() != null) {
					Optional<Client> cOpt = clientRepository.findById(pl.getClient().getId());
					if(cOpt != null)
					{
						Client c = cOpt.get();
						plOld.setClient(c);
					}
					
				}
				if (pl.getDate() != null) {
					plOld.setDate(pl.getDate());
				}
				if (pl.getDateValidC() != null) {
					plOld.setDateValidC(pl.getDateValidC());
				}
				if (pl.getDateValidF() != null) {
					plOld.setDateValidF(pl.getDateValidF());
				}
				if (pl.getFournisseur() != null) {
					Optional<Fournisseur> fOpt = fournisseurRepository.findById(pl.getFournisseur().getId());
					if(fOpt != null)
					{
						Fournisseur f = fOpt.get();
						plOld.setFournisseur(f);
					}
					
				}
				if (pl.getPeseeClient() != null) {
					plOld.setPeseeClient(pl.getPeseeClient());
				}
				if (pl.getPeseeFournisseur() != null) {
					plOld.setPeseeFournisseur(pl.getPeseeFournisseur());
				}
				if (pl.getProduit() != null) {
					Optional<Article> pOpt = articleRepository.findById(pl.getProduit().getId());
					if(pOpt != null)
					{
						Article p = pOpt.get();
						plOld.setProduit(p);
					}
					
				}
				if (pl.getUnitePesee() != null) {
					plOld.setUnitePesee(pl.getUnitePesee());
				}
				if (pl.getVehicule() != null) {
					Optional<Vehicule> vOpt = vehiculeRepository.findById(pl.getVehicule().getIdVeh());
					if(vOpt != null)
					{
						Vehicule v = vOpt.get();
						plOld.setVehicule(v);	
					}
				}

				return planningRepository.save(plOld);
			}
		} 
		return null;
	}

	@Override
	public void deletePlanning(Long id) {
		// TODO Auto-generated method stub
		if(id != null)
		{
			planningRepository.deleteById(id);	
		}	
	}

	@Override
	public List<Planning> findPlanningsByImm(String imm) {
		// TODO Auto-generated method stub
		if(imm != null)
		{
			return planningRepository.findPlanningsByImm(imm, Sort.by(Sort.Direction.DESC, "date"));
		}
		return null;
	}

	@Override
	public List<Planning> findPlanningsByImmandDate(String imm, Date dateD, Date dateF) {
		// TODO Auto-generated method stub
		if(imm != null && dateD != null && dateF != null)
		{
			return planningRepository.findPlanningsByImmandDate(imm, dateD, dateF, Sort.by(Sort.Direction.DESC, "date"));
		}
		return null;
	}

	/*********** Rappel ************/

	@Override
	public Rappel sendRappel(Rappel r) {
		// TODO Auto-generated method stub
		if (r != null) {
			r.setDate(new Date());
			r.setIsSeen(false);
			return rappelRepository.save(r);
		}
		return null;
	}

	@Override
	public List<Rappel> findRappelsForReceiver(Long id) {
		// TODO Auto-generated method stub
		if (id != null) {
			return rappelRepository.findRappelForReceiver(id);
		}
		return null;
	}

	@Override
	public Rappel rappelSeen(Long id) {
		// TODO Auto-generated method stub
		if (id != null) {
			Optional<Rappel> rOpt = rappelRepository.findById(id);
			if(rOpt != null)
			{
				Rappel rOld = rOpt.get();
				rOld.setIsSeen(true);
				return rappelRepository.save(rOld);
			}
			
		}
		return null;
	}

	@Override
	public Rappel updateRappel(Long id, Rappel r) {
		// TODO Auto-generated method stub
		if (id != null && r != null) {
			Optional<Rappel> rOpt = rappelRepository.findById(id);
		
			if (rOpt != null) {
				
				Rappel rOld = rOpt.get();
				
				if (r.getMessage() != null) {
					rOld.setMessage(r.getMessage());
				}
				if (r.getMotif() != null) {
					rOld.setMotif(r.getMotif());
				}
				if (r.getReceiver() != null) {
					Optional<AppUser> recOpt = userRepo.findById(r.getReceiver().getId());
					if(recOpt != null)
					{
						AppUser receiver = recOpt.get();
						rOld.setReceiver(receiver);
					}
					
				}

				return rappelRepository.save(rOld);
			}
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		if (id != null) {
			rappelRepository.deleteById(id);
		}
	}

	/*********** RevenuDepense ************/

	@Override
	public RevenuDepense addRevenuDepense(RevenuDepense rd) {
		// TODO Auto-generated method stub
		if (rd != null) {
			rd.setDate(new Date());
			return revenuDepenseRepository.save(rd);
		}
		return null;
	}

	@Override
	public RevenuDepense updateRevenuDepense(Long id, RevenuDepense rd) {
		// TODO Auto-generated method stub
		if (id != null && rd != null) {
			Optional<RevenuDepense> rdOpt = revenuDepenseRepository.findById(id);

			if (rdOpt != null) {
				
				RevenuDepense rdOld = rdOpt.get();
				
				if (rd.getDescription() != null) {
					rdOld.setDescription(rd.getDescription());
				}
				if (rd.getMontant() != null) {
					rdOld.setMontant(rd.getMontant());
				}
				if (rd.getType() != null) {
					rdOld.setType(rd.getType());
				}

				return revenuDepenseRepository.save(rdOld);
			}
		}
		return null;
	}

	@Override
	public void deleteRevenuDepense(Long id) {
		// TODO Auto-generated method stub
		if (id != null) {
			revenuDepenseRepository.deleteById(id);
		}
	}

	@Override
	public List<RevenuDepense> findAllRevenus() {
		// TODO Auto-generated method stub
		return revenuDepenseRepository.findAllRevenus(Sort.by(Sort.Direction.DESC, "date"));
	}

	@Override
	public List<RevenuDepense> findAllDepenses() {
		// TODO Auto-generated method stub
		return revenuDepenseRepository.findAllDepenses(Sort.by(Sort.Direction.DESC, "date"));
	}

	@Override
	public RevenuDepense findRevenuDepenseById(Long id) {
		// TODO Auto-generated method stub
		if (id != null) {
			return revenuDepenseRepository.findById(id).get();
		}
		return null;
	}

	/*********** User ************/

	@Override
	public AppUser addUser(AppUser u) {
		// TODO Auto-generated method stub
		if (u != null) {
			/*String hashPassword =bCryptPasswordEncoder.encode(u.getPassword());
			u.setPassword(hashPassword);*/
			return userRepo.save(u);
		}
		return null;
	}

	@Override
	public AppUser updateUser(Long id, AppUser u) {
		// TODO Auto-generated method stub
		if (id != null && u != null) {
			Optional<AppUser> uOpt = userRepo.findById(id);
			
			if (uOpt != null) {
				
				AppUser uOld = uOpt.get();
				
				if (u.getEmail() != null) {
					uOld.setEmail(u.getEmail());
				}
				if (u.getFirstName() != null) {
					uOld.setFirstName(u.getFirstName());
				}
				if (u.getLastName() != null) {
					uOld.setLastName(u.getLastName());
				}
				if (u.getPassword() != null) {
					uOld.setPassword(u.getPassword());
				}
				if (u.getRole() != null) {
					uOld.setRole(u.getRole());
				}

				return userRepo.save(uOld);
			}
		}

		return null;

	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		if (id != null) {
			userRepo.deleteById(id);
		}
	}

	@Override
	public List<AppUser> findOtherUsers() {
		// TODO Auto-generated method stub
		return userRepo.findOtherUsers();
	}

	@Override
	public AppUser findAppUserByEmail(String email) {
			/*if(email != null)
			{
				AppUser u = userRepo.findUserByEmail(email);
				
				if(u!=null)
				{
					return u;
				}
				else throw new UsernameNotFoundException("Utilisateur introuvable !");
			}*/
			return null;
		}
	
	/*@Override
	public UserDetails findUserByEmail(String email) {
		// TODO Auto-generated method stub
		if (email != null) {
			AppUser u = userRepo.findByEmail(email);
			
			if(u==null)
			{
				throw new UsernameNotFoundException("Email : "+email+" not found");
			}
			return new UserDetails() {
				
				@Override
				public boolean isEnabled() {
					// TODO Auto-generated method stub
					return true;
				}
				
				@Override
				public boolean isCredentialsNonExpired() {
					// TODO Auto-generated method stub
					return true;
				}
				
				@Override
				public boolean isAccountNonLocked() {
					// TODO Auto-generated method stub
					return true;
				}
				
				@Override
				public boolean isAccountNonExpired() {
					// TODO Auto-generated method stub
					return true;
				}
				
				@Override
				public String getUsername() {
					// TODO Auto-generated method stub
					return u.getEmail();
				}
				
				@Override
				public String getPassword() {
					// TODO Auto-generated method stub
					return u.getPassword();
				}
				
				@Override
				public Collection<? extends GrantedAuthority> getAuthorities() {
					// TODO Auto-generated method stub
					Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
					if(u.getRole().getName().equalsIgnoreCase("admin"))
					{
						authorities.add(new SimpleGrantedAuthority("admin"));
					}
					if(u.getRole().getName().equalsIgnoreCase("resp_p"))
					{
						authorities.add(new SimpleGrantedAuthority("resp_p"));
					}
					if(u.getRole().getName().equalsIgnoreCase("resp_e"))
					{
						authorities.add(new SimpleGrantedAuthority("resp_e"));
					}
					if(u.getRole().getName().equalsIgnoreCase("chauff"))
					{
						authorities.add(new SimpleGrantedAuthority("chauff"));
					}
					return authorities;
				}
			};
		}
		return null;
	}*/

	@Override
	public AppUser findUserById(Long id) {
		// TODO Auto-generated method stub
		if (id != null) {
			Optional<AppUser> userOpt = userRepo.findById(id);
			if(userOpt != null)
			{
				AppUser user = userOpt.get();
				return user;
			}
		}
		return null;
	}

	@Override
	public AppUser login(String email, String password) {
		// TODO Auto-generated method stub
		if(email != null && password != null)
		{
			return userRepo.findByEmailAndPassword(password, password);
		}
		return null;
	}

	@Override
	public AppUser findUserByRole(String role) {
		// TODO Auto-generated method stub
		if(role != null)
		{
			return userRepo.findByRoleName(role);
		}
		return null;
	}

	/*********** Vehicule ************/

	@Override
	public Vehicule addVehicule(Vehicule v) {
		// TODO Auto-generated method stub
		if(v != null)
		{
			return vehiculeRepository.save(v);
		}
		return null;
	}

	@Override
	public Vehicule updateVehicule(Long id, Vehicule v) {
		// TODO Auto-generated method stub
		if(id != null && v != null)
		{
			Optional<Vehicule> vOpt = vehiculeRepository.findById(id);
			
			if(vOpt != null)
			{
				Vehicule vOld = vOpt.get();
				if (v.getImmatriculation() != null) {
					vOld.setImmatriculation(v.getImmatriculation());
				}
				if (v.getNomChauffeur() != null) {
					vOld.setNomChauffeur(v.getNomChauffeur());
				}
				return vehiculeRepository.save(vOld);
			}
		}
		return null;
		
	}

	@Override
	public void deleteVehicule(Long id) {
		// TODO Auto-generated method stub
		if(id != null)
		{
			vehiculeRepository.deleteById(id);	
		}
	}

	@Override
	public Vehicule findVehiculeByImmatriculation(String imm) {
		// TODO Auto-generated method stub
		if(imm != null)
		{
			return vehiculeRepository.findVehiculeByImmatriculation(imm);
		}
		return null;
	}

	@Override
	public List<Vehicule> findAll() {
		// TODO Auto-generated method stub
		return vehiculeRepository.findAll();
	}

	@Override
	public Vehicule findVehiculeById(Long id) {
		// TODO Auto-generated method stub
		if(id != null)
		{
			return vehiculeRepository.findById(id).orElseThrow(
			()-> new ResourceNotFoundException("Le vehicule ayant l'id "+id+" est inexistant !"));
		}
		return null;
	}

	@Override
	public Role addRole(Role r) {
		if(r != null)
		{
			return roleRepo.save(r);
		}
		return null;
	}

	@Override
	public Role updateRole(Long id, Role r) {
		if(id != null && r != null)
		{
			Optional<Role> rOpt = roleRepo.findById(id);
			
			if(rOpt != null)
			{
				Role rOld = rOpt.get();
				if (r.getName() != null) {
					rOld.setName(r.getName());
				}
			
				return roleRepo.save(rOld);
			}
		}
		return null;
	}

	@Override
	public void deleteRole(Long id) {
		// TODO Auto-generated method stub
		if(id != null)
		{
			roleRepo.deleteById(id);
		}
	}

	@Override
	public List<Role> getRoles() {
		// TODO Auto-generated method stub
		return roleRepo.findAll();
	}

	@Override
	public Role getRoleById(Long id) {
		// TODO Auto-generated method stub
		if(id != null)
		{
			return roleRepo.findById(id).get();
		}
		return null;
	}

}
