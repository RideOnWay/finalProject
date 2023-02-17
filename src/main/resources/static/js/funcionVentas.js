'use strict'
let aux, nta;

async function easyTabs() {
  hora();
  easyTabs1();

}

//Drag and drog functions
function allowDrop(ev) {
  ev.preventDefault();

}

function dragEnd(ev) {
  ev.preventDefault();
  document.getElementById("erasetab").style.visibility = 'hidden';

}

function drag(ev) {
  ev.dataTransfer.setData("text", ev.target.id);
  document.getElementById("erasetab").style.visibility = 'visible';
}

function drop(ev) {
  ev.preventDefault();
  let data = ev.dataTransfer.getData("text");
  eratabform(data);
  document.getElementById(data).remove();
  document.getElementById("erasetab").style.visibility = 'hidden';

}

//function to erase forms
function eratabform(indetab) {
  var groups = document.querySelectorAll('.t-tab');
  let forera = document.querySelectorAll('.t-form');
  var quit;

  if (groups.length > 0) {
    for (let i = 0; i < groups.length; i++) {
      if (groups[i].id == indetab) {
        forera[i].remove();
      }
    }
  }
}

//hour
function hora() {
  let hoy = new Date();
  let dhoy = hoy.getDate();
  let mhoy = hoy.getMonth() + 1;
  let ahoy = hoy.getFullYear();
  let hour = hoy.getHours();
  let min = hoy.getMinutes();
  if (mhoy < 10) { mhoy = "0" + mhoy };
  if (min < 10) { min = "0" + min };

  document.getElementById("dia").innerHTML = ahoy + "-" + mhoy + "-" + dhoy ;
  document.getElementById("hora").innerHTML = hour + ":" + min;
  
  document.getElementById("diaE").innerHTML = dhoy + "/" + mhoy + "/" + ahoy;
  document.getElementById("horaE").innerHTML = hour + ":" + min;
  var time = setTimeout(function () { hora() }, 500);
}

//oculta las pestañas no seleccionadas
let last;
function easyTabs1() {
  var clicks = document.querySelectorAll('.t-tab');
  for (let i = 0; i < clicks.length; i++) {
    if (i != clicks.length - 1) {
      clicks[i].onclick = function () {
        last = undefined;
        var tSiblings = this.parentElement.children;
        for (let i = 0; i < tSiblings.length; i++) {
          tSiblings[i].className = "t-tab";
        }
        this.className = "t-tab selected";
        var idx = this.getAttribute("index");
        var cSiblings = document.querySelectorAll('.t-form');
        for (let i = 0; i < cSiblings.length; i++) {
          cSiblings[i].className = "t-form";
          if (cSiblings[i].getAttribute("index") == idx) {
            cSiblings[i].className = "t-form selected";
          }
        }
      };
    }
  }
}

// new tab, begin on 4 
function newtab() {

  if (typeof nta == 'undefined') {
    nta = 4;
  }

  const newli = document.createElement("li");
  newli.setAttribute('class', 't-tab');
  newli.id = "tab" + nta;
  newli.draggable = "true";
  newli.setAttribute("ondragstart", "drag(event)");
  newli.setAttribute("ondragend", "dragEnd(event)");
  newli.setAttribute('index', nta);
  const textNode = document.createTextNode("Venta " + nta);
  newli.appendChild(textNode);

  const newul = document.querySelector('#ulmain');
  newul.insertBefore(newli, newul.children[newul.children.length - 1]);
  creaform(nta);
  easyTabs1();

  ++nta;

}

// new form and all its atributes 
function creaform(inc) {
  let formu = document.getElementById("formulario");
  let newformu = formu.cloneNode(true);
  newformu.setAttribute('class', 't-form');
  newformu.setAttribute('index', inc);
  newformu.id = "form" + inc;

  const newsel = document.querySelector('#forms');
  newsel.insertBefore(newformu, newsel.children[newsel.children.length - 1]);

  let chnselect = document.getElementById('drinkList');
  chnselect.id = 'drinkList' + inc;
  chnselect.setAttribute('onchange', "enlistar('drinkList" + inc + "','#drinktable" + inc + "','" + inc + "','listnameB','listPrecioB','listidB')");

  let chntbldrk = document.getElementById('drinktable');
  chntbldrk.id = 'drinktable' + inc;

  let chnslcsnk = document.getElementById('snacklist');
  chnslcsnk.id = 'snacklist' + inc;
  chnslcsnk.setAttribute('onchange', "enlistar('snacklist" + inc + "','#tablesnack" + inc + "','" + inc + "','listnameS','listPrecioS','listidS')");

  let chntblsnk = document.getElementById('tablesnack');
  chntblsnk.id = 'tablesnack' + inc;

  let chnbtt = document.getElementById('eraseAll');
  chnbtt.id = 'erase' + inc;
  chnbtt.setAttribute('onclick', "eraseall('" + chntbldrk.id + "','" + chntblsnk.id + "' )");

  let chnerabtt = document.getElementById('borrar');
  chnerabtt.id = 'borrar' + inc;
  chnerabtt.setAttribute('onclick', "erasetab()");

  let chntotbtt = document.getElementById('total');
  chntotbtt.id = 'total' + inc;
  chntotbtt.setAttribute('onclick', "totales('.precio" + inc + "', 'latotal" + inc + "')");

  let chntotlab = document.getElementById('latotal');
  chntotlab.id = 'latotal' + inc;

}

//new list with drinks or snacks objects  aqui se generan las tablas de los productos seleccionados
async function enlistar(selectid, tableid, num, list1, list2,list3) {
  let auz;
  let entrada = document.getElementById(selectid).value;
  if (selectid.includes('drink')) {
    auz = 1;
    
  } else {
    auz = 2;
  }
  if (typeof aux == 'undefined') {
    aux = 0;
  }
  if (entrada != "") {
    const tr = document.createElement("tr");
    tr.id = "fila" + aux;
    tr.setAttribute('onclick', 'thear(event)');   
    const table = document.querySelector(tableid);
    table.appendChild(tr);

    document.getElementById(tr.id).innerHTML = "<td id='column" + aux + 4 + "'></td><td id='column" + aux + 1 + "'></td><td class='precio" + num + "' id ='column" + aux + 2 + "'> <td id='column" + aux + 3 + "'></td>"

    const list01 = document.getElementById(list1);
    const list02 = document.getElementById(list2);
    const list03 = document.getElementById(list3);
    
	document.getElementById('column' + aux + 4).setAttribute('name',"producto");
	document.getElementById('column' + aux + 4).innerHTML = await price(entrada,list01,list03);
    document.getElementById('column' + aux + 1).innerHTML = entrada;
    document.getElementById('column' + aux + 2).innerHTML = await price(entrada,list01,list02);                        
    document.getElementById('column' + aux + 3).innerHTML = "<input type='number' class='price' onchange='sumaPrecio(event)' value='1'> ";

  }
  document.getElementById(selectid).value = "";
  ++aux;

}

//METODO QUE BUSCA EL PRECIO SEGUN EL PRODUCTO SELECCIONADO
async function price(valor, lista1, lista2){
                                                              // buscamos el índice del valor en la primera lista
  const indice = Array.from(lista1.children).findIndex(
    (elemento) => elemento.textContent === valor);

  if (indice !== -1) {
                                                                // si el valor se encuentra en la primera lista, devolvemos el valor de la segunda lista en la misma posición
    return lista2.children[indice].textContent;
  } else {
                                                                // si el valor no se encuentra en la primera lista, devolvemos null
    return null;
  }
}

//erase the lists, drink and snack
function eraseall(valor4,valor3) {
 	eraseTable(valor4);
	eraseTable(valor3);
}

//erase the list, drink or snack
function eraseTable(valor4) {
  const listdrink = document.getElementById(valor4);
  while (listdrink.hasChildNodes()) {
    listdrink.removeChild(listdrink.firstChild);
  }
}

//last item selected painted red
let lastSelect;
function thear(event) {
	if(event.target.classList[0] != "price"){
		lastSelect = event.target.parentElement;
		let totale = document.querySelectorAll('td');
 		for (let t = 0; t < totale.length; t++) {
    			totale[t].style.background='white';
  		}
  		for (let j = 0; j < lastSelect.children.length; j++) {
    			lastSelect.children[j].style.background='red';
  		}
	} 
}

//remove the last item selected
function erasetab() {
  lastSelect.remove();
}

//get the total price of bill, suma todos los precios ndependiente del tipo
function totales(tdclass, labeltotal) {
  let suma = new Number();
  let totale = document.querySelectorAll(tdclass);
  for (let t = 0; t < totale.length; t++) {
    suma = parseInt(totale[t].innerHTML) + suma;
  }
  document.getElementById(labeltotal).innerText = suma;
}

//add the number of items
let sum2, active;
function sumaPrecio(event) {
  let sum3 = new Number();
  let sum1 = parseInt(event.target.value);
  let colum = event.target.parentElement.id;
  

  if (typeof active == 'undefined' && typeof sum2 == 'undefined') {
    sum2 = parseInt(event.target.parentElement.previousElementSibling.innerHTML);
    active = colum;
    if (event.target.value > 0) {
      sum3 = sum1 * sum2;
      event.target.parentElement.previousElementSibling.innerHTML = sum3;
    }

  } else if (active == colum) {
    if (event.target.value > 0) {
      sum3 = sum1 * sum2;
      event.target.parentElement.previousElementSibling.innerHTML = sum3;
    }

  } else if (active != colum) {
    sum2 = parseInt(event.target.parentElement.previousElementSibling.innerHTML);
    if (event.target.value > 0) {
      sum3 = sum1 * sum2;
      event.target.parentElement.previousElementSibling.innerHTML = sum3;
      active = colum;
    }
  }
}














































/*function easyTabs1() {
    var groups = document.querySelectorAll('.t-container');
    if (groups.length > 0) {
      for (i = 0; i < groups.length; i++) {
        var tabs = groups[i].querySelectorAll('.t-tab');
        for (t = 0; t < tabs.length; t++) {
          tabs[t].setAttribute("index", t+1);
          if (t == 0) tabs[t].className = "t-tab selected";
        }
        var contents = groups[i].querySelectorAll('.t-content');
        for (c = 0; c < contents.length; c++) {
          contents[c].setAttribute("index", c+1);
          if (c == 0) contents[c].className = "t-content selected";
        }
      }
      var clicks = document.querySelectorAll('.t-tab');
      for (i = 0; i < clicks.length; i++) {
        clicks[i].onclick = function() {
          var tSiblings = this.parentElement.children;
          for (i = 0; i < tSiblings.length; i++) {
            tSiblings[i].className = "t-tab";
          }
          this.className = "t-tab selected";
          var idx = this.getAttribute("index");
          var cSiblings = this.parentElement.parentElement.querySelectorAll('.t-content');
          for (i = 0; i < cSiblings.length; i++) {
            cSiblings[i].className = "t-content";
            if (cSiblings[i].getAttribute("index") == idx) {
              cSiblings[i].className = "t-content selected";
            }
          }
        };
      }
    }
 var tabs = document.querySelectorAll('.t-tab');
      for (t = 0; t < tabs.length; t++) {
        if(t != tabs.length-1) {
          tabs[t].setAttribute("index", t+1);
          if (t == 0) tabs[t].className = "t-tab selected"; 
        } 
      } 

      var tabs1 = document.querySelectorAll('.t-form');
      for (t = 0; t < tabs1.length; t++) {
        tabs1[t].setAttribute("index", t+1);
        if (t == 0) tabs1[t].className = "t-form selected";
      }
 
  }*/







