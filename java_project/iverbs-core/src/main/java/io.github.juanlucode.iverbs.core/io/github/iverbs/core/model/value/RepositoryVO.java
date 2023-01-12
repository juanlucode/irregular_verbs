package io.github.iverbs.core.model.value;

import java.util.List;

import io.github.iverbs.core.model.business.RepositoryBO;

public class RepositoryVO {

	private static RepositoryVO instance;
	private List<VerbVO> verbList = null;

	private RepositoryVO(String _verbsFile) {
		this.verbList = RepositoryBO.load(_verbsFile);
	}

	public static RepositoryVO getInstance(String _verbsFile){
		if ( instance == null ){
			instance = new RepositoryVO(_verbsFile);
		}
		return instance;
	}

	public List<VerbVO> getVerbList() {
		return verbList;
	}

	/**
	 * Gets the repository size. Number of verbs.
	 */
	public int size() {
		return verbList.size();
	}


}
