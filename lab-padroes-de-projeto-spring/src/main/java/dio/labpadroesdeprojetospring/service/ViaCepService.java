package dio.labpadroesdeprojetospring.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import dio.labpadroesdeprojetospring.model.Endereco;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
	
	@RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")
	Endereco consultarCep(@PathVariable("cep") String cep);

}
