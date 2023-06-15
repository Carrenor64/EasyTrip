window.addEventListener("load", cargar)

function cargar() {
  document.getElementById('toggle-password').addEventListener('click', togglePassword);
}
var contrasenha = document.getElementById('contrasenha');
var usuario = document.getElementById('usuario');
var form = document.getElementById('fondo');

function togglePassword() {
  if (contrasenha.type === "password") {
    contrasenha.type = "text";
  } else {
    contrasenha.type = "password";
  }
}

form.addEventListener('submit', function (e) {
  if (usuario.value === "" || contrasenha.value === "") {
    e.preventDefault();
    alert("Ambos campos deben ser llenados");
  }
});
