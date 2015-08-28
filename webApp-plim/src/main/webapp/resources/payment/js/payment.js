cc = Iugu.CreditCard("4111111111111111", "12", "18", "Nome", "Sobrenome", "123");

dataCharge = {
  token: "B07C78E1-9B01-44C3-9286-B5B29190C675",
  email: "teste@teste.com",
  items: [{
    description: "Item Um",
    quantity: "1",
    price_cents: "1000"
  }],
  payer: {
    name: "Nome do Cliente",
    phone_prefix: "11",
    phone: "12121212",
    email: "teste@teste.com",
    address: {
      street: "Rua Tal",
      number: "700",
      city: "São Paulo",
      state: "SP",
      country: "Brasil",
      zip_code: "12122-00"
    }
  }
}


jQuery(function($) {

  $('#payment-form').submit(function(evt) {
    var form = $(this);

    var tokenResponseHandler = function(data) {

      if (data.errors) {
              // console.log(data.errors);
              alert("Erro salvando cartão: " + JSON.stringify(data.errors));
            } else {
              $("#token").val( data.id );
              //form.get(0).submit();
            }

          // Seu código para continuar a submissão
          // Ex: form.submit();
        }

        Iugu.setAccountID("37b1b0a1-917e-482b-89cb-b4928b58614d");
      //test mode
      Iugu.setTestMode(true);

      var nome = jQuery(".credit_card_name").val();
      var sobreNome = jQuery(".credit_card_name").val();
      var numeroCartao = jQuery(".credit_card_number").val(); 
      var expiration = jQuery(".credit_card_expiration").val(); 
      Iugu.createPaymentToken(cc, tokenResponseHandler);
      return false;
    });

 /* $.ajax({
    url: "https://api.iugu.com/v1/charge",
    beforeSend: function(xhr) { 
      xhr.setRequestHeader("Authorization", "Basic " + btoa("cbacd7e79880e8d79a79ea473e43a2d0")); 
    },
    type: 'POST',
    dataType: 'json',
    contentType: 'application/json',
    processData: false,
    data: {
      token: "B07C78E1-9B01-44C3-9286-B5B29190C675",
      email: "teste@teste.com",
      items: [{
        description: "Item Um",
        quantity: "1",
        price_cents: "1000"
      }],
      payer: {
        name: "Nome do Cliente",
        phone_prefix: "11",
        phone: "12121212",
        email: "teste@teste.com",
        address: {
          street: "Rua Tal",
          number: "700",
          city: "São Paulo",
          state: "SP",
          country: "Brasil",
          zip_code: "12122-00"
        }
      }
    },
    success: function (data) {
      alert(JSON.stringify(data));
    },
    error: function(data){
      alert("Cannot get data" + data);
    }
  });*/

});