import {
  getSveUtakmice,
  getUtakmicePoEkipa,
  getUtakmicePoTipu,
} from "./api.js";

import { ispisiUtakmice, prikaziPoruku } from "./dom.js";

const btn1 = document.querySelector(".btn1");
const input = document.querySelector("#ekipa");
const radioButtons = document.querySelector(".radioButtons");

const normalizujNazivEkipe = function (ekipa) {
  return ekipa.charAt(0).toUpperCase() + ekipa.slice(1).toLowerCase();
};

// Sve utakmice
getSveUtakmice()
  .then((data) => {
    ispisiUtakmice(data);
  })
  .catch((err) => {
    console.error(err);
  });

// Pretraga ekipe
btn1.addEventListener("click", async function () {
  try {
    let ekipa = normalizujNazivEkipe(input.value);

    const data = await getUtakmicePoEkipa(ekipa);

    if (!data) {
      prikaziPoruku("Nema utakmica te ekipe!!!");
      return;
    }

    ispisiUtakmice(data);
  } catch (err) {
    console.error(err);
  }
});

// Filter po tipu
radioButtons.addEventListener("click", async function (e) {
  if (e.target.type !== "radio") return;

  try {
    const tip = e.target.value;

    const data = await getUtakmicePoTipu(tip);

    if (!data) {
      prikaziPoruku("Neodgovarajući tip");
      return;
    }

    ispisiUtakmice(data);
  } catch (err) {
    console.error(err);
  }
});
