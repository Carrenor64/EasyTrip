document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");

    form.addEventListener("submit", function (event) {
        event.preventDefault();

        if (validateForm()) {
            form.submit(); 
        }
    });

    function validateForm() {
        const ubicacionInput = document.getElementById("horario");
        const nombreInput = document.getElementById("nombre");
        const descripcionInput = document.getElementById("descripcion");
        const precioInput = document.getElementById("precio");

        if (ubicacionInput.value.trim() === "") {
            alert("Por favor, ingresa el horario.");
            ubicacionInput.focus();
            return false;
        }

        if (nombreInput.value.trim() === "") {
            alert("Por favor, ingresa el nombre.");
            nombreInput.focus();
            return false;
        }

        if (descripcionInput.value.trim() === "") {
            alert("Por favor, ingresa la descripción.");
            descripcionInput.focus();
            return false;
        }

        if (precioInput.value.trim() === "") {
            alert("Por favor, ingresa el precio.");
            precioInput.focus();
            return false;
        }

        return true;
    }
});