package com.todoproject.v2.DataAccess;

import com.todoproject.v2.Entities.Task;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


//JPA - ORM
@Repository
public class HibernateTaskDal implements ITaskDal{

    @Autowired
    public HibernateTaskDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private EntityManager entityManager;


    @Override
    @Transactional //AOP Aspect Oriented Programming
    public List<Task> getAll() {
       Session session = entityManager.unwrap(Session.class);
        List<Task> tasks = session.createQuery("from Task",Task.class).getResultList();
        return tasks;
    }

    @Override
    public void add(Task task) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(task);
    }

    @Override
    public void delete(Task task) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(task);

    }

    @Override
    public void update(Task task) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(task);

    }

    @Override
    public Task getById(int id) {
        Session session = entityManager.unwrap(Session.class);

        Task task = session.get(Task.class,id);
        return task;

    }
}
