package miffy;

import javax.jdo.*;

//PersistenceManagerFactoryインスタンスを取得する
public class PMF {
    private static final javax.jdo.PersistenceManagerFactory factory = 
        JDOHelper.getPersistenceManagerFactory("transactions-optional");
     
    private PMF(){}
     
    public static javax.jdo.PersistenceManagerFactory get(){
        return factory;
    }
}