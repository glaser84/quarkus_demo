package at.cgsit.train.quarkus.service;

import at.cgsit.train.quarkus.persistence.entities.ChatMessageEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@ApplicationScoped
public class DemoServiceDb {

    @Inject
    EntityManager em;

    @Transactional
    public String reverseEcho(String echoIn) {

        ChatMessageEntity entity = new ChatMessageEntity();
        entity.setChatMessage(echoIn);
        entity.setChatRoom("room1");
        entity.setUserName("username");
        entity.setCreationTime(LocalDateTime.now());

        em.persist(entity);

        Query query = em.createQuery("select count(e) from ChatMessageEntity e");
        Long singleResult = (Long) query.getSingleResult();

        return "count is: " + singleResult.toString();
    }
}
