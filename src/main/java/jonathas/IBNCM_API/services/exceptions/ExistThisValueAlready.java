package jonathas.IBNCM_API.services.exceptions;

import jonathas.IBNCM_API.entities.Finalidade;

public class ExistThisValueAlready extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExistThisValueAlready(String msg, Finalidade finalidade) {
		super(finalidade.getDescricao() + "Já existe! ");
	}
}
