'use strict'

function onchar(){
    easyform();
}

function easyform() { 
    var clicks = document.querySelectorAll('.ilc');
    for (let i = 0; i < clicks.length; i++) {
      clicks[i].onclick = function() {    
        var tSiblings = this.parentElement.children;
        for (let i = 0; i < tSiblings.length; i++) {
          tSiblings[i].className = "dilc";
        }
        
        this.className = "ilc-selected";
        //prove();
        let id1x = this.getAttribute("index");
        let forher = document.querySelector('.firma');
        let forhersibli = forher.parentElement.children;
        for (let i = 0; i < forhersibli.length; i++) {
             forhersibli[i].setAttribute('class','firma');
          if (forhersibli[i].getAttribute("index") == id1x) {
            forhersibli[i].className = "formu-selected";
          } 
        }
      };
  
    }
  }

  function restaurar(){
    let clicks1 = document.querySelector('.dilc');
    let pail = clicks1.parentElement.children;
    for (let i = 0; i < pail.length; i++) {
      pail[i].className = 'ilc';
    }
    let forher = document.querySelector('.firma');
        let forhersibli = forher.parentElement.children;
        for (let i = 0; i < forhersibli.length; i++) {
             forhersibli[i].setAttribute('class','firma');
        }
  }
  
  function getValorAtributoP(atributo) {
	alert('entro');
  let pValor = document.querySelectorAll('p');
  let valores = [];

  for (let i = 0; i < pValor.length; i++) {
    const valor = pValor[i].getAttribute(atributo);
    valores.push(valor);
  }

	for (let i = 0; i < pValor.length; i++) {
    	 pValor[i].setAttribute('th:text',"'${"+valores[i]+" }'");	
  	}
}