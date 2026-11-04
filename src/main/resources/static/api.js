export const getSveUtakmice = async function () {
  const res = await fetch("/utakmice/sve");
  if (!res.ok) {
    throw new Error(`Greska: ${res.status}`);
  }

  return res.json();
};

export const getUtakmicePoEkipa = async function (ekipa) {
  const res = await fetch(`/utakmice?ekipa=${encodeURIComponent(ekipa)}`);

  if (res.status === 204) {
    return null;
  }
  if (!res.ok) {
    throw new Error(`Greška: ${res.status}`);
  }

  return res.json();
};

export const getUtakmicePoTipu = async function (tip) {
  const res = await fetch(`/utakmice/tip/${encodeURIComponent(tip)}`);

  if (res.status === 204) {
    return null;
  }
  if (!res.ok) {
    throw new Error(`Greška: ${res.status}`);
  }

  return res.json();
};
