package dio.labpadroesdeprojetospring.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import dio.labpadroesdeprojetospring.model.Cliente;
import dio.labpadroesdeprojetospring.model.ClienteRepository;
import dio.labpadroesdeprojetospring.model.Endereco;
import dio.labpadroesdeprojetospring.model.EnderecoRepository;
import dio.labpadroesdeprojetospring.service.ClienteService;
import dio.labpadroesdeprojetospring.service.ViaCepService;

public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;
	
	@Override
	public Iterable<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Cliente cliente) {
		salvarClientecomCep(cliente);
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if(clienteBd.isPresent()) {
			salvarClientecomCep(cliente);
		}
	}

	@Override
	public void deletar(Long id) {
		clienteRepository.deleteById(id);
	}
	
	private void salvarClientecomCep(Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		cliente.setEndereco(endereco);
		clienteRepository.save(cliente);
	}
}
