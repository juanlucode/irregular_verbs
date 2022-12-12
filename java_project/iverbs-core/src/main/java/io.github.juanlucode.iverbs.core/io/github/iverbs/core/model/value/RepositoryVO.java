package io.github.iverbs.core.model.value;

import java.io.FileNotFoundException;
import java.util.List;

import io.github.iverbs.core.model.business.RepositoryBO;

public class RepositoryVO {

	private List<VerbVO> verbList = null;

	public RepositoryVO() throws FileNotFoundException {
		this.verbList = RepositoryBO.load();
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
