<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Card &ndash; the better way to collect credit cards</title>
<meta name="viewport" content="initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="resources/payment/css/payment.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<script type="text/javascript">
	function efetuarPagamento() {
		var settings = {
			"Forma" : "CartaoCredito",
			"Instituicao" : "Visa",
			"Parcelas" : "1",
			"CartaoCredito" : {
				"Numero" : "4073020000000002",
				"Expiracao" : "12/15",
				"CodigoSeguranca" : "123",
				"Portador" : {
					"Nome" : "Nome Sobrenome",
					"DataNascimento" : "30/12/1987",
					"Telefone" : "(11)3165-4020",
					"Identidade" : "222.222.222-22"
				}
			}
		}
		MoipWidget(settings);
		return false;
	}

	var funcaoSucesso = function(data) {
		alert('Sucesso\n' + JSON.stringify(data));
		window.open(data.url);
	};

	var funcaoFalha = function(data) {
		alert('Falha\n' + JSON.stringify(data));
	};

	pagarBoleto = function() {
		var settings = {
			"Forma" : "BoletoBancario"
		}
		MoipWidget(settings);
	}
</script>
</head>
<body>

	<style>
.demo-container {
	width: 100%;
	max-width: 350px;
	margin: 50px auto;
}

form {
	margin: 30px;
}

input {
	width: 200px;
	margin: 10px auto;
	display: block;
}
</style>
	<div class="demo-container"></div>
	<form action="payment" id="payment-form">
		<div class="usable-creditcard-form">
			<div class="card-wrapper"></div>
			<div class="wrapper" style="margin-top: 10px">
				<div class="input-group nmb_a">
					<div class="icon ccic-brand"></div>
					<input autocomplete="off" class="credit_card_number"
						data-iugu="number" placeholder="Número do Cartão" type="text"
						value="" name="number" />
				</div>
				<div class="input-group nmb_b">
					<div class="icon ccic-cvv"></div>
					<input autocomplete="off" class="credit_card_cvv"
						data-iugu="verification_value" placeholder="CVV" type="text"
						value="" name="cvc" />
				</div>
				<div class="input-group nmb_c">
					<div class="icon ccic-name"></div>
					<input class="credit_card_name" data-iugu="full_name"
						placeholder="Titular do Cartão" type="text" value="" name="name" />
				</div>
				<div class="input-group nmb_d">
					<div class="icon ccic-exp"></div>
					<input autocomplete="off" class="credit_card_expiration"
						data-iugu="expiration" placeholder="MM/AA" type="text" value=""
						name="expiry" />
				</div>
			</div>
			<input type="hidden" name="token" id="token" value="" readonly="true"
				size="64" style="text-align: center" />
			<div id="MoipWidget" data-token="${pedido.cartao.token}"
				callback-method-success="funcaoSucesso"
				callback-method-error="funcaoFalha"></div>
			<div class="col-md-12" style="margin-top: 10px">
				<div class="submit-div">
					<button type="button" onclick="efetuarPagamento()"
						class="form-group btn btn-success btn-sm"
						style="width: 100%; font-size: 18px; text-shadow: 1px 1px 1px #575353;">Pagar</button>
				</div>
			</div>
		</div>
	</form>

	<script type='text/javascript'
		src='https://desenvolvedor.moip.com.br/sandbox/transparente/MoipWidget-v2.js'
		charset='ISO-8859-1'></script>
	<script src="resources/lib/js/card.js"></script>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="https://js.iugu.com/v2"></script>
	<!-- <script type="text/javascript" src="resources/payment/js/payment.js"></script> -->
	<script type="text/javascript" src="https://js.iugu.com/v2"></script>
	<script type="text/javascript"></script>
	<script>
		new Card({
			form : document.querySelector('form'),
			container : '.card-wrapper'
		});
	</script>
</body>
</html>
