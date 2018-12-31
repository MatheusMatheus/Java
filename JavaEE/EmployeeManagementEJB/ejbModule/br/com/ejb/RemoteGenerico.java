package ejb;

import javax.ejb.Remote;

import br.com.modelo.EntidadeBase;

@Remote
public interface RemoteGenerico<T extends EntidadeBase> {
	public T salvar(T entidade) throws Exception;

	public void excluir(T entidade);

	public T consultarPorId(Long id);
}
