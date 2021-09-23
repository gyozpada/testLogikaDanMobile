const a = "Saat meng*ecat tembok, Agung dib_antu oleh Raihan.";
const b = "Berapa u(mur minimal[ untuk !mengurus ktp?";
const c = "Masing-masing anak mendap(atkan uang jajan ya=ng be&rbeda.";

const countSpecial = (input) => {
  const special = "!,;.-?[*_()=&";
  let count = 0;
  for (let i = 0; i < input.length; i++) {
    if (special.includes(input[i])) {
      count++;
    }
    continue;
  }
  return count;
};

console.log("Special Karakter pada kalimat a berjumlah " + countSpecial(a));
console.log("Special Karakter pada kalimat a berjumlah " + countSpecial(b));
console.log("Special Karakter pada kalimat a berjumlah " + countSpecial(c));
