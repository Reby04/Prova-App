package it.univaq.disim.mobile.unievent.business.impl;

import it.univaq.disim.mobile.unievent.business.domain.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {

    //boolean removeByToken(String token);

    void deleteByToken(String token);

    Session findByToken(String token);
    Session findByUserId (Long user_id);
}
