export const vratiPobednika = function (el) {
  let [gol1, gol2] = el.rezultat.split(":");

  if (gol2.endsWith("prod")) {
    gol2 = gol2.slice(0, -4);
  }

  if (gol2.endsWith("pen")) {
    gol2 = gol2.slice(0, -3);
  }

  if (+gol1 > +gol2) {
    return 1;
  } else if (+gol1 < +gol2) {
    return 2;
  }

  return 3;
};
