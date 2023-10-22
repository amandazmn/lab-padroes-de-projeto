package dio.labpadroesdeprojetospring.service;

import dio.labpadroesdeprojetospring.model.Cliente;
import dio.labpadroesdeprojetospring.service.ClienteService;

public interface ClienteService {
	
	Iterable<Cliente> buscarTodos();
	
	Cliente buscarPorId(Long id);
	
	void inserir(Cliente cliente);
	
	void atualizar(Long id, Cliente cliente);
	
	void deletar(Long id);

}
