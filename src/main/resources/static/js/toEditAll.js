function getValorAtributoP(atributo) {
	
  let inputValor = document.querySelectorAll('input');
  let valores = [];
  
  for (let i = 0; i < inputValor.length; i++) {   
    const valor = inputValor[i].getAttribute(atributo);  
    valores.push(valor);
  }

  let pValor = document.querySelectorAll('p');
	for (let i = 0; i < pValor.length; i++) {
    	 pValor[i].setAttribute('th:text',"*{"+valores[i]+"}");	
  	}
}




