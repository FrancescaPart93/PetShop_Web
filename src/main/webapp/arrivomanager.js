/**
 * 

 */
 
 
const ruoloButtons = Array.from(document.getElementsByClassName('ruoloBtn'));

ruoloButtons.forEach(ruoloButton => {
  ruoloButton.addEventListener('click', function (e) {
    console.log('Clickato');
    if (ruoloButton.textContent === 'G') {
      ruoloButton.textContent = 'M';
    } else {
      ruoloButton.textContent = 'G';
    }
  });
});


const statoButtons = Array.from(document.getElementsByClassName('statoBtn'));

statoButtons.forEach(statoButton => {
  statoButton.addEventListener('click', function (e) {
    console.log('Clickato');
    if (statoButton.textContent === 'A') {
      statoButton.textContent = 'D';
    } else {
      statoButton.textContent = 'A';
    }
  });
});





