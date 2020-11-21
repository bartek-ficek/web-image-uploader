package pl.bartekficek.springbootimageuploader.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bartekficek.springbootimageuploader.model.AppUser;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
