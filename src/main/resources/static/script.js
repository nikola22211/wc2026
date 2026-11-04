"use strict";

const utakmiceContainer = document.querySelector(`.utakmice`);
const btn1 = document.querySelector(`.btn1`);
const input = document.querySelector(`#ekipa`);
const radioButtons = document.querySelector(`.radioButtons`);

const napraviDOM = function (el) {
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

const boldujPobednika = function (el, utakmica) {
  const domacin = utakmica.querySelector(`.tim1`);
  const gost = utakmica.querySelector(`.tim2`);
  // console.log(utakmica);

  if (vratiPobednika(el) === 1) {
    domacin.classList.add(`strong`);
  } else if (vratiPobednika(el) === 2) {
    gost.classList.add(`strong`);
  }
};

const vratiPobednika = function (el) {
  let [gol1, gol2] = el.rezultat.split(`:`);

  if (gol2.endsWith(`prod`)) {
    gol2 = gol2.slice(0, -4);
  }
  if (gol2.endsWith(`pen`)) {
    gol2 = gol2.slice(0, -3);
  }

  if (+gol1 > +gol2) {
    return 1;
  } else if (+gol1 < +gol2) {
    return 2;
  }
  return 3;
};

const ispisiUtak = function (data) {
  data.forEach((d) => {
    const dom = napraviDOM(d);
    boldujPobednika(d, dom);
  });
};

fetch("/utakmice/sve")
  .then((response) => response.json())
  .then((data) => {
    data.forEach((el) => {
      const utakmica = napraviDOM(el);
      boldujPobednika(el, utakmica);
    });
  });

btn1.addEventListener(`click`, function () {
  let ekipa = input.value;
  ekipa = ekipa.charAt(0).toUpperCase() + ekipa.slice(1).toLowerCase();

  fetch(`utakmice?ekipa=${encodeURIComponent(ekipa)}`)
    .then((res) => {
      if (res.status === 204) {
        utakmiceContainer.innerHTML = `Nema utakmica te ekipe`;
        return null;
      }
      if (!res.ok) {
        throw new Error(`Greska: ${res.status}`);
      }
      return res.json();
    })
    .then((data) => {
      if (!data) {
        return;
      }
      utakmiceContainer.innerHTML = ``;
      ispisiUtak(data);
    });
});

radioButtons.addEventListener(`click`, function (e) {
  if (e.target.type === `radio`) {
    console.log(`Kliknuto:`, e.target.value);
    const tip = e.target.value;
    fetch(`utakmice/tip/${encodeURIComponent(tip)}`)
      .then((res) => {
        if (res.status === 204) {
          utakmiceContainer.innerHTML = `Neodgovarajuci tip`;
          return null;
        }
        if (!res.ok) {
          throw new Error(`Greska: ${res.status}`);
        }
        return res.json();
      })
      .then((data) => {
        if (!data) {
          return;
        }
        utakmiceContainer.innerHTML = ``;
        ispisiUtak(data);
      });
  }
});
