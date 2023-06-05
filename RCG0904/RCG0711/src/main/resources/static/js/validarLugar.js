document.addEventListener("DOMContentLoaded", function () {
    // Obtener el formulario
    const form = document.querySelector("form");

    // Agregar un evento al enviar el formulario
    form.addEventListener("submit", function (event) {
        event.preventDefault(); // Evitar el envío del formulario por defecto

        // Validar el formulario antes de enviarlo
        if (validateForm()) {
            form.submit(); // Enviar el formulario
        }
    });

    // Función para validar el formulario
    function validateForm() {
        // Obtener los campos del formulario
        const ubicacionInput = document.getElementById("ubicacion");
        const nombreInput = document.getElementById("nombre");
        const descripcionInput = document.getElementById("descripcion");
        const precioInput = document.getElementById("precio");

        // Realizar la validación de los campos según tus requisitos
        if (ubicacionInput.value.trim() === "") {
            alert("Por favor, ingresa la ubicación.");
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

        // Si todos los campos son válidos, retorna true
        return true;
    }
});