package apap.tutorial.gopud.repository;

import apap.tutorial.gopud.model.MenuModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface MenuDb extends JpaRepository<MenuModel, Long> {
	List<MenuModel> findByRestoranIdRestoran(Long restoranId);

	Optional<MenuModel> findMenuByNamaAndHarga(String nama, BigInteger harga);
}
