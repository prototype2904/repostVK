package ru.vkrepostcontest.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * @author Stetskevich Roman on 06.09.2016.
 * @since 0.1
 */
public interface PostRepository extends JpaRepository<Post, Long>{

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN 'true' ELSE 'false' END FROM Post p WHERE p.ownerId = ?1 and p.postId = ?2")
    Boolean isExistOneByOwnerIdAndPostId(String ownerId, String postId);

	/**

	 * найти доступные, не доступные посты
     * @param available
     * @return
     */
    List<Post> findAllByAvailable(boolean available);

	/**
     * найти доступные/недоступные за интервал времени
     * @param available
     * @param startDate
     * @param finishDate
     * @return
     */
    List<Post> findAllByAvailableAndDateBetween(boolean available, Date
            startDate, Date finishDate);

	/**
	 * найти доступные/недоступные за дату
     * @param available
     * @param date
     * @return
     */
    List<Post> findAllByAvailableAndDate(boolean available, Date date);
}
