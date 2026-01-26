function scanVoorScrollElementen() {
    const flowIsAan = localStorage.getItem("flowState") === "true";

    if (flowIsAan) {
        // De AI zoekt naar deze "triggers" op de pagina
        const verbodenWoorden = ["Abonneer", "Subscribe", "Like", "Volgen", "Follow", "Shorts"];
        const paginaTekst = document.body.innerText;

        verbodenWoorden.forEach(woord => {
            if (paginaTekst.includes(woord)) {
                // 1. Verhoog de teller in het geheugen
                let aantal = parseInt(localStorage.getItem("scrollBlokkades") || 0);
                localStorage.setItem("scrollBlokkades", aantal + 1);
                
                // 2. Stuur de gebruiker direct naar de "Muur"
                window.location.href = "block.html";
            }
        });
    }
}

// Scant elke 2 seconden of je stiekem aan het scrollen bent
setInterval(scanVoorScrollElementen, 2000);