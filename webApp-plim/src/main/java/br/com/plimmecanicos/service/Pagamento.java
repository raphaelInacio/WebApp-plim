package br.com.plimmecanicos.service;

import java.util.Date;

import br.com.moip.client.instruction.Address;
import br.com.moip.client.instruction.Billet;
import br.com.moip.client.instruction.Payer;
import br.com.moip.client.instruction.Receiver;
import br.com.moip.client.instruction.SendInstruction;
import br.com.moip.client.instruction.SingleInstruction;
import br.com.moip.client.instruction.Values;
import br.com.moip.client.response.SendSingleInstructionResponse;
import br.com.moip.client.send.SandboxMoip;
import br.com.plimmecanicos.bean.PedidoBean;

public class Pagamento {

	public SendSingleInstructionResponse receberTokenPagamento(PedidoBean pedido) {
		
		SendInstruction enviarInstrucao = new SendInstruction()
				.withSingleInstruction(new SingleInstruction()
						.withTransparentValidation()
						.withReason("Testaando a API de pagamentos MOIP")
						.withUniqueId("plim@" + new Date().getTime())
						.with(new Payer()
								.withName("Raphael In�cio")
								.withEmail("contato.raphaelinacio@gmail.com")
								.withPayerID("RAPHAELID")
								.withIdentity("222.222.222-22")
								.withCellphone("(61)9549-0529")
								.withBillingAddress(
										new Address()
												.withAddress("Rua Escorpi�o")
												.withNumber("550")
												.withNeighborhood(
														"Cidade Sat�lite")
												.withZipCode("08330-550")
												.withCity("Sao Paulo")
												.withState("SP")
												.withCountry("BRA")
												.withPhone("(11)2018-1788")))
						.with(new Values().withValue("15.00"))
						.with(new Receiver().withMoipLogin(
								"contato.raphaelinacio@gmail.com")
								.withNickname("contatorapha")));

		System.out.println(enviarInstrucao.getXML());

		System.out.println("--------------------------------");

		SendSingleInstructionResponse response = new SandboxMoip()
				.withToken("1NU4CZEUIRHYI2WTGYVJ7XCA7KAEMT9P")
				.withKey("J8QJBI8WHHWZUGLRMMBG4IDBER0LDDYIQUEEHDFN")
				.send(enviarInstrucao);

		System.out.println(response);
		
		return response;
	}
}
