package br.com.cdi;

import java.lang.reflect.ParameterizedType;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.modelo.EntidadeBase;
import br.com.modelo.dao.DAO;
import br.com.modelo.dao.DAOGenerico;

public class Producers {
    @Produces
    @PersistenceContext
    private EntityManager em;

    @Produces
    public <T extends EntidadeBase> DAO<T> getDao(InjectionPoint ip){
        ParameterizedType t = (ParameterizedType) ip.getType();
        Class<T> classe = (Class) t.getActualTypeArguments()[0];
        return new DAOGenerico<T>(em, classe);
    }
}
