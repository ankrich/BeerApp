package au.com.ankrich;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by arichharia on 29/06/2016.
 */
public interface DBRepository extends JpaRepository<Beer, Integer> {
}
