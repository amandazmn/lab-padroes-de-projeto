package dio;

import dio.singleton.SingletonEager;
import dio.singleton.SingletonLazy;
import dio.singleton.SingletonLazyHolder;
import dio.strategy.*;
import dio.facade.*;

public class Test {

	public static void main(String[] args) {

		//Singleron
		
		SingletonLazy lazy = SingletonLazy.getInstancia();
		System.out.println(lazy);
		lazy = SingletonLazy.getInstancia();
		System.out.println(lazy);

		SingletonEager eager = SingletonEager.getInstancia();
		System.out.println(eager);
		eager = SingletonEager.getInstancia();
		System.out.println(eager);
		
		SingletonLazyHolder lazyHolder = SingletonLazyHolder.getInstancia();
		System.out.println(lazyHolder);
		lazyHolder = SingletonLazyHolder.getInstancia();
		System.out.println(lazyHolder);
		
		//Strategy
		
		Comportamento defensivo = new ComportamentoDefensivo();
		Comportamento normal = new ComportamentoNormal();
		Comportamento agressivo = new ComportamentoAgressivo();
		
		Robo robo = new Robo();
		robo.setComportamneto(normal);
		robo.mover();
		robo.mover();
		robo.setComportamneto(agressivo);
		robo.mover();
		robo.setComportamneto(defensivo);
		robo.mover();
		robo.mover();
		robo.mover();
		
		//Facade
		
		Facade facade = new Facade();
		facade.migrarCliente("Amanda", "89128000");
	}

}
