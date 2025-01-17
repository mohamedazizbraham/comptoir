package comptoirs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import comptoirs.entity.Commande;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {
    @Query(
            // Chaîne de caractères multilignes
            """
             SELECT SUM(l.quantite *l.produit.prixUnitaire* (1-l.commande.remise))   
             FROM Ligne l
             WHERE l.commande.numero= :numeroCommande
             
            """)
    BigDecimal montantArticles(Integer numeroCommande);
}
