import { vratiPobednika } from "./utakmice.js";

const utakmiceContainer = document.querySelector(".utakmice");

export const napraviDOM = function (el) {
  const html = `
    <div class="utakmice-podklasa">
      <span class="tim1">${el.tim1}</span>
      <span class="rezultat">${el.rezultat}</span>
      <span class="tim2">${el.tim2}</span>
      <span class="datum">${el.datum}</span>
      <span class="faza">${el.faza}</span>
    </div>
  `;

  utakmiceContainer.insertAdjacentHTML("beforeend", html);

  return utakmiceContainer.lastElementChild;
};

export const boldujPobednika = function (el, utakmica) {
  const domacin = utakmica.querySelector(".tim1");
  const gost = utakmica.querySelector(".tim2");

  const pobednik = vratiPobednika(el);

  if (pobednik === 1) {
    domacin.classList.add("strong");
  } else if (pobednik === 2) {
    gost.classList.add("strong");
  }
};

export const ispisiUtakmice = function (data) {
  utakmiceContainer.innerHTML = "";

  data.forEach((el) => {
    const utakmica = napraviDOM(el);
    boldujPobednika(el, utakmica);
  });
};

export const prikaziPoruku = function (poruka) {
  utakmiceContainer.innerHTML = poruka;
};
