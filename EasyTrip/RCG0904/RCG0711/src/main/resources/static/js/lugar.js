window.addEventListener("click", changeCategory)
function changeCategory() {
    window.location.href = "/lugares/list/" +
        document.getElementById("select").value;
}