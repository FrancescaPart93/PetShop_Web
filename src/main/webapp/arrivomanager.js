/**
 * 
 */
 let ruoloButton = document.getElementById('ruolo');
 ruoloButton.addEventListener('click', function(e) {
		console.log('Clickato');
		if(ruoloButton.textContent === 'G') {
			ruoloButton.textContent = 'M';
		}else {
			ruoloBottone.textContent = 'G';
		}
});