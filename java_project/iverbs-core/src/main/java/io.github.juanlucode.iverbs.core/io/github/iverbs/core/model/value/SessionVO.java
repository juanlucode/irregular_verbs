package io.github.iverbs.core.model.value;

public class SessionVO {

    private static RepositoryVO repositoryVO;

    private static SessionVO instance;


    private SessionVO(String _verbsFile){
        repositoryVO = RepositoryVO.getInstance(_verbsFile);
    }

    public static SessionVO getInstance(String _verbsFile){
        if ( instance == null) {
            instance = new SessionVO(_verbsFile);
        }
        return instance;
    }

    public RepositoryVO getRepository(){
        return repositoryVO;
    }

}
