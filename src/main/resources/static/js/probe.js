function  callObjects(){
  
  fetch('http://localhost:5500/js/objetosCafe.json') 
    .then(resp => resp.json())
    .then(data => {return data} );
    
  }

  let bebei = 'Tinto';

  async function fetchExam() {
    alert("2");
    try {
        const response = await fetch('http://localhost:5500/js/objetosCafe.json', {
            method: 'GET',
            credentials: 'same-origin'
        });
        alert("3");
        const exam = await response.json();
        alert("4");
        return exam;
    } catch (error) {
        console.error(error);
    }
}

async function renderExam() {
    alert("1");
    const exam = await fetchExam();
    document.getElementById('response').innerHTML= exam[bebei];
    
}