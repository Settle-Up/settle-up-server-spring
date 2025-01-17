package settleup.backend.domain.user.repository;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import settleup.backend.domain.user.entity.AbstractUserEntity;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface UserBaseRepository<T extends AbstractUserEntity> extends JpaRepository<T, Long> {
    Optional<T> findById(Long id);
    Optional<T> findByUserEmail(String email);
    Optional<T> findByUserUUID(String UUID);

    @Query("SELECT u FROM #{#entityName} u WHERE u.userEmail LIKE %:partOfEmail% AND u.userEmail <> :notContainUserEmail")
    Page<T> findByUserEmailContainingAndUserEmailNot(
            @Param("partOfEmail") String partOfEmail,
            @Param("notContainUserEmail") String notContainUserEmail,
            Pageable pageable
    );

    @Query("SELECT u FROM #{#entityName} u WHERE u.userEmail LIKE %:email% AND u.id NOT IN :excludedUserIds")
    Page<T> findByEmailExcludingUsers(
            @Param("email") String email,
            @Param("excludedUserIds") List<Long> excludedUserIds,
            Pageable pageable
    );

//    @Fetch("SELECT u FROM #{#entityName} u WHERE u.")
}
