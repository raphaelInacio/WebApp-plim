package br.com.plimmecanicos.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.moip.client.response.SendSingleInstructionResponse;
import br.com.plimmecanicos.bean.PedidoBean;
import br.com.plimmecanicos.service.Pagamento;

@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public ModelAndView test(HttpServletResponse response) throws IOException {
		PedidoBean pedido = new PedidoBean();
		Pagamento pagamento = new Pagamento();
		SendSingleInstructionResponse responseTokenPagamento = pagamento
				.receberTokenPagamento(pedido);
		pedido.getCartao().setToken(responseTokenPagamento.getResponse().getToken());
		return new ModelAndView("home").addObject("pedido", pedido);
	}

	@RequestMapping(value = "/payment")
	public ModelAndView efetuarPagamento(PedidoBean pedido) throws IOException {
		System.out.println(pedido.getCartao().getCvc());
		return new ModelAndView("sucesso");
	}
}
