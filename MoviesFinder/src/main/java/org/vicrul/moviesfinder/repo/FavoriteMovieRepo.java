package org.vicrul.moviesfinder.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vicrul.moviesfinder.domain.FavoriteMovie;

@Repository
public interface FavoriteMovieRepo extends JpaRepository<FavoriteMovie, Integer> {
	int countByUserId(int userId);	
	FavoriteMovie findByUserIdAndMovieId(int userId, int movieId);
	List<FavoriteMovie> findByUserId(int userId, Pageable pageable);
	@Transactional
	@Modifying
	@Query("delete from FavoriteMovie m where m.userId = ?1 and m.movieId = ?2")
	void deleteByUserIdAndMovieId(int userId, int movieId);
}
