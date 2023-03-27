function notificar (titulo: string, mensagem: string , codigo: number) {

  let qtd = document.getElementsByClassName('alert').length;
  qtd++
  const alertElement = document.createElement("div");
  alertElement.style.top = qtd * 90 + 'px';
  alertElement.classList.add("alert");
  alertElement.classList.add(codigo == 0? "alert-success" : "alert-error")
  alertElement.innerHTML = `<strong>${titulo}!</strong> ${mensagem}`;

  document.body.appendChild(alertElement);

  setTimeout(() => {
    alertElement.classList.add("show");
  }, 100);

  setTimeout(() => {
    alertElement.classList.remove("show");
    alertElement.classList.add("exit");

    setTimeout(() => {
      document.body.removeChild(alertElement);
    }, 500);
  }, 3000);
}

export {notificar};