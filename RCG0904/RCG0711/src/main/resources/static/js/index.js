document.getElementById('searchForm').addEventListener('submit', function (event) {
    event.preventDefault();
    var query = document.getElementById('searchInput').value;
    if (query.toLowerCase() === 'new york') {
        window.location.href = '/lugares/newyork';
    } else if (query.toLowerCase() === 'paris') {
        window.location.href = '/lugares/paris';
    } else if (query.toLowerCase() === 'tokio') {
        window.location.href = '/lugares/tokio';
    } else if (query.toLowerCase() === 'coruña') {
        window.location.href = '/lugares/corunha';
    } else if (query.toLowerCase() === 'brasilia') {
        window.location.href = '/lugares/brasilia';
    } else {
        // Aquí puedes manejar otras consultas de búsqueda si lo deseas.
    }
});