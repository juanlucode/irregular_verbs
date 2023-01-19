package io.github.iverbs.core.model.value;

import java.util.List;

import io.github.iverbs.core.model.business.RepositoryBO;

public class RepositoryVO {

	private static RepositoryVO instance;
	private List<VerbVO> verbList = null;

	private RepositoryVO() {
		this.verbList = RepositoryBO.load();
	}

	public static RepositoryVO getInstance(){
		if ( instance == null ){
			instance = new RepositoryVO();
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
